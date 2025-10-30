package com.servicedesk.backend.entities;

import org.springframework.data.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collation = "tb_fila_chamado")
public class FilaChamadoEntity {
    @Id
    private String filaChamadoId;
    private String nomeFila;
    @CreatedDate
    private Date criadoEm;
    @LastModifiedDate
    private Date atualizadoEm;
}
