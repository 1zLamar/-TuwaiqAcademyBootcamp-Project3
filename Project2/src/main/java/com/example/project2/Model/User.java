package com.example.project2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {

    @NotNull(message = "id shouldn't be null")
    @Min(value =3,message = "id should be 3 character and more")
    private int id ;
    @NotNull(message = "id shouldn't be null")
    @Size(min=5,message = "should be 5 character and more")
    private String username ;
    @NotNull(message = "id shouldn't be null")
    @Size(min=3,message = "should be 6 character and more")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    private String password ;
    @NotNull(message = "The email shouldn't be empty")
    @Pattern(regexp = "^(.+)@(.+)$")
    private String email ;
    @NotNull(message = "role should'nt be empty")
    @Pattern(regexp = "^(Admin|Customer)$",message = "should be supervisor or Customer")
    private String role ;
    @NotNull(message = "role should'nt be empty")
    @Positive(message = "The number have to be positive")
    private int balance;

//    User Class :
//
//    id ( must not be empty , have to be 3 character long ).
//    username ( must not be empty , have to be 5 length long ).
//    password ( must not be empty , have to be 6 length long , must have characters and digits ).
//    email ( must not be empty , must be valid email ).
//    role ( must not be empty , have to be in ( “Admin”,”Customer”) ).
//    balance ( must not be empty , have to be positive ).


}
