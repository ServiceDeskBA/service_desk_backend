package com.servicedesk.backend.dtos.ticket;

import com.mongodb.lang.NonNull;

public record CriarTicketDTO(
        @NonNull String solicitanteUsuarioId,
        @NonNull String ticketAbertoUsuarioId,
        @NonNull String descricaoProblema
) {
}
