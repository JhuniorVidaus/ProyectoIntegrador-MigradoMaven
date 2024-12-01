package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConexionBD {
    Connection con;
    static String driver="com.mysql.cj.jdbc.Driver";
    static String url="jdbc:mysql://node210010-env-0675024.sp1.br.saveincloud.net.br:3306/bd_lucia?useUnicode=true&characterEncoding=UTF-8";
    static String user="root";
    static String pass="TFBkqi41779";
    
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
        }
        return con;
    }
}   