package Vistas;
import SQL.Cliente;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import SQL.Conexion_bd;
import java.sql.SQLException;
import SQL.Usuario;
import Utilidades.BorderRound;
import java.awt.Color;
import java.awt.Rectangle;

public class Registro extends JFrame{
    
    public Registro(){
        iniciarComponentes();
        this.setResizable(false);
        this.setBounds(new Rectangle(490,590));
        this.nombre = us.getNombre();
        this.correo = us.getCorreo();
          
    }
    
    public void iniciarComponentes(){
           
        panelInicio = new JPanel();
        panelInicio.setBounds(0,0,600,600);
        panelInicio.setBackground(new Color(197, 225, 165));
        panelInicio.setLayout(null);
        this.add(panelInicio);
        
        labelContraseña = new JLabel("Contraseña:");
        labelContraseña.setBounds(90, 240, 250, 25);
        labelContraseña.setFont(new Font("Corbel",0,23));
        panelInicio.add(labelContraseña);
        
        labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(90, 150, 160, 25);
        labelNombre.setFont(new Font("Corbel",0,23));
        panelInicio.add(labelNombre);
        
        labelInicio = new JLabel("Inicia sesión");
        labelInicio.setBounds(150, 20, 200, 30);
        labelInicio.setFont(new Font("Arial",1,25));
        panelInicio.add(labelInicio);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(90, 175, 300, 30);
        //txtNombre.setBorder(new BorderRound());
        txtNombre.setFont(new Font("Corbel",0,25));
        panelInicio.add(txtNombre);
        
        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(90,265,300,30);
        txtContraseña.setFont(new Font("Corbel",0,25));
        panelInicio.add(txtContraseña);
        
        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(165,370,150,40);
        btnRegistro.setBackground(new Color(197, 17, 98));
        btnRegistro.setFont(new Font("Corbel",1,20));
        btnRegistro.setForeground(Color.WHITE);
        btnRegistro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panelInicio.setVisible(false);
                panelRegistro();
            }
        });
        panelInicio.add(btnRegistro);
        
        
        btnInicio = new JButton("Iniciar sesión");
        btnInicio.setBounds(165,320,150,40);
        btnInicio.setBackground(new Color(197, 17, 98));
        btnInicio.setFont(new Font("Corbel",1,20));
        btnInicio.setForeground(Color.WHITE);
         btnInicio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Usuario us = new Usuario();
                us.setNombre(txtNombre.getText());
                us.setContraseña(txtContraseña.getText());
                String query = "select nombre, correo, contraseña from clientes where nombre=? and correo=? and contraseña=?";
              try{              
                
                if(con.existe(us)){
                    JOptionPane.showMessageDialog(null,"Puedes pasar UwU");
                  //  String nombre = us.getNombre(); String correo = us.getCorreo();
                    //cliente = con.traerInfo(cliente);  <---- ESTE METODO CAUSA CONFLICTO, CUANDO SE ACTIVA NO PERMITE A LA VENTANA SALIR
                    if(con.esAdmin(us)){
                        Ventana v = new Ventana(us);
                        v.setVisible(true);
                        v.setSize(1500, 900);
                        v.setLocationRelativeTo(null);
                        v.setVisible(true);
                        cerrar();
                    }else{
                        Cliente cliente = new Cliente(us.getNombre(), us.getContraseña());
                        
                        cliente =con.traerInfo(cliente);
                        System.out.println(cliente.toString());
                        System.out.println("Else");
                      VentanaCliente vc = new VentanaCliente(cliente);//<---AQUI TE QUEDASTE EKISDE
                        vc.setVisible(true);
                        vc.setSize(1500, 900);
                        vc.setLocationRelativeTo(null);
                        vc.setVisible(true);   
                        cerrar();
                    }
                   
                     
                }else{
                        panelInicio.setVisible(false);
                        panelRegistro();
                        JOptionPane.showMessageDialog(null,"Debes registrarte parce");
                }
                }catch(Exception ex){
                    System.out.println("Error\n"+ex);
                }
                
            }
        });
        panelInicio.add(btnInicio);
          
        
    }
    
    public void cerrar(){
        this.setVisible(false);
    }
