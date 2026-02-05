package com.konkiburger.user.action;

import com.google.gson.Gson;
import com.konkiburger.user.model.dto.UsuarioDTO;
import com.konkiburger.user.model.entity.UsuarioEntity;
import com.konkiburger.user.service.GenericServiceImpl;
import com.konkiburger.user.service.UsuarioService;
import com.konkiburger.user.service.UsuarioServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InicioAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private final UsuarioService usuarioService;

    // Lista de usuarios para el JSP
    private List<UsuarioDTO> usuarios;

    public InicioAction() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("konkiburger");
        EntityManager em = emf.createEntityManager();
        this.usuarioService = new UsuarioServiceImpl(new GenericServiceImpl<>(em));
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        // Comprobar sesión
        if (request.getSession().getAttribute("usuario") == null) {
            request.getSession().invalidate();
            return ERROR;
        }

        request.setAttribute("paginaActual", "Inicio");

        UsuarioDTO usuarioLogueado = (UsuarioDTO) request.getSession().getAttribute("usuario");
        request.setAttribute("username", usuarioLogueado.getUsername());

        // Cargar todos los usuarios desde la BD
        usuarios = usuarioService.listarUsuarios()
                .stream()
                .map(u -> new UsuarioDTO(
                        u.getId(),
                        u.getUsername(),
                        u.getNombre(),
                        u.getEmail(),
                        u.getRol().name(),
                        u.getDireccion(),
                        u.getFechaRegistro()
                ))
                .collect(Collectors.toList());

        return SUCCESS;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }
}

