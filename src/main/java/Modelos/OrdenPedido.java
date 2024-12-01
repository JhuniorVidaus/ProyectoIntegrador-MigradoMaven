package Modelos;

import java.util.Date;

/**
 * Esta clase representa una orden de pedido. 
 * Contiene información relevante como el número de serie, el empleado que realiza el pedido,
 * el proveedor, el producto solicitado, la fecha del pedido y la cantidad total.
 */

public class OrdenPedido {
    private String nSerie;
    private String nombreEmpleado;
    private String nombreProveedor;
    private String nombreProducto;
    private Date fecha;
    private int cantidadTotal;

    public String getNSerie() {
        return nSerie;
    }

    public void setNSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
}