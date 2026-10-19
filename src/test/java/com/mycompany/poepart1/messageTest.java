package com.mycompany.poepart1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */

public class messageTest {
    @BeforeEach
    @Test
    public void setUp(){
        Message.returnTotalMessages();
    }
     @Test
     public void testMessageLengthSuccess(){
         Message msg = new Message();
         String text = "hi mike can you join us for dinner tonight?";
         assertEquals("Message ready to send.", msg.vaildateMessageLength(text));
     }
     
     @Test
     public void testMessageLenghtFailure(){
          Message msg = new Message();
          StringBuilder longText = new StringBuilder();
          for (int i = 0; i < 260; i++) {
              longText.append("a");
             
         }
          String expected = "Message exceeds 250 characters by10;please reduce the size";
          assertEquals(expected, msg.vaildateMessageLength(longText.toString()));
     }
     @Test
     public void testRecipientCellSuccess(){
          Message msg = new Message(1, "+27718693002", "Test message");
          assertEquals("cell number successfully captured", msg.checkRecipientsCell());
     }
     @Test
     public void testRecipientCellFailure(){
         Message msg = new Message(1, "0857595889", "Test message");
         
         String expected = "cell number is incorreclty formattered or does not contain an internationalcode.Please correct the number and try again";
         assertEquals(expected, msg.checkRecipientsCell());
         
     }
     @Test
     public void testMessageHashTestCase1(){
         Message msg = new Message(0,"+27718693002", "hi mike can you join us for dinner tonight?" );
        msg.setMessageID("0012345678");
        assertEquals("00:0:HITONIGHT", msg.createMessageHash());
        
}
     @Test
     public void testMessageIDCreation(){
            Message msg = new Message(1, "+27718693002", "Sample text");
            assertNotNull(msg.getMessageID());
            assertTrue(msg.checkMessageID());
            
     }
     @Test
     public void testSentMessageOptions(){
         Message msg = new Message(1, "+27718693002", "Sample text" );
         assertEquals("message successfully sent", msg.SentMessage(1));
         assertEquals("press 0 to delete the mesage", msg.SentMessage(2));
          assertEquals("message successfully stored", msg.SentMessage(3));
     }
            
            
     }
