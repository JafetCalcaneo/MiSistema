
package SQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


//CLASE CONEXION, TODO LO RELACIONADO CON CONSULTAS Y BD SE ENCUENTRA AQUI
public class Conexion_bd {
    
    private static String URL = "jdbc:mysql://localhost/SistemaVentas", URL2 = "jdbc:sqlserver://DESKTOP-C8N9CPK:1433;databaseName=MiProyecto";
    private static String usuario = "root",usuario2="sa";
    private static String contraseña = "",contra2="123";
    private Connection conexion  = null;
    private ResultSet rst;
    private PreparedStatement pst;
    String nom,corr,contra, apellido,direccion,telefono,tarjeta;
    
    //METODO QUE CREA LA CONEXION A LA BASE DE DATOS EL CUAL NOS REGRESA UN OBJETO CONEXIÓN
    public Connection conectar(){
       try{
            /*Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, usuario, contraseña);
            System.out.println("Conexion establecida :D");*/
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(URL2, usuario2, contra2);
            System.out.println("Conectado");
                    
        }catch(Exception e){
            System.out.println("Error parce D:  \n"+e);
       }
        return conexion;
    }
    
    public int traeridCliente(){
        int id = 0;
         try{
            String query = "select*from clientes where idCliente=(\n" +
                            "SELECT COUNT(idCliente)\n" +
                            "FROM clientes)";
            PreparedStatement statement = conectar().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                id = rs.getInt("idCliente");
                System.out.println(id);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error registrarse traer cliente \n"+e);
        }
         
        return id  + 1;
        
    }
    //REGISTRA UN CLIENTE EN LA BASE DE DATOS HACIENDO UNA CONSULTA PRIMERO PARA VERIFICAR QUE EXISTE
    //ESTE SE REALIZA CON UN PROCEDIMIENTO ALMACENADO
    public void registrarCliente(Cliente cliente){
        try{
            String query = "";
            conexion = conectar();
            pst = conexion.prepareStatement("EXECUTE SP_REGISTRAR_CLIENTE ?,?,?,?");
            pst.setInt(1, traeridCliente());
            pst.setString(2,cliente.getNombre());
            pst.setString(3,cliente.getCorreo());
            pst.setString(4, cliente.getContraseña());
            pst.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error registrarse\n"+e);
        }
    }
    
    
    //COMPRUEBA SI EXISTE UN USUARIO EN LA BD PARA EL PANEL DE INICIO DE SESIÓN
    public Boolean existe(Usuario us)throws SQLException{
       String query = "EXECUTE SP_EXISTE_CLIENTE ?,?,?,?";
           PreparedStatement statement = conectar().prepareStatement(query);
           statement.setString(1,us.getNombre());      
           statement.setString(2, us.getContraseña());
           statement.setString(3, us.getNombre());
           statement.setString(4, us.getContraseña());
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
        String query = "SELECT nombre, correo, contraseña FROM clientes WHERE nombre=? or correo=? and contraseña=?";
        PreparedStatement statement = conectar().prepareStatement(query);
        statement.setString(1, us.getNombre());
        statement.setString(2, us.getCorreo());
        statement.setString(3, us.getContraseña());
        ResultSet set = statement.executeQuery();
        while(set.next()){
            String nombre = set.getString("nombre");
            String contraseña = set.getString("correo");
            String correo = set.getString("correo");
            System.out.println("existe");
            return true;
        }
        set.close(); //CERRAMOS LAS CONEXIONES QUE USAMOS
        statement.close();
        System.out.println("No existe ");
        return false;
    }
    //TRAE LA INFO DEL USUARIO COMO EL NOMBRE Y DATOS PERSONALES
    public Cliente traerInfo(Cliente cliente) throws SQLException{
        Cliente cliente2;
        System.out.println("Metodo traer info");
       //PREPARAMOS LA SENTENCIA QUE SE MANDARA AL OBJETO STATEMENT
        String query = "select*from clientes where idCliente=(select idCliente from clientes where nombre = ? and contraseña=?)";
        PreparedStatement statement = conectar().prepareStatement(query);
        statement.setString(1,cliente.getNombre());
        statement.setString(2, cliente.getContraseña());
        ResultSet set = statement.executeQuery();
        while(set.next()){
           nom = set.getString("nombre");
           corr = set.getString("correo");
           contra = set.getString("contraseña");
           apellido = set.getString("apellido");
           direccion = set.getString("direccion");
           telefono = set.getString("telefono");
           tarjeta = set.getString("tarjeta");
           //COMPROBAMOS QUE HATA TRAIDO LA INFORMACIÓN DEL CLIENTE CORRECTAMENTE
            System.out.println(nom+" "+corr+" "+contra);
        }
        cliente.setNombre(nom);  cliente.setApellido(apellido);
        cliente.setCorreo(corr);  cliente.setDireccion(direccion);
        cliente.setContraseña(contra);  cliente.setTelefono(telefono);
         cliente.setTarjeta(tarjeta);
        return cliente;
    }
    //CON ESTE MÉTODO CONTAMOS LOS NUMEROS DE REGISTROS DE PRODUCTOS 
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
        //Y DEVOLVEMOS EL NUMERO
        return r;
    }
    
    public Boolean esAdmin(Usuario us){
        String query = "SELECT nombre, contraseña FROM administradores WHERE nombre=? and contraseña=?";
        try{
             PreparedStatement statement = conectar().prepareStatement(query);
             statement.setString(1,us.getNombre());
             statement.setString(2, us.getContraseña());
             ResultSet set = statement.executeQuery();
             
             while(set.next()){
                 System.out.println("True");
                 return true;    
                 
           }
             System.out.println("False");
             return false;
             }catch(Exception e){
                 System.out.println(e+"  catch");
        }
       
        return true;
    }
    public void GuardarVenta(Cliente cliente){
        
    }
    
    public void guardarCompra(Cliente cliente, Object[] producto){
        System.out.println("Guardar 1");
        String query1 = "INSERT INTO venta(idCliente)VALUES(?)";
       
       
        try{       //LLENAMOS LA TABLA VENTA CON LA PRIMERA QUERY
            System.out.println("Try");
            PreparedStatement statement = conectar().prepareStatement(query1);
            statement.setInt(1, cliente.getIdCliente());
            ResultSet set = statement.executeQuery();
                  //LLENAMOS LA TABLA DETALLES_VENTA CON LA SEGUNDA QUERY
            guardarCompra2(cliente,producto);
        }catch(Exception e){
            System.out.println("Catch guardarCompra "+e);
        }
                 
    }
    
    public void guardarCompra2(Cliente cliente, Object[]producto){
        String query2 = "INSERT INTO detalles_venta values(\n" +
"	(SELECT idVenta FROM venta where idVenta=(SELECT COUNT(idVenta)FROM venta)),\n" +
"	?,\n" +
"	?,\n" +
"	?,\n" +
"	(SELECT precio FROM Productos WHERE idProducto=?))";
        
        try{
           
                  //LLENAMOS LA TABLA DETALLES_VENTA CON LA SEGUNDA QUERY
            PreparedStatement statement2 = conectar().prepareStatement(query2);
            statement2.setInt(1, cliente.getIdCliente());
            statement2.setInt(2,(int)producto[0]);      
            statement2.setInt(3, 1);                     
            statement2.setInt(4,(int)producto[0]);
            System.out.println("Statement 2"+cliente.getIdCliente()+" "+producto[0]);
            ResultSet set2 = statement2.executeQuery();
        }catch(Exception e){
            System.out.println("Exepcion 2 "+e);
        }
    }
      
    public void actualizar(Object[] producto){
        String query = "EXECUTE SP_ACTUALIZAR_TABLA_PRODUCTOS ?,?,?,?,?,?";
        try{System.out.println("Try");
            PreparedStatement statement = conectar().prepareStatement(query);
            statement.setString(1,(String) producto[1]);
            statement.setString(2, (String)producto[2]);
            statement.setString(3,(String)producto[3]);
            statement.setString(4, (String)producto[4]);
            statement.setString(5, (String)producto[5]);
            System.out.println("En medio");
            statement.setString(6, (String)producto[0]);
            ResultSet set = statement.executeQuery();
        }catch(Exception e){
            System.out.println("Catch actualizar "+e);
        }
        
    }
    
   
      
}
    