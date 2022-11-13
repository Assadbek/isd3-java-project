package com.example.findtutor.repository;

import com.example.findtutor.model.user.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<MyUser, Long> {
    MyUser findSystemUserByUsername (String username);

}
