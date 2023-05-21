package com.example.project2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    @NotNull(message = "id shouldn't be null")
    @Min(value =3,message = "id should be 3 character and more")
    private int id;

    @NotNull(message = "name shouldn't be null")
    @Size(min=3,message = "name should be 3 character and more")
    private String name;

    @NotNull(message = "price shouldn't be null")
    @Positive(message = "price should be positive number")
    private int price ;

    @NotNull(message = "category id shouldn't be null")
    @Min(value =3,message = "category id should be 3 character and more")
    private int categoryID;


    /*Product Class :

id ( must not be empty , have to be 3 character long ).
name ( must not be empty , have to be 3 length long ).
price ( must not be empty , must be positive number ).
categoryID ( must not be empty , have to be 3 character long ).*/

}
