package com.servicedesk.backend.controllers;

import com.servicedesk.backend.dtos.ticket.BuscarTicketDTO;
import com.servicedesk.backend.enums.PrioridadeTicket;
import com.servicedesk.backend.enums.StatusTicket;
import com.servicedesk.backend.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/filtrar")
    public ResponseEntity<List<BuscarTicketDTO>> filtrarChamados(
            @RequestParam(required = false) StatusTicket status,
            @RequestParam(required = false) PrioridadeTicket prioridade,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFim) {
        
        List<BuscarTicketDTO> chamados = ticketService.filtrarChamados(status, prioridade, dataInicio, dataFim);
        return ResponseEntity.ok(chamados);
    }
}


