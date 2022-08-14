package com.example.TacoCloud.DomanObject;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Order {
    @NotBlank(message = "name can't be null")
    @Size(min = 3, max = 12, message = "Name must be between 3 - 12 character.")
    private String name;
    @NotBlank(message = "state can't be null or empty")
    private String state;
    @NotBlank(message = "City can't be null or empty")
    private String city;
    @NotBlank(message = "Street can't be null or empty")
    private String street;
    @NotBlank(message = "Zip can't be null or empty")
    private String zip;
}
