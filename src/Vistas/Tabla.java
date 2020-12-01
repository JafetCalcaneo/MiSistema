
package Vistas;

import javax.lang.model.SourceVersion;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;
import Utilidades.Celdas;
import Utilidades.ModeloTabla;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import SQL.Conexion_bd;
import java.sql.Statement;



public class Tabla extends JTable{
    public Tabla(){
         super();
         this.setBounds(new Rectangle(500,300));
        obtenerTitulos();
        System.out.println("Constructor Tabla");
        this.setVisible(true);
    }
    public Tabla(int x, int y){
        super();
        this.x = x;
        this.y = y;        
       // Rectangle r = new Rectangle(500,300);
        this.setBounds(new Rectangle(500,300));
        obtenerTitulos();
        System.out.println("Constructor Tabla");
        this.setVisible(true);
        this.setLocation(x, y);
    }
    
    private void obtenerTitulos(){
        String titulos[] = {"ID","Codigo","Nombre","Precio","Stock","Color"};
        miModelo = new ModeloTabla(obtenerDatos(titulos),titulos);
        construirTabla();
        
    }
    
    private Object[][] obtenerDatos(String titulos[]){
 
          Conexion_bd con = new Conexion_bd();      int numR = con.NumRegistros();
          String query = "SELECT*FROM Productos";   
          System.out.println("Num registros: "+numR);
          Object registros[][] = new Object[numR][titulos.length];
         int c =0;
         
         try{ 
              Statement statement = con.conectar().createStatement();
              ResultSet set = statement.executeQuery(query);
              
        while(set.next()){
            for (int i = 0; i < titulos.length; i++) {
                registros[c][i] = set.getString(i+1);
                System.out.println(registros[c][i]);    
            }
             System.out.println("Vueltas while: "+c);
            ++c;           
            }
         }catch(Exception e){
            System.out.println(e);      
         }
         
         return registros;
    }
    
    
    private void construirTabla(){
        //System.out.println(datos[0][0]);
      //  miModelo = new ModeloTabla(datos,titulos);
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
    private int x, y;
    
}


