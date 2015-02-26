package com.fiuba.taller.ums.component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.fiuba.taller.ums.action.ConvertCalculatorAction;
import com.fiuba.taller.ums.action.ConvertCalculatorButtonAction;


public class Calculator extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelConvertir;
	private JPanel panelOptions;
	private JRadioButton rdbtnDecimalAHexa;
	private JRadioButton rdbtnHexaDecimal;
	private JRadioButton rdbtnComplement ;
	private JRadioButton rdbtnPuntoFlotante;
	private JButton  jbnButton2;	
	private JTextField jTextEntrada;
	private JTextField jTextResult;
	private JLabel lblEntrada;
	private boolean convertirDecimalAHexadecimal;
	private boolean convertirComplemento2;

	public Calculator() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setForeground(Color.BLACK);
		setResizable(false);
		setTitle("Converter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(280, 250, 412, 200);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		createComponents();		
		initialize();
		addListener();
	}
	
	private void createComponents() {
		convertirDecimalAHexadecimal = true;
		convertirComplemento2 = true;
		// se crea el panel de opciones
		panelOptions = new JPanel();
		panelOptions.setForeground(Color.GRAY);
		panelOptions.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panelOptions.setBounds(220, 67, 175, 81);
		panelOptions.setLayout(null);
		
		// se crea el panel de conversion
		panelConvertir = new JPanel();
		panelConvertir.setToolTipText("");
		panelConvertir.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 1, true), "Convertir", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panelConvertir.setBounds(10, 67, 195, 81);
		panelConvertir.setLayout(null);
		
		// se crean los componentes de los paneles
		
		rdbtnDecimalAHexa = new JRadioButton("Decimal a Hexadecimal");		
		rdbtnDecimalAHexa.setFont(new Font("Dialog", Font.PLAIN, 11));
		rdbtnDecimalAHexa.setBounds(5, 22, 186, 23);	
		
		rdbtnHexaDecimal = new JRadioButton("Hexadecimal a Decimal");
		rdbtnHexaDecimal.setBounds(5, 50, 186, 23);
		rdbtnHexaDecimal.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		rdbtnComplement = new JRadioButton("Complemento a dos");
		rdbtnComplement.setBounds(5, 22, 165, 23);
		rdbtnComplement.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		rdbtnPuntoFlotante = new JRadioButton("Punto flotante");
		rdbtnPuntoFlotante.setBounds(5, 50, 128, 23);
		rdbtnPuntoFlotante.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		jbnButton2 = new JButton("Convert");
		jbnButton2.setBounds(220,5,128,23);
		
		
		// se agregan los componentes al panel de convertir
		panelConvertir.add(rdbtnHexaDecimal);
		panelConvertir.add(rdbtnDecimalAHexa);
		// se agregan los componentes al panel de opcion
		panelOptions.add(rdbtnComplement);
		panelOptions.add(rdbtnPuntoFlotante);
		
		// se agregan los paneles al panel principal
		contentPane.add(panelConvertir);
		contentPane.add(panelOptions);
		
		contentPane.add(jbnButton2);
		jTextEntrada = new JTextField();		
		jTextEntrada.setBounds(15, 30, 190, 25);
		contentPane.add(jTextEntrada);
		jTextEntrada.setColumns(10);
		
		jTextResult = new JTextField();
		jTextResult.setBounds(220, 30, 175, 25);
		contentPane.add(jTextResult);
		jTextResult.setColumns(10);
		
		lblEntrada = new JLabel("Ingresar Número");
		lblEntrada.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEntrada.setForeground(Color.GRAY);
		lblEntrada.setBounds(15, 7, 175, 15);
		contentPane.add(lblEntrada);
	}
	
	private void initialize() {
		rdbtnComplement.setEnabled(true);
		rdbtnPuntoFlotante.setEnabled(true);
		rdbtnDecimalAHexa.setEnabled(true);
		rdbtnHexaDecimal.setEnabled(true);
		rdbtnDecimalAHexa.setSelected(true);
		rdbtnComplement.setSelected(true);
	}
	
	private void addListener() {
		rdbtnDecimalAHexa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnHexaDecimal.setSelected(false);
				//rdbtnComplement.setEnabled(false);
			//	rdbtnPuntoFlotante.setEnabled(false);
				convertirDecimalAHexadecimal = true;
			}
		});
		
		rdbtnHexaDecimal.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnDecimalAHexa.setSelected(false);
				//rdbtnComplement.setEnabled(true);
				//rdbtnPuntoFlotante.setEnabled(true);
				convertirDecimalAHexadecimal = false;
			}
		});
		
		rdbtnComplement.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnPuntoFlotante.setSelected(false);
				convertirComplemento2 = true;
			}
		});
		
		rdbtnPuntoFlotante.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnComplement.setSelected(false);		
				convertirComplemento2 = false;
			}
		});
		
		jTextEntrada.addKeyListener(new ConvertCalculatorAction(this));
		jbnButton2.addActionListener(new ConvertCalculatorButtonAction(this));
		
	}
	
	public boolean esConvertirDecimalAHexadecimal() {
		return convertirDecimalAHexadecimal;
	}

	public boolean esConvertirComplemento2() {
		return convertirComplemento2;
	}
	
	public boolean esConvertirPuntoFlotante() {
		return !convertirComplemento2;
	}
	
	public String getNumberInput() {
		return jTextEntrada.getText();
	}
	
	public void setResult(String result) {
		jTextResult.setForeground(Color.BLACK);
		jTextResult.setText(result);
	}

	public void informarError() {
		jTextResult.setForeground(Color.RED);		
		jTextResult.setText("Número mal formado");		
	}
}

