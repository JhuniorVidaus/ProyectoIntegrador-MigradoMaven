package Modelos;

/**
 * Esta clase representa un artículo en el carrito de compras.
 */
public class Carrito {
    int item;
    int idProducto;
    String nombres;
    String descrpcion;
    String foto;
    double precioCompra;
    int cantidad;
    double subtotal;

    public Carrito() {
    }
    
   
    // Constructor con parámetros para inicializar todos los atributos
    public Carrito(int item, int idProducto, String nombres, String descrpcion,String foto, double precioCompra, int cantidad, double subtotal) {
        this.item = item;
        this.idProducto = idProducto;
        this.nombres = nombres;
        this.descrpcion = descrpcion;
        this.foto= foto;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Métodos getter y setter para acceder y modificar los atributos
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

     }
