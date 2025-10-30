package com.servicedesk.backend.dtos.filachamado;

public record AtualizarFilaChamadoDTO(
        String nomeFilaChamado
) {
    public static AtualizarFilaChamadoDTO from(CriarFilaChamadoDTO dto){
        return new AtualizarFilaChamadoDTO(dto.nomeFilaChamado());
    }
}
