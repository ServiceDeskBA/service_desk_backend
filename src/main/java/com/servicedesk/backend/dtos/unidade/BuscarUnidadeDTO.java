package com.servicedesk.backend.dtos.unidade;

import com.servicedesk.backend.dtos.MensagemStatusDTO;

public record BuscarUnidadeDTO(
        MensagemStatusDTO mensagemStatus,
        Long unidadeId,
        String nomeUnidade
) {
}
