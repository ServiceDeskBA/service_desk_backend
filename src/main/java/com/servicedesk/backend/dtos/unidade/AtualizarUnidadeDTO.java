package com.servicedesk.backend.dtos.unidade;

import com.servicedesk.backend.dtos.MensagemStatusDTO;

public record AtualizarUnidadeDTO(
        MensagemStatusDTO mensagemStatus,
        String nomeUnidade
) {
    public static AtualizarUnidadeDTO from(CriarUnidadeDTO dto){
        return new AtualizarUnidadeDTO(dto.mensagemStatus(), dto.nomeUnidade());
    }
}
