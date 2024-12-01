package Modelos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    // Conexión con la base de datos
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    /**
     * Valida si un cliente existe en la base de datos con el correo y la contraseña proporcionados.
     * 
     * @param email El correo electrónico del cliente.
     * @param passcliente La contraseña del cliente.
     * @return Un objeto Cliente con los datos encontrados, o un cliente vacío si no se encuentra.
     */
    public Cliente validar(String email, String passcliente) {
        Cliente client = new Cliente();
        String sql = "select * from cliente where correo=? and password=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, passcliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                client.setId_cliente(rs.getInt("id_cliente"));
                client.setDni(rs.getInt("dni"));
                client.setNombre(rs.getString("nombre"));
                client.setDirección(rs.getString("dirección"));
                client.setCorreo(rs.getString("correo"));
                client.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return client;
    }

    /**
     * Lista todos los clientes registrados en la base de datos.
     * 
     * @return Una lista de objetos Cliente con los datos de todos los clientes.
     */
    public List listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt(1));
                cl.setDni(rs.getInt(2));
                cl.setNombre(rs.getString(3));
                cl.setDirección(rs.getString(4));
                cl.setCorreo(rs.getString(5));
                cl.setPassword(rs.getString(6));
                lista.add(cl);
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return lista;
    }

    /**
     * Agrega un nuevo cliente a la base de datos.
     * 
     * @param cl El objeto Cliente que contiene los datos a agregar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int agregar(Cliente cl) {
        String sql = "insert into cliente(dni,nombre,dirección,correo,password) values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getDirección());
            ps.setString(4, cl.getCorreo());
            ps.setString(5, cl.getPassword());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * Actualiza los datos de un cliente existente en la base de datos.
     * 
     * @param cl El objeto Cliente con los datos a actualizar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int actualizar(Cliente cl) {
        String sql = "update cliente set dni=?, nombre=?, dirección=?,correo=?,password=? where id_cliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getDirección());
            ps.setString(4, cl.getCorreo());
            ps.setString(5, cl.getPassword());
            ps.setInt(6, cl.getId_cliente());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            // Manejo de excepciones
        }
        return r;
    }

    /**
     * Obtiene un cliente de la base de datos utilizando su id.
     * 
     * @param idcl El id del cliente a buscar.
     * @return Un objeto Cliente con los datos del cliente encontrado.
     */
    public Cliente listarId(int idcl) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where id_cliente=" + idcl;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId_cliente(rs.getInt(1));
                cli.setDni(rs.getInt(2));
                cli.setNombre(rs.getString(3));
                cli.setDirección(rs.getString(4));
                cli.setCorreo(rs.getString(5));
                cli.setPassword(rs.getString(6));
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        }
        return cli;
    }

    /**
     * Elimina un cliente de la base de datos utilizando su id.
     * 
     * @param idcl El id del cliente a eliminar.
     */
    public void eliminar(int idcl) {
        String sql = "delete from cliente where id_cliente=" + idcl;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            // Manejo de excepciones
        }
    }
}