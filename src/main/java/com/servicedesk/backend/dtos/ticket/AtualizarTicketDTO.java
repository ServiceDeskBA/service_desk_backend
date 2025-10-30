package com.servicedesk.backend.dtos.ticket;

public record AtualizarTicketDTO(
        String solicitanteUsuarioId,
        String ticketAbertoUsuarioId,
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
