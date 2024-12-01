package Conexion;

public class GenerarSerie {
    
    // Variable para almacenar el dato proporcionado para la generación de serie
    int dato;
    
    // Variable para almacenar el número de serie generado
    String numero;
    
    /**
     * Método que genera un número de serie en función de un dato numérico.
     * El número de serie se genera añadiendo ceros a la izquierda hasta alcanzar una longitud mínima de 7 dígitos.
     * 
     * @param dato El dato numérico que se incrementa en 1 y se utiliza para generar el número de serie.
     * @return El número de serie generado como una cadena con ceros a la izquierda, si es necesario.
     */
    public String NumeroSerie(int dato){
        // Incrementa el dato en 1
        this.dato = dato + 1;

        // Generación del número de serie con ceros a la izquierda dependiendo del valor de 'dato'
        if ((this.dato >= 1000000) && (this.dato <= 10000000)){
            numero = "" + this.dato;
        }
        if ((this.dato >= 100000) && (this.dato <= 1000000)){
            numero = "0" + this.dato;
        }
        if ((this.dato >= 10000) && (this.dato <= 100000)){
            numero = "00" + this.dato;
        }
        if ((this.dato >= 1000) && (this.dato <= 10000)){
            numero = "000" + this.dato;
        }
        if ((this.dato >= 100) && (this.dato <= 1000)){
            numero = "0000" + this.dato;
        }
        if ((this.dato >= 10) && (this.dato <= 100)){
            numero = "00000" + this.dato;
        }
        if (this.dato < 10){
            numero = "000000" + this.dato;
        }
        // Retorna el número de serie generado
        return numero;
    }
}
