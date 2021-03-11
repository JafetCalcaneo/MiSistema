
package Vistas;

import SQL.Cliente;
import SQL.Conexion_bd;
import SQL.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelProductos extends JPanel{  //EN ESTA CLASE CREAMOS EL PANEL QUE SE MUESTRA EN LA SECCIÓN TIENDA
    Conexion_bd con = new Conexion_bd();
    Tabla tablaProductos = new Tabla();
    JScrollPane scroll = new JScrollPane();
    Object fila[] = new Object[6];
    JButton btn;
    //SE USA ESTE CONSTRUCTOR SI EL OBJETO RECIBIDO ES DE TIPO CLIENTE
    PanelProductos(Cliente cliente){
        //IMPLEMENTAMOS LA INTERFAZ
        MouseListener oyente = new MouseListener() { //SOBREESCRIBIMOS UN MÉTODO
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccion = tablaProductos.rowAtPoint(e.getPoint());//RECUPERAMOS DONDE EL PUNTO DONDE ESTE SELECCIONADO EN LA TABLA
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = tablaProductos.getValueAt(seleccion, i);  //Y RECORREMOS LA FILA PARA RELLENAR NUESTRO ARRAY
                }
                System.out.println(fila[0]+" "+fila[3]);
            }
               //ESTOS MÉTODOS NO ESTAN EN USO        
            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        tablaProductos.addMouseListener(oyente); //LE AGREGAMOS EL OYENTE A LA TABLA PARA QUE ESTE PENDIENTE DE LOS EVENTOS
        btn = new JButton("Comprar");
        btn.addActionListener(new ActionListener(){ //IMPLEMENTAMOS LA INTERFAZ ACTION LISTENER PARA REALIZAR LA ACCION AL MOMENTO DEL CLICK
          public void actionPerformed(ActionEvent e){
              String mensaje = "¿Seguro que desea hacer la siguiente compra?\n";
              String campos[] = {"ID","Código","Producto","Precio","Stock","Color"};
                
              for (int i = 0; i < fila.length; i++) {  //RECORREMOS LOS DATOS QUE SE HAN SOLICITADO
                  mensaje +=campos[i]+": "+((String) fila[i])+"\n"; //Y CONTATENAMOS UN MENSAJE DE SALIDA PARA MOSTRAR LOS QUE SE HA PEDIDO
              }
              JOptionPane.showMessageDialog(null,mensaje);
                con.guardarCompra(cliente, fila);//CON LA CONEXION LLAMAMOS AL MÉTODO GUARDAR QUE SE ENCARGA DE REGISTRAR LA COMPRA EN LA BD
                }
        });
        btn.setBounds(700, 400, 300, 50);
        btn.setBackground(new Color(121, 134, 203));
        btn.setFont(new Font("Corbel",1,23));
        btn.setForeground(Color.WHITE);
        scroll.setVisible(true);        //EN ESTA SECCIÓN LE DAMOS DISEÑO A NUESTRA TABLA CON EL SCROLL
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setViewportView(tablaProductos);
        scroll.setBounds(300, 70, 1175, 300);
        
        this.setBounds(new Rectangle(1500,900));
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,400));
        this.add(btn);
        this.add(scroll);
    }
    
    PanelProductos(Usuario us){
         MouseListener oyente = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccion = tablaProductos.rowAtPoint(e.getPoint());
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = tablaProductos.getValueAt(seleccion, i);
                }
                System.out.println(fila[0]+" "+fila[2]);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        tablaProductos.addMouseListener(oyente);
        btn = new JButton("Guardar");
        btn.setBounds(700, 400, 300, 50);
        btn.setBackground(new Color(64, 196, 255));
        btn.setFont(new Font("Corbel",1,23));
        btn.setForeground(Color.WHITE);
        btn.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String mensaje = "¿Seguro que desea hacer estos cambios?\n";
              String campos[] = {"ID","Código","Producto","Precio","Stock","Color"};
                
              for (int i = 0; i < fila.length; i++) {
                  mensaje +=campos[i]+": "+((String) fila[i])+"\n";
              }
              JOptionPane.showMessageDialog(null,mensaje);
                con.actualizar(fila);
                }
        });
        
        scroll.setVisible(true);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setViewportView(tablaProductos);
        scroll.setBounds(300, 70, 1175, 290);

   
       
        this.setBounds(new Rectangle(1500,900));
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,400));
        this.add(btn);
        this.add(scroll);
    } 
   
        
    
}
