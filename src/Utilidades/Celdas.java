
package Utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Celdas extends DefaultTableCellRenderer{
    
    public Celdas(){
        
    }
    @Override
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        Color colorFondo = null;
        Color colorSeleccion=new Color(230, 74, 25);
        Color colorFocus=new Color(38, 76, 113);
        
        if (selected) {                
            this.setBackground(colorSeleccion);   
            
             
        }
        else
        {
           //Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(Color.white);
        }
        
        if (focused) {
    			colorFondo=colorFocus;
    		}else{
    			colorFondo= colorSeleccion;
    		}
        
         this.setHorizontalAlignment( JLabel.CENTER );
         this.setText( (String) value );
         this.setBackground( (selected)? colorFondo :new Color(255, 183, 77));
         this.setForeground( (selected)? Color.WHITE :Color.BLACK);
        
        return this;
    }
    
    private Font normal = new Font( "Verdana",Font.PLAIN ,12 );
	private Font bold = new Font( "Verdana",Font.BOLD ,12 );
	private JLabel label = new JLabel();
        
        
    
}
