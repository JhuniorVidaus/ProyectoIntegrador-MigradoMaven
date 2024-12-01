package Controladores;

import Modelos.Pedido;
import Modelos.PedidoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PedidosPorCliente", urlPatterns = {"/miscompras"})
public class PedidosPorCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Integer idCliente = (Integer) session.getAttribute("idcliente");

        if (idCliente != null) {
            PedidoDAO pedidoDAO = new PedidoDAO();
            List<Pedido> pedidos = pedidoDAO.obtenerPedidosPorCliente(idCliente);

            request.setAttribute("pedidos", pedidos);
            request.getRequestDispatcher("Compras.jsp").forward(request, response);
        } else {
            response.sendRedirect("LoginCliente.jsp");
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
}
