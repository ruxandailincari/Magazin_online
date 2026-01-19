package com.shop.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @Email(message = "Email-ul este invalid.")
        String username,

        @Size(min = 8, message = "Parola trebuie să aibă minim 8 caractere.")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9]).*$", message = "Parola trebuie să conțină o majusculă și un număr.")
        String password) {
}
