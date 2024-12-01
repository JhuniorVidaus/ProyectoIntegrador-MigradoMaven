package Modelos;

/**
 * Esta clase representa la información de un proveedor.
 */

public class Proveedor {
    
    int id_proveedor;
    String Nombre;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String Nombre) {
        this.id_proveedor = id_proveedor;
        this.Nombre = Nombre;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
