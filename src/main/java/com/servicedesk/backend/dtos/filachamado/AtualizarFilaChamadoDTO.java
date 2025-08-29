package com.servicedesk.backend.dtos.filachamado;

import com.servicedesk.backend.dtos.MensagemStatusDTO;

public record AtualizarFilaChamadoDTO(
        MensagemStatusDTO mensagemStatus,
        String nomeFilaChamado
) {
    public static AtualizarFilaChamadoDTO from(CriarFilaChamadoDTO dto){
        return new AtualizarFilaChamadoDTO(dto.mensagemStatus(), dto.nomeFilaChamado());
    }
}
