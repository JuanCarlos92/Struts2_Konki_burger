//package com.konkiburger.user.service;
//
//import com.konkiburger.user.model.entity.PedidoDetalleEntity;
//
//import java.util.List;
//import java.util.Optional;
//
//public class PedidoDetalleServiceImpl implements PedidoDetalleService {
//
//    private final GenericServiceImpl<PedidoDetalleEntity> genericService;
//
//    public PedidoDetalleServiceImpl(GenericServiceImpl<PedidoDetalleEntity> genericService) {
//        this.genericService = genericService;
//    }
//
//    @Override
//    public void guardarDetalle(PedidoDetalleEntity detalle) {
//        genericService.guardar(detalle);
//    }
//
//    @Override
//    public void eliminarDetalle(Integer id) {
//        genericService.eliminar(PedidoDetalleEntity.class, id);
//    }
//
//    @Override
//    public Optional<PedidoDetalleEntity> porId(Integer id) {
//        return genericService.porId(PedidoDetalleEntity.class, id);
//    }
//    @Override
//    public List<PedidoDetalleEntity> listarDetalles() {
//        return genericService.listar(PedidoDetalleEntity.class);
//    }
//
//    @Override
//    public List<PedidoDetalleEntity> listarPorPedido(Integer pedidoId) {
//        return genericService.listar(PedidoDetalleEntity.class);
//    }
//
//    @Override
//    public void modificarDetalle(PedidoDetalleEntity detalle) {
//        genericService.guardar(detalle);
//    }
//}
