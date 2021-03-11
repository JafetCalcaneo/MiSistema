
package SQL;


public class Administrador {
    private final int idAdmin=1;
    private static int contadorAdmins;
    private String nombre, apellido, correo, contraseña;
   
    
    public Administrador(String nombre, String correo, String contraseña){
        
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

   
    
    public int getIdCliente(){
        return this.idAdmin;
    }

    @Override
    public String toString() {
        return "Administrador{" + "idAdmin=" + idAdmin + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }

    
    
    
    
}
