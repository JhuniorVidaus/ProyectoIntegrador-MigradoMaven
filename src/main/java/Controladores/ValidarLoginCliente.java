
package Controladores;

import Modelos.Cliente;
import Modelos.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidarLoginCliente extends HttpServlet {

    ClienteDAO cdao = new ClienteDAO();
    Cliente cli = new Cliente();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String menu = request.getParameter("accionvalidar");
        if (menu.equalsIgnoreCase("Ingresar")) {
            String email = request.getParameter("txtcorreo");
            String passclient = request.getParameter("txtpassclient");
            cli = cdao.validar(email, passclient);
            if (cli.getCorreo() != null) {
                request.getSession().setAttribute("nombrecliente", cli.getNombre());
                request.getSession().setAttribute("idcliente", cli.getId_cliente());
                request.getSession().setAttribute("direccion", cli.getDirección());
                request.getSession().setAttribute("correo", cli.getCorreo());
                request.getSession().setAttribute("dni", cli.getDni());
                response.sendRedirect("ControladorCarrito01?accion=home");
            } else {
                response.sendRedirect("LoginCliente.jsp");
            }
        } else if (menu.equalsIgnoreCase("Registrar")){
                    String dni = request.getParameter("txtdni");
                    String nombre = request.getParameter("txtnombre");
                    String direccion = request.getParameter("txtdireccion");
                    String correo = request.getParameter("txtcorreo");
                    String password = request.getParameter("txtpassword");
                    if (dni != null && !dni.isEmpty() &&
                        nombre != null && !nombre.isEmpty() &&
                        direccion != null && !direccion.isEmpty() &&
                        correo != null && !correo.isEmpty() &&
                        password != null && !password.isEmpty()) {
                        try {
                            cli.setDni(Integer.parseInt(dni));
                            cli.setNombre(nombre);
                            cli.setDirección(direccion);
                            cli.setCorreo(correo);
                            cli.setPassword(password);
                            cdao.agregar(cli);
                            request.getRequestDispatcher("RegistroExitoso.jsp").forward(request, response);
                        } catch (NumberFormatException e) {
                            request.getRequestDispatcher("LoginCliente.jsp").forward(request, response);
                        }
                    } else {
                        request.getRequestDispatcher("RegistroError.jsp").forward(request, response);
                    }
        } else if (menu.equalsIgnoreCase("salir")) {
            request.getSession().removeAttribute("nombrecliente");
            request.getSession().removeAttribute("idcliente");
            request.getSession().removeAttribute("direccion");
            request.getSession().removeAttribute("correo");
            request.getSession().removeAttribute("dni");
            response.sendRedirect("ControladorCarrito01?accion=home");
        } else {
            response.sendRedirect("LoginCliente.jsp");
        }
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
