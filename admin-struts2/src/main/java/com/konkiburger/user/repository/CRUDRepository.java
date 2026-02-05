package com.konkiburger.user.repository;

import com.konkiburger.user.model.entity.Entidad;

import java.util.List;

/**
 * Interfaz que define los métodos CRUD de los repository de las entidades.
 * No accede directamente a la base de datos, es un paso intermedio
 */
public interface CRUDRepository<T extends Entidad> {
    List<T> listar(Class<T> clase);
    T porId(Class<T> clase, Integer id);
    void guardar(T t);
    void eliminar(Class<T> clase, Integer id);
}
