package com.example.stentio.service;

import com.example.stentio.dto.UsuarioRequestDTO;
import com.example.stentio.dto.UsuarioResponseDTO;
import com.example.stentio.model.Usuario;
import com.example.stentio.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UsuarioService {

    private UsuarioRepository repository;
    //private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository){ // PasswordEncoder passwordEncoder)
        this.repository = repository;
        //this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDTO login(UsuarioRequestDTO dadosLogin) {
        Optional<Usuario> user = repository.findByEmail(dadosLogin.getEmail());
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        Usuario usuarioEncontrado = user.get();
        String senhalimpa = dadosLogin.getSenha();
        String senhaHash = usuarioEncontrado.getSenhaHash();
        if (!senhalimpa.equals(senhaHash)) {   //if (!passwordEncoder.matches(senhalimpa, senhaHash))
            throw new RuntimeException("Senha inválida");
        }

        return new UsuarioResponseDTO(usuarioEncontrado);
    }
}
