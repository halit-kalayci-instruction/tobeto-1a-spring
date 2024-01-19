package com.tobeto.a.spring.intro.core.filters;

import com.tobeto.a.spring.intro.core.services.JwtService;
import com.tobeto.a.spring.intro.services.abstracts.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter
{
    private final JwtService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException
    {
        // ..... jwt'yi oku
        // jwt doğrula
        // security'e giriş yaptırıcaz.
        // chaini ilerleticez
        String jwtHeader = request.getHeader("Authorization");

        if(jwtHeader != null && jwtHeader.startsWith("Bearer "))
        {
            // ..
            String jwt = jwtHeader.substring(7); // eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmdAc3RyaW5nLmNvbSIsImlhdCI6MTcwNTQ5NTk5NiwiZXhwIjoxNzA1NDk2NTk2fQ.dKpaT7SgmT7gO_wEqUzdXb1LKqQe4aZAq-8TMqOMyuA
            String username = jwtService.extractUser(jwt);

            if(username!=null)
            {
                UserDetails user = userService.loadUserByUsername(username);
                if(jwtService.validateToken(jwt, user))
                {
                     //her şey başarılı
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }


        filterChain.doFilter(request,response);
    }
}
