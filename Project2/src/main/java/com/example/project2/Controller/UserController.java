package com.example.project2.Controller;

import com.example.project2.ApiResponse.ApiResponse;
import com.example.project2.Model.User;
import com.example.project2.Service.MerchantStockService;
import com.example.project2.Service.ProductService;
import com.example.project2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;
        private final MerchantStockService merchantStockService;
        private final ProductService productService;

        @GetMapping("/get")
        public ResponseEntity getUser(){
            ArrayList<User> users= userService.getUsers();
            return ResponseEntity.status(200).body(users);
        }

        @PostMapping("/add")
        public ResponseEntity addUser(@Valid @RequestBody User user, Errors error){
            if(error.hasErrors()){
                String msg= error.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(msg);
            }
            userService.addUser(user);
            return ResponseEntity.status(200).body("user added successfully");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateProduct(@Valid @RequestBody User user , Errors error,@PathVariable int id){
            if(error.hasErrors()){
                String msg = error.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new ApiResponse(msg));
            }
            boolean isUpdated= userService.updateUser(user, id);

            if(isUpdated){
                return ResponseEntity.status(200).body("User updated");
            }
            return ResponseEntity.status(400).body("Wrong id");
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteProduct(@PathVariable int id){

            boolean isDeleted= userService.deleteUser(id);

            if(isDeleted){
                return ResponseEntity.status(200).body("User deleted");
            }
            return ResponseEntity.status(400).body("wrong id");

        }

    @PutMapping("/buy/{userId}/{productId}/{merchantId}")
    public ResponseEntity buyProduct(@PathVariable int userId,Errors error, @PathVariable int productId, @PathVariable int merchantId) {
        if(error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
            if (userService.isExist(userId)) {
            if (merchantStockService.isExistStock(merchantId, productId)) {
                if (productService.getPrice(productId) != -1) {
                    if (userService.getBalance(userId) >= productService.getPrice(productId)) {
                        userService.reduceBalance(userId, productService.getPrice(productId));
                        merchantStockService.reducStock(productId, merchantId);
                        return ResponseEntity.status(200).body("Product Bought");
                    }
                }
                return ResponseEntity.status(400).body("wrong product id");
            }
        }
        return ResponseEntity.status(400).body("wrong id");
    }


}
