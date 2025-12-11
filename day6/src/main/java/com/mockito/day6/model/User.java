package com.mockito.day6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class User {
private Long id;
private String username;
private String email;
private String password;
    
}