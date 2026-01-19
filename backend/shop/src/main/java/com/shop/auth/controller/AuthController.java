package com.shop.auth.controller;

import com.shop.auth.dto.LoginRequest;
import com.shop.auth.dto.JwtResponse;
import com.shop.auth.dto.RegisterRequest;
import com.shop.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest dto) {
        return authService.login(dto);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest dto, Errors errors){
        if(errors.hasErrors()){
            String e = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(Map.of("message", e));
        }
        try {
            authService.register(dto);
            return ResponseEntity.ok().build();
        } catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatusCode()).body(Map.of("message", e.getReason()));
        }
    }
}