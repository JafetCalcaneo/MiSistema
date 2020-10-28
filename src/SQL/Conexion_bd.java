
package SQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexion_bd {
    
    private static String URL = "jdbc:mysql://localhost/SistemaVentas";
    private static String usuario = "root";
    private static String contraseña = "";
    private Connection conexion  = null;
    private ResultSet rst;
    private PreparedStatement pst;
    
    public Connection conectar(){
       try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, usuario, contraseña);
            System.out.println("Conexion establecida :D");
                    
        }catch(Exception e){
            System.out.println("Error parce D:  \n"+e);
       }
        return conexion;
    }
    
    public void registrarCliente(Usuario us){
        try{
            conexion = conectar();
            pst = conexion.prepareStatement("INSERT INTO clientes (nombre, correo, contraseña)VALUES (?,?,?)");
            pst.setString(1, us.getNombre());
            pst.setString(2,us.getCorreo());
            pst.setString(3,us.getContraseña());
            pst.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error registrarse"+e);
        }
    }
    
    public Boolean existe(Usuario us)throws SQLException{
       String query = "SELECT nombre, contraseña FROM clientes WHERE nombre=? AND contraseña=?";
           PreparedStatement statement = conectar().prepareStatement(query);
           statement.setString(1,us.getNombre());
           statement.setString(2, us.getContraseña());
           ResultSet set = statement.executeQuery();
           while(set.next()){
               String nombre = set.getString("nombre");
               String contra = set.getString("contraseña");
               System.out.println(nombre+" "+contra);
               return true;
           }
           set.close();
           statement.close();
           return false; 
    }
    
    public Boolean existe2(Usuario us) throws SQLException{
        String query = "SELECT nombre, correo, contraseña FROM clientes WHERE nombre=? and correo=? and contraseña=?";
        PreparedStatement statement = conectar().prepareStatement(query);
        statement.setString(1, us.getNombre());
        statement.setString(2, us.getCorreo());
        statement.setString(3, us.getContraseña());
        ResultSet set = statement.executeQuery();
        while(set.next()){
            String nombre = set.getString("nombre");
            String contraseña = set.getString("correo");
            String correo = set.getString("correo");
            System.out.println(nombre+" "+correo+" "+contraseña);
            return true;
        }
        set.close();
        statement.close();
        return false;
    }
    
   
    
    
    
    
}
