package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.unidade.AtualizarUnidadeDTO;
import com.servicedesk.backend.dtos.unidade.BuscarUnidadeDTO;
import com.servicedesk.backend.dtos.unidade.CriarUnidadeDTO;
import com.servicedesk.backend.entities.UnidadeEntity;

import java.util.List;

public interface UnidadeInterface {
    UnidadeEntity criarUnidade(CriarUnidadeDTO criarUnidadeDados);
    BuscarUnidadeDTO buscarUnidade(Long unidadeId);
    List<BuscarUnidadeDTO> buscarTodasUnidades();
    MensagemStatusDTO atualizarUnidade(Long unidadeId, AtualizarUnidadeDTO atualizarUnidadeDados);
    void deletarUnidade(Long unidadeId);
    boolean verificaSeExisteUnidadePorId(Long unidadeId);
}
