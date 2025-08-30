package com.servicedesk.backend.services;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.filachamado.AtualizarFilaChamadoDTO;
import com.servicedesk.backend.dtos.filachamado.BuscarFilaChamadoDTO;
import com.servicedesk.backend.dtos.filachamado.CriarFilaChamadoDTO;
import com.servicedesk.backend.entities.FilaChamadoEntity;
import com.servicedesk.backend.exceptions.NaoEncontradoException;
import com.servicedesk.backend.interfaces.FilaChamadoInterface;
import com.servicedesk.backend.repository.FilaChamadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilaChamadoService implements FilaChamadoInterface {
    private final FilaChamadoRepository filaChamadoRepository;
    private final ModelMapper modelMapper;

    public FilaChamadoService(FilaChamadoRepository filaChamadoRepository, ModelMapper modelMapper){
        this.filaChamadoRepository = filaChamadoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FilaChamadoEntity criarFilaChamado(CriarFilaChamadoDTO criarFilaChamadoDados) {
        FilaChamadoEntity filaChamadoEntidade = modelMapper.map(criarFilaChamadoDados, FilaChamadoEntity.class);
        return this.filaChamadoRepository.save(filaChamadoEntidade);
    }

    @Override
    public BuscarFilaChamadoDTO buscarFilaChamado(Long filaChamadoId) {
        FilaChamadoEntity filaChamadoEntidade = this.filaChamadoRepository.findById(filaChamadoId)
                .orElseThrow(() -> new NaoEncontradoException("Fila de Chamado",'a'));

        return modelMapper.map(filaChamadoEntidade, BuscarFilaChamadoDTO.class);
    }

    @Override
    public List<BuscarFilaChamadoDTO> buscarTodasFilaChamado() {
        if(this.filaChamadoRepository.count() == 0) throw new RuntimeException("Nenhuma fila de chamado encontrada");

        return this.filaChamadoRepository.findAll()
                .stream()
                .map(filaChamado -> modelMapper.map(filaChamado, BuscarFilaChamadoDTO.class))
                .toList();

    }

    @Override
    public MensagemStatusDTO atualizarFilaChamado(Long filaChamadoId, AtualizarFilaChamadoDTO atualizarFilaChamadoDados) {
        if(!this.verificaSeExisteFilaChamadoPorId(filaChamadoId)) throw new NaoEncontradoException("Fila de Chamado",'a');

        this.modelMapper.getConfiguration().setSkipNullEnabled(true);
        FilaChamadoEntity filaChamadoEntidade = this.modelMapper.map(atualizarFilaChamadoDados, FilaChamadoEntity.class);

        this.filaChamadoRepository.save(filaChamadoEntidade);

        return new MensagemStatusDTO("Fila de Chamados atualizados com sucesso",200);
    }

    @Override
    public void deletarFilaChamado(Long filaChamadoId) {
        this.filaChamadoRepository.deleteById(filaChamadoId);

        if(this.filaChamadoRepository.existsById(filaChamadoId)) throw new RuntimeException("Erro ao deletar Fila de Chamado");
    }

    @Override
    public boolean verificaSeExisteFilaChamadoPorId(Long filaChamadoId) {
        return this.filaChamadoRepository.existsById(filaChamadoId);
    }
}
