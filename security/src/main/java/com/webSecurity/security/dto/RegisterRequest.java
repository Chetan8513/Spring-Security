package com.webSecurity.security.dto;


import com.webSecurity.security.entity.Role;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class RegisterRequest {


    private String name;


    private String email;


    private String password;

    private Role role;

    private Timestamp createdAt;
//
//    private boolean activeFlag;
}
