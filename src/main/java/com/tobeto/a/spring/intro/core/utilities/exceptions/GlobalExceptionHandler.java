package com.tobeto.a.spring.intro.core.utilities.exceptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// 11:10 workshopdayız.
@RestControllerAdvice // Class içerisinde global ex. handler methodlar bulunduğunu söyler.
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class}) // methodun içerisinde verilen türün ex. handler metodu olduğunu belirler
    @ResponseStatus(HttpStatus.BAD_REQUEST) // return işlevinin cevabı hangi http statüsünde döndüreceğini belirler.
    public String handleValidationError(MethodArgumentNotValidException exception)
    {
        // TODO: Exceptionin içeriğini inceleyerek tüm validasyon hatalarını alan ve hata mesajı olarak yazdırmak.
        return "Validasyon hatası";
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException exception)
    {
        return exception.getMessage();
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleError(Exception exception)
    {
        return "Bilinmedik hata";
    }
}
