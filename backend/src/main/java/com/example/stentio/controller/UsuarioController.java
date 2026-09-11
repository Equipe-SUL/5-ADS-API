package com.example.stentio.controller;

import com.example.stentio.dto.UsuarioRequestDTO;
import com.example.stentio.dto.UsuarioResponseDTO;
import com.example.stentio.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }



    @PostMapping("/login")
    public UsuarioResponseDTO login(@RequestBody UsuarioRequestDTO dadosLogin) {
        return service.login(dadosLogin);


    }



}
