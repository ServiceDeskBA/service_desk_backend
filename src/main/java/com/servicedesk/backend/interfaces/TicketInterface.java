package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.ticket.AtualizarTicketDTO;
import com.servicedesk.backend.dtos.ticket.BuscarTicketDTO;
import com.servicedesk.backend.dtos.ticket.CriarTicketDTO;
import com.servicedesk.backend.entities.TicketEntity;
import com.servicedesk.backend.entities.UnidadeEntity;

import java.util.List;

public interface TicketInterface {
    TicketEntity criarTicket(CriarTicketDTO criarTicketDados);
    BuscarTicketDTO buscarTicket(Long ticketId);
    List<BuscarTicketDTO> buscarTodosTickets();
    MensagemStatusDTO atualizarTicket(Long ticketId, AtualizarTicketDTO atualizarTicketDados);
    void deletarTicket(Long ticketId);
    boolean verificaSeExisteTicketPorId(Long ticketId);
}
