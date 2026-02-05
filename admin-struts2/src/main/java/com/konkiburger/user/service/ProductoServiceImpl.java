package com.konkiburger.user.service;

import com.konkiburger.user.model.entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService {

    private final GenericServiceImpl<ProductoEntity> genericService;

    public ProductoServiceImpl(GenericServiceImpl<ProductoEntity> genericService) {
        this.genericService = genericService;
    }

    @Override
    public void guardarProducto(ProductoEntity producto) {
        genericService.guardar(producto);
    }

    @Override
    public void eliminarProducto(Integer id) {
        genericService.eliminar(ProductoEntity.class, id);
    }

    @Override
    public Optional<ProductoEntity> porId(Integer id) {
        return genericService.porId(ProductoEntity.class, id);
    }

    @Override
    public List<ProductoEntity> listarProductos() {
        return genericService.listar(ProductoEntity.class);
    }

    @Override
    public void modificarProducto(ProductoEntity producto) {
        genericService.guardar(producto);
    }
}

