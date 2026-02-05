//package com.konkiburger.user.action;
//
//import com.konkiburger.user.model.converter.PedidoDetalleConverter;
//import com.konkiburger.user.model.dto.PedidoDetalleDTO;
//import com.konkiburger.user.model.entity.PedidoDetalleEntity;
//import com.konkiburger.user.model.entity.PedidoEntity;
//import com.konkiburger.user.model.entity.ProductoEntity;
//import com.konkiburger.user.service.GenericServiceImpl;
//import com.konkiburger.user.service.PedidoDetalleService;
//import com.konkiburger.user.service.PedidoDetalleServiceImpl;
//import com.opensymphony.xwork2.ActionSupport;
//import org.apache.struts2.ServletActionContext;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//public class PedidoDetalleAction extends ActionSupport {
//
//    private static final long serialVersionUID = 1L;
//
//    private PedidoDetalleDTO detalle;
//    private List<PedidoDetalleDTO> detalles;
//
//    private PedidoDetalleService detalleService;
//    private GenericServiceImpl<PedidoEntity> pedidoService;
//    private GenericServiceImpl<ProductoEntity> productoService;
//
//    public PedidoDetalleAction() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("konkiburger");
//        EntityManager em = emf.createEntityManager();
//
//        this.pedidoService = new GenericServiceImpl<>(em);
//        this.productoService = new GenericServiceImpl<>(em);
//        this.detalleService = new PedidoDetalleServiceImpl(new GenericServiceImpl<>(em));
//    }
//
//    @Override
//    public String execute() {
//        HttpServletRequest request = ServletActionContext.getRequest();
//        String accion = request.getParameter("accion");
//
//        switch (accion != null ? accion : "") {
//            case "crear":
//                return crear(request);
//            case "modificar":
//                return modificar(request);
//            case "eliminar":
//                return eliminar(request);
//            default:
//                return listar();
//        }
//    }
//
//    private String crear(HttpServletRequest request) {
//        Integer pedidoId = Integer.valueOf(request.getParameter("pedidoId"));
//        Integer productoId = Integer.valueOf(request.getParameter("productoId"));
//        Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
//
//        PedidoEntity pedido = pedidoService.porId(PedidoEntity.class, pedidoId).orElse(null);
//        ProductoEntity producto = productoService.porId(ProductoEntity.class, productoId).orElse(null);
//
//        if (pedido != null && producto != null) {
//            PedidoDetalleEntity nuevo = new PedidoDetalleEntity();
//            nuevo.setPedido(pedido);
//            nuevo.setProducto(producto);
//            nuevo.setCantidad(cantidad);
//            nuevo.setPrecioUnitario(producto.getPrecio());
//            detalleService.guardarDetalle(nuevo);
//
//            // Actualizar total del pedido
//            double total = pedido.getDetalles().stream()
//                    .mapToDouble(d -> d.getCantidad() * d.getPrecioUnitario())
//                    .sum();
//            pedido.setTotal(total);
//            pedidoService.guardar(pedido);
//        }
//
//
//        return listar();
//    }
//
//    private String modificar(HttpServletRequest request) {
//        Integer id = Integer.valueOf(request.getParameter("id"));
//        Optional<PedidoDetalleEntity> opt = detalleService.porId(id);
//
//        if (opt.isPresent()) {
//            PedidoDetalleEntity existente = opt.get();
//            Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
//            existente.setCantidad(cantidad);
//            existente.setPrecioUnitario(existente.getProducto().getPrecio());
//            detalleService.modificarDetalle(existente);
//        }
//
//        return listar();
//    }
//
//    private String eliminar(HttpServletRequest request) {
//        Integer id = Integer.valueOf(request.getParameter("id"));
//        detalleService.eliminarDetalle(id);
//        return listar();
//    }
//
//    private String listar() {
//        HttpServletRequest request = ServletActionContext.getRequest();
//        Integer pedidoId = Integer.valueOf(request.getParameter("pedidoId"));
//
//        detalles = detalleService.listarPorPedido(pedidoId)
//                .stream()
//                .map(PedidoDetalleConverter::entityToDTO)
//                .collect(Collectors.toList());
//
//        return SUCCESS;
//    }
//
//
//    // Getters para JSP
//    public PedidoDetalleDTO getDetalle() {
//        return detalle;
//    }
//
//    public List<PedidoDetalleDTO> getDetalles() {
//        return detalles;
//    }
//}
