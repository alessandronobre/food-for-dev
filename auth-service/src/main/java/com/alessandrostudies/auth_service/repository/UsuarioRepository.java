package com.alessandrostudies.auth_service.repository;

import com.alessandrostudies.auth_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM USUARIO WHERE EMAIL = ?1", nativeQuery = true)
    Usuario buscarPorEmail(String email);
}
