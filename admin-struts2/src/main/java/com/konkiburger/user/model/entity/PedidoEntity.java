package com.konkiburger.user.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class PedidoEntity extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "num_pedido", nullable = false, unique = true)
    private String numPedido;

    @Column(name = "email")
    private String email;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "hora_recogida", nullable = false)
    private LocalTime horaRecogida;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "total", nullable = false)
    private Double total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoDetalleEntity> detalles = new ArrayList<>();

    public PedidoEntity() {}

    // Metodo helper para agregar detalle
    public void agregarDetalle(PedidoDetalleEntity detalle) {
        detalle.setPedido(this);
        detalles.add(detalle);
        total += detalle.getSubtotal();
    }

    @PrePersist
    public void prePersist() {
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        if (this.total == null) this.total = 0.0;
        if (this.estado == null) this.estado = "pendiente";
    }

    // ===== Getters y setters =====
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNumPedido() { return numPedido; }
    public void setNumPedido(String numPedido) { this.numPedido = numPedido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public LocalTime getHoraRecogida() { return horaRecogida; }
    public void setHoraRecogida(LocalTime horaRecogida) { this.horaRecogida = horaRecogida; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public List<PedidoDetalleEntity> getDetalles() { return detalles; }
    public void setDetalles(List<PedidoDetalleEntity> detalles) { this.detalles = detalles; }
}
