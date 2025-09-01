package com.servicedesk.backend.repository;

import com.servicedesk.backend.entities.UnidadeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UnidadeRepository extends MongoRepository<UnidadeEntity, Long> {
}
