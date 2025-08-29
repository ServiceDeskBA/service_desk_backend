package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.usuario.AtualizarUsuarioDTO;
import com.servicedesk.backend.dtos.usuario.BuscarUsuarioDTO;
import com.servicedesk.backend.dtos.usuario.CriarUsuarioDTO;
import com.servicedesk.backend.entities.UnidadeEntity;
import com.servicedesk.backend.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioInterface {
    UsuarioEntity criarUsuario(CriarUsuarioDTO criarUsuarioDados);
    BuscarUsuarioDTO buscarUsuario(Long usuarioId);
    List<BuscarUsuarioDTO> buscarTodosUsuarios();
    MensagemStatusDTO atualizarUsuario(Long usuarioId, AtualizarUsuarioDTO atualizarUsuarioDados);
    void deletarUsuario(Long usuarioId);
    boolean verificaSeExisteUsuarioPorId(Long usuarioId);
}
