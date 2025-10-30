package com.servicedesk.backend.services;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.ticket.AtualizarTicketDTO;
import com.servicedesk.backend.dtos.ticket.BuscarTicketDTO;
import com.servicedesk.backend.dtos.ticket.CriarTicketDTO;
import com.servicedesk.backend.entities.TicketEntity;
import com.servicedesk.backend.enums.StatusTicket;
import com.servicedesk.backend.exceptions.NaoEncontradoException;
import com.servicedesk.backend.helpers.GerarCodigoHelper;
import com.servicedesk.backend.interfaces.TicketInterface;
import com.servicedesk.backend.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements TicketInterface {
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final GerarCodigoHelper gerarCodigoHelper;

    public TicketService(
            TicketRepository ticketRepository,
            ModelMapper modelMapper,
            GerarCodigoHelper gerarCodigoHelper
            ){
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
        this.gerarCodigoHelper = gerarCodigoHelper;
    }


    @Override
    public TicketEntity criarTicket(CriarTicketDTO criarTicketDados) {
        TicketEntity ticketEntidade = this.modelMapper.map(criarTicketDados, TicketEntity.class);
        ticketEntidade.setStatusTicket(StatusTicket.NOVO);
        ticketEntidade.setNumeroChamado(gerarCodigoHelper.gerarNumeroChamado());

        return this.ticketRepository.save(ticketEntidade);
    }

    @Override
    public BuscarTicketDTO buscarTicket(String ticketId) {
        Optional<TicketEntity> ticket = this.ticketRepository.findById(ticketId);
        if(ticket.isEmpty()) throw new NaoEncontradoException("Ticket",'o');

        return modelMapper.map(ticket, BuscarTicketDTO.class);
    }

    @Override
    public List<BuscarTicketDTO> buscarTodosTickets() {
        if(this.ticketRepository.count() == 0) throw new RuntimeException("Nenhum ticket encontrado");

        List<TicketEntity> tickets = this.ticketRepository.findAll();

        return tickets.stream()
                .map(ticket -> modelMapper.map(ticket, BuscarTicketDTO.class))
                .toList();
    }

    @Override
    public MensagemStatusDTO atualizarTicket(String ticketId, AtualizarTicketDTO atualizarTicketDados) {
        if(!this.verificaSeExisteTicketPorId(ticketId)) new NaoEncontradoException("Ticket",'o');

        this.modelMapper.getConfiguration().setSkipNullEnabled(true);
        TicketEntity ticketEntidade = this.modelMapper.map(atualizarTicketDados, TicketEntity.class);

        ticketRepository.save(ticketEntidade);

        return new MensagemStatusDTO("Ticket atualizado com sucesso", 200);
    }

    @Override
    public void deletarTicket(String ticketId) {
        this.ticketRepository.deleteById(ticketId);

        Optional<TicketEntity> verificaSeDeletouTicket = this.ticketRepository.findById(ticketId);
        if(verificaSeDeletouTicket.isPresent()) throw new RuntimeException("Erro ao deletar ticket");
    }

    @Override
    public boolean verificaSeExisteTicketPorId(String ticketId) {
        return this.ticketRepository.existsById(ticketId);
    }
}
