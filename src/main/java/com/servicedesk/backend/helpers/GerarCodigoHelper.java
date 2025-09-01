package com.servicedesk.backend.helpers;

import com.servicedesk.backend.repository.TicketRepository;
import org.springframework.stereotype.Component;

@Component
public class GerarCodigoHelper {
    private final TicketRepository ticketRepository;

    public GerarCodigoHelper(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public long gerarNumeroChamado(){
        long countTicket = this.ticketRepository.count();
        return countTicket + 1;
    }
}
