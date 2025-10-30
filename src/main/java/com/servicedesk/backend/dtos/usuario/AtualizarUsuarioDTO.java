package com.servicedesk.backend.dtos.usuario;

import com.servicedesk.backend.enums.TipoUsuario;

public record AtualizarUsuarioDTO(
        String unidadeId,
        String nomeCompleto,
        String email,
        String senha,
        TipoUsuario tipoUsuario
) {
    public static AtualizarUsuarioDTO from(CriarUsuarioDTO dto){
        return new AtualizarUsuarioDTO(
            dto.unidadeId(),
            dto.nomeCompleto(),
            dto.email(),
            dto.senha(),
            dto.tipoUsuario()
        );
    }
}
