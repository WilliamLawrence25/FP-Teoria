package TeoriaFP.fase03.practica02;

import java.sql.*;

public class Prueba {
  public static void main(String[] args) {
    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      Class.forName("com.mysql.jdbc.Driver");

      String url = "jdbc:mysql://localhost:3306/Pets";
      String usuario = "root";
      String contraseña = "root";
      conn = DriverManager.getConnection(url, usuario, contraseña);

      if (conn != null) {
        System.out.println("Conexión exitosa a MySQL!");
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
        
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        if (conn != null && !conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}