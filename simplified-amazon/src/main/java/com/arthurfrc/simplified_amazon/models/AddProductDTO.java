package com.arthurfrc.simplified_amazon.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddProductDTO(
        @NotBlank(message = "The name attribute is required.")
        String name,

        @NotNull(message = "The price attribute is required.")
        Double price,

        @NotNull(message = "The quantity attribute is required.")
        @Min(value = 1, message = "The minimum value for the quantity attribute is 1." )
        Integer quantity
) {
}
