package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    private static final String url = "jdbc:mysql://localhost:3306/javaweb";
    private static final String user = "root";
    private static final String password = "";
    private static Connection connection;
    
    // metodo estatico: MiClase.metodoestatico();
    // metodo que pertenece a la clase, no a una instancia
    public static Connection getConnection() {
        if (connection == null) {
           // Hacemos la comprobacion de que si la conexion es nula, significa que no esta conectada
           // Hacemos un try catch para realizar la conexion a la bd
           try {
               Class.forName("com.mysql.cj.jdbc.Driver"); // Esto es para el controlador o Driver mysql para Java(jconnector)
               connection = DriverManager.getConnection(url, user, password);
               System.out.println("CONEXION EXITOSA");
           } catch(Exception e){
               System.out.println("CONEXCION FALLIDA");
           }
        }
        return connection;
    }
}
