package com.example.Backend.auth.service;

import com.example.Backend.auth.model.User;
import com.example.Backend.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Método para registrar un nuevo usuario
    public User registerUser (User user) {
        // Verificar si el nombre de usuario ya está en uso
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
        // Guardar el nuevo usuario en la base de datos
        return userRepository.save(user);
    }

    // Método para autenticar un usuario
    public Optional<User> authenticateUser (String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));
    }
}