
package Vistas;

import Utilidades.JLabelRound;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel{
    //CLASE PANEL DONDE SE CREAN LOS PANELES DE DISEÑO DEL PROGRAMA
    public Panel(){
       super();
    }
    
    //CON ESTE MÉTODO PODEMOS AÑADIR IMAGENES AL PANEL DANDOLE PROPIEDADES
    public void añadirImagen(int x, int y, Rectangle r, String url){
        label = new JLabel();
        label.setBounds(r);
        label.setLocation(x, y);
        icono = new ImageIcon(getClass().getResource(url));
        icono2 = new ImageIcon(icono.getImage().getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_DEFAULT));
        label.setIcon(icono2);
        this.add(label);
        
    }
    //CON ESTE OTRO TAMBIEN PERO LA VOVEMOS UNA IMAGEN REDONDA
     public void añadirImagenRedonda(int x, int y, Rectangle r, String url){
        labelRound = new JLabelRound();
        labelRound.setBounds(r);
        labelRound.setLocation(x,y);
        icono = new ImageIcon(getClass().getResource(url));
        icono2 = new ImageIcon(icono.getImage().getScaledInstance(labelRound.getWidth(), labelRound.getHeight(),Image.SCALE_DEFAULT));
        labelRound.setIcon(icono2);
        this.add(labelRound);
        
    }
     //METODO PARA PONERLE TEXTO AL PANEL
     public void texto(int x, int y, Rectangle r, String texto){
         label = new JLabel(texto);
         label.setLayout(null);
         label.setBounds(r);
         label.setLocation(x, y);
         
         this.add(label);
     }
        //METODO USADO PARA IMPLANTAR TEXTO EN EL PANEL CON DISTINTOS PARAMETROS
          public void texto(int x, int y, Rectangle r, String texto, String tipo, int modo, int tamaño){
         label = new JLabel(texto);
         label.setLayout(null);
         label.setBounds(r);
         label.setLocation(x, y);
         label.setFont(new Font(tipo,modo,tamaño));
         this.add(label);       //<--- SE AÑADEN AL LABEL
     }
    
    
    public static final String LUCIA = "/Recursos/Lucia.jpeg";
    public static final String EMILY = "/Recursos/Emily.jpeg";
    public static final String PADORU = "/Recursos/Padoru.jpg";
    //ESTAS CONSTANTES SON LAS DIRECCIOES DE IMAGENES PREDETERMINADAS QUE PODEMOS PONER
    private ImageIcon icono, icono2;
    private JLabel label;
    private JLabelRound labelRound;
}
