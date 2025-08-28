package com.servicedesk.backend.dtos.usuario;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.enums.TipoUsuario;
import java.time.LocalDateTime;

public record BuscarUsuarioDTO(
        MensagemStatusDTO mensagemStatus,
        Long usuarioId,
        Long unidadeId,
        String nomeCompleto,
        String email,
        TipoUsuario tipoUsuario,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {
}
