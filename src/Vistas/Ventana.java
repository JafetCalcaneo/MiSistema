package Vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import Vistas.Producto;

public class Ventana extends JFrame {
    
    public Ventana(){
         barraMenu();
        iniciarComponentes();
        //panelOpciones();
     //  construirTabla();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
    public void iniciarComponentes(){
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBounds(0,90,1500, 800 );
        panelPrincipal.setBackground(Color.white);
        this.add(panelPrincipal);
                   
        labelUsuario = new JLabel();
        labelUsuario.setBounds(600, 100, 300, 300);
        
        usuario = new ImageIcon(getClass().getResource("/Recursos/usuario.jpg"));
        icono = new ImageIcon(usuario.getImage().getScaledInstance(labelUsuario.getWidth(), labelUsuario.getHeight(),Image.SCALE_DEFAULT));
        labelUsuario.setIcon(icono);
        panelPrincipal.add(labelUsuario);
        
        labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(550, 500, 180, 30);   
        labelNombre.setFont(new Font("Arial",1,20));
        labelNombre.setForeground(Color.BLACK);
        panelPrincipal.add(labelNombre);
        
        labelCorreo = new JLabel("Correo:");
        labelCorreo.setBounds(780, 500, 180, 30);
        labelCorreo.setFont(new Font("Arial",1,20));
        labelCorreo.setForeground(Color.white);
        panelPrincipal.add(labelCorreo);
        
       /* labelEquis2 = new JLabel("Hey");
        labelEquis2.setBounds(240,10,30,30);
        equis = new ImageIcon(getClass().getResource("/Recursos/Equis.png"));
        icono = new ImageIcon(equis.getImage().getScaledInstance(labelEquis2.getWidth(), labelEquis2.getHeight(), Image.SCALE_DEFAULT));
        labelEquis2.setIcon(icono);
        panelPrincipal.add(labelEquis2);    */
          
    }
    
    public JPanel panelOpciones(){
       
        panelOpciones = new JPanel();
        panelOpciones.setLayout(null);
        panelOpciones.setBounds(0,0,290,900);
        panelOpciones.setBackground(new Color(224,255,255));
        panelOpciones.setVisible(false);
        panelPrincipal.add(panelOpciones);
        
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
              //  panelProductos();
           
                
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
    
  /*  private void panelProductos(){
        labelUsuario.setVisible(false);
        panelPrincipal.add(scroll);
    }
    
    private void construirTabla() {
		
		listaProductos=consultarListaProductos();
		
		ArrayList<String> titulosList=new ArrayList<>();
		
		titulosList.add("Nombre");
		titulosList.add("Precio");
		titulosList.add("Stock");
		titulosList.add("Codigo");
		titulosList.add("Color");
		
				
		//se asignan las columnas al arreglo para enviarse al momento de construir la tabla
		String titulos[] = new String[titulosList.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i]=titulosList.get(i);
		}*/
		/*obtenemos los datos de la lista y los guardamos en la matriz
		 * que luego se manda a construir la tabla
		 */
	/*	Object[][] data =obtenerMatrizDatos(titulosList);
		construirTabla(titulos,data);
		
	}*/
    
    /**
	 * Permite simular el llenado de personas en una lista
	 * que posteriormente alimentará la tabla
	 * @return
	 */
	/*private ArrayList<Producto> consultarListaProductos() {
		ArrayList<Producto> lista=new ArrayList<>();
		
		lista.add(new Producto("Laptop Dell",10000,30,"EL12020","Negro"));
		lista.add(new Producto("SmartPhone Samsung",5000,10,"ES12020","Blanco"));
		lista.add(new Producto("SmartPhone Huawei",15000,40,"ES22020","Gris"));
		lista.add(new Producto("Tablet LG",12000,10,"ET12020","Negro"));
		lista.add(new Producto("Laptop Apple",25000,20,"EL22020","Blanco"));
		lista.add(new Producto("Consola Xbox",8000,40,"EX12020","Negro"));
		lista.add(new Producto("SmartPhone Xiaomi",10,13000,"ES32020","Gold"));
		
		return lista;
	}
        
        private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {*/
		
		/*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
		 */
		/*String informacion[][] = new String[listaProductos.size()][titulosList.size()];
                
		
		for (int x = 0; x < informacion.length; x++) {
			
			informacion[x][Utilidades.CODIGO] = listaProductos.get(x).getCodigo();
			informacion[x][Utilidades.NOMBRE] = listaProductos.get(x).getNombre();
			informacion[x][Utilidades.PRECIO] = listaProductos.get(x).getPrecio()+"";
			informacion[x][Utilidades.COLOR] = listaProductos.get(x).getColor();
			informacion[x][Utilidades.STOCK] = listaProductos.get(x).getStock()+"";*/
			
			//se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
			/*informacion[x][Utilidades.PERFIL] = "PERFIL";
			informacion[x][Utilidades.EVENTO] = "EVENTO";*/
	/*	}
		
		return informacion;
	}*/

        /**
	 * Con los titulos y la información a mostrar se crea el modelo para 
	 * poder personalizar la tabla, asignando tamaño de celdas tanto en ancho como en alto
	 * así como los tipos de datos que va a poder soportar.
	 * @param titulos
	 * @param data
	 */
	/*private void construirTabla(String[] titulos, Object[][] data) {
		modelo=new ModeloTabla(data, titulos);
		//se asigna el modelo a la tabla
		tablaProductos.setModel(modelo);
		
		filasTabla=tablaProductos.getRowCount();
		columnasTabla=tablaProductos.getColumnCount();
		
		//se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
		tablaProductos.getColumnModel().getColumn(Utilidades.CODIGO).setCellRenderer(new GestionCeldas("texto"));
		tablaProductos.getColumnModel().getColumn(Utilidades.NOMBRE).setCellRenderer(new GestionCeldas("texto"));
		tablaProductos.getColumnModel().getColumn(Utilidades.PRECIO).setCellRenderer(new GestionCeldas("numerico"));
		tablaProductos.getColumnModel().getColumn(Utilidades.COLOR).setCellRenderer(new GestionCeldas("texto"));
		tablaProductos.getColumnModel().getColumn(Utilidades.STOCK).setCellRenderer(new GestionCeldas("numerico"));*/
		
		//se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
		/*for (int i = 0; i < titulos.length-7; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
			System.out.println(i);
			tablaProductos.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
		}*/
		
	/*	tablaProductos.getTableHeader().setReorderingAllowed(false);
		tablaProductos.setRowHeight(25);//tamaño de las celdas
		tablaProductos.setGridColor(new java.awt.Color(0, 0, 0)); 
		//Se define el tamaño de largo para cada columna y su contenido
		tablaProductos.getColumnModel().getColumn(Utilidades.CODIGO).setPreferredWidth(130);//documento
		tablaProductos.getColumnModel().getColumn(Utilidades.NOMBRE).setPreferredWidth(380);//nombre
		tablaProductos.getColumnModel().getColumn(Utilidades.PRECIO).setPreferredWidth(350);//direccion
		tablaProductos.getColumnModel().getColumn(Utilidades.COLOR).setPreferredWidth(130);//telefono
		tablaProductos.getColumnModel().getColumn(Utilidades.STOCK).setPreferredWidth(280);//profesion*/
		
		/*tablaProductos.getColumnModel().getColumn(Utilidades.PERFIL).setPreferredWidth(30);//accion perfil
		tablaProductos.getColumnModel().getColumn(Utilidades.EVENTO).setPreferredWidth(30);//accion evento*/
		
		//personaliza el encabezado
	/*	JTableHeader jtableHeader = tablaProductos.getTableHeader();
	    jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
	    tablaProductos.setTableHeader(jtableHeader);
	    
	    //se asigna la tabla al scrollPane
	    scroll.setViewportView(tablaProductos);


	}*/ 
    
    private JPanel panelPrincipal,panelTrans,panelOpciones;
    private JButton btnPerfil,btnTienda,btnMenu,btnEquis;
    private ImageIcon usuario, icono,equis;
    private JLabel labelUsuario, labelNombre,labelCorreo,labelEquis,labelEquis2;
    private JMenuBar barra;
    private JMenu menu;
    private Dimension dimension;
    private Boolean b;
    private JScrollPane scroll;
    ArrayList<Producto> listaProductos;
    ModeloTabla modelo;//modelo definido en la clase ModeloTabla
    private int filasTabla;
    private int columnasTabla;
    private JTable tablaProductos;
   
    int x;
}
