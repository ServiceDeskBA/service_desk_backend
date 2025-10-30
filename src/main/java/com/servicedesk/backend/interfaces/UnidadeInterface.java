package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.unidade.AtualizarUnidadeDTO;
import com.servicedesk.backend.dtos.unidade.BuscarUnidadeDTO;
import com.servicedesk.backend.dtos.unidade.CriarUnidadeDTO;
import com.servicedesk.backend.entities.UnidadeEntity;

import java.util.List;

public interface UnidadeInterface {
    UnidadeEntity criarUnidade(CriarUnidadeDTO criarUnidadeDados);
    BuscarUnidadeDTO buscarUnidade(String unidadeId);
    List<BuscarUnidadeDTO> buscarTodasUnidades();
    MensagemStatusDTO atualizarUnidade(String unidadeId, AtualizarUnidadeDTO atualizarUnidadeDados);
    void deletarUnidade(String unidadeId);
    boolean verificaSeExisteUnidadePorId(String unidadeId);
}
