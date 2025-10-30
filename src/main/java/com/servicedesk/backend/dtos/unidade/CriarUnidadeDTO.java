package com.servicedesk.backend.dtos.unidade;

import com.mongodb.lang.NonNull;

public record CriarUnidadeDTO(
        @NonNull String nomeUnidade
) {
}
