package TeoriaFP.fase03.practica02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prueba2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Establecer la conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/Pets";
            String usuario = "root";
            String contraseña = "root";
            connection = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println(connection.getClass().hashCode());

            // Crear una declaración SQL
            statement = connection.createStatement();

            // Ejecutar una consulta SQL
            String consulta = "SELECT*FROM owners";
            resultSet = statement.executeQuery(consulta);

            // Imprimir los resultados
            while (resultSet.next()) {
                // Aquí puedes acceder a los datos de cada fila
                String columna1 = resultSet.getString("id");
                String columna2 = resultSet.getString("city");

                System.out.println("Columna 1: " + columna1 + ", Columna 2: " + columna2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar resultSet, statement y conexión
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
