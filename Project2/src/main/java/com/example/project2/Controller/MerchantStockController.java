package com.example.project2.Controller;

import com.example.project2.ApiResponse.ApiResponse;
import com.example.project2.Model.MerchantStock;
import com.example.project2.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("api/v1/merchantstock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){
        ArrayList<MerchantStock> merchantStocks= merchantStockService.getMerchantStock();
        return ResponseEntity.status(200).body(merchantStocks);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors error){
        if(error.hasErrors()){
            String msg= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@Valid @RequestBody MerchantStock merchantStock , Errors error,@PathVariable int id){
        if(error.hasErrors()){
            String msg = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        boolean isUpdated= merchantStockService.updateMerchantStock(merchantStock, id);

        if(isUpdated){
            return ResponseEntity.status(200).body("MerchantStock updated");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id){
        boolean isDeleted= merchantStockService.deleteMerchantStock(id);

        if(isDeleted){
            return ResponseEntity.status(200).body("MerchantStock deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    @PutMapping("/addproduct/{idMerchant}/{idProduct}/{stock}")
    public ResponseEntity addProductToMerchant(@PathVariable int idMerchant, @PathVariable int idProduct, @PathVariable int stock) {
        if (merchantStockService.addProductToMerchant(idMerchant, idProduct, stock)) {
            return ResponseEntity.ok("Product added");
        }
        return ResponseEntity.badRequest().body("Failed to add product");
    }
}
