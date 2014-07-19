package Pruebas;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.fiuba.taller.ums.ControlUnit;
import com.fiuba.taller.ums.Memory;
import com.fiuba.taller.ums.RegisterMemory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.Font;


public class Vista implements Observer{

	private JFrame frame;
	private JPanel contentPane;
	private JTable tablaMemoria;
	private JPanel panelMemoria;
	private JPanel panelRegistro;
	private JTable tablaRegistro;
	private JScrollPane scrollPaneMemoria;
	private JScrollPane scrollPaneRegistro;
	private JButton botonEjecutar;
	private JButton botonPasoAPaso;
	private JButton botonCargarPrograma;
	private JLabel labelRegistro;
	private JLabel labelMemoria;
	private JPanel panelControles;
	private JLabel tituloEstado;
	private JLabel estado;
	private JButton botonRecargarPrograma;
	
	private Object[][] dataMemoria;
	private String[] colMemoria;
	private DefaultTableModel dtmMemoria;
	
	private Object[][] dataRegistro;
	private String[] colRegistro;
	private DefaultTableModel dtmRegistro;
	
	private Modelo modelo;

	/**
	 * Create the application.
	 */
	public Vista() {		
		initialize();
	}
	
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBounds(100, 100, 600, 500);
		
		crearPanelDeMemoria();
		crearPanelDeRegistro();
		crearPanelDeControles();
				
		
		contentPane.add(panelMemoria);
		contentPane.add(panelRegistro);
		contentPane.add(panelControles);		
	}

	private void crearPanelDeControles() {
		panelControles = new JPanel();
		panelControles.setBounds(354, 36, 211, 300);		
		panelControles.setLayout(null);
		
		botonEjecutar = new JButton("Ejecutar programa");
		botonEjecutar.setBounds(5, 168, 183, 25);
		
		botonPasoAPaso = new JButton("Ejecutar paso a paso");
		botonPasoAPaso.setBounds(5, 131, 183, 25);
		
		botonCargarPrograma = new JButton("Cargar Programa");
		botonCargarPrograma.setBounds(5, 53, 183, 25);
		
		tituloEstado = new JLabel("Estado:");
		tituloEstado.setFont(new Font("Dialog", Font.BOLD, 10));
		tituloEstado.setBounds(10, 250, 100, 20);	
		
		estado = new JLabel("Programa no cargado");
		estado.setForeground(Color.RED);
		estado.setFont(new Font("Dialog", Font.BOLD, 10));
		estado.setBounds(60, 250, 150, 20);
		
		botonRecargarPrograma = new JButton("Recargar Programa");
		botonRecargarPrograma.setBounds(5, 94, 183, 25);
		panelControles.add(botonRecargarPrograma);
		

		panelControles.add(botonCargarPrograma);		
		panelControles.add(botonPasoAPaso);	
		panelControles.add(botonEjecutar);
		panelControles.add(tituloEstado);
		panelControles.add(estado);
		
		agregarListenerControles();
	}
	
	private void agregarListenerControles() {
		botonEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.ejecutarPrograma();				
			}
		});		
		
		botonPasoAPaso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.ejecutarPasoApaso();				
			}
		});		
			
		botonCargarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				JFileChooser chooserFile=new JFileChooser();
				chooserFile.showOpenDialog(frame);

				File fileMaq = chooserFile.getSelectedFile();	
				
				// no comprueba que sea un .maq
				if(fileMaq != null) {
					modelo.cargarPrograma(fileMaq);										
				}
			}
		});
		
		botonRecargarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.recargarPrograma();				
			}
		});
	}	
	
	private void crearPanelDeMemoria() {		
		panelMemoria = new JPanel();
		panelMemoria.setLocation(28, 35);
		panelMemoria.setSize(170, 404);
		panelMemoria.setLayout(null);
		
		labelMemoria = new JLabel("Memoria");
		labelMemoria.setBounds(56, 0, 66, 25);
		panelMemoria.add(labelMemoria);
		
		colMemoria = new String[]{"Direccion", "Valor"};
		dataMemoria = new Object[128][2];
		inicializarMemoria();
		dtmMemoria = new DefaultTableModel(dataMemoria, colMemoria);		
		tablaMemoria = new JTable(dtmMemoria);
		tablaMemoria.setBackground(Color.WHITE);
		tablaMemoria.getColumn("Direccion").setMaxWidth(75);
		tablaMemoria.getColumn("Valor").setMaxWidth(70);
		tablaMemoria.setDefaultRenderer(Object.class, new StatusColumnCellRenderer());
		
		scrollPaneMemoria = new JScrollPane();
		scrollPaneMemoria.setBounds(0, 34, 167, 369);
		scrollPaneMemoria.setViewportView(tablaMemoria);
		panelMemoria.add(scrollPaneMemoria);
	}
	
	private void crearPanelDeRegistro() {
		panelRegistro = new JPanel();
		panelRegistro.setBorder(null);
		panelRegistro.setLocation(210, 35);
		panelRegistro.setSize(110,300);
		panelRegistro.setLayout(null);
		
		labelRegistro = new JLabel("Registro");
		labelRegistro.setForeground(Color.BLACK);
		labelRegistro.setBackground(Color.WHITE);
		labelRegistro.setBounds(10, 11, 73, 16);		

		colRegistro = new String[]{"Registro","Valor"};
		dataRegistro = new Object[16][2];
		inicializarRegistro();
		dtmRegistro = new DefaultTableModel(dataRegistro, colRegistro);
		tablaRegistro = new JTable(dtmRegistro);
		tablaRegistro.setBackground(Color.WHITE);
		tablaRegistro.getColumn("Registro").setMaxWidth(50);
		tablaRegistro.getColumn("Valor").setMaxWidth(40);
		
		scrollPaneRegistro = new JScrollPane();
		scrollPaneRegistro.setBounds(10,32,90,259);
		scrollPaneRegistro.setLocation(10, 35);
		scrollPaneRegistro.setRowHeaderView(tablaRegistro);
		
		panelRegistro.add(labelRegistro);	
		panelRegistro.add(scrollPaneRegistro);	
	}
	
	private void inicializarMemoria() {		
		int count = 0;
		for(int i = 0; i<128; i++) {			
			dataMemoria[i][0]= Integer.toString(count++) + "-" + Integer.toString(count++);
			dataMemoria[i][1]="";
		}	
	}
	
	private void inicializarRegistro() {		
		for(int i=0; i<=15;i++) {
			dataRegistro[i][0]=Integer.toString(i);
			dataRegistro[i][1]="";
		}	
	}

	public void update(Observable o, Object arg) {		
		RegisterMemory reg = ((Modelo)o).getRegisterMemory();
		Memory memoria = ((Modelo)o).getMemory();
		
		actualizarEstado();
						
		dtmRegistro.setValueAt(reg.readReg("0"), 0, 1);		dtmRegistro.setValueAt(reg.readReg("1"), 1, 1);
		dtmRegistro.setValueAt(reg.readReg("2"), 2, 1);		dtmRegistro.setValueAt(reg.readReg("3"), 3, 1);		
		dtmRegistro.setValueAt(reg.readReg("4"), 4, 1);		dtmRegistro.setValueAt(reg.readReg("5"), 5, 1);
		dtmRegistro.setValueAt(reg.readReg("6"), 6, 1);		dtmRegistro.setValueAt(reg.readReg("7"), 7, 1);
		dtmRegistro.setValueAt(reg.readReg("8"), 8, 1);		dtmRegistro.setValueAt(reg.readReg("9"), 9, 1);
		dtmRegistro.setValueAt(reg.readReg("A"), 10, 1);	dtmRegistro.setValueAt(reg.readReg("B"), 11, 1);		
		dtmRegistro.setValueAt(reg.readReg("C"), 12, 1);	dtmRegistro.setValueAt(reg.readReg("D"), 13, 1);
		dtmRegistro.setValueAt(reg.readReg("E"), 14, 1);	dtmRegistro.setValueAt(reg.readReg("F"), 15, 1);
		
		int count = 0;
		String data1 = "";
		String data2 = "";
		
		for(int i=0;i<128;i++) {
			data1 = memoria.readCell(count++);
			data2 = memoria.readCell(count++);
			
			if(!data1.equals("") || !data2.equals("")) {
				dtmMemoria.setValueAt(data1 + "|" + data2, i, 1);
			}
			data1 = "";
			data2 = "";
		}
		
		ControlUnit unidadDeControl = ((Modelo)o).getControlUnity();		
		tablaMemoria.getSelectionModel().setSelectionInterval(unidadDeControl.getNextInstructionAddress()/2, 
				unidadDeControl.getNextInstructionAddress()/2);
	}
	
	private void actualizarEstado() {
		switch(modelo.getEstado()) {
			case Modelo.PROGRAMASININICIAR:
				estado.setText("Programa Cargado");
				inicializarMemoria();
				inicializarRegistro();
				break;
			case Modelo.PROGRAMACORRIENDO:
				estado.setText("Programa Ejecutandose");
				break;
			case Modelo.PROGRAMAFINALIZADO:
				estado.setText("Programa Finalizado");
				break;
		}
	}
	
	// la que da color a la celda seleccionada
	public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
			if(isSelected) {
				this.setBackground(Color.RED);
			}
			else {
				this.setBackground(Color.WHITE);
			}
			return this;
		}
	}
}
