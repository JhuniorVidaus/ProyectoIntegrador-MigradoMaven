package Modelos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    // Instancia para manejar la conexión a la base de datos
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    /**
     * Busca un proveedor en la base de datos por su nombre.
     * 
     * @param nompro El nombre del proveedor a buscar.
     * @return El objeto Proveedor correspondiente al nombre buscado.
     */
    public Proveedor buscar(String nompro) {
        Proveedor provee = new Proveedor();
        String sql = "SELECT * FROM proveedor WHERE nombre = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nompro);
            rs = ps.executeQuery();
            while (rs.next()) {
                provee.setId_proveedor(rs.getInt("id_proveedor"));
                provee.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provee;
    }

    /**
     * Lista todos los proveedores de la base de datos.
     * 
     * @return Una lista de objetos Proveedor que representan a todos los proveedores en la base de datos.
     */
    public List listar() {
        String sql = "select * from proveedor";
        List<Proveedor> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor prove = new Proveedor();
                prove.setId_proveedor(rs.getInt(1));
                prove.setNombre(rs.getString(2));
                lista.add(prove);
            }
        } catch (Exception e) {
            // Manejo de errores (sin acciones específicas)
        }
        return lista;
    }

    /**
     * Agrega un nuevo proveedor a la base de datos.
     * 
     * @param prove El objeto Proveedor que contiene los datos del proveedor a agregar.
     * @return El número de filas afectadas (1 si se agregó el proveedor correctamente, 0 si no).
     */
    public int agregar(Proveedor prove) {
        String sql = "insert into proveedor(nombre) values(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prove.getNombre());
            r = ps.executeUpdate();
            System.out.println("Filas afectadas al agregar: " + r);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * Actualiza la información de un proveedor en la base de datos.
     * 
     * @param prove El objeto Proveedor que contiene los nuevos datos para actualizar.
     * @return El número de filas afectadas (1 si se actualizó correctamente, 0 si no).
     */
    public int actualizar(Proveedor prove) {
        String sql = "update proveedor set nombre=? where id_proveedor=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prove.getNombre());
            ps.setInt(2, prove.getId_proveedor());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            // Manejo de errores (sin acciones específicas)
        }
        return r;
    }

    /**
     * Lista un proveedor específico por su ID.
     * 
     * @param idpro El ID del proveedor a buscar.
     * @return El objeto Proveedor correspondiente al ID buscado.
     */
    public Proveedor listarId(int idpro) {
        Proveedor provee = new Proveedor();
        String sql = "select * from proveedor where id_proveedor=" + idpro;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                provee.setId_proveedor(rs.getInt(1));
                provee.setNombre(rs.getString(2));
            }
        } catch (SQLException e) {
            // Manejo de errores (sin acciones específicas)
        }
        return provee;
    }

    /**
     * Elimina un proveedor de la base de datos por su ID.
     * 
     * @param idpro El ID del proveedor a eliminar.
     */
    public void eliminar(int idpro) {
        String sql = "delete from proveedor where id_proveedor=" + idpro;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            // Manejo de errores (sin acciones específicas)
        }
    }

    /**
     * Lista los nombres de todos los proveedores.
     * 
     * @return Una lista de cadenas con los nombres de todos los proveedores en la base de datos.
     */
    public List<String> listarNombreProveedor() {
        List<String> nombreProveedor = new ArrayList<>();
        String sql = "SELECT nombre FROM proveedor";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombreProveedor.add(rs.getString("nombre"));
            }
            System.out.println(nombreProveedor);
        } catch (SQLException e) {
            // Manejo de errores (sin acciones específicas)
        }
        return nombreProveedor;
    }
}
