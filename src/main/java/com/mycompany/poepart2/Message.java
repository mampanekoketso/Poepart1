/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 *
 * @author Student
 */
public class Message {
    private String messageID;
    private int messageNumber;
    private String recipientCell;
    private String messageText;
    private static int totalMessagesSent = 0;
    
    public Message(){}
    
    public Message(int messageNumber,String recipientCell,String messageText){
       this.messageNumber = messageNumber;
       this.recipientCell = recipientCell;
       this.messageText = messageText;
       this.messageID = generateMessageID();
    }
    public String generateMessageID(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
            
        }
        return sb.toString();
        
    }
    public boolean checkMessageID(){
        return messageID != null && messageID.length() <=10;
    }
    public String vaildateMessageLength(String text){
        if(text != null && text.length()<250){
            return "Message ready to send.";
        
        }else{
            int excess = (text == null ? 0 :text.length()-250);
            return "Message exceeds 250 characters by" + excess + ";please reduce the size";
        }
    }
    public String checkRecipientsCell(){
        if (recipientCell != null && recipientCell.length() <= 10 && recipientCell.startsWith("+27")){
            return "Cell number successfully captured.";
        }else if(recipientCell != null && recipientCell.startsWith("+27")){
            return "cell number successfully captured";
        }else{
            return "cell number is incorreclty formattered or does not contain an internationalcode.Please correct the number and try again";
            
        }
    }
    public String createMessageHash(){
        if (messageID == null || messageID.length() <2 || messageText == null || messageText.trim().isEmpty()){
            return "";
        }
        String firstTwo = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z0-9]", "");
        String lastWord = words[words.length -1].replaceAll("[^a-zA-Z0-9]", "");
        
        String rawHash = firstTwo +":" + messageNumber + ":" + firstWord + lastWord;
        return rawHash.toUpperCase();
    }
    public String SentMessage(int choice){
        switch (choice){
            case 1:
                totalMessagesSent++;
                return "message successfully sent";
            case 2:
                return "press 0 to delete the mesage";
            case 3:
                storeMessage();
                return "message successfully stored";
            default:
                return "invaild option.";
        }
        }
    public String printMessage(){
        return "Message ID: " + messageID + "\n"
        + "Message Hash: " + createMessageHash() + "\n"
        + "Recipient: " + recipientCell + "\n"
        + "message: " + messageText;
    }
     public static int returnTotalMessagess(){
      return totalMessagesSent;   
     }
     public static void returnTotalMessages(){
         totalMessagesSent = 0;
     }
     public void storeMessage(){
         String jsonString = "{\n"
                 +" \"messageId\": \"" +messageID + "\",\n"
                 +" \"messageNumber\": "+ messageNumber + ",\n"
                 +" \"recipient\": \"" + recipientCell + "\",\n"
                 +" \"message\": \"" + messageText.replace("\"", "\\\"") + "\",\n"
                 +" \"messageHash\": \"" + createMessageHash() + "\"\n"
                 +"}";
    
         try (FileWriter writer = new FileWriter("stored_message.json", true)){
           writer.write(jsonString + "\n");
         }catch (IOException e){
            System.out.println("Error saving message to JSON:" + e.getMessage());
         }
       
    }
    
             public String getMessageID(){ return messageID; }
             public void setMessageID(String messageID) {this.messageID = messageID; }
             public String getRecipientCell() {return recipientCell;}
             public void setRecipientCell(String recipientCell) {this.recipientCell = recipientCell; }
             public String getMessageText() {return messageText;}
             public void setMessageText(String MessageText) {this.messageText = messageText; }
             public int getMessageNumber() {return messageNumber;}
             public void  setMessageNumber (int messageNumber){this.messageNumber = messageNumber;}      
}

