package Modelos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoVentaDAO {
    
    // Instancia de la clase ConexionBD para manejar la conexión a la base de datos
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    /**
     * Registra una venta y sus detalles en la base de datos.
     * 
     * @param venta El objeto PedidoVenta que contiene la información de la venta.
     * @return El número de filas afectadas por la operación.
     */
    public int GenerarVenta(PedidoVenta venta) {
        int idventas;
        // Inserta los datos de la venta en la tabla pedidoventa
        String sql = "Insert into pedidoventa(id_cliente, id_pago, fecha, total, estado) values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getIdcliente());   // ID del cliente
            ps.setInt(2, venta.getIdpago());      // ID de pago
            ps.setString(3, venta.getFecha());    // Fecha de la venta
            ps.setDouble(4, venta.getMonto());    // Total de la venta
            ps.setString(5, venta.getEstado());   // Estado de la venta
            r = ps.executeUpdate();   // Ejecuta la inserción
            
            // Obtiene el ID de la venta recién insertada
            sql = "select @@IDENTITY AS id_pedido";
            rs = ps.executeQuery(sql);
            rs.next();
            idventas = rs.getInt("id_pedido");
            rs.close();
            
            // Inserta los detalles de la venta en la tabla detalle_pedidoventa
            for (Carrito detalle : venta.getDetallecompras()) {
                sql = "insert into detalle_pedidoventa(id_producto, id_pedidoventa, cantidad, preciocompra) values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, detalle.getIdProducto());        // ID del producto
                ps.setInt(2, idventas);                       // ID del pedido
                ps.setInt(3, detalle.getCantidad());          // Cantidad del producto
                ps.setDouble(4, detalle.getPrecioCompra());   // Precio de compra del producto
                r = ps.executeUpdate();                       // Ejecuta la inserción
            }
        } catch (Exception e) {
            e.printStackTrace(); // Se recomienda manejar excepciones adecuadamente
        }
        return r;
    }

    /**
     * Obtiene el ID del último pago registrado en la base de datos.
     * 
     * @return El ID de pago más reciente.
     */
    public String idPago() {
        String idpago = "";
        String sql = "select max(id_pago) from pago";   // Consulta el ID de pago máximo (último registrado)
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idpago = rs.getString(1);   // Recupera el ID de pago
                System.out.println("ID de pago obtenido: " + idpago);
            }
        } catch (Exception e) {
            e.printStackTrace();  // Se recomienda manejar excepciones adecuadamente
        }
        return idpago;
    }

    /**
     * Registra un pago en la base de datos.
     * 
     * @param pag El objeto Pago que contiene la información del pago.
     * @return El número de filas afectadas por la operación.
     */
    public int PagarCarrito(Pago pag) {
        String sql = "insert into pago(monto) values(?)";   // Inserta el monto del pago en la tabla pago
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, pag.getMonto());   // Establece el monto del pago
            r = ps.executeUpdate();            // Ejecuta la inserción
        } catch (SQLException e) {
            e.printStackTrace();  // Se recomienda manejar excepciones adecuadamente
        }
        return r;
    }
}
