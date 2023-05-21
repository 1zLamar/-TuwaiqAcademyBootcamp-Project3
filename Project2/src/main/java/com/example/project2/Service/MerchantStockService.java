package com.example.project2.Service;

import com.example.project2.Model.Merchant;
import com.example.project2.Model.MerchantStock;
import com.example.project2.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStocks;
    }

    public MerchantStock addMerchantStock(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);
        return merchantStock;
    }

    public boolean updateMerchantStock(MerchantStock merchant, int id){
        for(int i=0; i< merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==id){
                merchantStocks.set(i,merchant);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(int id) {
        for(int i=0; i< merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==id){
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(int idMerchant, int productId, int stock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getMerchantid() == idMerchant) {
                if (merchantStocks.get(i).getProductid() == productId) {
                    if (stock >= 0) {
                        merchantStocks.get(i).setStock(merchantStocks.get(i).getStock() + stock);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean isExistStock(int idMerchant, int productId) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getMerchantid() == idMerchant) {
                if (merchantStocks.get(i).getProductid() == productId) {

                    if (merchantStocks.get(i).getStock() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean reducStock(int idMerchant, int productId) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getMerchantid() == idMerchant) {
                if (merchantStocks.get(i).getProductid() == productId) {
                    if (merchantStocks.get(i).getStock() > 0) {
                        merchantStocks.get(i).setStock(merchantStocks.get(i).getStock() - 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
