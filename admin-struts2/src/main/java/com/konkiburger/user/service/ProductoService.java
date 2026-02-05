package com.konkiburger.user.service;
import com.konkiburger.user.model.entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    void guardarProducto(ProductoEntity producto);
    void eliminarProducto(Integer id);
    Optional<ProductoEntity> porId(Integer id);
    List<ProductoEntity> listarProductos();
    void modificarProducto(ProductoEntity producto);
}
