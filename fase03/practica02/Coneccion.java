package TeoriaFP.fase03.practica02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coneccion {

    private static Connection conn = null;

    private Coneccion() {
    }

    public static synchronized Connection obtenerConexion() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establecer la conexión con la base de datos
                String url = "jdbc:mysql://localhost:3306/Pets";
                String usuario = "root";
                String contraseña = "root";
                conn = DriverManager.getConnection(url, usuario, contraseña);

                System.out.println("Conexión exitosa a MySQL!");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void main(String[] args) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Connection conn = obtenerConexion();

            // Imprimir el hashCode del objeto Connection
            System.out.println("HashCode de la conexión: " + conn.hashCode());

            // Resto del código sigue igual...
            statement = conn.createStatement();
            String query = "SELECT * FROM owners;";

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("first_name");
                String password = resultSet.getString("city");

                System.out.println("ID: " + id
                        + ", username: " + username
                        + ", password: " + password
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
