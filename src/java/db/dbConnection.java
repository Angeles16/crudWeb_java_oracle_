package db;

/**
 *
 * @author luis_
 */
import java.sql.*;

public class dbConnection {
    static String db = "USR_PRODUCT";
    static String passwor = "ANGEL";
    static String url = "jdbc:oracle:thin:@DESKTOP-2R7RS92:1521:xe";
    Connection conn = null;
    
    public dbConnection(){
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, db, passwor);
            if(conn != null){
                System.out.println("Conexion exitosa");
            }
        } catch (SQLException ex)
        {
            System.out.println("Error de coneccion => " + ex);
        } catch (ClassNotFoundException ex){
            System.out.println("Error ClassNotFund => " + ex);
        }
    }
    
    public Connection getConnectio(){
        return conn;
    }
    
    public void closeConnection(){
        if(conn != null){
            try
            {
                conn.close();
            } catch (Exception e)
            {
                System.out.println("Error en la desconexion => " + e);
            }
        }
    }
    
}
