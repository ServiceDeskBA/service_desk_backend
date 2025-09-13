package com.servicedesk.backend.entities;

import com.servicedesk.backend.enums.TipoUsuario;
import org.springframework.data.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
public class UsuarioEntity implements UserDetails {
    @Field("_usuario_id")
    @Id
    private Long usuarioId;

    @Field("unidade_id")
    private Long unidadeId;

    @Field("nome_completo")
    private String nomeCompleto;

    @Field("email")
    private String email;

    @Field("senha")
    private String senha;

    @Field("token")
    private String token;

    @Field("tipo_usuario")
    private TipoUsuario tipoUsuario;

    @Field("criado_em")
    @CreatedDate
    private LocalDateTime criadoEm;

    @Field("atualizado_em")
    @LastModifiedDate
    private LocalDateTime atualizadoEm;

    // MÉTODOS DA INTERFACE USERDETAILS

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.tipoUsuario.name()));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


