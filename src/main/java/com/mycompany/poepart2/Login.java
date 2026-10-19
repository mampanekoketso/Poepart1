/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author Student
 */
public class Login {
    private String username;
    private String firstName;
    private String password;
    private String surname;
    private String phoneNumber;
    
    public Login(String username, String password, String firstName, String surname, String phoneNumber){
        this.password = password;
        this.surname = surname;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }
     public Login(){}
     public boolean checkUserName(){
         return username != null && username.contains("_") && username.length() <=5;
    
     }
     public boolean checkPasswordSensitivity(){
      if (password == null || password.length() <8)   
          return false;
           boolean hasCapitalLetter = !password.equals(password.toLowerCase());
           boolean hasNumber = password.matches(".*\\d.*");
           boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
           
           return hasCapitalLetter && hasNumber && hasSpecial;
     }
     public boolean checkphoneNumber(){
      String regex = "^\\+27[0-9]{9}$";
      return phoneNumber !=null
              && phoneNumber.matches("^\\+27\\d{9}$");
     }
     public String registerUser () {
         if (!checkUserName()){
             return "username is not correctly formatted; please ensure that your usernamecontain an underscore and is no more than five characters in length";
         } 
         if (!checkphoneNumber()){
             return "Phone number incorrectly formatted or does not include international code";   
         }
         if (!checkPasswordSensitivity()){
             return " password is incorrectly formatted please ensure that the pasword contains at least 8 characters , a capital letter, a number, and a special character.";   
         }
         return "User registered successfully.";
         
     }
     public boolean loginUser(String enteredUsername, String enteredPassword){
         return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
        
     }
     public String returnLoginStatus(boolean isLoggedIn){
         if (isLoggedIn){
             
             
             return "Welcome " + firstName + "," + surname + " it is great to see you again";
         }else{
             return "Username or password incorrect,please try again";
         }
     }
     public void setUsername(String username){this.username = username; }
    public void setPassword(String password){this.password = password; }
    public void setphoneNumber(String phoneNumber){this.phoneNumber = phoneNumber; }
}
