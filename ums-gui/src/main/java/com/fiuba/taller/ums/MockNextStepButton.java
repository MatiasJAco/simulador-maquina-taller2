package com.fiuba.taller.ums;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.*;
//(2) FORMULARIO

public class MockNextStepButton extends JFrame implements  ActionListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame jtfMainFrame;
	JButton  jbnButton2;
	private JTextField jtfInput;
	JPanel jplPanel;
	private CycleController usin;
	public MockNextStepButton (CycleController usin) {
		jtfMainFrame = new JFrame("Next");
		jtfMainFrame.setSize(50, 50);
//		jbnButton1 = new JButton("Button 1");
		jbnButton2 = new JButton("NextStep");
//		
		jplPanel = new JPanel();
		this.usin=usin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jbnButton1.setMnemonic(KeyEvent.VK_I); //Set ShortCut Keys
//		jbnButton1.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				jtfInput.setText("Button 1!");
//			}
//		});	
		jbnButton2.setMnemonic(KeyEvent.VK_I);
		jbnButton2.addActionListener(this);
		//
		//		});
		jplPanel.setLayout(new FlowLayout());
//		jplPanel.add(jtfInput);
//		jplPanel.add(jbnButton1);
		jplPanel.add(jbnButton2);
		jtfMainFrame.getContentPane().add(jplPanel, BorderLayout.CENTER);
		jtfMainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jtfMainFrame.pack();
		jtfMainFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if( arg0.getSource().equals(jbnButton2) ){
			synchronized(usin){
				this.usin.setInputData(true);			
				this.usin.notify();			
			}
		}
	}

	public void close(){
		
		jtfMainFrame.setVisible(false);
		jtfMainFrame.dispose();
		this.setVisible(false);
		this.dispose();
	};
	
}


//	
//	//(3) CONTROLES DEL FORMULARIO        
//
//	private JPanel jpanel = (JPanel) this.getContentPane();
//
//	private JLabel jlabel = new JLabel();
//
//	private JTextField jtextfield = new JTextField();    
//
//	private JButton jButtonEnter = new JButton("OK");
//
//	private UserInputData userInput;
//
//
//	//(4) CONSTRUCTOR DEL FORMULARIO       
//
//	public JTextField getJtextfield() {
//		return jtextfield;
//	}
//
//
//
//	public void setJtextfield(JTextField jtextfield) {
//		this.jtextfield = jtextfield;
//	}
//
//
//
//	public UserInputWindow(UserInputData usin) {
//
//		//(5) PROPIEDADES DEL CONTENEDOR
//
//		jpanel.setLayout(null);
//
//		//		jpanel.setBackground(Color.lightGray);
//
//
//
//
//
//
//
//		//(6) PROPIEDADES DE LOS CONTROLES         
//
//		//		jlabel.setBounds(new Rectangle(5, 15, 220, 21));
//
//		//		jlabel.setText("Entra: ");
//
//		jtextfield.setBounds(new Rectangle(225, 15, 80, 21));
//
//
//
//		//(7) ADICION DE LOS CONTROLES AL CONTENEDOR        
//
//		//		jpanel.add(jlabel, null);
//
//		jpanel.add(jtextfield, null);
//
//		jpanel.add(jButtonEnter);
//
//
//		//(8) PROPIEDADES DEL FORMULARIO         
//
//		setSize(300,150); 
//		setTitle("Form1");
//		setVisible(true);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if( e.getSource().equals(jButtonEnter) ){
//			synchronized(userInput){
//				this.userInput.setInputData(this.jtextfield.getText());			
//				this.userInput.notify();
//			}
//		}
//	}
//}