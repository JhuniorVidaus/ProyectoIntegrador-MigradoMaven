package Modelos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrdenCompraDAO {

    // Instancia para manejar la conexión a la base de datos
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    /**
     * Genera el número de serie de la próxima orden de compra, basado en el valor máximo actual en la base de datos.
     * 
     * @return El número de serie de la próxima orden de compra.
     */
    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "select max(NroSerie) from ordenpedido";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (Exception e) {
            // Manejo de errores (sin acciones específicas)
        }
        return numeroserie;
    }

    /**
     * Obtiene el ID de la próxima orden de compra, basado en el valor máximo actual en la base de datos.
     * 
     * @return El ID de la próxima orden de compra.
     */
    public String idOrden() {
        String idorden = "";
        String sql = "select max(id_orden) from ordenpedido";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idorden = rs.getString(1);
            }
        } catch (Exception e) {
            // Manejo de errores (sin acciones específicas)
        }
        return idorden;
    }

    /**
     * Guarda una nueva orden de compra en la base de datos.
     * 
     * @param orc El objeto OrdenCompra que contiene los datos de la nueva orden a guardar.
     * @return El número de filas afectadas (1 si la orden se guardó correctamente, 0 si no).
     */
    public int guardarOrden(OrdenCompra orc) {
        String sql = "insert into ordenpedido(id_empleado,id_proveedor,NroSerie,fecha) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, orc.getId_empleado());
            ps.setInt(2, orc.getId_proveedor());
            ps.setString(3, orc.getNroSerie());
            ps.setString(4, orc.getFecha());
            r = ps.executeUpdate();
        } catch (Exception e) {
            // Manejo de errores (sin acciones específicas)
        }
        return r;
    }

    /**
     * Guarda los detalles de una orden de compra en la base de datos.
     * 
     * @param orden El objeto OrdenCompra que contiene los detalles de la orden a guardar.
     * @return El número de filas afectadas (1 si los detalles se guardaron correctamente, 0 si no).
     */
    public int guardarDetalleOrden(OrdenCompra orden) {
        String sql = "insert into detalle_ordenpedido(id_ordenpedido,id_producto,cantidad) values (?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, orden.getId_orden());
            ps.setInt(2, orden.getId_producto());
            ps.setInt(3, orden.getCantidad());
            r = ps.executeUpdate();
        } catch (Exception e) {
            // Manejo de errores (sin acciones específicas)
        }
        return r;
    }
}
