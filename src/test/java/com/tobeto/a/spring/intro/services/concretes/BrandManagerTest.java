package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.concretes.Brand;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class BrandManagerTest {
    private BrandManager brandManager;

    @Mock
    private BrandRepository brandRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brandManager = new BrandManager(brandRepository);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void nameWithTwoLettersShouldThrowException() {
        // Mock

        // 3A => Arrange, Act, Assert

        // Arrange
        AddBrandRequest addBrandRequest = new AddBrandRequest();
        addBrandRequest.setName("ab");
        // Arrange
        // Act
        // Act
        // Assert, Act = Expected ?
        assertThrows(RuntimeException.class, () -> {
            brandManager.add(addBrandRequest);
        });
        // Assert
    }

    @Test
    void brandWithSameNameShouldNotExist() {
        AddBrandRequest addBrandRequest = new AddBrandRequest();
        addBrandRequest.setName("Mercedes");

        Mockito.when(brandRepository.findByName("Mercedes"))
               .thenReturn(Optional.of(new Brand("Mercedes", "mercedes.png")));


        assertThrows(RuntimeException.class, () -> {
            brandManager.add(addBrandRequest);
        });
    }

    @Test
    void successfull() {
        AddBrandRequest addBrandRequest = new AddBrandRequest();
        addBrandRequest.setName("Mercedes");
        brandManager.add(addBrandRequest);
        assert true;
    }
}
// TDD