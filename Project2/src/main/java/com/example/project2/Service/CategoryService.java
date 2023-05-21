package com.example.project2.Service;

import com.example.project2.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CategoryService {
    ArrayList<Category> categorys = new ArrayList<>();

    public ArrayList<Category> getCategory() {
        return categorys;
    }

    public Category addCategory(Category category) {
        categorys.add(category);
        return category;


    }

    public boolean updateCategory(Category category, int id){
        for(int i=0; i< categorys.size();i++){
            if(categorys.get(i).getId()==id){
                categorys.set(i,category);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCategory(int id) {
        for(int i=0; i< categorys.size();i++){
            if(categorys.get(i).getId()==id){
                categorys.remove(i);
                return true;
            }
        }
        return false;


    }

}
