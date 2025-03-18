package com.example.Backend.auth.repository;

import com.example.Backend.auth.model.User; // Asegúrate de que esta línea esté presente
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}