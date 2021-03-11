package Vistas;

import Pruebas.VentanaMarco;
import SQL.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.JTableHeader;
//import Utilidades.Producto;
import javax.swing.table.TableModel;
import Utilidades.JLabelRound;
import Vistas.Panel;
import javafx.scene.control.ScrollBar;
import javax.swing.JScrollPane;

public class Ventana extends JFrame {
   
    public Ventana(Usuario us){
        this.name = name;
        this.correo = correo;
         barraMenu();
        iniciarComponentes();
        this.us = us;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentes(){
        panel = "perfil";
        
        panelPerfil();
        
      
          
    }
    
    public void panelPerfil(){
        panelPerfil = new Panel();
        panelPerfil.setBounds(new Rectangle(1500,900));
        panelPerfil.setLayout(null);
        panelPerfil.setBackground(new Color(0, 172, 193));
        panelPerfil.añadirImagenRedonda(310, 50,new Rectangle(200,200), Panel.PADORU);
       panelPerfil.texto(515, 100, new Rectangle(150,30), "Nombre", "Candara",Font.ITALIC , 21);
        panelPerfil.texto(515, 122, new Rectangle(150,30), "Jafet", "Candara",Font.PLAIN , 28);
        panelPerfil.texto(515, 160, new Rectangle(150,30), "Correo", "Candara",Font.ITALIC , 21);
         panelPerfil.texto(515, 182, new Rectangle(400,30), "jafetcalcaneo2@gmail.com", "Candara",Font.PLAIN , 28);
        
        this.add(panelPerfil);
        panelPuntero = panelPerfil;
      
    }
    
     private JPanel panelProductos(){
         //CREE UN OBJETO PANELPRODUCTOS Y LO TRAIGO AQUI
         PanelProductos panel = new PanelProductos(us);
         panel.add(panelOpciones);
         panel.setVisible(true);
         this.add(panel);
         return panel;
      }
     
    public JPanel panelOpciones(){
       
        panelOpciones = new JPanel();
       //  panelProductos().add(panelOpciones);
        panelOpciones.setLayout(null);
        panelOpciones.setBounds(0,0,290,900);
        panelOpciones.setBackground(new Color(0, 96, 100));
        panelPerfil.add(panelOpciones);
      //  panelTabla.add(panelOpciones);
        
    //    panelTabla.add(panelOpciones);
        panelOpciones.setVisible(true);
        
      
        
        btnPerfil = new JButton("Perfil");
        btnPerfil.setBounds(20,60,250,45);
        btnPerfil.setContentAreaFilled(false);
        icono = new ImageIcon(getClass().getResource("/Recursos/Perfil.png"));
        btnPerfil.setIcon(icono);
        btnPerfil.setHorizontalTextPosition(4);
        btnPerfil.setFont(new Font("Courier New",1,20));
        btnPerfil.setForeground(Color.WHITE);
        btnPerfil.setVisible(false);
        panelOpciones.add(btnPerfil);
              
        btnTienda = new JButton("Tienda");
        btnTienda.setBounds(20, 110, 250, 45);
        btnTienda.setContentAreaFilled(false);
        icono = new ImageIcon(getClass().getResource("/Recursos/Tienda.png"));
        btnTienda.setIcon(icono);
        btnTienda.setHorizontalTextPosition(4);
        btnTienda.setFont(new Font("Courier New",1,20));
        btnTienda.setForeground(Color.WHITE);
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
       //  panelProductos().add(panelOpciones);
       
        btnPedidos = new JButton("Pedidos");
        btnPedidos.setBounds(20,160,250,45);
        btnPedidos.setContentAreaFilled(false);
        btnPedidos.setHorizontalTextPosition(4);
        icono = new ImageIcon(getClass().getResource("/Recursos/Pedidos.png"));
        btnPedidos.setFont(new Font("Courier New",1,20));
        btnPedidos.setForeground(Color.WHITE);
        btnPedidos.setIcon(icono);
        panelOpciones.add(btnPedidos);
        
        btnEstadistica = new JButton("Estadistica");
        btnEstadistica.setBounds(20,220,250,45);
        btnEstadistica.setContentAreaFilled(false);
        btnEstadistica.setHorizontalTextPosition(4);
        icono = new ImageIcon(getClass().getResource("/Recursos/Estadistica.png"));
        btnEstadistica.setFont(new Font("Courier New",1,20));
        btnEstadistica.setForeground(Color.WHITE);
        btnEstadistica.setIcon(icono);
        panelOpciones.add(btnEstadistica);
       
        btnCalendario = new JButton("Calendario");
        btnCalendario.setBounds(20,280,250,45);
        btnCalendario.setContentAreaFilled(false);
        btnCalendario.setHorizontalTextPosition(4);
        icono = new ImageIcon(getClass().getResource("/Recursos/Calendario.png"));
        btnCalendario.setFont(new Font("Courier New",1,20));
        btnCalendario.setForeground(Color.WHITE);
        btnCalendario.setIcon(icono);
        panelOpciones.add(btnCalendario);
        
        btnPremios = new JButton("Premios");
        btnPremios.setBounds(20,340,250,45);
        btnPremios.setContentAreaFilled(false);
        btnPremios.setHorizontalTextPosition(4);
        icono = new ImageIcon(getClass().getResource("/Recursos/Recompensas.png"));
        btnPremios.setFont(new Font("Courier New",1,20));
        btnPremios.setForeground(Color.WHITE);
        btnPremios.setIcon(icono);
        panelOpciones.add(btnPremios);
       
        btnPerfil.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            panelPerfil.setVisible(true);
            panel = "Perfil";
            System.out.println(panel);
            panelProductos();
        }
    });
     
        btnEquis.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println(panel);  
             cerrarMenu();
                
            }
            
        }); 
        
          btnTienda.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                             
                panelPerfil.setVisible(false);
                panel = "Tienda";
                System.out.println(panel);
                panelProductos();
                
                
                 
             
                
            }
            
        }); 
              
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
        
            
         btnMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                switch(panel){
                    case "Perfil": abrirMenu();panelPerfil();  break;
                    case "Tienda": abrirMenu(); panelProductos(); ;break;
                    default: abrirMenu();
                }
                
                
            }
            
        }); 
       
               
    }
    
    public int abrirMenu(){
        
         if(x==0){
              
                  panelOpciones().show();
                  panelOpciones.setSize(x,900);
                   Thread th = new Thread(){
                    public void run(){
                        try{
                            for(int i = 0; i<=x; i++){
                                Thread.sleep(4/5);
                                panelOpciones.setSize(i, 900);
                                
                                btnPerfil.setVisible(true);
                                btnTienda.setVisible(true);
                                panelOpciones.setVisible(true);
                              //  System.out.println(i);
                            }
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex);
                        }
                    }  
                  };th.start(); 
                  x=290;
              }
         System.out.println("Abrir menu"+x);
         return x;
    }
    
    public int cerrarMenu(){
        
        if(x==290){
                //  panelOpciones().show();
                  panelOpciones.setSize(x,900);
                   Thread th = new Thread(){
                    public void run(){
                        try{
                            for(int i = 290; i>=0; i--){
                                Thread.sleep(4/5);
                                panelOpciones.setSize(i, 900);
                                
                                //btnTienda.setVisible(false);
                              //   System.out.println(i);
                            }
                            
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex);
                        }
                    }  
                  };th.start(); 
                  x=0;
              }
        System.out.println("Cerrar menu "+x);
        return x;
    }
    
   
    

    
    private JPanel panelPrincipal,panelOpciones, panelPuntero= null;
    private JButton btnPerfil,btnTienda,btnMenu,btnEquis, btnPedidos, btnEstadistica, btnCalendario, btnPremios;
    private ImageIcon usuario, icono,equis;
    private JLabel labelUsuario, labelNombre,labelCorreo,labelEquis,labelEquis2;
    private JMenuBar barra;
    private JMenu menu;
    private Dimension dimension;
    private Boolean b;
    private JScrollPane scroll;
    private Usuario us;
    
    private int filasTabla;
    private int columnasTabla;
    private JTable tablaProductos, miTabla;
    private TableModel miModelo;
    Rectangle medidasPanel = new Rectangle(1500,900);
    private JLabelRound label; 
    private Panel panelPerfil, panelTabla;
    private Tabla tabla;
    private JScrollPane scroll2;
    private static String panel = "";
    private JScrollBar barra2;
    private String name, correo;
    static int x=0, y;
}
