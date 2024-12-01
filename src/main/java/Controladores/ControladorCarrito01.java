/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Conexion.Fecha;
import Modelos.Carrito;
import Modelos.Cliente;
import Modelos.Pago;
import Modelos.PedidoVenta;
import Modelos.PedidoVentaDAO;
import Modelos.Producto;
import Modelos.ProductoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControladorCarrito01
 */
public class ControladorCarrito01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ProductoDAO pdao = new ProductoDAO();
    Producto p=new Producto();
    Cliente cliente = new Cliente();
    PedidoVentaDAO pvdao = new PedidoVentaDAO();
    PedidoVenta venta;
    Pago pago=new Pago();
    int res;
    
    List<Producto> productos = new ArrayList<>();
    
    List<Carrito> listaCarrito=new ArrayList<>();
    int cantidad=1;
    int item;
    double totalPagar=0.0;
   
    int idp;
    Carrito car=new Carrito();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        productos = pdao.listar();       
        switch (accion) {
            
            case "Comprar":
                totalPagar=0.0;
                idp=Integer.parseInt(request.getParameter("id"));
                p=pdao.listarId(idp);
                item=item+1;
                car=new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getId_producto());
                car.setNombres(p.getNombre());
                car.setDescrpcion(p.getDescripcion());
                car.setFoto(p.getFoto());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubtotal(cantidad*p.getPrecio());
                listaCarrito.add(car);
                for (int i = 0; i < listaCarrito.size(); i++){
                    totalPagar=totalPagar+listaCarrito.get(i).getSubtotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("Carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                break;
                
            case "AgregarCarrito":
                int pos=0;
                cantidad=1;
                idp=Integer.parseInt(request.getParameter("id"));
                p = pdao.listarId(idp);
                if(listaCarrito.size()>0){
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idp==listaCarrito.get(i).getIdProducto()) {
                            pos=i;
                        }
                    }
                    if (idp==listaCarrito.get(pos).getIdProducto()) {
                        cantidad=listaCarrito.get(pos).getCantidad()+cantidad;
                        double subtotal=listaCarrito.get(pos).getPrecioCompra()*cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal(subtotal);
                    }else{
                        item = item+1;
                        car=new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getId_producto());
                        car.setNombres(p.getNombre());
                        car.setDescrpcion(p.getDescripcion());
                        car.setFoto(p.getFoto());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubtotal(cantidad*p.getPrecio());
                        listaCarrito.add(car); 
                    }
                }else{
                    item = item+1;
                    car=new Carrito();
                    car.setItem(item);
                    car.setIdProducto(p.getId_producto());
                    car.setNombres(p.getNombre());
                    car.setDescrpcion(p.getDescripcion());
                    car.setFoto(p.getFoto());
                    car.setPrecioCompra(p.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubtotal(cantidad*p.getPrecio());
                    listaCarrito.add(car); 
                }
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("ControladorCarrito01?accion=home").forward(request, response);
                break;
            case "Delete":
                int idproducto=Integer.parseInt(request.getParameter("idp"));
                   for (int i=0; i <listaCarrito.size(); i++) {
                        if(listaCarrito.get(i).getIdProducto()==idproducto){
                            listaCarrito.remove(i);
                    }
                }
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("ControladorCarrito01?accion=Carrito").forward(request, response);   
            break;
            case "ActualizarCantidad":
                int idpro=Integer.parseInt(request.getParameter("idp"));
                int cant=Integer.parseInt(request.getParameter("Cantidad"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdProducto()==idpro) {
                        listaCarrito.get(i).setCantidad(cant);
                        double st=listaCarrito.get(i).getPrecioCompra()*cant;
                        listaCarrito.get(i).setSubtotal(st);
                    }
                }
            break;
            case "Carrito":
                totalPagar=0.0;
                request.setAttribute("Carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++){
                    totalPagar=totalPagar+listaCarrito.get(i).getSubtotal();
                }
                request.setAttribute("contador", listaCarrito.size());
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                break;
            case "GenerarVenta":
                if (!listaCarrito.isEmpty()) {
                    pago.setMonto(totalPagar);
                    pvdao.PagarCarrito(pago);
                    int idCliente = (int) request.getSession().getAttribute("idcliente");
                    int idpago1 = Integer.parseInt(pvdao.idPago());
                    
                    venta = new PedidoVenta(idCliente, idpago1, Fecha.FechaBD(), totalPagar, "En espera", listaCarrito);
                    res = pvdao.GenerarVenta(venta);
                    
                    for (Carrito itemCarrito : listaCarrito) {
                        int idProducto = itemCarrito.getIdProducto();
                        int cantidadVenta = itemCarrito.getCantidad();
                        Producto producto = pdao.buscar(idProducto);
                        int nuevoStock = producto.getStock() - cantidadVenta;
                        pdao.actualizarStock(idProducto, nuevoStock);
                    }
                    
                    listaCarrito.clear();                   
                    request.getRequestDispatcher("ventaexitosa.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("ventaerror.jsp").forward(request, response);
                }
                break;
            case "RealizarPago":
                if (!listaCarrito.isEmpty()) {
                    pago.setMonto(totalPagar);
                    pvdao.PagarCarrito(pago);
                    int idCliente = (int) request.getSession().getAttribute("idcliente");
                    int idpago1 = Integer.parseInt(pvdao.idPago());
                    venta = new PedidoVenta(idCliente, idpago1, Fecha.FechaBD(), totalPagar, "Pagado", listaCarrito);
                    res = pvdao.GenerarVenta(venta);
                    for (Carrito itemCarrito : listaCarrito) {
                        int idProducto = itemCarrito.getIdProducto();
                        int cantidadVenta = itemCarrito.getCantidad();
                        Producto producto = pdao.buscar(idProducto);
                        int nuevoStock = producto.getStock() - cantidadVenta;
                        pdao.actualizarStock(idProducto, nuevoStock);
                    }
                    listaCarrito.clear();                  
                    request.getRequestDispatcher("ventaexitosa.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("ventaerror.jsp").forward(request, response);
                }
                break;
            case "BuscarProducto":
                String dato = request.getParameter("Buscar");
                List<Producto> lista = pdao.buscarProducto(dato);
                request.setAttribute("productos", lista);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("contador", listaCarrito.size());
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
   
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador para el manejo del carrito de compras";
    }
}