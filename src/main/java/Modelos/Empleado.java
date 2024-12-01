package Modelos;

/**
 * La clase `Empleado` representa a un empleado en el sistema.
 * Contiene información relacionada con el empleado, como su nombre, rol, usuario y contraseña.
 */

public class Empleado {
    
    int id_empleado;
    String nombre;
    String rol;
    String usuario;
    String contraseña;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre, String rol, String usuario, String contraseña) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.rol = rol;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
