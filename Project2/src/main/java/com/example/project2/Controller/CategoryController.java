package com.example.project2.Controller;

import com.example.project2.ApiResponse.ApiResponse;
import com.example.project2.Model.Category;
import com.example.project2.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategory(){
        ArrayList<Category> categorys= categoryService.getCategory();
        return ResponseEntity.status(200).body(categorys);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Category category, Errors error){
        if(error.hasErrors()){
            String msg= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@Valid @RequestBody Category category , Errors error,@PathVariable int id){
        if(error.hasErrors()){
            String msg = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        boolean isUpdated= categoryService.updateCategory(category, id);

        if(isUpdated){
            return ResponseEntity.status(200).body("Product updated");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        boolean isDeleted= categoryService.deleteCategory(id);

        if(isDeleted){
            return ResponseEntity.status(200).body("Category deleted");
        }
        return ResponseEntity.status(400).body("wrong id");


    }




}
