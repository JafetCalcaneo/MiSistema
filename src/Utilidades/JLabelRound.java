
package Utilidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Utilidades.BorderRound;
import java.awt.Dimension;


public class JLabelRound extends JLabel{
    
    public JLabelRound(){
        nombre = "";
        initComponent();
    }
    
    public JLabelRound(String info){
        nombre = info;
        initComponent();
    }
    
    public JLabelRound(ImageIcon info){
        icono = info;
        initComponent();
    }
    
    private void initComponent(){
        setText(nombre);
        setHorizontalAlignment(CENTER);
        setIcon(icono);
        setOpaque(true);
        setBorder(border);
        setPreferredSize(new Dimension(100,100));
    }
    
    
    private String nombre = "";
    private ImageIcon icono = null;
    private final BorderRound border = new BorderRound();
}
