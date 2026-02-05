package com.konkiburger.user.model.converter;

import com.konkiburger.user.model.dto.ProductoDTO;
import com.konkiburger.user.model.entity.CategoriaEntity;
import com.konkiburger.user.model.entity.ProductoEntity;

public class ProductoConverter {

    public static ProductoDTO entityToDTO(ProductoEntity producto) {
        if (producto == null) return null;
        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getCategoria() != null ? producto.getCategoria().getId() : null,
                producto.getCategoria() != null ? producto.getCategoria().getNombre() : null,
                producto.getEstado()
        );
    }

    public static ProductoEntity dtoToEntity(ProductoDTO dto, CategoriaEntity categoria) {
        if (dto == null) return null;
        ProductoEntity producto = new ProductoEntity();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setCategoria(categoria);
        producto.setEstado(dto.getEstado());
        return producto;
    }
}

