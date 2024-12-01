/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Conexion.GenerarSerie;
import Modelos.Cliente;
import Modelos.ClienteDAO;
import Modelos.Empleado;
import Modelos.EmpleadoDAO;
import Modelos.OrdenCompra;
import Modelos.OrdenCompraDAO;
import Modelos.Producto;
import Modelos.ProductoDAO;
import Modelos.Proveedor;
import Modelos.ProveedorDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    java.util.Date ahora = new java.util.Date();
    //aqui estaba el error de 3 horas :'v
    SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
    String fechaFormateada = formateador.format(ahora);

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int ide;

    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int idp;

    Proveedor pro = new Proveedor();
    ProveedorDAO prodao = new ProveedorDAO();
    int idepro;

    Cliente cl = new Cliente();
    ClienteDAO cldao = new ClienteDAO();
    int idcl;

    OrdenCompra orc = new OrdenCompra();
    OrdenCompraDAO odao = new OrdenCompraDAO();

    List<OrdenCompra> lista = new ArrayList<>();

    int item;
    int cod;
    String descp;
    int cant;
    int stock_i;
    int stock_f;
    String numeroserie = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");

        if (menu.equals("LoginSuccess")) {
            request.getRequestDispatcher("paneladmin.jsp").forward(request, response);

        } else if (menu.equals("Empleado")) {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtnombre");
                    String rol = request.getParameter("txtrol");
                    String usuario = request.getParameter("txtusuario");
                    String contraseña = request.getParameter("txtcontrasena");
                    if (nombre != null && !nombre.isEmpty()
                            && rol != null && !rol.isEmpty()
                            && usuario != null && !usuario.isEmpty()
                            && contraseña != null && !contraseña.isEmpty()) {
                        em.setNombre(nombre);
                        em.setRol(rol);
                        em.setUsuario(usuario);
                        em.setContraseña(contraseña);
                        edao.agregar(em);
                        request.setAttribute("success", "Empleado agregado exitosamente. <i class=\"fa-solid fa-circle-check\"></i>");
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("error", "Uno o más campos están vacios. <i class=\"fa-solid fa-circle-exclamation\"></i>");
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    }
                    break;
                case "Modificar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtnombre");
                    String usuario1 = request.getParameter("txtusuario");
                    String contraseña1 = request.getParameter("txtcontrasena");
                    String rol1 = request.getParameter("txtrol");
                    if (nombre1 != null && !nombre1.isEmpty()
                            && rol1 != null && !rol1.isEmpty()
                            && usuario1 != null && !usuario1.isEmpty()
                            && contraseña1 != null && !contraseña1.isEmpty()) {
                    em.setNombre(nombre1);
                    em.setUsuario(usuario1);
                    em.setContraseña(contraseña1);
                    em.setRol(rol1);
                    em.setId_empleado(ide);
                    edao.actualizar(em);
                    request.setAttribute("actualizar", "Empleado actualizado exitosamente. <i class=\"fa-solid fa-pen\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    } else {
                    request.setAttribute("error", "No se ha seleccionado ningún registro. <i class=\"fa-solid fa-circle-exclamation\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);    
                    }
                    break;
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.eliminar(ide);
                    request.setAttribute("success", "Empleado eliminado exitosamente. <i class=\"fa-solid fa-delete-left\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        } else if (menu.equals("Cliente")) {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "Listar":
                    List lista = cldao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtdni");
                    String nombre = request.getParameter("txtnombre");
                    String direccion = request.getParameter("txtdireccion");
                    String correo = request.getParameter("txtcorreo");
                    String password = request.getParameter("txtpassword");
                    if (dni != null && !dni.isEmpty()
                            && nombre != null && !nombre.isEmpty()
                            && direccion != null && !direccion.isEmpty()
                            && correo != null && !correo.isEmpty()
                            && password != null && !password.isEmpty()) {
                    cl.setDni(Integer.parseInt(dni));
                    cl.setNombre(nombre);
                    cl.setDirección(direccion);
                    cl.setCorreo(correo);
                    cl.setPassword(password);
                    cldao.agregar(cl);
                    request.setAttribute("success", "Cliente agregado exitosamente. <i class=\"fa-solid fa-circle-check\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);                       
                    } else {
                    request.setAttribute("error", "Uno o más campos están vacios. <i class=\"fa-solid fa-circle-exclamation\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    }
                    break;
                case "Modificar":
                    idcl = Integer.parseInt(request.getParameter("idcl"));
                    Cliente c = cldao.listarId(idcl);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni2 = request.getParameter("txtdni");
                    String nombre2 = request.getParameter("txtnombre");
                    String direccion2 = request.getParameter("txtdireccion");
                    String correo2 = request.getParameter("txtcorreo");
                    String password2 = request.getParameter("txtpassword");
                    if (dni2 != null && !dni2.isEmpty()
                            && nombre2 != null && !nombre2.isEmpty()
                            && direccion2 != null && !direccion2.isEmpty()
                            && correo2 != null && !correo2.isEmpty()
                            && password2 != null && !password2.isEmpty()) {
                    try {
                        cl.setDni((Integer.parseInt(dni2)));
                    } catch (NumberFormatException e) {
                        System.out.println("El valor ingresado no es valido");
                    }
                    cl.setNombre(nombre2);
                    cl.setDirección(direccion2);
                    cl.setCorreo(correo2);
                    cl.setPassword(password2);
                    cl.setId_cliente(idcl);
                    cldao.actualizar(cl);
                    request.setAttribute("actualizar", "Cliente actualizado exitosamente. <i class=\"fa-solid fa-pen\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    }else{
                    request.setAttribute("error", "No se ha seleccionado ningún registro. <i class=\"fa-solid fa-circle-exclamation\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    }
                    break;
                case "Eliminar":
                    idcl = Integer.parseInt(request.getParameter("idcl"));
                    cldao.eliminar(idcl);
                    request.setAttribute("success", "Cliente eliminado exitosamente. <i class=\"fa-solid fa-delete-left\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        } else if (menu.equals("Proveedor")) {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "Listar":
                    List lista = prodao.listar();
                    request.setAttribute("proveedores", lista);
                    break;
                case "Agregar":
                    String nombre3 = request.getParameter("txtnombre");
                    if (nombre3 != null && !nombre3.isEmpty()) {
                        pro.setNombre(nombre3);
                        prodao.agregar(pro);
                        request.setAttribute("success", "Proveedor agregado exitosamente. <i class=\"fa-solid fa-circle-check\"></i>");
                        request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("error", "Uno o más campos están vacios. <i class=\"fa-solid fa-circle-exclamation\"></i>");
                        request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    }
                    break;
                case "Modificar":
                    idepro = Integer.parseInt(request.getParameter("idpro"));
                    Proveedor op = prodao.listarId(idepro);
                    request.setAttribute("proveedor", op);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre4 = request.getParameter("txtnombre");
                    if (nombre4 != null && !nombre4.isEmpty()) {
                    pro.setNombre(nombre4);
                    pro.setId_proveedor(idepro);
                    prodao.actualizar(pro);
                    request.setAttribute("actualizar", "Proveedor actualizado exitosamente. <i class=\"fa-solid fa-pen\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("error", "No se ha seleccionado ningún registro. <i class=\"fa-solid fa-circle-exclamation\"></i>");
                        request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    }
                    break;
                case "Eliminar":
                    idepro = Integer.parseInt(request.getParameter("idpro"));
                    prodao.eliminar(idepro);
                    request.setAttribute("success", "Proveedor eliminado exitosamente. <i class=\"fa-solid fa-delete-left\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                default:
            }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);

        } else if (menu.equals("Producto")) {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "Agregar":
                    String nombrep = request.getParameter("txtnombre");
                    String fotop = request.getParameter("txtfoto");
                    String descripp = request.getParameter("txtdescripcion");
                    String preciop = request.getParameter("txtprecio");
                    String stockp = request.getParameter("txtstock");
                    if (nombrep != null && !nombrep.isEmpty()
                            && fotop != null && !fotop.isEmpty()
                            && descripp != null && !descripp.isEmpty()
                            && preciop != null && !preciop.isEmpty()
                            && stockp != null && !stockp.isEmpty()) {
                        p.setPrecio(Double.parseDouble(preciop));
                        p.setStock(Integer.parseInt(stockp));
                        p.setNombre(nombrep);
                        p.setFoto(fotop);
                        p.setDescripcion(descripp);
                        pdao.agregar(p);
                        request.setAttribute("success", "Producto agregado exitosamente. <i class=\"fa-solid fa-circle-check\"></i>");
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("error", "Uno o más campos están vacios. <i class=\"fa-solid fa-circle-exclamation\"></i>");
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    }
                    break;
                case "Modificar":
                    idp = Integer.parseInt(request.getParameter("idp"));
                    Producto pr = pdao.listarId(idp);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre2 = request.getParameter("txtnombre");
                    String foto2 = request.getParameter("txtfoto");
                    String descripcion2 = request.getParameter("txtdescripcion");
                    String precio2 = request.getParameter("txtprecio");
                    String stock2 = request.getParameter("txtstock");
                    p.setNombre(nombre2);
                    p.setFoto(foto2);
                    p.setDescripcion(descripcion2);
                    if (nombre2 != null && !nombre2.isEmpty()
                            && foto2 != null && !foto2.isEmpty()
                            && descripcion2 != null && !descripcion2.isEmpty()
                            && precio2 != null && !precio2.isEmpty()
                            && stock2 != null && !stock2.isEmpty()) {
                    try {
                        p.setPrecio(Double.parseDouble(precio2));
                    } catch (NumberFormatException e) {
                        System.out.println("El valor ingresado no es valido");
                    }
                    try {
                        p.setStock(Integer.parseInt(stock2));
                    } catch (NumberFormatException e) {
                        System.out.println("El valor ingresado no es valido");
                    }
                    p.setId_producto(idp);
                    pdao.actualizar(p);
                    request.setAttribute("actualizar", "Producto actualizado exitosamente. <i class=\"fa-solid fa-pen\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    }else{
                    request.setAttribute("error", "No se ha seleccionado ningún registro O el campo Foto esta vacío. <i class=\"fa-solid fa-circle-exclamation\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    }
                    break;
                case "Eliminar":
                    idp = Integer.parseInt(request.getParameter("idp"));
                    pdao.eliminar(idp);
                    request.setAttribute("success", "Proveedor eliminado exitosamente. <i class=\"fa-solid fa-delete-left\"></i>");
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Listar":
                    List<Producto> productos = pdao.listar();
                    request.setAttribute("productos", productos);
                    break;
                default:
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        } else if (menu.equals("OrdenCompra")) {
            String accion = request.getParameter("accion");
            orc = new OrdenCompra();
            request.setAttribute("f_fecha", fechaFormateada);
            List<String> provenombres = prodao.listarNombreProveedor();
            List<String> productnombres = pdao.listarNombreProductos();
            switch (accion) {
                case "BuscarProveedor":
                    try {
                    String nomproveedor = request.getParameter("nombreproveedor");
                    pro = prodao.buscar(nomproveedor);
                    request.setAttribute("proveedor", pro);
                    request.setAttribute("nserie", numeroserie);
                } catch (Exception e) {
                    request.getRequestDispatcher("Controlador?menu=OrdenCompra&accion=default").forward(request, response);
                }
                request.setAttribute("provenombres", provenombres);
                request.setAttribute("productnombres", productnombres);
                break;
                case "BuscarProducto":
                    try {
                    String nomproducto = request.getParameter("productnombre");
                    p = pdao.buscarProductoOC(nomproducto);
                    request.setAttribute("producto", p);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.getRequestDispatcher("Controlador?menu=OrdenCompra&accion=default").forward(request, response);
                }
                request.setAttribute("provenombres", provenombres);
                request.setAttribute("productnombres", productnombres);
                request.setAttribute("proveedor", pro);
                request.setAttribute("lista", lista);
                request.setAttribute("nserie", numeroserie);
                request.getRequestDispatcher("Controlador?menu=OrdenCompra&accion=default").forward(request, response);
                break;
                case "Agregar":
                    try {
                    request.setAttribute("proveedor", pro);
                    item = item + 1;
                    cod = p.getId_producto();
                    descp = request.getParameter("productnombre");
                    cant = Integer.parseInt(request.getParameter("cantidad"));
                    stock_i = Integer.parseInt(request.getParameter("stock"));
                    stock_f = cant + stock_i;
                    orc = new OrdenCompra();
                    orc.setItem(item);
                    orc.setId_producto(cod);
                    orc.setDescripcionOrden(descp);
                    orc.setCantidad(cant);
                    orc.setStock_inicial(stock_i);
                    orc.setStock_final(stock_f);
                    lista.add(orc);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                } catch (NumberFormatException e) {
                    request.getRequestDispatcher("Controlador?menu=OrdenCompra&accion=default").forward(request, response);
                }
                request.setAttribute("provenombres", provenombres);
                request.setAttribute("productnombres", productnombres);
                break;
                case "GenerarOrden":
                    if (lista.size() == 0) {
                        request.getRequestDispatcher("Controlador?menu=OrdenCompra&accion=default").forward(request, response);
                        break;
                    }
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantstock = lista.get(i).getCantidad();
                        int id_producto = lista.get(i).getId_producto();
                        ProductoDAO prdao = new ProductoDAO();
                        pr = prdao.buscar(id_producto);
                        int sac = pr.getStock() + cantstock;
                        prdao.actualizarStock(id_producto, sac);
                    }

                    int idEmpleado = (int) request.getSession().getAttribute("idemp");

                    orc.setId_proveedor(pro.getId_proveedor());
                    orc.setId_empleado(idEmpleado);
                    orc.setNroSerie(numeroserie);
                    orc.setFecha(formateador.format(ahora));
                    odao.guardarOrden(orc);
                    int ido = Integer.parseInt(odao.idOrden());
                    for (int i = 0; i < lista.size(); i++) {
                        orc = new OrdenCompra();
                        orc.setId_orden(ido);
                        orc.setId_producto(lista.get(i).getId_producto());
                        orc.setCantidad(lista.get(i).getCantidad());
                        odao.guardarDetalleOrden(orc);
                    }
                    orc = new OrdenCompra();
                    lista = new ArrayList<>();
                    request.setAttribute("success", "<i class=\"fa-solid fa-circle-check\"></i> Se ha generado la Orden con N° de Serie: ");
                    request.getRequestDispatcher("Controlador?menu=OrdenCompra&accion=default").forward(request, response);
                    break;
                default:
                    orc = new OrdenCompra();
                    request.setAttribute("provenombres", provenombres);
                    request.setAttribute("productnombres", productnombres);
                    item = 0;
                    numeroserie = odao.GenerarSerie();
                    request.setAttribute("f_fecha", fechaFormateada);
                    if (numeroserie == null) {
                        numeroserie = "0000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int increment = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(increment);
                        request.setAttribute("nserie", numeroserie);
                    }
            }

            request.getRequestDispatcher("OrdenCompra.jsp").forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
