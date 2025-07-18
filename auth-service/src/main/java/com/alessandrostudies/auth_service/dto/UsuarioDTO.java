package com.alessandrostudies.auth_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
}
