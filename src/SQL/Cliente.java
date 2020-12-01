
package SQL;


public class Cliente extends Usuario {
    private final int idCliente;
    private static int contadorClientes;
    private String nombre, apellido, correo, contraseña, telefono, direccion,tarjeta;
    
    private Cliente(){
        this.idCliente = ++contadorClientes;
    }
    
    public Cliente(String nombre, String correo, String contraseña){
        this();
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    public int getIdCliente(){
        return this.idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", telefono=" + telefono + ", direccion=" + direccion + ", tarjeta=" + tarjeta + '}';
    }
    
    
    
    
}
