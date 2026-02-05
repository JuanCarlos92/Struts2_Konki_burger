package com.konkiburger.user.model.dto;

import java.time.LocalDateTime;

public class UsuarioDTO {
    private Integer id;
    private String username;
    private String nombre;
    private String email;
    private String rol;
    private String direccion;
    private LocalDateTime fechaRegistro;

    public UsuarioDTO() {}

    public UsuarioDTO(Integer id, String username, String nombre, String email, String rol,
                      String direccion, LocalDateTime fechaRegistro) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
