package com.servicedesk.backend.entities;

import com.servicedesk.backend.enums.StatusTicket;
import org.springframework.data.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "tb_ticket")
@Data
public class TicketEntity {
    @Id
    private String ticketId;
    private String solicitanteUsuarioId;
    private String ticketAbertoUsuarioId;
    private String atribuicaoUsuarioId;
    private StatusTicket statusTicket;
    private Long numeroChamado;
    private String descricaoProblema;
    private String descricaoSolucao;
    @CreatedDate
    private Date criadoEm;
    @LastModifiedDate
    private Date dataEncerramentoLimite;
}
