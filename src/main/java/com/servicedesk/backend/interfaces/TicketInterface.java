package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.ticket.AtualizarTicketDTO;
import com.servicedesk.backend.dtos.ticket.BuscarTicketDTO;
import com.servicedesk.backend.dtos.ticket.CriarTicketDTO;
import com.servicedesk.backend.entities.TicketEntity;

import java.util.List;

public interface TicketInterface {
    TicketEntity criarTicket(CriarTicketDTO criarTicketDados);
    BuscarTicketDTO buscarTicket(String ticketId);
    List<BuscarTicketDTO> buscarTodosTickets();
    MensagemStatusDTO atualizarTicket(String ticketId, AtualizarTicketDTO atualizarTicketDados);
    void deletarTicket(String ticketId);
    boolean verificaSeExisteTicketPorId(String ticketId);
}
