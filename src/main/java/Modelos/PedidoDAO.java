package Modelos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    
    // Instancia de la clase ConexionBD para manejar la conexión a la base de datos
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    /**
     * Obtiene todos los pedidos registrados en la base de datos.
     * 
     * Realiza una consulta que obtiene el ID del pedido, el nombre y correo del cliente,
     * los productos comprados (con su cantidad), la fecha de la venta, el monto total
     * y el estado del pedido.
     * 
     * @return Una lista de objetos Pedido con la información de todos los pedidos.
     */
    public List<Pedido> obtenerPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT pv.id_pedido AS idPedido, c.nombre AS nombreCliente, c.correo AS correo, "
                    + "GROUP_CONCAT(CONCAT(pr.nombre, ' x ', dpv.cantidad) SEPARATOR ' - ') AS nombreProductos, "
                    + "pv.fecha AS fecha, pg.monto AS monto, pv.estado AS estado "
                    + "FROM pedidoventa pv "
                    + "INNER JOIN cliente c ON pv.id_cliente = c.id_cliente "
                    + "INNER JOIN pago pg ON pv.id_pago = pg.id_pago "
                    + "INNER JOIN detalle_pedidoventa dpv ON pv.id_pedido = dpv.id_pedidoventa "
                    + "INNER JOIN producto pr ON dpv.id_producto = pr.id_producto "
                    + "GROUP BY pv.id_pedido, c.nombre, c.correo, pv.fecha, pg.monto, pv.estado";
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));           // Establece el ID del pedido
                pedido.setNombreCliente(rs.getString("nombreCliente")); // Establece el nombre del cliente
                pedido.setCorreo(rs.getString("correo"));             // Establece el correo del cliente
                pedido.setNombreProductos(rs.getString("nombreProductos")); // Establece los productos y sus cantidades
                pedido.setFecha(rs.getString("fecha"));               // Establece la fecha del pedido
                pedido.setMonto(rs.getDouble("monto"));               // Establece el monto total del pedido
                pedido.setEstado(rs.getString("estado"));             // Establece el estado del pedido
                pedidos.add(pedido); // Añade el pedido a la lista
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); // Se recomienda manejar excepciones adecuadamente
        }
        return pedidos; // Devuelve la lista de pedidos
    }
    
    /**
     * Obtiene los pedidos de un cliente específico.
     * 
     * Realiza una consulta similar a la de `obtenerPedidos()`, pero filtrando por el ID del cliente.
     * Obtiene el ID del pedido, el nombre y correo del cliente, los productos comprados (con su cantidad),
     * la fecha de la venta, el monto total y el estado del pedido para un cliente determinado.
     * 
     * @param idCliente El ID del cliente cuyos pedidos se desean obtener.
     * @return Una lista de objetos Pedido con la información de los pedidos del cliente.
     */
    public List<Pedido> obtenerPedidosPorCliente(int idCliente) {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT pv.id_pedido AS idPedido, c.nombre AS nombreCliente, c.correo AS correo, "
                    + "GROUP_CONCAT(CONCAT(pr.nombre, ' x ', dpv.cantidad) SEPARATOR ' - ') AS nombreProductos, "
                    + "pv.fecha AS fecha, pg.monto AS monto, pv.estado AS estado "
                    + "FROM pedidoventa pv "
                    + "INNER JOIN cliente c ON pv.id_cliente = c.id_cliente "
                    + "INNER JOIN pago pg ON pv.id_pago = pg.id_pago "
                    + "INNER JOIN detalle_pedidoventa dpv ON pv.id_pedido = dpv.id_pedidoventa "
                    + "INNER JOIN producto pr ON dpv.id_producto = pr.id_producto "
                    + "WHERE pv.id_cliente = ? "
                    + "GROUP BY pv.id_pedido, c.nombre, c.correo, pv.fecha, pg.monto, pv.estado";
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente); // Establece el ID del cliente para filtrar los resultados
            rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));           // Establece el ID del pedido
                pedido.setNombreCliente(rs.getString("nombreCliente")); // Establece el nombre del cliente
                pedido.setCorreo(rs.getString("correo"));             // Establece el correo del cliente
                pedido.setNombreProductos(rs.getString("nombreProductos")); // Establece los productos y sus cantidades
                pedido.setFecha(rs.getString("fecha"));               // Establece la fecha del pedido
                pedido.setMonto(rs.getDouble("monto"));               // Establece el monto total del pedido
                pedido.setEstado(rs.getString("estado"));             // Establece el estado del pedido
                pedidos.add(pedido); // Añade el pedido a la lista
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); // Se recomienda manejar excepciones adecuadamente
        }
        return pedidos; // Devuelve la lista de pedidos del cliente
    }
}
