package com.konkiburger.user.service;
import com.konkiburger.user.model.entity.Entidad;

import java.util.List;
import java.util.Optional;

public interface RepositoryService<T extends Entidad> {
    List<T> listar(Class<T> clase);
    Optional<T> porId(Class<T> clase, Integer id);
    void guardar(T t);
    void eliminar(Class<T> clase, Integer id);
    Optional<T> buscarEntidad(T t, Class<T> clase);
}
