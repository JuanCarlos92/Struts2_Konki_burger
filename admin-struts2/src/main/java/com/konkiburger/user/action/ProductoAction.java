package com.konkiburger.user.action;

import com.konkiburger.user.model.converter.ProductoConverter;
import com.konkiburger.user.model.dto.ProductoDTO;
import com.konkiburger.user.model.entity.CategoriaEntity;
import com.konkiburger.user.model.entity.ProductoEntity;
import com.konkiburger.user.service.GenericServiceImpl;
import com.konkiburger.user.service.ProductoService;
import com.konkiburger.user.service.ProductoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductoAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private ProductoDTO producto;
    private List<ProductoDTO> productos;
    private List<CategoriaEntity> categorias;

    private ProductoService productosService;
    private GenericServiceImpl<CategoriaEntity> categoriaService;

    public ProductoAction() {
        // Inicializar JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("konkiburger");
        EntityManager em = emf.createEntityManager();

        // Inicializar servicios con repositorio JPA
        this.categoriaService = new GenericServiceImpl<>((jakarta.persistence.EntityManager) em);
        this.productosService = new ProductoServiceImpl(new GenericServiceImpl<>((jakarta.persistence.EntityManager) em));
    }

    // Setters por si Struts necesita inyección
    public void setProductosService(ProductoService productosService) {
        this.productosService = productosService;
    }

    public void setCategoriaService(GenericServiceImpl<CategoriaEntity> categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Override
    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String accion = request.getParameter("accion");
        request.setAttribute("paginaActual", "Productos");

        // Cargar siempre categorías para el JSP
        categorias = categoriaService.listar(CategoriaEntity.class);

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
        String descripcion = request.getParameter("descripcion");
        Double precio = Double.valueOf(request.getParameter("precio"));
        Integer categoriaId = Integer.valueOf(request.getParameter("categoriaId"));
        String estadoParam = request.getParameter("estado");
        Boolean estado = "Disponible".equals(estadoParam);

        CategoriaEntity categoria = categoriaService.porId(CategoriaEntity.class, categoriaId).orElse(null);
        ProductoEntity nuevo = new ProductoEntity(nombre, descripcion, precio, categoria, estado);
        productosService.guardarProducto(nuevo);

        return listar();
    }

    private String modificar(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Optional<ProductoEntity> opt = productosService.porId(id);

        if (opt.isPresent()) {
            ProductoEntity productoExistente = opt.get();
            productoExistente.setNombre(request.getParameter("nombre"));
            productoExistente.setDescripcion(request.getParameter("descripcion"));
            productoExistente.setPrecio(Double.valueOf(request.getParameter("precio")));

            Integer categoriaId = Integer.valueOf(request.getParameter("categoriaId"));
            CategoriaEntity categoria = categoriaService.porId(CategoriaEntity.class, categoriaId).orElse(null);
            productoExistente.setCategoria(categoria);

            String estadoParam = request.getParameter("estado");
            productoExistente.setEstado("Disponible".equals(estadoParam));

            productosService.modificarProducto(productoExistente);
        }

        return listar();
    }

    private String eliminar(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        productosService.eliminarProducto(id);
        return listar();
    }

    private String listar() {
        productos = productosService.listarProductos()
                .stream()
                .map(ProductoConverter::entityToDTO)
                .collect(Collectors.toList());
        return SUCCESS;
    }

    // Getters para JSP
    public ProductoDTO getProducto() { return producto; }
    public List<ProductoDTO> getProductos() { return productos; }
    public List<CategoriaEntity> getCategorias() { return categorias; }
}
