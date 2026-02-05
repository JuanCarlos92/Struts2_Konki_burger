package com.konkiburger.user.service;

import com.konkiburger.user.model.entity.PedidoEntity;

import java.util.List;
import java.util.Optional;

public class PedidoServiceImpl implements PedidoService {

    private final GenericServiceImpl<PedidoEntity> genericService;

    public PedidoServiceImpl(GenericServiceImpl<PedidoEntity> genericService) {
        this.genericService = genericService;
    }

    @Override
    public void guardarPedido(PedidoEntity pedido) {
        genericService.guardar(pedido);
    }

    @Override
    public void eliminarPedido(Integer id) {
        genericService.eliminar(PedidoEntity.class, id);
    }

    @Override
    public Optional<PedidoEntity> porId(Integer id) {
        return genericService.porId(PedidoEntity.class, id);
    }

    @Override
    public List<PedidoEntity> listarPedidos() {
        return genericService.listar(PedidoEntity.class);
    }

    @Override
    public void modificarPedido(PedidoEntity pedido) {
        genericService.guardar(pedido);
    }
}
