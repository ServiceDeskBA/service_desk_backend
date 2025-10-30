package com.servicedesk.backend.dtos.filachamado;

import com.mongodb.lang.NonNull;

public record CriarFilaChamadoDTO(
        @NonNull String nomeFilaChamado
) {
}
