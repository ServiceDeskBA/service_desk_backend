package com.servicedesk.backend.dtos.filachamado;

import com.servicedesk.backend.dtos.MensagemStatusDTO;

public record AtualizarFilaChamadoDTO(
        String nomeFilaChamado
) {
    public static AtualizarFilaChamadoDTO from(CriarFilaChamadoDTO dto){
        return new AtualizarFilaChamadoDTO(dto.nomeFilaChamado());
    }
}
