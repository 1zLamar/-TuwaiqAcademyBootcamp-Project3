package com.example.project2.Service;

import com.example.project2.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public boolean updateUser(User user, int id){
        for(int i=0; i< users.size();i++){
            if(users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        for(int i=0; i< users.size();i++){
            if(users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean isExist(int id){
        for (int i=0; i<= users.size();) {
            if(users.get(i).getId()==id)
                return true;
        }
        return false;
    }

    public boolean reduceBalance(int userId, int price) {
        for (User user : users) {
            if (user.getId() == userId && user.getBalance() >= price) {
                user.setBalance(user.getBalance() - price);
                return true;
            }
        }
        return false;
    }

    public int getBalance(int idUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == idUser) {
                return users.get(i).getBalance();
            }
        }
        return -1;

    }

}
