package com.konkiburger.user.service;

import com.konkiburger.user.model.entity.CategoriaEntity;

import java.util.List;
import java.util.Optional;

public class CategoriaServiceImpl implements CategoriaService {

    private final GenericServiceImpl<CategoriaEntity> genericService;

    public CategoriaServiceImpl(GenericServiceImpl<CategoriaEntity> genericService) {
        this.genericService = genericService;
    }

    @Override
    public void guardarCategoria(CategoriaEntity categoria) {
        genericService.guardar(categoria);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        genericService.eliminar(CategoriaEntity.class, id);
    }

    @Override
    public Optional<CategoriaEntity> porId(Integer id) {
        return genericService.porId(CategoriaEntity.class, id);
    }

    @Override
    public List<CategoriaEntity> listarCategorias() {
        return genericService.listar(CategoriaEntity.class);
    }

    @Override
    public void modificarCategoria(CategoriaEntity categoria) {
        genericService.guardar(categoria);
    }
}
