package com.servicedesk.backend.repository;

import com.servicedesk.backend.entities.TicketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<TicketEntity, String> {
}
