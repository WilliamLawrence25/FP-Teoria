import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
    // Configura la información de conexión
    private static final String URL = "jdbc:mysql://192.168.18.30:3306/fp2_23b";
    private static final String USUARIO = "fp2_23b";
    private static final String CONTRASENA = "12345678";
    private static int id;

    public static boolean verificarCredenciales(String username, String password) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            String consultaSQL = "SELECT * FROM usuario";
            statement = conexion.prepareStatement(consultaSQL);

            resultSet = statement.executeQuery();

            // ir por la tabla
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String contrasena = resultSet.getString("contrasena");
                String usuario = resultSet.getString("usuario");

                // datos
                if (username.equals(usuario) && password.equals(contrasena)) {
                    return true;
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static int getId(){
        return id;
    }
    
    public static boolean registrarUsuario(String correo, String usuario, String contrasena) {
        if (correo.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
            System.out.println("Error: Ninguna de las variables puede estar vacía");
            return false;
        }

        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            if (usuarioExistente(conexion, usuario)) {
                System.out.println("Error: El usuario ya existe");
                return false;
            }

            String consultaSQL = "INSERT INTO usuario (correo, usuario, contrasena) VALUES (?, ?, ?)";
            statement = conexion.prepareStatement(consultaSQL);
            statement.setString(1, correo);
            statement.setString(2, usuario);
            statement.setString(3, contrasena);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    private static boolean usuarioExistente(Connection conexion, String usuario) throws SQLException {
        String consultaSQL = "SELECT COUNT(*) AS total FROM usuario WHERE usuario = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = conexion.prepareStatement(consultaSQL);
            statement.setString(1, usuario);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int totalUsuarios = resultSet.getInt("total");
                return totalUsuarios > 0;
            }
            
        } finally {
            // Cerrar los recursos
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return false;
    }
    public static boolean registrarPartida(int idUsuario, String ganador, String perdedor, int numSolGanad, int numSolEnemi) {
        if (ganador.isEmpty() || perdedor.isEmpty()) {
            System.out.println("Error: Ganador y perdedor no pueden estar vacíos");
            return false;
        }
    
        Connection conexion = null;
        PreparedStatement statement = null;
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    
            String consultaSQL = "INSERT INTO partidas (id_usuario, ganador, perdedor, num_sol_ganad, num_sol_enemi) VALUES (?, ?, ?, ?, ?)";
            statement = conexion.prepareStatement(consultaSQL);
            statement.setInt(1, idUsuario);
            statement.setString(2, ganador);
            statement.setString(3, perdedor);
            statement.setInt(4, numSolGanad);
            statement.setInt(5, numSolEnemi);
    
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
    
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
