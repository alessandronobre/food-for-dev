package com.alessandrostudies.auth_service.service;

import com.alessandrostudies.auth_service.config.JwtUtil;
import com.alessandrostudies.auth_service.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthService {

    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public ResponseEntity<?> login(UsuarioDTO usuario) {
        UsuarioDTO user = usuarioService.buscarPorEmail(usuario.getEmail());

        if (Objects.nonNull(user) && user.getSenha().equals(usuario.getSenha())) {
            String token = jwtUtil.gerarToken(user.getNome(), user.getEmail());
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
}
