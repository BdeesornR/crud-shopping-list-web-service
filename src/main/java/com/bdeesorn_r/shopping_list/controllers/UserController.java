package com.bdeesorn_r.shopping_list.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bdeesorn_r.shopping_list.dto.request.RequestUserDto;
import com.bdeesorn_r.shopping_list.dto.response.ResponseCommonDto;
import com.bdeesorn_r.shopping_list.services.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<ResponseCommonDto> createNewUser(@RequestBody RequestUserDto userDto) {
        return ResponseEntity.ok().body(userService.createNewUser(userDto));
    }

    @GetMapping(value = "/show-all-user")
    public ResponseEntity<ResponseCommonDto> showAllUser() {
        return ResponseEntity.ok().body(userService.showAllUser());
    }
}
