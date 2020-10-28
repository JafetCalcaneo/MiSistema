
package SQL;


public class Usuario {
    
    public Usuario(){
        this.contraseña = "";
        this.correo = "";
        this.nombre = "";
    }
    
    private String nombre, correo, contraseña;
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    
    public void setNombre(String nom){
        nombre = nom;
    }
    
    public void setCorreo(String cor){
        correo = cor;
    }
    
    public void setContraseña(String con){
        contraseña = con;   
    }
    
        
     
}
