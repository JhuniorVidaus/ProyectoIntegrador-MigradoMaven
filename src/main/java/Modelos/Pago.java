package Modelos;

/**
 * Esta clase representa el pago de un pedido. 
 * Contiene la información del ID del pago y el monto asociado al mismo.
 */

public class Pago {
    int id;
    double monto;

    public Pago() {
    }

    public Pago(int id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
