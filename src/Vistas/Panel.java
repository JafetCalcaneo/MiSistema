
package Vistas;

import Utilidades.JLabelRound;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel{
    
    public Panel(){
       super();
    }
    
    
    public void añadirImagen(int x, int y, Rectangle r, String url){
        label = new JLabel();
        label.setBounds(r);
        label.setLocation(x, y);
        icono = new ImageIcon(getClass().getResource(url));
        icono2 = new ImageIcon(icono.getImage().getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_DEFAULT));
        label.setIcon(icono2);
        this.add(label);
        
    }
    
     public void añadirImagenRedonda(int x, int y, Rectangle r, String url){
        labelRound = new JLabelRound();
        labelRound.setBounds(r);
        labelRound.setLocation(x,y);
        icono = new ImageIcon(getClass().getResource(url));
        icono2 = new ImageIcon(icono.getImage().getScaledInstance(labelRound.getWidth(), labelRound.getHeight(),Image.SCALE_DEFAULT));
        labelRound.setIcon(icono2);
        this.add(labelRound);
        
    }
     
     public void texto(int x, int y, Rectangle r, String texto){
         label = new JLabel(texto);
         label.setLayout(null);
         label.setBounds(r);
         label.setLocation(x, y);
         
         this.add(label);
     }
     
          public void texto(int x, int y, Rectangle r, String texto, String tipo, int modo, int tamaño){
         label = new JLabel(texto);
         label.setLayout(null);
         label.setBounds(r);
         label.setLocation(x, y);
         label.setFont(new Font(tipo,modo,tamaño));
         this.add(label);
     }
    
    
    public static final String LUCIA = "/Recursos/Lucia.jpeg";
    public static final String EMILY = "/Recursos/Emily.jpeg";
    public static final String PADORU = "/Recursos/Padoru.jpg";
    
    private ImageIcon icono, icono2;
    private JLabel label;
    private JLabelRound labelRound;
}
