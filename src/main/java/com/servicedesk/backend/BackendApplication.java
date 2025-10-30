package com.servicedesk.backend;

import com.servicedesk.backend.repository.FilaChamadoRepository;
import com.servicedesk.backend.repository.TicketRepository;
import com.servicedesk.backend.repository.UnidadeRepository;
import com.servicedesk.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoAuditing //permite que o Mongo possa setar coisas automáticas no banco, como createdAt
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.servicedesk.backend.repository")
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UnidadeRepository unidadeRepository;
    @Autowired
    FilaChamadoRepository filaChamadoRepository;
}
