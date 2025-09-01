package com.servicedesk.backend.repository;

import com.servicedesk.backend.entities.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, Long> {
}
