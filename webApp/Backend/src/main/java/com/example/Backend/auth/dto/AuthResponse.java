package com.example.Backend.auth.dto;

public class AuthResponse {
    private boolean authenticated;
    private String message;

    public AuthResponse(boolean authenticated) {
        this.authenticated = authenticated;
        this.message = authenticated ? "Login exitoso" : "Credenciales incorrectas";
    }

       // Getters y Setters
    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

 

    
}
