package Conexion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
    
    // Instancia de Calendar para trabajar con fechas
    public static Calendar calendar = Calendar.getInstance();
    
    // Variable para almacenar la fecha formateada
    public static String fecha;
    
    /**
     * Método que devuelve la fecha actual en formato "dd/MM/YYYY".
     * 
     * @return La fecha actual como una cadena en formato "dd/MM/YYYY".
     */
    public static String Fecha() {
        // Crear un objeto SimpleDateFormat para formatear la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        // Formatear la fecha actual
        fecha = sdf.format(calendar.getTime());
        // Retornar la fecha formateada
        return fecha;
    }

    /**
     * Método que devuelve la fecha actual en formato "YYYY-MM-dd", adecuado para bases de datos.
     * 
     * @return La fecha actual como una cadena en formato "YYYY-MM-dd".
     */
    public static String FechaBD() {
        // Crear un objeto SimpleDateFormat para formatear la fecha en formato adecuado para bases de datos
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        // Formatear la fecha actual
        fecha = sdf.format(calendar.getTime());
        // Retornar la fecha formateada
        return fecha;
    }
}
