package com.servicedesk.backend.entities;

import org.springframework.data.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
public class FilaChamadoEntity {
    @Field("_fila_chamado_id")
    @Id
    private Long filaChamadoId;

    @Field("nome_fila")
    private String nomeFila;

    @Field("criado_em")
    @CreatedDate
    private LocalDateTime criadoEm;

    @Field("atualizado_em")
    @LastModifiedDate
    private LocalDateTime atualizadoEm;
}
