package com.konkiburger.user.service;

import com.konkiburger.user.model.entity.CategoriaEntity;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    void guardarCategoria(CategoriaEntity categoria);
    void eliminarCategoria(Integer id);
    Optional<CategoriaEntity> porId(Integer id);
    List<CategoriaEntity> listarCategorias();
    void modificarCategoria(CategoriaEntity categoria);
}
