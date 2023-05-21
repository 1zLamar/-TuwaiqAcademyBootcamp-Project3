package com.example.project2.Controller;

import com.example.project2.ApiResponse.ApiResponse;
import com.example.project2.Model.Merchant;
import com.example.project2.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        ArrayList<Merchant> merchants= merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors error){
        if(error.hasErrors()){
            String msg= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchant , Errors error,@PathVariable int id){
        if(error.hasErrors()){
            String msg = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        boolean isUpdated= merchantService.updateMerchant(merchant, id);

        if(isUpdated){
            return ResponseEntity.status(200).body("Merchant updated");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable int id){

        boolean isDeleted= merchantService.deleteMerchant(id);

        if(isDeleted){
            return ResponseEntity.status(200).body("Merchant deleted");
        }
        return ResponseEntity.status(400).body("wrong id");


    }


}
