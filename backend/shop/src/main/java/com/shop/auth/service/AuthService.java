package com.shop.auth.service;

import com.shop.auth.dto.JwtResponse;
import com.shop.auth.dto.LoginRequest;
import com.shop.auth.dto.RegisterRequest;
import com.shop.auth.entity.Role;
import com.shop.auth.entity.User;
import com.shop.auth.repository.UserRepository;
import com.shop.auth.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service // ← acesta lipsește sau este șters
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public JwtResponse login(LoginRequest dto) {
        // 1. autentificare
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password())
        );

        // 2. extragem UserDetails (conține și autoritățile)
        UserDetails user = (UserDetails) auth.getPrincipal();
        String role = user.getAuthorities().iterator().next().getAuthority(); // "ADMIN" sau "CUSTOMER"

        // 3. generăm token cu rolul real
        String token = jwtUtils.generateToken(user.getUsername(), role);

        return new JwtResponse(token, role);
    }

    public void register(RegisterRequest dto){
        if(userRepository.findByUsername(dto.username()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole(Role.CUSTOMER);

        userRepository.save(user);
    }
}