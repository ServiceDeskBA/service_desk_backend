package com.servicedesk.backend.repository;

import com.servicedesk.backend.entities.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {
    // Método com Optional para o email a ser procurado sempre ser tradado antes de retornar
    Optional<UsuarioEntity> findByEmail(String email);
}
