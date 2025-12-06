package com.junit.day1.utils;


public class EmailValidator {

    public boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}
