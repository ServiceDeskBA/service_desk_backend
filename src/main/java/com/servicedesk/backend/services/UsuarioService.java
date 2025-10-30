package com.servicedesk.backend.services;

import com.servicedesk.backend.dtos.MensagemStatusDTO;
import com.servicedesk.backend.dtos.usuario.AtualizarUsuarioDTO;
import com.servicedesk.backend.dtos.usuario.BuscarUsuarioDTO;
import com.servicedesk.backend.dtos.usuario.CriarUsuarioDTO;
import com.servicedesk.backend.entities.UsuarioEntity;
import com.servicedesk.backend.exceptions.NaoEncontradoException;
import com.servicedesk.backend.interfaces.UsuarioInterface;
import com.servicedesk.backend.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioInterface {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            ModelMapper modelMapper,
            PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UsuarioEntity criarUsuario(CriarUsuarioDTO criarUsuarioDados) {
        UsuarioEntity usuario = this.modelMapper.map(criarUsuarioDados, UsuarioEntity.class);
        usuario.setSenha(passwordEncoder.encode(criarUsuarioDados.senha()));
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public BuscarUsuarioDTO buscarUsuario(String usuarioId) {
        UsuarioEntity buscaUsuario = this.usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new NaoEncontradoException("Usuário",'o'));
        return modelMapper.map(buscaUsuario, BuscarUsuarioDTO.class);
    }

    @Override
    public List<BuscarUsuarioDTO> buscarTodosUsuarios() {
        if(this.usuarioRepository.count() == 0) throw new RuntimeException("Nenhum usuário encontrado");

        List<UsuarioEntity> usuarios = this.usuarioRepository.findAll();

        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario,BuscarUsuarioDTO.class))
                .toList();
    }

    @Override
    public MensagemStatusDTO atualizarUsuario(String usuarioId, AtualizarUsuarioDTO atualizarUsuarioDados) {
        if(!this.verificaSeExisteUsuarioPorId(usuarioId)) new NaoEncontradoException("Usuário",'o');

        this.modelMapper.getConfiguration().setSkipNullEnabled(true);
        UsuarioEntity usuarioEntidade = this.modelMapper.map(atualizarUsuarioDados, UsuarioEntity.class);

        this.usuarioRepository.save(usuarioEntidade);

        return new MensagemStatusDTO("Usuário foi atualizado com sucesso", 200);
    }

    @Override
    public void deletarUsuario(String usuarioId) {
        this.usuarioRepository.deleteById(usuarioId);

        Optional<UsuarioEntity> buscaUsuario = this.usuarioRepository.findById(usuarioId);
        if(buscaUsuario.isPresent()) throw new RuntimeException("Erro ao deletar usuário");
    }

    @Override
    public boolean verificaSeExisteUsuarioPorId(String usuarioId) {
        return this.usuarioRepository.existsById(usuarioId);
    }
}
