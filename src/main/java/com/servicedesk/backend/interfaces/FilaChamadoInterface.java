package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.filachamado.AtualizarFilaChamadoDTO;
import com.servicedesk.backend.dtos.filachamado.BuscarFilaChamadoDTO;
import com.servicedesk.backend.dtos.filachamado.CriarFilaChamadoDTO;
import com.servicedesk.backend.entities.FilaChamadoEntity;
import java.util.List;

public interface FilaChamadoInterface {
    FilaChamadoEntity criarFilaChamado(CriarFilaChamadoDTO criarFilaChamadoDados);
    BuscarFilaChamadoDTO buscarFilaChamado(Long filaChamadoId);
    List<BuscarFilaChamadoDTO> buscarTodasFilaChamado();
    MensagemStatusDTO atualizarFilaChamado(Long filaChamadoId, AtualizarFilaChamadoDTO atualizarFilaChamadoDados);
    void deletarFilaChamado(Long filaChamadoId);
    boolean verificaSeExisteFilaChamadoPorId(Long filaChamadoId);
}
