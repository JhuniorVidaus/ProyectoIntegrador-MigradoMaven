/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelos.Empleado;
import Modelos.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class Validarlogin extends HttpServlet {
    
    EmpleadoDAO edao=new EmpleadoDAO();
    Empleado em=new Empleado();
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validarlogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validarlogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String menu = request.getParameter("accionvalidar");
        if (menu.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            em = edao.validar(user, pass);
            if (em.getUsuario() != null) {
                request.getSession().setAttribute("usuario", em.getUsuario());
                request.getSession().setAttribute("idemp", em.getId_empleado());
                request.getSession().setAttribute("rol", em.getRol());
                request.getSession().setAttribute("nombreEmpleado", em.getNombre());              
                response.sendRedirect("paneladmin.jsp");
            } else {    
                response.sendRedirect("loginadmin.jsp");
            }
        } else if (menu.equalsIgnoreCase("salir")) {
            request.getSession().removeAttribute("usuario");
            request.getSession().removeAttribute("idemp");
            request.getSession().removeAttribute("rol");
            request.getSession().removeAttribute("nombreEmpleado");      
            response.sendRedirect("loginadmin.jsp");
        } else {
            response.sendRedirect("loginadmin.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
