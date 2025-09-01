package com.servicedesk.backend.dtos.ticket;

import com.servicedesk.backend.dtos.MensagemStatusDTO;

public record AtualizarTicketDTO(
        Long solicitanteUsuarioId,
        Long ticketAbertoUsuarioId,
        String descricaoProblema
) {
    public static AtualizarTicketDTO from(AtualizarTicketDTO dto){
        return new AtualizarTicketDTO(
                dto.solicitanteUsuarioId(),
                dto.ticketAbertoUsuarioId(),
                dto.descricaoProblema()
        );
    }
}
