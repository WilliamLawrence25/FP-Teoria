package TeoriaFP.fase03.practica02;

import java.sql.SQLException;

public class Test4 {
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws SQLException {
        
        
        Conexion cn = new Conexion();		
		System.out.println(cn.getClass().hashCode());
        System.out.println(cn.getClass().hashCode());
        System.out.println(cn.getClass().hashCode());
        System.out.println(cn.getClass().hashCode());
        System.out.println(cn.getClass().hashCode());
        
        /*for(int i = 0; i<0; i++){
            Conexion cn = new Conexion();
            cn.getConexion();
            System.out.println(cn.getClass().hashCode());
        }*/
    }
}
