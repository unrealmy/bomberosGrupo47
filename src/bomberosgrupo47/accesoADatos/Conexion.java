/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo47.accesoADatos;

/**
 *
 * @author hecto
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
      private static  final String  url= "jdbc:mariadb://localhost:3306/";
      private static  final String db="bomberos47";
    private static  final String nombre= "root";
    private static  final String pass="";
   private static Connection conexion=null;
   private Conexion(){}
   public static Connection getConexion(){
   if (conexion==null) {
           
           try {
             
               Class.forName("org.mariadb.jdbc.Driver");
                 conexion=DriverManager.getConnection(url+db,nombre,pass);
           } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null,"error al cargar driver"+ex.getMessage());
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"error de coneccion"+ex.getMessage());
           }
          
           
       }
       
       return conexion;
   }
}
