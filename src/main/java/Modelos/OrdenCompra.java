package Modelos;

/**
 * La clase `OrdenCompra` representa una orden de compra realizada por un empleado a un proveedor.
 * Contiene información detallada sobre el pedido, como el número de serie, las cantidades de productos solicitados,
 * el stock inicial y final, y la descripción de la orden.
 */

public class OrdenCompra {
    
    int id_orden;
    int id_empleado;
    int id_proveedor;
    int id_producto;
    int item;
    String NroSerie;
    String fecha;
    int cantidad;
    String DescripcionOrden;
    int stock_inicial;
    int stock_final;

    public OrdenCompra() {
    }

    public OrdenCompra(int id_orden, int id_empleado, int id_proveedor, int id_producto, int item, String NroSerie, String fecha, int c_entrante, String DescripcionOrden, int stock_inicial, int stock_final) {
        this.id_orden = id_orden;
        this.id_empleado = id_empleado;
        this.id_proveedor = id_proveedor;
        this.id_producto = id_producto;
        this.item = item;
        this.NroSerie = NroSerie;
        this.fecha = fecha;
        this.cantidad = c_entrante;
        this.DescripcionOrden = DescripcionOrden;
        this.stock_inicial = stock_inicial;
        this.stock_final = stock_final;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getNroSerie() {
        return NroSerie;
    }

    public void setNroSerie(String NroSerie) {
        this.NroSerie = NroSerie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int c_entrante) {
        this.cantidad = c_entrante;
    }

    public String getDescripcionOrden() {
        return DescripcionOrden;
    }

    public void setDescripcionOrden(String DescripcionOrden) {
        this.DescripcionOrden = DescripcionOrden;
    }

    public int getStock_inicial() {
        return stock_inicial;
    }

    public void setStock_inicial(int stock_inicial) {
        this.stock_inicial = stock_inicial;
    }

    public int getStock_final() {
        return stock_final;
    }

    public void setStock_final(int stock_final) {
        this.stock_final = stock_final;
    }

    
    
    
}
