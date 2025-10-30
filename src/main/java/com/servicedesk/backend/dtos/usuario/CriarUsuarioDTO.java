package com.servicedesk.backend.dtos.usuario;

import com.mongodb.lang.NonNull;
import com.servicedesk.backend.enums.TipoUsuario;

public record CriarUsuarioDTO(
        @NonNull String unidadeId,
        @NonNull String nomeCompleto,
        @NonNull String email,
        @NonNull String senha,
        @NonNull TipoUsuario tipoUsuario
) {
}
