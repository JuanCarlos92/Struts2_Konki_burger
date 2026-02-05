package com.konkiburger.user.model.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class ProductoEntity extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    @Column(length = 500)
    private String descripcion;
    @Column(nullable = false)
    private Double precio;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaEntity categoria;
    @Column(nullable = false)
    private Boolean estado;


    public ProductoEntity() {}

    public ProductoEntity(String nombre, String descripcion, Double precio, CategoriaEntity categoria, Boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
    }

    @Override
    public Integer getId() {
        return id;
    }

    // Getters y setters
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public CategoriaEntity getCategoria() { return categoria; }
    public void setCategoria(CategoriaEntity categoria) { this.categoria = categoria; }
    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
}
