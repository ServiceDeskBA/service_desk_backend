package com.servicedesk.backend.dtos.usuario;

import com.mongodb.lang.NonNull;
import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.enums.TipoUsuario;

public record CriarUsuarioDTO(
        @NonNull Long unidadeId,
        @NonNull String nomeCompleto,
        @NonNull String email,
        @NonNull String senha,
        @NonNull TipoUsuario tipoUsuario
) {
}
