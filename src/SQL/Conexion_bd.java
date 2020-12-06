
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
    
    private static String URL = "jdbc:mysql://localhost/SistemaVentas", URL2 = "jdbc:sqlserver://DESKTOP-C8N9CPK:1433;databaseName=MiProyecto";
    private static String usuario = "root",usuario2="sa";
    private static String contraseña = "",contra2="123";
    private Connection conexion  = null;
    private ResultSet rst;
    private PreparedStatement pst;
    //METODO QUE CREA LA CONEXION A LA BASE DE DATOS
    public Connection conectar(){
       try{
            /*Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, usuario, contraseña);
            System.out.println("Conexion establecida :D");*/
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(URL2, usuario2, contra2);
          //  System.out.println("Conectado");
                    
        }catch(Exception e){
            System.out.println("Error parce D:  \n"+e);
       }
        return conexion;
    }
    
    
    //REGISTRA UN CLIENTE EN LA BASE DE DATOS
    public void registrarCliente(Cliente cliente){
        try{
            conexion = conectar();
            pst = conexion.prepareStatement("INSERT INTO clientes (idCliente, nombre, correo, contraseña)VALUES (?,?,?,?)");
            pst.setInt(1, cliente.getIdCliente());
            pst.setString(2,cliente.getNombre());
            pst.setString(3,cliente.getCorreo());
            pst.setString(4, cliente.getContraseña());
            pst.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error registrarse"+e);
        }
    }
    
    
    //COMPRUEBA SI EXISTE UN USUARIO EN LA BD PARA EL PANEL DE INICIO DE SESIÓN
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
        //COMPRUEBA SI YA EXISTE UN USUARIO EN LA BD PARA EL PANEL DE REGISTRO
    public Boolean existe2(Usuario us) throws SQLException{
        String query = "SELECT nombre, correo, contraseña FROM clientes WHERE nombre=? or correo=? or contraseña=?";
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
    //TRAE LA INFO DEL USUARIO COMO EL NOMBRE Y DATOS PERSONALES
    public Cliente traerInfo(Cliente cliente) throws SQLException{
        String query = "SELECT nombre, correo FROM clientes WHERE nombre=?";
        PreparedStatement statement = conectar().prepareStatement(query);
        statement.setString(1,cliente.getNombre());
        ResultSet set = statement.executeQuery();
        while(set.next()){
            String nombre = set.getString("nombre");
            String correo = set.getString("correo");
            cliente.setNombre(nombre);
            cliente.setCorreo(correo);
        }
        return cliente;
    }
    
    public int NumRegistros(){
        int r = 0;
        try{
           String query = "SELECT * FROM Productos"  ;
           PreparedStatement statement = conectar().prepareStatement(query);
           ResultSet set = statement.executeQuery();
           while(set.next()){
               r = set.getRow();
               
           }
        }catch(Exception e){
            System.out.println(e);      
        }
        
        return r;
    }
   
   
    
    
    
}
    