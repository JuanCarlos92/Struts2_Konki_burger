package com.konkiburger.user.model.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaEntity extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;

    public CategoriaEntity() {}

    public CategoriaEntity(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Integer getId() {
        return id;
    }

    // Getters y setters
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}