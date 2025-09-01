package com.servicedesk.backend.dtos.ticket;

import com.mongodb.lang.NonNull;
import com.servicedesk.backend.dtos.MensagemStatusDTO;

public record CriarTicketDTO(
        @NonNull Long solicitanteUsuarioId,
        @NonNull Long ticketAbertoUsuarioId,
        @NonNull String descricaoProblema
) {
}
