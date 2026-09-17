/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.poepart1;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class POEPart1 {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         
         System.out.println("Please enter your first name");
         String firstName = scanner.nextLine();
         
         System.out.println("Please enter your surname");
         String surname = scanner.nextLine();
         
         System.out.println("Please enter your uesrname");
         String username = scanner.nextLine();
         
         System.out.println("Please enter your password");
         String password = scanner.nextLine();
         
         System.out.println("Please enter your phone number");
         String phoneNumber = scanner.nextLine();
         
         
         Login user = new Login(firstName, password, username, phoneNumber, surname);
         
         //show resgistration status
         String registerMessage = user.registerUser();
         System.out.println(registerMessage);
         
         if(!registerMessage.equals("User is registered successfully")){
             return;
         }
         System.out.println("login");
         System.out.println("Please enter your username");
         String loginUser = scanner.nextLine();
         
         System.out.println("Please enter your password");
         String loginPass = scanner.nextLine();
         
         boolean loginSuccess = user.loginUser(loginUser, loginPass);
         System.out.println(user.returnLoginStatus(loginSuccess));
         
             
            
            
        
        }
    }

