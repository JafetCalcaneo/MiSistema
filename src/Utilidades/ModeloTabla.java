
package Utilidades;

import javax.swing.table.DefaultTableModel;


public class ModeloTabla extends DefaultTableModel{
    
    public ModeloTabla(Object[][] datos, String[] titulos) {
		super();
		this.titulos=titulos;
		this.datos=datos;
		setDataVector(datos, titulos);
                System.out.println(datos[0][1]);
	}
   
    
	
	public ModeloTabla() {
		
	}
        
        public void llenarDatos(String[] datos){
            for (int i = 0; i < datos.length; i++) {
                this.titulos[i] = datos[i];
            }
            
        }
        
        
        
        String[] titulos;
	Object[][] datos;
        
        
}
