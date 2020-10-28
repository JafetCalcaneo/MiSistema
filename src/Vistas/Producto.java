package Vistas;

public class Producto {
	
	private String nombre;
        private double precio;
        private int stock;
        private String codigo;
        private String color;
	
	public Producto(){
		
	}
	
	public Producto(String nombre, double precio, int stock, String codigo, String color) {
		super();
		this.stock = stock;
                this.codigo = codigo;
                this.color = color;
                this.precio = precio;
                this.nombre = nombre;
	}
	
	
	public void setNombre(String nombre){
            this.nombre = nombre;
        }
        public String getNombre(){
            return this.nombre;
        }
        
        public void setCantidad(int stock){
            this.stock = stock;
        }
        public int getStock(){
            return this.stock;
        }
        
        public void setCodigo(String codigo){
            this.codigo = codigo;
        }
        public String getCodigo(){
            return this.codigo;
        }
        
        public void setPrecio(double precio){
            this.precio = precio;
        }
        public double getPrecio(){
            return this.precio;
        }
        
        public void setColor(String color){
            this.color = color;
        }
        public String getColor(){
            return this.color;
        }

}