
package misistema;
import Vistas.Ventana;
import Vistas.Registro;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
 class MiSistema {
     
     
     

  
    public static void main(String[] args) {
        //MiSistema.main(args);
        Ventana ventana = new Ventana();
        ventana.setSize(1500, 900);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        //JOptionPane.showMessageDialog(null,"Hey");
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       /* Registro r = new Registro();
        r.setVisible(true);
        r.setSize(490,680);
        r.setLocationRelativeTo(null);*/
       
    }
    
}
