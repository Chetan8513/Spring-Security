package com.webSecurity.security.service;


import com.webSecurity.security.dto.AuthRequest;
import com.webSecurity.security.dto.RegisterRequest;
import com.webSecurity.security.entity.User;
import com.webSecurity.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private  PasswordEncoder passwordEncoder;


    public String registerUser(RegisterRequest registerRequest) {

        Optional<User> findUser = userRepo.findByEmail(registerRequest.getEmail());

        if (findUser.isPresent()) {
            throw new RuntimeException("userName already exist in out records");
        }


        User user = new User();

        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));  // password saved in hashed
      user.setCreatedAt(registerRequest.getCreatedAt());
        user.setRole(registerRequest.getRole());


         userRepo.save(user);

         return "User registered succesfully";
    }




    public String verifiedUser(AuthRequest authRequest){


        Optional<User>userExist = userRepo.findByEmail(authRequest.getEmail());

        if(userExist.isEmpty()){
            return "user not found";
        }

        User user = userExist.get();


        if(!passwordEncoder.matches(user.getPassword(), authRequest.getPassword())){

            return "Login unsusseful:";
        }

        return "login sucessfull:"+user.getName();
    }

}
