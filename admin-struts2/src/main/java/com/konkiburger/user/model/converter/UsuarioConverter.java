package com.konkiburger.user.model.converter;

import com.konkiburger.user.model.dto.UsuarioDTO;
import com.konkiburger.user.model.entity.UsuarioEntity;

public class UsuarioConverter {

    public static UsuarioDTO entityToDTO(UsuarioEntity usuario) {
        if (usuario == null) return null;
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRol().name(),
                usuario.getDireccion(),
                usuario.getFechaRegistro()
        );
    }

    public static UsuarioEntity dtoToEntity(UsuarioDTO dto) {
        if (dto == null) return null;
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsername(dto.getUsername());
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setRol(UsuarioEntity.Rol.valueOf(dto.getRol()));
        usuario.setDireccion(dto.getDireccion());
        usuario.setFechaRegistro(dto.getFechaRegistro());
        return usuario;
    }
}
