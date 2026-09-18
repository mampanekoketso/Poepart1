/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
    @Test
    public void testUsernsmeFormatSuccess(){
        Login user = new Login();
        user.setUsername("kyl_1");
        assertTrue(user.checkUserName());
          
    }
    @Test
    public void testUsernameFormatFailure(){
        Login user = new Login();
        user.setUsername("kyle!!!!!!");
        assertFalse(user.checkUserName());
    }  
    @Test
    public void testPasswordSensitivitySuccess(){
        Login user = new Login();
        user.setPassword("Ch&&sec@ke99!");
        assertTrue(user.checkPasswordSensitivity());
        
    }
    @Test
    public void testPasswordSensitivityFailure(){
        Login user = new Login();
        user.setPassword("password");
        assertFalse(user.checkPasswordSensitivity());
    }
    
    @Test
     public void testphoneNumberSuccess(){
        Login user = new Login();
        user.setphoneNumber("+27838968901");
        assertTrue(user.checkphoneNumber());
     }
    
     @Test
     public void testphoneNumberFailure(){
        Login user = new Login();
        user.setphoneNumber("08966553");
        assertFalse(user.checkphoneNumber());
     }
     @Test
     public void testLoginSuccess(){
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
     }
     @Test
     public void testLoginFailure(){
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
        assertFalse(user.loginUser("kyl_1", "wrongpassword"));
     }
     @Test 
     public void testresgisterUserFailureMessage(){
     Login user = new Login("kyle!!!!!!", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
     String expectedMessage =  "username is not correctly formatted; please ensure that your usernamecontain an underscore and is no more than five characters in length";
             assertEquals(expectedMessage, user.registerUser());
     
             
     }   
     @Test 
     public void testUsernameExactlyLengthSize(){
         Login user = new Login();
         user.setUsername("ab_12");
         assertTrue(user.checkUserName());
     }
     @Test 
     public void testReturningLoginStatusSuccessMessage(){
         Login user = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
          boolean loginSuccess = user.loginUser("kyl_1" , "Ch&&sec@ke99!");
          String expectedWelcomeMessage = "Welcome Kyle,Smith it is great to see you again";
          assertEquals(expectedWelcomeMessage, user.returnLoginStatus(loginSuccess));
     }
}
    
    
