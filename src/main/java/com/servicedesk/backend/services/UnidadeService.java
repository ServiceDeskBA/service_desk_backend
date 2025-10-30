package com.servicedesk.backend.services;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.unidade.AtualizarUnidadeDTO;
import com.servicedesk.backend.dtos.unidade.BuscarUnidadeDTO;
import com.servicedesk.backend.dtos.unidade.CriarUnidadeDTO;
import com.servicedesk.backend.entities.UnidadeEntity;
import com.servicedesk.backend.exceptions.NaoEncontradoException;
import com.servicedesk.backend.interfaces.UnidadeInterface;
import com.servicedesk.backend.repository.UnidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService implements UnidadeInterface {
    private final UnidadeRepository unidadeRepository;
    private final ModelMapper modelMapper;

    public UnidadeService(UnidadeRepository unidadeRepository, ModelMapper modelMapper){
        this.unidadeRepository = unidadeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UnidadeEntity criarUnidade(CriarUnidadeDTO criarUnidadeDados) {
        UnidadeEntity unidadeEntidade = modelMapper.map(criarUnidadeDados, UnidadeEntity.class);
        return this.unidadeRepository.save(unidadeEntidade);
    }

    @Override
    public BuscarUnidadeDTO buscarUnidade(String unidadeId) {
        UnidadeEntity unidadeEntidade = this.unidadeRepository.findById(unidadeId)
                .orElseThrow(() -> new NaoEncontradoException("Unidade",'a'));

        return modelMapper.map(unidadeEntidade, BuscarUnidadeDTO.class);
    }

    @Override
    public List<BuscarUnidadeDTO> buscarTodasUnidades() {
        if(this.unidadeRepository.count() == 0) throw new RuntimeException("Nenhuma unidade encontrada");

        List<UnidadeEntity> unidades = this.unidadeRepository.findAll();

        return unidades.stream()
                .map(unidade -> modelMapper.map(unidade,BuscarUnidadeDTO.class))
                .toList();
    }

    @Override
    public MensagemStatusDTO atualizarUnidade(String unidadeId, AtualizarUnidadeDTO atualizarUnidadeDados) {
        if(!this.verificaSeExisteUnidadePorId(unidadeId)) throw new NaoEncontradoException("Unidade",'a');

        this.modelMapper.getConfiguration().setSkipNullEnabled(true);
        UnidadeEntity unidadeEntidade = this.modelMapper.map(atualizarUnidadeDados, UnidadeEntity.class);

        this.unidadeRepository.save(unidadeEntidade);
        return new MensagemStatusDTO("Unidade atualiza com sucesso", 200);
    }

    @Override
    public void deletarUnidade(String unidadeId) {
        this.unidadeRepository.deleteById(unidadeId);

        if(this.verificaSeExisteUnidadePorId(unidadeId)) throw new RuntimeException("Erro ao deletar unidade");
    }

    @Override
    public boolean verificaSeExisteUnidadePorId(String unidadeId) {
        return this.unidadeRepository.existsById(unidadeId);
    }
}
