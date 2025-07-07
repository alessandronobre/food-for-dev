package com.alessandrostudies.auth_service.controller;

import com.alessandrostudies.auth_service.dto.UsuarioDTO;
import com.alessandrostudies.auth_service.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastro(@RequestBody UsuarioDTO usuario) {
        usuarioService.cadastro(usuario);
    }


}
