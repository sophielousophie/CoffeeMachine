package org.formation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CoffeeUpdateDto(String name,
                              @Positive(message = "Price should be positive")
                              Integer price) { /// Comme ça même si pas de flux, alors le prix est nul et pas 0

}
