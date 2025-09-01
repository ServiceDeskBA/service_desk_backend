package com.servicedesk.backend.dtos.unidade;

import com.mongodb.lang.NonNull;
import com.servicedesk.backend.dtos.MensagemStatusDTO;

public record CriarUnidadeDTO(
        @NonNull String nomeUnidade
) {
}
