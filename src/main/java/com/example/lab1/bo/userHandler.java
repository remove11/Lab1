package com.example.lab1.bo;

import com.example.lab1.db.userDB;
import com.example.lab1.ui.UserDTO;

public class userHandler{

    public static UserDTO authenticate(String userName, String password){
        User user = userDB.authenticate(userName,password);
        if (user != null){
           return new UserDTO(user.getId(),user.getName(),user.getPassword(), user.getAdmin());
        }else{
            return null;
        }

    }
    public static boolean isAdmin(String username){
        boolean admin = userDB.isAdmin(username);
        return admin;
    }
    public static void register(String username, String password, boolean Admin){
        userDB.register(username,password,Admin);
    }
}

