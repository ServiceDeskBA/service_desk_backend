package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.filachamado.AtualizarFilaChamadoDTO;
import com.servicedesk.backend.dtos.filachamado.CriarFilaChamadoDTO;
import com.servicedesk.backend.entities.FilaChamadoEntity;
import java.util.List;

public interface FilaChamadoInterface {
    void criarFilaChamado(CriarFilaChamadoDTO criarFilaChamadoDados);
    FilaChamadoEntity buscarFilaChamado(Long filaChamadoId);
    List<FilaChamadoEntity> buscarTodasFilaChamado();
    void atualizarFilaChamado(Long filaChamadoId, AtualizarFilaChamadoDTO atualizarFilaChamadoDados);
    void deletarFilaChamado(Long filaChamadoId);
    boolean verificaSeExisteFilaChamadoPorId(Long filaChamadoId);
}
