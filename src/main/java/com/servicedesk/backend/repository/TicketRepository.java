package com.servicedesk.backend.repository;

import com.servicedesk.backend.entities.TicketEntity;
import com.servicedesk.backend.enums.PrioridadeTicket;
import com.servicedesk.backend.enums.StatusTicket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends MongoRepository<TicketEntity, String> {
    List<TicketEntity> findByStatusTicket(StatusTicket statusTicket);
    List<TicketEntity> findByPrioridade(PrioridadeTicket prioridade);
    List<TicketEntity> findByCriadoEmBetween(Date dataInicio, Date dataFim);
    List<TicketEntity> findByStatusTicketAndPrioridade(StatusTicket statusTicket, PrioridadeTicket prioridade);
    List<TicketEntity> findByStatusTicketAndCriadoEmBetween(StatusTicket statusTicket, Date dataInicio, Date dataFim);
    List<TicketEntity> findByPrioridadeAndCriadoEmBetween(PrioridadeTicket prioridade, Date dataInicio, Date dataFim);
    List<TicketEntity> findByStatusTicketAndPrioridadeAndCriadoEmBetween(StatusTicket statusTicket, PrioridadeTicket prioridade, Date dataInicio, Date dataFim);
}