//------------------------------------------SEPARACION------------------------------------------------------------------
    
    public void panelRegistro(){
        
        panelRegistro = new JPanel();
        panelRegistro.setBounds(0,0,600,600);
        panelRegistro.setLayout(null);
        panelRegistro.setBackground(new Color(255, 82, 82));
        this.add(panelRegistro);
        
        labelCorreo = new JLabel("Correo:");
        labelCorreo.setBounds(90, 210, 250, 25);
        labelCorreo.setFont(new Font("Corbel",0,25));
       // labelCorreo.setForeground(Color.WHITE);
        panelRegistro.add(labelCorreo);
        
        labelContraseña = new JLabel("Contraseña:");
        labelContraseña.setBounds(90, 300, 250, 25);
        labelContraseña.setFont(new Font("Corbel",0,25));
    //    labelContraseña.setForeground(Color.WHITE);
        panelRegistro.add(labelContraseña);
        
        labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(90, 120, 160, 25);
        labelNombre.setFont(new Font("Corbel",0,25));
     //   labelNombre.setForeground(Color.WHITE);
        panelRegistro.add(labelNombre);
        
        labelInicio = new JLabel("Registrate");
        labelInicio.setBounds(165, 20, 200, 30);
        labelInicio.setFont(new Font("Arial",1,25));
      //  labelInicio.setForeground(Color.WHITE);
        panelRegistro.add(labelInicio);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(90, 145, 300, 30);
        txtNombre.setFont(new Font("Corbel",0,25));
        panelRegistro.add(txtNombre);
        
        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(90,325,300,30);
        txtContraseña.setFont(new Font("Corbel",0,25));
        panelRegistro.add(txtContraseña);
        
        txtCorreo = new JTextField();
        txtCorreo.setBounds(90,235,300,30);
        txtCorreo.setFont(new Font("Corbel",0,25));
        panelRegistro.add(txtCorreo);
        
        
        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(165,380,150,40);
        btnRegistro.setBackground(new Color(197, 225, 165));
        btnRegistro.setFont(new Font("Corbel",1,20));
        panelRegistro.add(btnRegistro);
        btnRegistro.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              us.setCorreo(txtCorreo.getText());   us.setContraseña(txtContraseña.getText());  us.setNombre(txtNombre.getText());
              if(us.getCorreo().equals("") && us.getContraseña().equals("") && us.getNombre().equals("")){
                     JOptionPane.showMessageDialog(null,"Campos vacios");
                }else{
                    try{
                         if(con.existe2(us)){
                             JOptionPane.showMessageDialog(null,"Este usuario ya existe");
                         }else{
                             //cliente = new Cliente(us.getNombre(),us.getCorreo(),us.getContraseña());
                             con.registrarCliente(new Cliente(us.getNombre(), us.getCorreo(), us.getContraseña()));
                             
                             JOptionPane.showMessageDialog(null,"Datos ingresados");
                              }
                       }catch(Exception ex){
                            JOptionPane.showMessageDialog(null,"Algo salio mal UnU\n"+ex);
                            }       
                      }
                }
        });
        
        btnVolverInicio = new JButton("Iniciar sesión");
        btnVolverInicio.setBounds(165,430,150,40);
        btnVolverInicio.setBackground(new Color(197, 225, 165));
        btnVolverInicio.setFont(new Font("Corbel",1,20));
        panelRegistro.add(btnVolverInicio);
        btnVolverInicio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panelRegistro.setVisible(false);
                iniciarComponentes();
            }
            
        });
         
                      
      }
    
    private JPanel panelInicio, panelRegistro;
    private JLabel labelCorreo, labelContraseña, labelNombre, labelInicio;
    private JTextField txtNombre, txtContraseña, txtCorreo;
    private JButton btnInicio, btnRegistro, btnVolverInicio;
    private String nombre, correo;
    Conexion_bd con = new Conexion_bd();
    Usuario us = new Usuario();
   // Cliente cliente;

 
    
}
