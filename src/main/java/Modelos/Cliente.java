package Modelos;

/**
 * Esta clase representa la información de un cliente.
 */

public class Cliente {
    
    int id_cliente;
    int dni;
    String nombre;
    String dirección;
    String correo;
    String password;

    public Cliente() {
    }
// Constructor con parámetros para inicializar todos los atributos
    public Cliente(int id_cliente, int dni, String nombre, String dirección, String correo, String password) {
        this.id_cliente = id_cliente;
        this.dni = dni;
        this.nombre = nombre;
        this.dirección = dirección;
        this.correo = correo;
        this.password = password;
    }

// Métodos getter y setter para acceder y modificar los atributos
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
