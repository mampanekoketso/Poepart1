/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.poepart2;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class POEPart2 {

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
                
   
    //PART 2
     if (!loginSuccess){
     System.out.println("Login failed.You  cannot access QuickChat");
     return;
     }
        System.out.println("welcome to quickchat.");
        
       int choice = 0;
       while (choice !=3){
           System.out.println("main menu");
           System.out.println("1) send message");
           System.out.println("2)Show recently sent messages");
           System.out.println("3)quit");
           System.out.println("select an option");
           
           if (!scanner.hasNextInt()){
               scanner.next();
               continue;
               
           }
           choice = scanner.nextInt();
           scanner.nextLine();
           
           switch(choice){
           case 1:
           System.out.println("how many messages do you wish to enter");
           int totalToEnter = scanner.nextInt();
           scanner.nextLine();
           Message msg = null;
           
           
               for (int i = 1; i <= totalToEnter; i++) {
                   System.out.println("enetering message" + i + "of" + totalToEnter + "----");
                   
                   System.out.println("ENTER RECIPIENT CELL NUMBER");
                   String recipient = scanner.nextLine();
                   
                   System.out.println("enetr message text:");
                   String text = scanner.nextLine();
                   
                    msg = new Message(i, recipient, text);
                   
                   String lenCheck = msg.vaildateMessageLength(text);
                   if (!lenCheck.equals("Message ready to send")){
                       System.out.println("lenCheck");
                       i--;
                       continue;
                   
                   
               }
               System.out.println("message ID generate: " + msg.getMessageID());
               System.out.println("1)send message");
               System.out.println("2)Disregard message");
               System.out.println("3)store message to sned later");
               System.out.print("choice:");
               int action = scanner.nextInt();
               scanner.nextLine();
               
               String actionResult = msg.SentMessage(action);
               System.out.println(actionResult);
               
               System.out.println("message details");
               System.out.println(msg.printMessage());
           }
           
           System.out.println("Total messages sent in this session: " + Message.returnTotalMessagess());
           break;
       
           case 2:
                System.out.println("coming soon.");
                break;
           
           case 3:
           System.out.println("THANK YOU FOR USING QUICKCHAT. GOODBYE!");
           break;
           
           default:
           System.out.println("Invaild option.Please try again");
           break;
           }
       }
    }
    }
       
       
    

  




