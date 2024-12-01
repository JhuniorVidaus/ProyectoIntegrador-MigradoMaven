package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelos.Empleado;
import Conexion.ConexionBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    // Instancia para manejar la conexión a la base de datos
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    /**
     * Valida las credenciales de un empleado en la base de datos.
     * 
     * @param user El nombre de usuario del empleado.
     * @param contraseña La contraseña del empleado.
     * @return Un objeto Empleado con la información del empleado validado, o vacío si no se encuentra.
     */
    public Empleado validar(String user, String contraseña) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where usuario=? and contraseña=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId_empleado(rs.getInt("id_empleado"));
                em.setNombre(rs.getString("nombre"));
                em.setUsuario(rs.getString("usuario"));
                em.setContraseña(rs.getString("contraseña"));
                em.setRol(rs.getString("rol"));
            }
        } catch (Exception e) {
            // Manejo de errores (sin acciones específicas)
        }
        return em;
    }

    /**
     * Lista todos los empleados registrados en la base de datos.
     * 
     * @return Una lista de objetos Empleado.
     */
    public List listar() {
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId_empleado(rs.getInt(1));
                em.setNombre(rs.getString(2));
                em.setUsuario(rs.getString(3));
                em.setContraseña(rs.getString(4));
                em.setRol(rs.getString(5));
                lista.add(em);
            }
        } catch (Exception e) {
            // Manejo de errores (sin acciones específicas)
        }
        return lista;
    }

    /**
     * Agrega un nuevo empleado a la base de datos.
     * 
     * @param em El objeto Empleado que contiene los datos del empleado a agregar.
     * @return El número de filas afectadas (1 si se agregó correctamente, 0 si no).
     */
    public int agregar(Empleado em) {
        String sql = "insert into empleado(nombre,usuario,contraseña,rol) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getUsuario());
            ps.setString(3, em.getContraseña());
            ps.setString(4, em.getRol());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * Actualiza los datos de un empleado en la base de datos.
     * 
     * @param em El objeto Empleado con los nuevos datos del empleado.
     * @return El número de filas afectadas (1 si se actualizó correctamente, 0 si no).
     */
    public int actualizar(Empleado em) {
        String sql = "update empleado set nombre=?, usuario=?, contraseña=?,rol=? where id_empleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getUsuario());
            ps.setString(3, em.getContraseña());
            ps.setString(4, em.getRol());
            ps.setInt(5, em.getId_empleado());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            // Manejo de errores (sin acciones específicas)
        }
        return r;
    }

    /**
     * Obtiene los datos de un empleado específico por su ID.
     * 
     * @param id El ID del empleado a obtener.
     * @return Un objeto Empleado con los datos del empleado correspondiente.
     */
    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql = "select * from empleado where id_empleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setId_empleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setUsuario(rs.getString(3));
                emp.setContraseña(rs.getString(4));
                emp.setRol(rs.getString(5));
            }
        } catch (SQLException e) {
            // Manejo de errores (sin acciones específicas)
        }
        return emp;
    }

    /**
     * Elimina un empleado de la base de datos según su ID.
     * 
     * @param id El ID del empleado a eliminar.
     */
    public void eliminar(int id) {
        String sql = "delete from empleado where id_empleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            // Manejo de errores (sin acciones específicas)
        }
    }
}
