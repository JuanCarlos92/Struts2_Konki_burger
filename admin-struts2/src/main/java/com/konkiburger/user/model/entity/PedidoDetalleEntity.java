//package com.konkiburger.user.model.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "pedido_detalle")
//public class PedidoDetalleEntity extends Entidad {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pedido_id", nullable = false)
//    private PedidoEntity pedido;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "producto_id", nullable = false)
//    private ProductoEntity producto;
//
//    @Column(nullable = false)
//    private Integer cantidad;
//
//    @Column(name = "precio_unitario", nullable = false)
//    private Double precioUnitario;
//
//    @Column(nullable = false)
//    private Double subtotal;
//
//    @PrePersist
//    @PreUpdate
//    public void calcularSubtotal() {
//        if (cantidad != null && precioUnitario != null) {
//            this.subtotal = cantidad * precioUnitario;
//        }
//    }
//
//    // Getters y setters
//    public Integer getId() { return id; }
//    public void setId(Integer id) { this.id = id; }
//
//    public PedidoEntity getPedido() { return pedido; }
//    public void setPedido(PedidoEntity pedido) { this.pedido = pedido; }
//
//    public ProductoEntity getProducto() { return producto; }
//    public void setProducto(ProductoEntity producto) { this.producto = producto; }
//
//    public Integer getCantidad() { return cantidad; }
//    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
//
//    public Double getPrecioUnitario() { return precioUnitario; }
//    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
//
//    public Double getSubtotal() { return subtotal; }
//    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
//}
