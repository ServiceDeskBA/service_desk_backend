package com.servicedesk.backend.entities;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "tb_unidade")
public class UnidadeEntity {
    @Id
    private String unidadeId;
    private String nomeUnidade;
}
