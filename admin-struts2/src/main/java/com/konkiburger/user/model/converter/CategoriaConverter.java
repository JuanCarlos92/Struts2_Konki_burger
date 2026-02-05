package com.konkiburger.user.model.converter;

import com.konkiburger.user.model.dto.CategoriaDTO;
import com.konkiburger.user.model.entity.CategoriaEntity;

public class CategoriaConverter {

    public static CategoriaDTO entityToDTO(CategoriaEntity categoria) {
        if (categoria == null) return null;
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNombre()
        );
    }

}
