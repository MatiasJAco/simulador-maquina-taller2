package com.fiuba.taller.ums.action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.fiuba.taller.ums.UmsEditorGui;

public class CompileAction implements ActionListener {

	public CompileAction(UmsEditorGui editorUmsGui) {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setTitle("Compilation Log");
		frame.setBounds(0, 0,
				200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane editorText = new JTextPane();
		editorText.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(editorText);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}

}
