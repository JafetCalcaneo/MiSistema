
package Pruebas;

import javax.lang.model.SourceVersion;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import Pruebas.ModeloTabla;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;



public class VentanaMarco extends JTable{
    public VentanaMarco(){
        Rectangle r = new Rectangle(500,300);
        this.setBounds(r);
        obtenerTitulos();
        System.out.println("Constructor Tabla");
        this.setVisible(true);
    }
    
    private void obtenerTitulos(){
        String titulos[] = {"ID","Nombre","Numero"};
        
        construirTabla(titulos,obtenerDatos(titulos));
        
    }
    
    private Object[][] obtenerDatos(String [] titulos){
        //String informacion[][] = new String[listaPersonas.size()][titulosList.size()];
         String informacion[][] = new String[2][titulos.length];
         informacion[0][0] = "1";
         informacion[0][1] = "Jafet";
         informacion[0][2] = "9933209220";
         informacion[1][0] = "2";
         informacion[1][1] = "Alejandro";
         informacion[1][2] = "12345678";
         
         return informacion;
    }
    private void construirTabla(String[] titulos, Object[][] datos){
        System.out.println(datos[0][0]);
        miModelo = new ModeloTabla(datos,titulos);
        this.setModel(miModelo);
        
        this.getColumnModel().getColumn(0).setCellRenderer(new Celdas());
        this.getColumnModel().getColumn(1).setCellRenderer(new Celdas());
        this.getColumnModel().getColumn(2).setCellRenderer(new Celdas());
        
        this.getTableHeader().setReorderingAllowed(false);
	this.setRowHeight(25);//tamaño de las celdas
	this.setGridColor(new java.awt.Color(0, 0, 0)); 
		//Se define el tamaño de largo para cada columna y su contenido
	this.getColumnModel().getColumn(0).setPreferredWidth(130);//documento
	this.getColumnModel().getColumn(1).setPreferredWidth(380);//nombre
	this.getColumnModel().getColumn(2).setPreferredWidth(350);//direccio
    }
    

    
    private ModeloTabla miModelo;
 //   private JTable miTabla;
    private JPanel panel;
    private JFrame v2;
    
}


