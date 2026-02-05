package com.konkiburger.user.service;

import com.konkiburger.user.model.dto.UsuarioDTO;
import com.konkiburger.user.model.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de usuarios.
 * Define operaciones como login, creación, modificación y consulta de usuarios.
 */
public interface UsuarioService {

    Optional<UsuarioDTO> login(String username, String password);

    void guardarUsuario(UsuarioEntity usuario);
    void eliminarUsuario(Integer id);
    Optional<UsuarioEntity> porId(Integer id);
    List<UsuarioEntity> listarUsuarios();
    void modificarUsuario(UsuarioEntity usuario);
}
