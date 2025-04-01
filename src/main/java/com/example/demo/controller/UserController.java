package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "사용자 관리 API")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @Operation(summary = "모든 사용자 조회", description = "데이터베이스에 저장된 모든 사용자를 조회합니다.")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "새 사용자 생성", description = "새로운 사용자를 생성하고 저장합니다.")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
