package com.alessandrostudies.auth_service.service;

import com.alessandrostudies.auth_service.dto.UsuarioDTO;
import com.alessandrostudies.auth_service.model.Usuario;
import com.alessandrostudies.auth_service.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public void cadastro(UsuarioDTO usuario) {
        Usuario user = modelMapper.map(usuario, Usuario.class);
        usuarioRepository.save(modelMapper.map(usuario, Usuario.class));
    }

    public UsuarioDTO buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.buscarPorEmail(email);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
}
