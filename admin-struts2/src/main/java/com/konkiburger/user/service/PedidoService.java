package com.konkiburger.user.service;

import com.konkiburger.user.model.entity.PedidoEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    void guardarPedido(PedidoEntity pedido);
    void eliminarPedido(Integer id);
    Optional<PedidoEntity> porId(Integer id);
    List<PedidoEntity> listarPedidos();
    void modificarPedido(PedidoEntity pedido);
}
