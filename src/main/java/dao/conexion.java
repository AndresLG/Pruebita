package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private Connection cn;
    
    public void conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.8.113:1521:XE", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+ e);
        }
    }
    
    public void cerrar() throws SQLException{
        if (cn!=null) {
            if (cn.isClosed()==false) {
                cn.close();
            }
        }
    }
    
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        conexion dao = new conexion();
        dao.conexion();
        if (dao.getCn() != null) {
            System.out.println("Conectado");
        } else {
            System.err.println("Coneccion es null Error");
        }
    }
    
}
