package Vistas;
import SQL.Cliente;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import SQL.Conexion_bd;
import java.sql.SQLException;
import SQL.Usuario;

public class Registro extends JFrame{
    
    public Registro(){
        iniciarComponentes();
        this.nombre = us.getNombre();
        this.correo = us.getCorreo();
    
    }
    
    public void iniciarComponentes(){
        /*Conexion_bd con = new Conexion_bd();
        con.conectar();*/
        
        panelInicio = new JPanel();
        panelInicio.setBounds(0,0,600,600);
        panelInicio.setLayout(null);
        this.add(panelInicio);
        
        labelCorreo = new JLabel("Correo");
        labelCorreo.setBounds(90, 140, 160, 25);
        labelCorreo.setFont(new Font("Arial",1,17));
       // panelInicio.add(labelCorreo);
        
        labelContraseña = new JLabel("Contraseña:");
        labelContraseña.setBounds(90, 340, 250, 25);
        labelContraseña.setFont(new Font("Arial",1,20));
        panelInicio.add(labelContraseña);
        
        labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(90, 150, 160, 25);
        labelNombre.setFont(new Font("Arial",1,20));
        panelInicio.add(labelNombre);
        
        labelInicio = new JLabel("Inicia sesión");
        labelInicio.setBounds(150, 20, 200, 30);
        labelInicio.setFont(new Font("Arial",1,25));
        panelInicio.add(labelInicio);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(90, 175, 300, 30);
        panelInicio.add(txtNombre);
        
        txtContraseña = new JTextField();
        txtContraseña.setBounds(90,365,300,30);
        panelInicio.add(txtContraseña);
        
        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(150, 440, 150, 30);
        btnRegistro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panelInicio.setVisible(false);
                panelRegistro();
            }
        });
        panelInicio.add(btnRegistro);
        
        
        btnInicio = new JButton("Iniciar sesión");
        btnInicio.setBounds(150,400,150,30);
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
                    Ventana v = new Ventana(nombre,correo);
                    v.setVisible(true);
                    v.setSize(1500, 900);
                    v.setLocationRelativeTo(null);
                    v.setVisible(true);
                    cerrar();
                     
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
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    
    public void panelRegistro(){
        
        panelRegistro = new JPanel();
        panelRegistro.setBounds(0,0,600,600);
        panelRegistro.setLayout(null);
        this.add(panelRegistro);
        
        labelCorreo = new JLabel("Correo");
        labelCorreo.setBounds(90, 145, 160, 25);
        labelCorreo.setFont(new Font("Arial",1,20));
        panelRegistro.add(labelCorreo);
        
        labelContraseña = new JLabel("Contraseña:");
        labelContraseña.setBounds(90, 340, 250, 25);
        labelContraseña.setFont(new Font("Arial",1,20));
        panelRegistro.add(labelContraseña);
        
        labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(90, 250, 160, 25);
        labelNombre.setFont(new Font("Arial",1,20));
        panelRegistro.add(labelNombre);
        
        labelInicio = new JLabel("Registrate");
        labelInicio.setBounds(165, 20, 200, 30);
        labelInicio.setFont(new Font("Arial",1,25));
        panelRegistro.add(labelInicio);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(90, 275, 300, 30);
        panelRegistro.add(txtNombre);
        
        txtContraseña = new JTextField();
        txtContraseña.setBounds(90,365,300,30);
        panelRegistro.add(txtContraseña);
        
        txtCorreo = new JTextField();
        txtCorreo.setBounds(90,170,300,30);
        panelRegistro.add(txtCorreo);
        
        
        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(120, 450, 250, 40);
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
        btnVolverInicio.setBounds(120, 490, 250, 40);
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
    Cliente cliente;

 
    
}
