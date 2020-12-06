
package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelProductos extends JPanel{
    
    Tabla tablaProductos = new Tabla();
    JScrollPane scroll = new JScrollPane();
    
    
    PanelProductos(){
        scroll.setVisible(true);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setViewportView(tablaProductos);
        scroll.setBounds(300, 70, 900, 200);

    //    scroll.add(tablaProductos);
       
        this.setBounds(new Rectangle(1500,900));
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,400));
        this.add(scroll);
    } 
   
        
    
}
