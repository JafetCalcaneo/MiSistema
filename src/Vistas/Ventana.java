package Vistas;

import Pruebas.VentanaMarco;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import Vistas.Producto;
import javax.swing.table.TableModel;
import Utilidades.JLabelRound;
import Vistas.Panel;
import javax.swing.JScrollPane;

public class Ventana extends JFrame {
   
    public Ventana(){
         barraMenu();
        iniciarComponentes();
       // panelOpciones();
     //  construirTabla();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
    public void iniciarComponentes(){
        panelPerfil();
        
     /*  panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBounds(medidasPanel );
        panelPrincipal.setBackground(new Color(255, 255, 255));
        this.add(panelPrincipal);
                   
        labelUsuario = new JLabel();
        labelUsuario.setBounds(600, 100, 300, 300);
        
        label = new JLabelRound();
        label.setBounds(600, 100, 300, 300);
               
        
        usuario = new ImageIcon(getClass().getResource("/Recursos/Lucia.jpeg"));
        icono = new ImageIcon(usuario.getImage().getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_DEFAULT));
        label.setIcon(icono);
        panelPrincipal.add(label);
        
        labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(550, 500, 180, 30);   
        labelNombre.setFont(new Font("Arial",1,20));
        labelNombre.setForeground(Color.BLACK);
        panelPrincipal.add(labelNombre);
        
        labelCorreo = new JLabel("Correo:");
        labelCorreo.setBounds(780, 500, 180, 30);
        labelCorreo.setFont(new Font("Arial",1,20));
        labelCorreo.setForeground(Color.BLACK);
        panelPrincipal.add(labelCorreo);
        
         panelPuntero = panelPrincipal;*/
       /* labelEquis2 = new JLabel("Hey");
        labelEquis2.setBounds(240,10,30,30);
        equis = new ImageIcon(getClass().getResource("/Recursos/Equis.png"));
        icono = new ImageIcon(equis.getImage().getScaledInstance(labelEquis2.getWidth(), labelEquis2.getHeight(), Image.SCALE_DEFAULT));
        labelEquis2.setIcon(icono);
        panelPrincipal.add(labelEquis2);    */
          
    }
    
    public void panelPerfil(){
        panelPerfil = new Panel();
        panelPerfil.setBounds(new Rectangle(1500,900));
        panelPerfil.setLayout(null);
        panelPerfil.setBackground(Color.WHITE);
        panelPerfil.añadirImagenRedonda(600, 100,new Rectangle(300,300), Panel.LUCIA);
      //  panelPerfil.texto(400, 450, new Rectangle(150,30), "Correo:", "Segoe Print",Font.BOLD , 30);
        this.add(panelPerfil);
    }
    
    public JPanel panelOpciones(){
       
        panelOpciones = new JPanel();
        panelOpciones.setLayout(null);
        panelOpciones.setBounds(0,0,290,900);
        panelOpciones.setBackground(new Color(224,255,255));
        panelPerfil.add(panelOpciones);
        panelOpciones.setVisible(false);
       // panelPuntero.add(panelOpciones);
        
        btnPerfil = new JButton("Perfil");
        btnPerfil.setBounds(20,60,250,45);
        btnPerfil.setContentAreaFilled(false);
        icono = new ImageIcon(getClass().getResource("/Recursos/Perfil.png"));
        btnPerfil.setIcon(icono);
        btnPerfil.setHorizontalTextPosition(4);
        btnPerfil.setFont(new Font("Courier New",1,20));
        btnPerfil.setVisible(false);
        panelOpciones.add(btnPerfil);
              
        btnTienda = new JButton("Tienda");
        btnTienda.setBounds(20, 110, 250, 45);
        btnTienda.setContentAreaFilled(false);
        icono = new ImageIcon(getClass().getResource("/Recursos/Tienda.png"));
        btnTienda.setIcon(icono);
        btnTienda.setHorizontalTextPosition(4);
        btnTienda.setFont(new Font("Courier New",1,20));
        btnTienda.setVisible(false);
        panelOpciones.add(btnTienda);
                
        btnEquis = new JButton();
        btnEquis.setBounds(240,10,30,30);
        btnEquis.setContentAreaFilled(false);
        btnEquis.setHorizontalTextPosition(4);
        equis = new ImageIcon(getClass().getResource("/Recursos/Equis.png"));
        icono = new ImageIcon(equis.getImage().getScaledInstance(btnEquis.getWidth(), btnEquis.getHeight(), Image.SCALE_DEFAULT));
        btnEquis.setIcon(icono);
        panelOpciones.add(btnEquis);
        
       
        
        x = 290;
        btnEquis.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
              if(x==290){
                //  panelOpciones().show();
                  panelOpciones.setSize(x,900);
                   Thread th = new Thread(){
                    public void run(){
                        try{
                            for(int i = 290; i>=0; i--){
                                Thread.sleep(4/5);
                                panelOpciones.setSize(i, 900);
                                //btnPerfil.setVisible(false);
                                //btnTienda.setVisible(false);
                                
                                System.out.println(i);
                            }
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex);
                        }
                    }  
                  };th.start(); 
                  x=0;
              }
                
            }
            
        }); 
        
          btnTienda.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               // panelPuntero = panelTabla;
                panelPerfil.setVisible(false);
               
                panelProductos();
                 panelTabla.setVisible(true);
                 tabla.setVisible(true);
                
            }
            
        }); 
        

        
              
        //ImageIcon icono = new ImageIcon(home.getImage().getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(),Image.SCALE_DEFAULT));
        return panelOpciones;
    }
    
    public void barraMenu(){
        menu = new JMenu("Algo xd");
        
        barra = new JMenuBar();
        barra.setPreferredSize(new Dimension(1500,70));
        barra.setLayout(null);
        this.setJMenuBar(barra);
        
        btnMenu = new JButton();
        btnMenu.setBounds(20,5,70,70);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorder(null);
        btnMenu.setHorizontalTextPosition(SwingConstants.CENTER);
        btnMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnMenu.setVerticalAlignment(SwingConstants.CENTER);
              
        icono = new ImageIcon(getClass().getResource("/Recursos/Cubito.png"));
        btnMenu.setIcon(icono);
        btnMenu.setPressedIcon(icono);
        icono = new ImageIcon(getClass().getResource("/Recursos/Cubito2.png"));
        btnMenu.setRolloverIcon(icono);
        barra.add(btnMenu);
        
        
        
         x = 0;
         btnMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              if(x==0){
                  panelOpciones().show();
                  panelOpciones.setSize(x,900);
                   Thread th = new Thread(){
                    public void run(){
                        try{
                            for(int i = 0; i<=x; i++){
                                Thread.sleep(4/5);
                                panelOpciones.setSize(i, 900);
                              //  panelPerfil.add(panelOpciones);
                                btnPerfil.setVisible(true);
                                btnTienda.setVisible(true);
                                panelOpciones.setVisible(true);
                                System.out.println(i);
                            }
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex);
                        }
                    }  
                  };th.start(); 
                  x=290;
              }
                
            }
            
        }); 
       
               
    }
    
    private void panelProductos(){
       panelTabla = new Panel();
       panelTabla.setBounds(medidasPanel);
       panelTabla.setLayout(null);
       panelTabla.setBackground(Color.BLUE);
       tabla = new Tabla(500,200);
       scroll2 = new JScrollPane();
       scroll2.add(tabla);
       panelTabla.add(tabla);
       
        this.add(panelTabla);
        
        
       
    }
    

    
    private JPanel panelPrincipal,panelOpciones, panelPuntero;
    private JButton btnPerfil,btnTienda,btnMenu,btnEquis;
    private ImageIcon usuario, icono,equis;
    private JLabel labelUsuario, labelNombre,labelCorreo,labelEquis,labelEquis2;
    private JMenuBar barra;
    private JMenu menu;
    private Dimension dimension;
    private Boolean b;
    private JScrollPane scroll;
    ArrayList<Producto> listaProductos;
    //ModeloTabla modelo;//modelo definido en la clase ModeloTabla
    private int filasTabla;
    private int columnasTabla;
    private JTable tablaProductos, miTabla;
    private TableModel miModelo;
    Rectangle medidasPanel = new Rectangle(1500,900);
    private JLabelRound label; 
    private Panel panelPerfil, panelTabla;
    private Tabla tabla;
    private JScrollPane scroll2;
    int x;
}
