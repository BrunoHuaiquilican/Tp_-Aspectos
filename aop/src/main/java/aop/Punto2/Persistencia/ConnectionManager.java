package aop.Punto2.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    protected static String DB = "concursosdb";
    protected static String user = "root";
    protected static String pass = "";
    protected static Connection conn = null;

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL_DB = "jdbc:mysql://localhost:3306/" + DB + "?useSSL=false&serverTimezone=UTC";

    public static void connect() {
        try {
            // Carga del driver
            Class.forName(DRIVER);

            // Conexión
            conn = DriverManager.getConnection(URL_DB, user, pass);

            System.out.println("Conectado a la base de datos " + DB);

        } catch (SQLException sqlEx) {
            System.out.println("No se ha podido conectar a " + URL_DB + ". " + sqlEx.getMessage());
        } catch (ClassNotFoundException cnfEx) {
            System.out.println("Error al cargar el driver: " + cnfEx.getMessage());
        }
    }

    public static void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Desconectado de la base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reconnect() {
        disconnect();
        connect();
    }

    public static Connection getConnection() throws RuntimeException {
        if (conn == null) {
            connect();
        }
        if (conn == null) {
            throw new RuntimeException("No se pudo conectar a la Base de Datos.");
        }
        return conn;
    }
}
