package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.ticket.AtualizarTicketDTO;
import com.servicedesk.backend.dtos.ticket.CriarTicketDTO;
import com.servicedesk.backend.entities.TicketEntity;
import com.servicedesk.backend.entities.UnidadeEntity;

import java.util.List;

public interface TicketInterface {
    void criarTicket(CriarTicketDTO criarTicketDados);
    TicketEntity buscarTicket(Long ticketId);
    List<TicketEntity> buscarTodosTickets();
    void atualizarTicket(Long ticketId, AtualizarTicketDTO atualizarTicketDados);
    void deletarTicket(Long ticketId);
    boolean verificaSeExisteTicketPorId(Long ticketId);
}
