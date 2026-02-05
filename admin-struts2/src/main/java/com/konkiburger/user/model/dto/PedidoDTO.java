package com.konkiburger.user.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PedidoDTO {
    private Integer id;
    private String numPedido;
    private String email;
    private String estado;
    private LocalDate fecha;
    private LocalTime hora;
    private LocalTime horaRecogida;
    private String metodoPago;
    private Double total;
    private List<PedidoDetalleDTO> detalles;

    public PedidoDTO() {}

    public PedidoDTO(Integer id, String numPedido, String email, String estado,
                     LocalDate fecha, LocalTime hora, LocalTime horaRecogida,
                     String metodoPago, Double total, List<PedidoDetalleDTO> detalles) {
        this.id = id;
        this.numPedido = numPedido;
        this.email = email;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
        this.horaRecogida = horaRecogida;
        this.metodoPago = metodoPago;
        this.total = total;
        this.detalles = detalles;
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

    public List<PedidoDetalleDTO> getDetalles() { return detalles; }
    public void setDetalles(List<PedidoDetalleDTO> detalles) { this.detalles = detalles; }
}
