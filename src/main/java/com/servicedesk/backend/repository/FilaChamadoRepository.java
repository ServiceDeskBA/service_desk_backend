package com.servicedesk.backend.repository;

import com.servicedesk.backend.entities.FilaChamadoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilaChamadoRepository extends MongoRepository<FilaChamadoEntity, Long> {
}
