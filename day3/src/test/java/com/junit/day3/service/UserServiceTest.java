package test.java.com.junit.day3.service;

import main.java.com.junit.day3.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    void testStrongPassword(){
        assertTrue(userService.isStrongPassword("Suraj123"));
    }

    @Test
    void testWeakPassword_NoUpperCase(){
        assertFalse(userService.isStrongPassword("suraj123"));
    }

    @Test
    void testWeakPassword_NoLowerCase(){
        assertFalse(userService.isStrongPassword("SURAJ123"));  
    }

    @Test
    void testWeakPassword_NoDigit(){
        assertFalse(userService.isStrongPassword("Surajabc"));  
    }

    @Test
    void testWeakPassword_ShortLength(){
        assertFalse(userService.isStrongPassword("Su1a"));  
    }

    @Test
    void testWeakPassword_Null(){
        assertFalse(userService.isStrongPassword(null));  
    }

    
}
