package com.konkiburger.user.service;

import com.konkiburger.user.model.converter.UsuarioConverter;
import com.konkiburger.user.model.dto.UsuarioDTO;
import com.konkiburger.user.model.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de usuarios.
 * Gestiona todas las operaciones relacionadas con UsuarioEntity usando GenericServiceImpl.
 */
public class UsuarioServiceImpl implements UsuarioService {

    private final GenericServiceImpl<UsuarioEntity> genericService;


    public UsuarioServiceImpl(GenericServiceImpl<UsuarioEntity> genericService) {
        this.genericService = genericService;
    }

    @Override
    public Optional<UsuarioDTO> login(String username, String password) {
        return genericService.listar(UsuarioEntity.class).stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .map(UsuarioConverter::entityToDTO);
    }

    @Override
    public void guardarUsuario(UsuarioEntity usuario) {
        genericService.guardar(usuario);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        genericService.eliminar(UsuarioEntity.class, id);
    }

    @Override
    public Optional<UsuarioEntity> porId(Integer id) {
        return genericService.porId(UsuarioEntity.class, id);
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return genericService.listar(UsuarioEntity.class);
    }

    @Override
    public void modificarUsuario(UsuarioEntity usuario) {
        genericService.guardar(usuario);
    }
}
