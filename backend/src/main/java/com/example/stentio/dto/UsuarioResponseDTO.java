package com.example.stentio.dto;

import com.example.stentio.model.Usuario;
import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private String email;
    private String nome;

    public UsuarioResponseDTO(Usuario usuario) {
        this.email = usuario.getEmail();
        this.nome = usuario.getNome();
    }


}
