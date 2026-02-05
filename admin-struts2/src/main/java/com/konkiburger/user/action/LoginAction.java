package com.konkiburger.user.action;

import com.konkiburger.user.model.dto.UsuarioDTO;
import com.konkiburger.user.model.entity.UsuarioEntity;
import com.konkiburger.user.service.GenericServiceImpl;
import com.konkiburger.user.service.UsuarioService;
import com.konkiburger.user.service.UsuarioServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import java.util.Optional;

public class LoginAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private UsuarioDTO usuarioDTO;
    private final UsuarioService usuarioService;

    public LoginAction() {
        // Creamos EntityManager usando la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("konkiburger");
        EntityManager em = emf.createEntityManager();

        GenericServiceImpl<UsuarioEntity> genericService = new GenericServiceImpl<>(em);
        this.usuarioService = new UsuarioServiceImpl(genericService);
    }

    @Override
    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();

        // Cierre de sesión
        if ("true".equals(request.getParameter("BotonPulsadoCerrarSesion"))) {
            request.getSession().invalidate();
            return ERROR;
        }

        // Comprobar si ya hay usuario en sesión
        if (request.getSession().getAttribute("usuario") != null) {
            usuarioDTO = (UsuarioDTO) request.getSession().getAttribute("usuario");
            return SUCCESS;
        }

        String accion = request.getParameter("accion");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("iniciarSesion".equals(accion) && username != null && password != null) {
            Optional<UsuarioDTO> usuarioOpt = usuarioService.login(username, password);

            if (usuarioOpt.isPresent()) {
                usuarioDTO = usuarioOpt.get();
                request.getSession().setAttribute("usuario", usuarioDTO);
                return SUCCESS;
            } else {
                // Login fallido
                request.setAttribute("errorMessage", "Usuario o contraseña incorrectos");
                return ERROR;
            }
        }

        return ERROR;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }
}
