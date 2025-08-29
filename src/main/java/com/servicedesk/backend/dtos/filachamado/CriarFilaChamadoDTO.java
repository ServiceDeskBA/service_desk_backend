package com.servicedesk.backend.dtos.filachamado;

import com.mongodb.lang.NonNull;
import com.servicedesk.backend.dtos.MensagemStatusDTO;

public record CriarFilaChamadoDTO(
        @NonNull MensagemStatusDTO mensagemStatus,
        @NonNull String nomeFilaChamado
) {
}
