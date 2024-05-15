
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    static public String driver = "com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:33065/bd_internet";
    static public String usuario = "root";
    static public String password = "";
    
    protected Connection conn = null;
    
    public ConexionBD (){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection conectar(){
        return conn;
    }
    
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
