package com.fiuba.taller.ums.component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import com.fiuba.taller.ums.action.ConvertDecToHexAction;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class DecToHexCalculatorWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9202325187447130896L;

	private JTextField decimalField;
	private JTextField hexaField;

	public DecToHexCalculatorWindow() {
		super();
		setTitle("DEC to HEX Converter");
		setBounds(100, 100, 350, 160);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] { ColumnSpec.decode("50px"),
						FormFactory.DEFAULT_COLSPEC,
						ColumnSpec.decode("150px"),
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblDecimal = new JLabel("Decimal:");
		getContentPane().add(lblDecimal, "2, 4, right, default");

		decimalField = new JTextField();
		((AbstractDocument) decimalField.getDocument()).setDocumentFilter(
                new OnlyNumbersFilter());   
		getContentPane().add(decimalField, "3, 4, fill, default");
		decimalField.setColumns(10);

		JLabel lblHexaLabel = new JLabel("Hexadecimal:");
		getContentPane().add(lblHexaLabel, "2, 8, right, default");

		hexaField = new JTextField();
		hexaField.setEditable(false);
		getContentPane().add(hexaField, "3, 8, fill, default");
		hexaField.setColumns(10);

		JButton btnConvert = new JButton("Convert");
		getContentPane().add(btnConvert, "2, 12, 2, 1, fill, default");

		btnConvert.addActionListener(new ConvertDecToHexAction(this));
	}

	public JTextField getDecimalField() {
		return decimalField;
	}

	public void setDecimalField(JTextField decimalField) {
		this.decimalField = decimalField;
	}

	public JTextField getHexaField() {
		return hexaField;
	}

	public void setHexaField(JTextField hexaField) {
		this.hexaField = hexaField;
	}

}
