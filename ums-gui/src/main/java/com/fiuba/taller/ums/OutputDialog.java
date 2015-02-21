package com.fiuba.taller.ums;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Component;

public class OutputDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OutputDialog dialog = new OutputDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OutputDialog() {
		setTitle("OUTPUT dialog");
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {80, 150};
		gbl_contentPanel.rowHeights = new int[] {50, 50};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Please click on 'OK' to continue...");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblValue = new JLabel("Output value:");
			GridBagConstraints gbc_lblValue = new GridBagConstraints();
			gbc_lblValue.anchor = GridBagConstraints.WEST;
			gbc_lblValue.insets = new Insets(0, 0, 5, 5);
			gbc_lblValue.gridx = 0;
			gbc_lblValue.gridy = 1;
			contentPanel.add(lblValue, gbc_lblValue);
		}
		{
			textField = new JTextField();
			textField.setToolTipText("Enter up to 2 hexadecimal digits");
			textField.setText("0");
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[] {100};
			gbl_buttonPane.rowHeights = new int[] {50};
			gbl_buttonPane.columnWeights = new double[]{0.0};
			gbl_buttonPane.rowWeights = new double[]{0.0};
			buttonPane.setLayout(gbl_buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				GridBagConstraints gbc_okButton = new GridBagConstraints();
				gbc_okButton.anchor = GridBagConstraints.EAST;
				gbc_okButton.insets = new Insets(0, 0, 0, 5);
				gbc_okButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_okButton.gridx = 0;
				gbc_okButton.gridy = 0;
				buttonPane.add(okButton, gbc_okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
