package com.servicedesk.backend.dtos.filachamado;

import com.servicedesk.backend.dtos.MensagemStatusDTO;

import java.time.LocalDateTime;

public record BuscarFilaChamadoDTO(
        MensagemStatusDTO mensagemStatus,
        Long filaChamadoId,
        String nomeFilaChamado,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {
}
