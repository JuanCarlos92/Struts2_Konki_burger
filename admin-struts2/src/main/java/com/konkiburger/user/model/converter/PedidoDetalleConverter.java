//package com.konkiburger.user.model.converter;
//
//import com.konkiburger.user.model.dto.PedidoDetalleDTO;
//import com.konkiburger.user.model.entity.PedidoDetalleEntity;
//import com.konkiburger.user.model.entity.PedidoEntity;
//import com.konkiburger.user.model.entity.ProductoEntity;
//
//public class PedidoDetalleConverter {
//
//    public static PedidoDetalleDTO entityToDTO(PedidoDetalleEntity detalle) {
//        if (detalle == null) return null;
//        return new PedidoDetalleDTO(
//                detalle.getId(),
//                ProductoConverter.entityToDTO(detalle.getProducto()),
//                detalle.getCantidad(),
//                detalle.getPrecioUnitario(),
//                detalle.getSubtotal()
//        );
//    }
//
//    public static PedidoDetalleEntity dtoToEntity(PedidoDetalleDTO dto, PedidoEntity pedido, ProductoEntity producto) {
//        if (dto == null) return null;
//        PedidoDetalleEntity detalle = new PedidoDetalleEntity();
//        detalle.setPedido(pedido);
//        detalle.setProducto(producto);
//        detalle.setCantidad(dto.getCantidad());
//        detalle.setPrecioUnitario(dto.getPrecioUnitario());
//        // subtotal se calcula automáticamente
//        return detalle;
//    }
//}
