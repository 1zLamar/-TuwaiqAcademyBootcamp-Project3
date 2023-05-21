package com.example.project2.Service;

import com.example.project2.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products=new ArrayList<>();

    public ArrayList getProduct(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public boolean updateProduct(Product product,int id){
        for(int i=0; i< products.size();i++){
            if(products.get(i).getId()==id){
                products.set(i,product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id){
        for(int i=0; i< products.size();i++){
            if(products.get(i).getId()==id){
                products.remove(i);
                return true;
            }
        }
        return false;



    }
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public int isExist(int id){
        for (int i=0; i<= products.size();) {
            if(products.get(i).getId()==id)
                return i;
        }
        return -1;
    }

    public int getPrice(int idProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                return products.get(i).getPrice();
            }
        }
        return -1;
    }

}
