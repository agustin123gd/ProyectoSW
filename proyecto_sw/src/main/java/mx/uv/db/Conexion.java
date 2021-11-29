package mx.uv.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/cuestionarios?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "root";
    private String driverName = "com.mysql.jdbc.Driver";
    

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Se estableció la conexión!");
        } catch (SQLException e) {
            System.out.println("Falló con la conexion");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Falló la carga de la clase del JDBC");
            e.printStackTrace();
        }
        return conn;
    }
}
