package com.konkiburger.user.model.converter;

import com.konkiburger.user.model.dto.PedidoDTO;
import com.konkiburger.user.model.entity.PedidoEntity;
import com.konkiburger.user.model.entity.PedidoDetalleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoConverter {

    public static PedidoDTO entityToDTO(PedidoEntity pedido) {
        if (pedido == null) return null;
        return new PedidoDTO(
                pedido.getId(),
                pedido.getNumPedido(),
                pedido.getEmail(),
                pedido.getEstado(),
                pedido.getFecha(),
                pedido.getHora(),
                pedido.getHoraRecogida(),
                pedido.getMetodoPago(),
                pedido.getTotal(),
                pedido.getDetalles() != null
                        ? pedido.getDetalles().stream()
                        .map(PedidoDetalleConverter::entityToDTO)
                        .collect(Collectors.toList())
                        : null
        );
    }

    public static PedidoEntity dtoToEntity(PedidoDTO dto, List<PedidoDetalleEntity> detalles) {
        if (dto == null) return null;
        PedidoEntity pedido = new PedidoEntity();
        pedido.setId(dto.getId());
        pedido.setNumPedido(dto.getNumPedido());
        pedido.setEmail(dto.getEmail());
        pedido.setEstado(dto.getEstado());
        pedido.setFecha(dto.getFecha());
        pedido.setHora(dto.getHora());
        pedido.setHoraRecogida(dto.getHoraRecogida());
        pedido.setMetodoPago(dto.getMetodoPago());
        pedido.setTotal(dto.getTotal());
        pedido.setDetalles(detalles);
        return pedido;
    }
}
