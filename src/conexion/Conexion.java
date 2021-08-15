/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    
    Connection conn = null;
    
    
    public Conexion(){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/inventario","root","");
            System.out.println("Exito Consulta Realizada");
        }catch(SQLException e){
            System.out.println(e);
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }      
}
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
 conn = null;       
    }
    
    //Método para insertar
    private String url = "jdbc:mysql://localhost/inventario";
    private String login = "root"; //Administrador de MySQL
    private String password = "";
    private Connection cnx = null;
    private Statement sttm = null;
    private ResultSet rst = null;
    public void UID(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //instanciar la clase
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement(); //Crea un objeto SQLServerStatement para enviar instrucciones SQL a la base de datos.
            sttm.executeUpdate(sql);//Ejecuta la instrucción SQL determinada, que puede ser una instrucción INSERT, UPDATE, DELETE o una instrucción SQL que no devuelve nada
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.exit(1); //salir de aplicación
        }
    }
    
}


    

