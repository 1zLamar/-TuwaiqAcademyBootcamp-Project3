package com.example.project2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MerchantStock {
    @NotNull(message = "id shouldn't be null")
    @Min(value =3,message = "id should be 3 character and more")
    private int id;
    @NotNull(message = "product id shouldn't be null")
    @Min(value =3,message = "product id should be 3 character and more")
    private int productid ;
    @NotNull(message = "merchant id shouldn't be null")
    @Min(value =3,message = "merchant id should be 3 character and more")
    private int merchantid ;
    @NotNull(message = "merchant id shouldn't be null")
    @Min(value = 11,message = "stock should be more than 10")
    private int stock;

}
