package com.konkiburger.user.action;

import com.konkiburger.user.model.converter.PedidoConverter;
import com.konkiburger.user.model.dto.PedidoDTO;
import com.konkiburger.user.model.entity.PedidoEntity;
import com.konkiburger.user.model.entity.ProductoEntity;
import com.konkiburger.user.service.GenericServiceImpl;
import com.konkiburger.user.service.PedidoService;
import com.konkiburger.user.service.PedidoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PedidoAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private PedidoDTO pedido;
    private List<PedidoDTO> pedidos;
    private PedidoService pedidoService;
    private GenericServiceImpl<ProductoEntity> productoService;
    private List<ProductoEntity> productos;

    public PedidoAction() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("konkiburger");
        EntityManager em = emf.createEntityManager();
        this.pedidoService = new PedidoServiceImpl(new GenericServiceImpl<>(em));
        this.productoService = new GenericServiceImpl<>(em);
    }

    public List<ProductoEntity> getProductos() {
        return productos;
    }

    @Override
    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String accion = request.getParameter("accion");

        switch (accion != null ? accion : "") {
//            case "crear":
//                return crear(request);
//            case "guardar":
//                return guardar(request);
            case "modificar":
                return modificar(request);
            case "eliminar":
                return eliminar(request);
            default:
                return listar();
        }
    }

// Metodo crear pedido
//    private String crear(HttpServletRequest request) {
//        this.pedido = new PedidoDTO();
//        this.pedido.setEstado("pendiente");
//        this.productos = productoService.listar(ProductoEntity.class);
//        return "detallePedido";
//    }

    private String modificar(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Optional<PedidoEntity> opt = pedidoService.porId(id);

        if (opt.isPresent()) {
            PedidoEntity existente = opt.get();
            existente.setEstado(request.getParameter("estado"));
            String horaStr = request.getParameter("horaRecogida");
            if (horaStr != null && !horaStr.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                existente.setHoraRecogida(LocalTime.parse(horaStr, formatter));
            } else {
                existente.setHoraRecogida(null);
            }
            pedidoService.modificarPedido(existente);
        }
        return listar();
    }

    private String eliminar(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        pedidoService.eliminarPedido(id);
        return listar();
    }

    private String listar() {
        pedidos = pedidoService.listarPedidos()
                .stream()
                .map(PedidoConverter::entityToDTO)
                .collect(Collectors.toList());
        return SUCCESS;
    }

    // Getters para JSP
    public PedidoDTO getPedido() {
        return pedido;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }
}
