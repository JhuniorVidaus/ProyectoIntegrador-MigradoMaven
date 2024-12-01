package Modelos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class ProductoDAO {

    // Instancia de la clase ConexionBD para manejar la conexión a la base de datos
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    /**
     * Busca un producto en la base de datos por su ID.
     * 
     * @param id El ID del producto a buscar.
     * @return Un objeto Producto con los datos encontrados en la base de datos.
     */
    public Producto buscar(int id) {
        Producto p = new Producto();
        String sql = "SELECT * FROM producto WHERE id_producto = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Se recomienda agregar manejo de excepciones adecuado
        }
        return p;
    }

    /**
     * Actualiza el stock de un producto en la base de datos.
     * 
     * @param id El ID del producto cuyo stock se actualizará.
     * @param stock El nuevo valor de stock.
     * @return El número de filas afectadas por la actualización.
     */
    public int actualizarStock(int id, int stock) {
        String sql = "UPDATE producto SET stock = ? WHERE id_producto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            r = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * Obtiene todos los productos de la base de datos.
     * 
     * @return Una lista de objetos Producto con todos los productos en la base de datos.
     */
    public List<Producto> listar() {
        String sql = "SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Se recomienda agregar manejo de excepciones adecuado
        }
        return lista;
    }

    /**
     * Agrega un nuevo producto a la base de datos.
     * 
     * @param p El objeto Producto que se agregará.
     * @return El número de filas afectadas por la inserción.
     */
    public int agregar(Producto p) {
        String sql = "INSERT INTO producto (nombre, foto, descripcion, precio, stock) VALUES(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getFoto());
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            r = ps.executeUpdate();
            System.out.println("Filas afectadas al agregar: " + r);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
        }
        return r;
    }

    /**
     * Actualiza un producto en la base de datos.
     * 
     * @param p El objeto Producto que contiene los nuevos datos.
     * @return El número de filas afectadas por la actualización.
     */
    public int actualizar(Producto p) {
        String sql = "UPDATE producto SET nombre = ?, foto = ?, descripcion = ?, precio = ?, stock = ? WHERE id_producto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getFoto());
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            ps.setInt(6, p.getId_producto());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * Obtiene un producto específico por su ID.
     * 
     * @param idp El ID del producto a buscar.
     * @return Un objeto Producto con los datos del producto encontrado.
     */
    public Producto listarId(int idp) {
        Producto pro = new Producto();
        String sql = "SELECT * FROM producto WHERE id_producto = " + idp;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId_producto(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setFoto(rs.getString(3));
                pro.setDescripcion(rs.getString(4));
                pro.setPrecio(rs.getDouble(5));
                pro.setStock(rs.getInt(6));
                System.out.println("Filas actualizadas al listar ID: " + idp);
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta SQL listarId: " + e.getMessage());
        }
        return pro;
    }

    /**
     * Elimina un producto de la base de datos por su ID.
     * 
     * @param idp El ID del producto a eliminar.
     */
    public void eliminar(int idp) {
        String sql = "DELETE FROM producto WHERE id_producto = " + idp;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Producto eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta SQL eliminar: " + e.getMessage());
        }
    }

    /**
     * Busca un producto por su nombre en la base de datos.
     * 
     * @param nomproducto El nombre del producto a buscar.
     * @return Un objeto Producto con los datos encontrados.
     */
    public Producto buscarProductoOC(String nomproducto) {
        Producto productoo = new Producto();
        String sql = "SELECT * FROM producto WHERE nombre = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nomproducto);
            rs = ps.executeQuery();
            while (rs.next()) {
                productoo.setId_producto(rs.getInt("id_producto"));
                productoo.setNombre(rs.getString("nombre"));
                productoo.setStock(rs.getInt("stock"));
                productoo.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productoo;
    }

    /**
     * Realiza una búsqueda de productos que coincidan parcialmente con el texto ingresado.
     * 
     * @param texto El texto de búsqueda.
     * @return Una lista de productos que contienen el texto en su nombre.
     */
    public List<Producto> buscarProducto(String texto) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombre LIKE '%" + texto + "%'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setNombre(rs.getString("nombre"));
                pro.setFoto(rs.getString("foto"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(rs.getDouble("precio"));
                lista.add(pro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Obtiene una lista de los nombres de todos los productos.
     * 
     * @return Una lista de cadenas con los nombres de los productos.
     */
    public List<String> listarNombreProductos() {
        List<String> nombreProductos = new ArrayList<>();
        String sql = "SELECT nombre FROM producto";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombreProductos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreProductos;
    }
}
