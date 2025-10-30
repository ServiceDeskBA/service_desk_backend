package com.servicedesk.backend.dtos.filachamado;

import com.servicedesk.backend.dtos.MensagemStatusDTO;

import java.time.LocalDateTime;

public record BuscarFilaChamadoDTO(
        MensagemStatusDTO mensagemStatus,
        String filaChamadoId,
        String nomeFilaChamado,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {
}
