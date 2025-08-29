package com.servicedesk.backend.entities;

import com.servicedesk.backend.enums.StatusTicket;
import org.springframework.data.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "service_desk")
@Data
public class TicketEntity {
    @Field("_ticket_id")
    @Id
    private Long ticketId;

    @Field("solicitante_usuario_id")
    private Long solicitanteUsuarioId;

    @Field("ticket_aberto_usuario_id")
    private Long ticketAbertoUsuarioId;

    @Field("atribuicao_usuario_id")
    private Long atribuicaoUsuarioId;

    @Field("status_ticket")
    private StatusTicket statusTicket;

    @Field("numero_chamado")
    private Long numeroChamado;

    @Field("descricao_problema")
    private String descricaoProblema;

    @Field("descricao_solucao")
    private String descricaoSolucao;

    @Field("criado_em")
    @CreatedDate
    private LocalDateTime criadoEm;

    @Field("atualizado_em")
    @LastModifiedDate
    private LocalDateTime dataEncerramentoLimite;
}
