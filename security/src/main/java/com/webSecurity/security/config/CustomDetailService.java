package com.webSecurity.security.config;

import com.webSecurity.security.entity.User;
import com.webSecurity.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CustomDetailService implements UserDetailsService {



    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepo.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        User user = userOptional.get();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()))
        );
    }
}