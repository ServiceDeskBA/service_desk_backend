package com.servicedesk.backend.entities;

import com.servicedesk.backend.enums.TipoUsuario;
import org.springframework.data.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Date;

@Data
@Document(collation = "tb_usuario")
public class UsuarioEntity implements UserDetails{
    @Id
    private String usuarioId;
    private String unidadeId;
    private String nomeCompleto;
    private String email;
    private String senha;
    private String token;
    private TipoUsuario tipoUsuario;
    @CreatedDate
    private Date criadoEm;
    @LastModifiedDate
    private Date atualizadoEm;

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


