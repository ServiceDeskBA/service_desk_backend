package com.servicedesk.backend.dtos.unidade;

public record AtualizarUnidadeDTO(
        String nomeUnidade
) {
    public static AtualizarUnidadeDTO from(CriarUnidadeDTO dto){
        return new AtualizarUnidadeDTO(dto.nomeUnidade());
    }
}
