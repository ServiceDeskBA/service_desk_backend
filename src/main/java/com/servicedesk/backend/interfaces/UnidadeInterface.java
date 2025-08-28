package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.unidade.AtualizarUnidadeDTO;
import com.servicedesk.backend.dtos.unidade.CriarUnidadeDTO;
import com.servicedesk.backend.entities.UnidadeEntity;

import java.util.List;

public interface UnidadeInterface {
    void criarUnidade(CriarUnidadeDTO criarUnidadeDados);
    UnidadeEntity buscarUnidade(Long unidadeId);
    List<UnidadeEntity> buscarTodasUnidades();
    void atualizarUnidade(Long unidadeId, AtualizarUnidadeDTO atualizarUnidadeDados);
    void deletarUnidade(Long unidadeId);
    boolean verificaSeExisteUnidadePorId(Long unidadeId);
}
