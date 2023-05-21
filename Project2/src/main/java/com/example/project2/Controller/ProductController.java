package com.example.project2.Controller;

import com.example.project2.ApiResponse.ApiResponse;
import com.example.project2.Model.Product;
import com.example.project2.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("/get")
    public ResponseEntity getProduct(){
        ArrayList<Product> products= productService.getProduct();
        return ResponseEntity.status(200).body(products);
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors error){
        if(error.hasErrors()){
            String msg= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@Valid @RequestBody Product product , Errors error,@PathVariable int id){
        if(error.hasErrors()){
            String msg = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        boolean isUpdated= productService.updateProduct(product, id);

        if(isUpdated){
            return ResponseEntity.status(200).body("Product updated");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        boolean isDeleted= productService.deleteProduct(id);

        if(isDeleted){
            return ResponseEntity.status(200).body("Product deleted");
        }
        return ResponseEntity.status(400).body("wrong id");


    }


}
