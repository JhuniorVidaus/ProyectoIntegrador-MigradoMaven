package Modelos;

/**
 * Esta clase representa un pedido realizado por un cliente.
 * Un pedido incluye información sobre el cliente, los productos comprados, la fecha de realización,
 * el monto total y el estado del pedido.
 */

public class Pedido{
    private int idPedido;
    private String nombreCliente;
    private String correo;
    private String nombreProductos;
    private String fecha;
    private double monto;
    private String estado;

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}