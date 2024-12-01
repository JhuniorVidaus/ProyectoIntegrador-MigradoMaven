package Modelos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdenDAO {
    
    // Instancia de la clase ConexionBD para manejar la conexión a la base de datos
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    /**
     * Obtiene todas las órdenes de pedido registradas en la base de datos.
     * 
     * Realiza una consulta SQL que obtiene el número de serie de la orden, el nombre del empleado,
     * el nombre del proveedor, el nombre del producto, la fecha de la orden y la cantidad total de productos.
     * 
     * @return Una lista de objetos OrdenPedido con la información de todas las órdenes de pedido.
     */
    public List<OrdenPedido> obtenerOrdenes() {
        List<OrdenPedido> ordenes = new ArrayList<>();
        try {
            String sql = "SELECT o.NroSerie AS NSerie, e.nombre AS NombreEmpleado, p.nombre AS NombreProveedor, prod.nombre AS NombreProducto, o.fecha AS Fecha, SUM(dop.cantidad) AS CantidadTotal "
                    + "FROM ordenpedido o "
                    + "INNER JOIN empleado e ON o.id_empleado = e.id_empleado "
                    + "INNER JOIN proveedor p ON o.id_proveedor = p.id_proveedor "
                    + "INNER JOIN detalle_ordenpedido dop ON o.id_orden = dop.id_ordenpedido "
                    + "INNER JOIN producto prod ON dop.id_producto = prod.id_producto "
                    + "GROUP BY o.NroSerie, e.nombre, p.nombre, prod.nombre, o.fecha "
                    + "ORDER BY o.NroSerie ASC";
            con = cn.Conexion(); // Establece la conexión con la base de datos
            ps = con.prepareStatement(sql); // Prepara la consulta
            rs = ps.executeQuery(); // Ejecuta la consulta

            // Recorre el ResultSet y crea un objeto OrdenPedido para cada fila
            while (rs.next()) {
                OrdenPedido orden = new OrdenPedido();
                orden.setNSerie(rs.getString("NSerie"));               // Establece el número de serie de la orden
                orden.setNombreEmpleado(rs.getString("NombreEmpleado")); // Establece el nombre del empleado
                orden.setNombreProveedor(rs.getString("NombreProveedor")); // Establece el nombre del proveedor
                orden.setNombreProducto(rs.getString("NombreProducto")); // Establece el nombre del producto
                orden.setFecha(rs.getDate("Fecha"));                   // Establece la fecha de la orden
                orden.setCantidadTotal(rs.getInt("CantidadTotal"));     // Establece la cantidad total de productos
                ordenes.add(orden); // Añade la orden a la lista
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); // Se recomienda manejar excepciones adecuadamente
        }
        return ordenes; // Devuelve la lista de órdenes de pedido
    }
}
