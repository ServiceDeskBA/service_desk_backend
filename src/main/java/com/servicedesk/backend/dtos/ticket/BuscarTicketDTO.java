package com.servicedesk.backend.dtos.ticket;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.enums.StatusTicket;

import java.time.LocalDateTime;

public record BuscarTicketDTO(
        MensagemStatusDTO mensagemStatusDTO,
        String ticketId,
        String solicitanteUsuarioId,
        String ticketAbertoUsuarioId,
        String atribuicaoUsuarioId, // escolher aleatorio com base da unidade
        StatusTicket statusTicket,
        String numeroChamado,
        String descricaoProblema,
        String descricaoSolucao,
        LocalDateTime criadoEm,
        LocalDateTime dataEncerramentoLimite
) {
}
