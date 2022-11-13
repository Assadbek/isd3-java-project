package com.example.findtutor.controller;

import com.example.findtutor.model.user.MyUser;
import com.example.findtutor.model.user.Role;
import com.example.findtutor.model.user.RoleToUser;
import com.example.findtutor.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<MyUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("user/save")
    public ResponseEntity<MyUser> saveUser(@RequestBody MyUser user){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping ("role/save")
    public ResponseEntity<Role> saveUser(@RequestBody Role role){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping ("role/assigntouser")
    public ResponseEntity<?> assignRole(@RequestBody RoleToUser roleToUser){
        userService.assignRole(roleToUser.getUsername(), roleToUser.getRoleName());
        return ResponseEntity.ok().build();
    }

}
