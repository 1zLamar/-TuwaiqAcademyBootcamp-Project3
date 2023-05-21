package com.example.project2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {
    @NotNull(message = "id shouldn't be null")
    @Min(value =3,message = "id should be 3 character and more")
    private int id ;
    @NotNull(message = "name shouldn't be null")
    @Size(min=3,message = "name should be 3 character and more")
    private String name;

}
