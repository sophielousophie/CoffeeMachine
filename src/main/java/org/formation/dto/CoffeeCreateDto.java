package org.formation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CoffeeCreateDto(@NotBlank(message = "Coffee name connot be null")
                              String name,
                              @Positive(message = "Price should be positive") int price) {

}
