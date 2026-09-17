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
        user.setphoneNumber("+278389689");
        assertTrue(user.checkphoneNumber());
     }
     @Test
     public void testphoneNumberFailure(){
        Login user = new Login();
        user.setphoneNumber("08966553");
        assertTrue(user.checkphoneNumber());
     }
     @Test
     public void testLoginSuccess(){
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
     }
     @Test
     public void testLoginFailure(){
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
        assertTrue(user.loginUser("kyl_1", "wrongpassword"));
     }
     
}
    
    
