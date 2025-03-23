package com.webSecurity.security.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "User_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    private String name;


    private String email;


    private String password;


    private Timestamp createdAt;

    private boolean activeFlag;



    @Enumerated(EnumType.STRING)
    private Role role;



}
