package com.servicedesk.backend.services;

import com.servicedesk.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca o usuario pelo Email, e caso nao encontre solta uma exceção
        return usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException
                        ("Usúario com o email " + username +  " não encontrado"));
    }
}
