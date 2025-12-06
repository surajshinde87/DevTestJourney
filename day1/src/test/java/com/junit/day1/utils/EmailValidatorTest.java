package com.junit.day1.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    EmailValidator validator = new EmailValidator();

    @Test
    void testValidEmail() {
        assertTrue(validator.isValidEmail("surajshinde@gmail.com"));
    }

    @Test
    void testInvalidEmail() {
        assertFalse(validator.isValidEmail("surajshinde.com"));
    }

    @Test
    void testNullEmail() {
        assertFalse(validator.isValidEmail(null));
    }
}

