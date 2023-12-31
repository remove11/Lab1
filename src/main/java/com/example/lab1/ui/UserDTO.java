package com.example.lab1.ui;

public class UserDTO
{
   private boolean isAdmin;
   private int id;
   private String password;
   private String username;

   public UserDTO( int id,String username, String password,boolean isAdmin) {
      this.isAdmin = isAdmin;
      this.id = id;
      this.password = password;
      this.username = username;
   }



   public boolean isAdmin() {
      return isAdmin;
   }

   public void setAdmin(boolean admin) {
      isAdmin = admin;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

}

