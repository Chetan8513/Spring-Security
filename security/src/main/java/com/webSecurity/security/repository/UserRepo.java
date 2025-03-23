package com.webSecurity.security.repository;


import com.webSecurity.security.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {


    Optional <User> findByEmail(String email);
}
