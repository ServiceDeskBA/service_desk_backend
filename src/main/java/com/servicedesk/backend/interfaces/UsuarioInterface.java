package com.servicedesk.backend.interfaces;

import com.servicedesk.backend.dtos.usuario.AtualizarUsuarioDTO;
import com.servicedesk.backend.dtos.usuario.CriarUsuarioDTO;
import com.servicedesk.backend.entities.UnidadeEntity;
import com.servicedesk.backend.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioInterface {
    void criarUsuario(CriarUsuarioDTO criarUsuarioDados);
    UsuarioEntity buscarUsuario(Long usuarioId);
    List<UsuarioEntity> buscarTodosUsuarios();
    void atualizarUsuario(Long usuarioId, AtualizarUsuarioDTO atualizarUsuarioDados);
    void deletarUsuario(Long usuarioId);
    boolean verificaSeExisteUsuarioPorId(Long usuarioId);
}
