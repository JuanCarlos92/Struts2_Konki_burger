package com.konkiburger.user.action;

import com.konkiburger.user.model.dto.CategoriaDTO;
import com.konkiburger.user.model.entity.CategoriaEntity;
import com.konkiburger.user.model.converter.CategoriaConverter;
import com.konkiburger.user.service.CategoriaService;
import com.konkiburger.user.service.CategoriaServiceImpl;
import com.konkiburger.user.service.GenericServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoriaAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private CategoriaDTO categoria;
    private List<CategoriaDTO> categorias;

    private CategoriaService categoriaService;

    public CategoriaAction() {
        // Inicializar JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("konkiburger");
        EntityManager em = emf.createEntityManager();

        // Crear el GenericServiceImpl para Categoria
        GenericServiceImpl<CategoriaEntity> genericService = new GenericServiceImpl<>(em);

        // Pasarlo al servicio específico
        this.categoriaService = new CategoriaServiceImpl(genericService);
    }

    @Override
    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String accion = request.getParameter("accion");

        switch (accion != null ? accion : "") {
            case "crear":
                return crear(request);
            case "modificar":
                return modificar(request);
            case "eliminar":
                return eliminar(request);
            default:
                return listar();
        }
    }

    private String crear(HttpServletRequest request) {
        String nombre = request.getParameter("nombre");


        CategoriaEntity nueva = new CategoriaEntity();
        nueva.setNombre(nombre);

        categoriaService.guardarCategoria(nueva);
        return listar();
    }

    private String modificar(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Optional<CategoriaEntity> opt = categoriaService.porId(id);

        if (opt.isPresent()) {
            CategoriaEntity existente = opt.get();
            existente.setNombre(request.getParameter("nombre"));
            categoriaService.modificarCategoria(existente);
        }
        return listar();
    }

    private String eliminar(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        categoriaService.eliminarCategoria(id);
        return listar();
    }

    private String listar() {
        categorias = categoriaService.listarCategorias()
                .stream()
                .map(CategoriaConverter::entityToDTO)
                .collect(Collectors.toList());
        return SUCCESS;
    }

    // Getters para JSP
    public CategoriaDTO getCategoria() { return categoria; }
    public List<CategoriaDTO> getCategorias() { return categorias; }
}
