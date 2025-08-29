package com.servicedesk.backend.entities;

import com.servicedesk.backend.enums.TipoUsuario;
import org.springframework.data.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
public class UsuarioEntity {
    @Field("_usuario_id")
    @Id
    private Long usuarioId;

    @Field("unidade_id")
    private Long unidadeId;

    @Field("nome_completo")
    private String nomeCompleto;

    @Field("email")
    private String email;

    @Field("senha")
    private String senha;

    @Field("token")
    private String token;

    @Field("tipo_usuario")
    private TipoUsuario tipoUsuario;

    @Field("criado_em")
    @CreatedDate
    private LocalDateTime criadoEm;

    @Field("atualizado_em")
    @LastModifiedDate
    private LocalDateTime atualizadoEm;
}
