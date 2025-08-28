package com.servicedesk.backend.entities;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Field;

public class UnidadeEntity {
    @Field("_unidade_id")
    @Id
    private Long unidadeId;

    @Field("nome_unidade")
    private String nomeUnidade;
}
