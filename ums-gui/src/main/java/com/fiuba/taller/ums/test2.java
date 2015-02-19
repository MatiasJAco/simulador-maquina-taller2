/*
 * Creation : 19/02/2015
 */
package com.fiuba.taller.ums;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class test2 {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblR;
	private JTextField textField_2;
	private JLabel lblR_1;
	private JTextField textField_3;
	private JLabel lblR_2;
	private JTextField textField_4;
	private JLabel lblR_3;
	private JTextField textField_5;
	private JLabel lblR_4;
	private JTextField textField_6;
	private JLabel lblR_5;
	private JTextField textField_7;
	private JLabel lblR_6;
	private JTextField textField_8;
	private JLabel lblR_7;
	private JTextField textField_9;
	private JLabel lblR_8;
	private JTextField textField_10;
	private JLabel lblR_9;
	private JTextField textField_11;
	private JLabel lblR_10;
	private JTextField textField_12;
	private JLabel lblR_11;
	private JTextField textField_13;
	private JLabel lblR_12;
	private JTextField textField_14;
	private JLabel lblR_13;
	private JTextField textField_15;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_4;
	private JLabel label;
	private JTextField textField_32;
	private JLabel label_17;
	private JTextField textField_33;
	private JLabel label_18;
	private JTextField textField_34;
	private JLabel label_19;
	private JTextField textField_35;
	private JLabel label_20;
	private JTextField textField_36;
	private JLabel label_21;
	private JTextField textField_37;
	private JLabel label_22;
	private JTextField textField_38;
	private JLabel label_23;
	private JTextField textField_39;
	private JLabel label_24;
	private JTextField textField_40;
	private JLabel label_25;
	private JTextField textField_41;
	private JLabel label_26;
	private JTextField textField_42;
	private JLabel label_27;
	private JTextField textField_43;
	private JLabel label_28;
	private JTextField textField_44;
	private JLabel label_29;
	private JTextField textField_45;
	private JLabel label_30;
	private JTextField textField_46;
	private JLabel label_31;
	private JTextField textField_47;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2 window = new test2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 676, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 660, 127);
		panel.setBorder(new TitledBorder(null, "Regristry",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 40, 80, 40, 80, 40, 80, 40,
				110 };
		gridBagLayout.rowHeights = new int[] { 25, 25, 25, 25, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0,
				1.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
		panel.setLayout(gridBagLayout);

		lblNewLabel = new JLabel("R00");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		lblNewLabel_1 = new JLabel("R01");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 0;
		panel.add(textField_1, gbc_textField_1);

		lblR = new JLabel("R02");
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.anchor = GridBagConstraints.EAST;
		gbc_lblR.insets = new Insets(0, 0, 5, 5);
		gbc_lblR.gridx = 4;
		gbc_lblR.gridy = 0;
		panel.add(lblR, gbc_lblR);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 0;
		panel.add(textField_2, gbc_textField_2);

		lblR_1 = new JLabel("R03");
		GridBagConstraints gbc_lblR_1 = new GridBagConstraints();
		gbc_lblR_1.anchor = GridBagConstraints.EAST;
		gbc_lblR_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_1.gridx = 6;
		gbc_lblR_1.gridy = 0;
		panel.add(lblR_1, gbc_lblR_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 7;
		gbc_textField_3.gridy = 0;
		panel.add(textField_3, gbc_textField_3);

		lblR_2 = new JLabel("R04");
		GridBagConstraints gbc_lblR_2 = new GridBagConstraints();
		gbc_lblR_2.anchor = GridBagConstraints.EAST;
		gbc_lblR_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_2.gridx = 0;
		gbc_lblR_2.gridy = 1;
		panel.add(lblR_2, gbc_lblR_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 1;
		panel.add(textField_4, gbc_textField_4);

		lblR_3 = new JLabel("R05");
		GridBagConstraints gbc_lblR_3 = new GridBagConstraints();
		gbc_lblR_3.anchor = GridBagConstraints.EAST;
		gbc_lblR_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_3.gridx = 2;
		gbc_lblR_3.gridy = 1;
		panel.add(lblR_3, gbc_lblR_3);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 1;
		panel.add(textField_5, gbc_textField_5);

		lblR_4 = new JLabel("R06");
		GridBagConstraints gbc_lblR_4 = new GridBagConstraints();
		gbc_lblR_4.anchor = GridBagConstraints.EAST;
		gbc_lblR_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_4.gridx = 4;
		gbc_lblR_4.gridy = 1;
		panel.add(lblR_4, gbc_lblR_4);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 1;
		panel.add(textField_6, gbc_textField_6);

		lblR_5 = new JLabel("R07");
		GridBagConstraints gbc_lblR_5 = new GridBagConstraints();
		gbc_lblR_5.anchor = GridBagConstraints.EAST;
		gbc_lblR_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_5.gridx = 6;
		gbc_lblR_5.gridy = 1;
		panel.add(lblR_5, gbc_lblR_5);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 7;
		gbc_textField_7.gridy = 1;
		panel.add(textField_7, gbc_textField_7);

		lblR_6 = new JLabel("R08");
		GridBagConstraints gbc_lblR_6 = new GridBagConstraints();
		gbc_lblR_6.anchor = GridBagConstraints.EAST;
		gbc_lblR_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_6.gridx = 0;
		gbc_lblR_6.gridy = 2;
		panel.add(lblR_6, gbc_lblR_6);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 2;
		panel.add(textField_8, gbc_textField_8);

		lblR_7 = new JLabel("R09");
		GridBagConstraints gbc_lblR_7 = new GridBagConstraints();
		gbc_lblR_7.anchor = GridBagConstraints.EAST;
		gbc_lblR_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_7.gridx = 2;
		gbc_lblR_7.gridy = 2;
		panel.add(lblR_7, gbc_lblR_7);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 3;
		gbc_textField_9.gridy = 2;
		panel.add(textField_9, gbc_textField_9);

		lblR_8 = new JLabel("R0A");
		GridBagConstraints gbc_lblR_8 = new GridBagConstraints();
		gbc_lblR_8.anchor = GridBagConstraints.EAST;
		gbc_lblR_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_8.gridx = 4;
		gbc_lblR_8.gridy = 2;
		panel.add(lblR_8, gbc_lblR_8);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 5;
		gbc_textField_10.gridy = 2;
		panel.add(textField_10, gbc_textField_10);

		lblR_9 = new JLabel("R0B");
		GridBagConstraints gbc_lblR_9 = new GridBagConstraints();
		gbc_lblR_9.anchor = GridBagConstraints.EAST;
		gbc_lblR_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_9.gridx = 6;
		gbc_lblR_9.gridy = 2;
		panel.add(lblR_9, gbc_lblR_9);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 7;
		gbc_textField_11.gridy = 2;
		panel.add(textField_11, gbc_textField_11);

		lblR_10 = new JLabel("R0C");
		GridBagConstraints gbc_lblR_10 = new GridBagConstraints();
		gbc_lblR_10.anchor = GridBagConstraints.EAST;
		gbc_lblR_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_10.gridx = 0;
		gbc_lblR_10.gridy = 3;
		panel.add(lblR_10, gbc_lblR_10);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(0, 0, 5, 5);
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 3;
		panel.add(textField_12, gbc_textField_12);

		lblR_11 = new JLabel("R0D");
		GridBagConstraints gbc_lblR_11 = new GridBagConstraints();
		gbc_lblR_11.anchor = GridBagConstraints.EAST;
		gbc_lblR_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_11.gridx = 2;
		gbc_lblR_11.gridy = 3;
		panel.add(lblR_11, gbc_lblR_11);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.insets = new Insets(0, 0, 5, 5);
		gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_13.gridx = 3;
		gbc_textField_13.gridy = 3;
		panel.add(textField_13, gbc_textField_13);

		lblR_12 = new JLabel("R0E");
		GridBagConstraints gbc_lblR_12 = new GridBagConstraints();
		gbc_lblR_12.anchor = GridBagConstraints.EAST;
		gbc_lblR_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_12.gridx = 4;
		gbc_lblR_12.gridy = 3;
		panel.add(lblR_12, gbc_lblR_12);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		GridBagConstraints gbc_textField_14 = new GridBagConstraints();
		gbc_textField_14.insets = new Insets(0, 0, 5, 5);
		gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_14.gridx = 5;
		gbc_textField_14.gridy = 3;
		panel.add(textField_14, gbc_textField_14);

		lblR_13 = new JLabel("R0F");
		GridBagConstraints gbc_lblR_13 = new GridBagConstraints();
		gbc_lblR_13.anchor = GridBagConstraints.EAST;
		gbc_lblR_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_13.gridx = 6;
		gbc_lblR_13.gridy = 3;
		panel.add(lblR_13, gbc_lblR_13);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		GridBagConstraints gbc_textField_15 = new GridBagConstraints();
		gbc_textField_15.insets = new Insets(0, 0, 5, 0);
		gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_15.gridx = 7;
		gbc_textField_15.gridy = 3;
		panel.add(textField_15, gbc_textField_15);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 127, 660, 132);
		panel_2.setBorder(new TitledBorder(null, "Memory",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 25, 216, 25 };
		gbl_panel_2.rowHeights = new int[] { 100, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		btnNewButton = new JButton("<");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_2.add(btnNewButton, gbc_btnNewButton);

		panel_4 = new JPanel();
		panel_4.setBorder(null);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 40, 80, 40, 80, 40, 80, 40, 80,
				0 };
		gbl_panel_4.rowHeights = new int[] { 25, 25, 25, 25, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0,
				1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		label = new JLabel("R00");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_4.add(label, gbc_label);

		textField_32 = new JTextField();
		textField_32.setText("00000000");
		textField_32.setColumns(10);
		GridBagConstraints gbc_textField_32 = new GridBagConstraints();
		gbc_textField_32.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_32.insets = new Insets(0, 0, 5, 5);
		gbc_textField_32.gridx = 1;
		gbc_textField_32.gridy = 0;
		panel_4.add(textField_32, gbc_textField_32);

		label_17 = new JLabel("R01");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.anchor = GridBagConstraints.EAST;
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 2;
		gbc_label_17.gridy = 0;
		panel_4.add(label_17, gbc_label_17);

		textField_33 = new JTextField();
		textField_33.setColumns(10);
		GridBagConstraints gbc_textField_33 = new GridBagConstraints();
		gbc_textField_33.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_33.insets = new Insets(0, 0, 5, 5);
		gbc_textField_33.gridx = 3;
		gbc_textField_33.gridy = 0;
		panel_4.add(textField_33, gbc_textField_33);

		label_18 = new JLabel("R02");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.anchor = GridBagConstraints.EAST;
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 4;
		gbc_label_18.gridy = 0;
		panel_4.add(label_18, gbc_label_18);

		textField_34 = new JTextField();
		textField_34.setColumns(10);
		GridBagConstraints gbc_textField_34 = new GridBagConstraints();
		gbc_textField_34.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_34.insets = new Insets(0, 0, 5, 5);
		gbc_textField_34.gridx = 5;
		gbc_textField_34.gridy = 0;
		panel_4.add(textField_34, gbc_textField_34);

		label_19 = new JLabel("R03");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.anchor = GridBagConstraints.EAST;
		gbc_label_19.insets = new Insets(0, 0, 5, 5);
		gbc_label_19.gridx = 6;
		gbc_label_19.gridy = 0;
		panel_4.add(label_19, gbc_label_19);

		textField_35 = new JTextField();
		textField_35.setColumns(10);
		GridBagConstraints gbc_textField_35 = new GridBagConstraints();
		gbc_textField_35.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_35.insets = new Insets(0, 0, 5, 0);
		gbc_textField_35.gridx = 7;
		gbc_textField_35.gridy = 0;
		panel_4.add(textField_35, gbc_textField_35);

		label_20 = new JLabel("R04");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.anchor = GridBagConstraints.EAST;
		gbc_label_20.insets = new Insets(0, 0, 5, 5);
		gbc_label_20.gridx = 0;
		gbc_label_20.gridy = 1;
		panel_4.add(label_20, gbc_label_20);

		textField_36 = new JTextField();
		textField_36.setColumns(10);
		GridBagConstraints gbc_textField_36 = new GridBagConstraints();
		gbc_textField_36.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_36.insets = new Insets(0, 0, 5, 5);
		gbc_textField_36.gridx = 1;
		gbc_textField_36.gridy = 1;
		panel_4.add(textField_36, gbc_textField_36);

		label_21 = new JLabel("R05");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.anchor = GridBagConstraints.EAST;
		gbc_label_21.insets = new Insets(0, 0, 5, 5);
		gbc_label_21.gridx = 2;
		gbc_label_21.gridy = 1;
		panel_4.add(label_21, gbc_label_21);

		textField_37 = new JTextField();
		textField_37.setColumns(10);
		GridBagConstraints gbc_textField_37 = new GridBagConstraints();
		gbc_textField_37.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_37.insets = new Insets(0, 0, 5, 5);
		gbc_textField_37.gridx = 3;
		gbc_textField_37.gridy = 1;
		panel_4.add(textField_37, gbc_textField_37);

		label_22 = new JLabel("R06");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.anchor = GridBagConstraints.EAST;
		gbc_label_22.insets = new Insets(0, 0, 5, 5);
		gbc_label_22.gridx = 4;
		gbc_label_22.gridy = 1;
		panel_4.add(label_22, gbc_label_22);

		textField_38 = new JTextField();
		textField_38.setColumns(10);
		GridBagConstraints gbc_textField_38 = new GridBagConstraints();
		gbc_textField_38.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_38.insets = new Insets(0, 0, 5, 5);
		gbc_textField_38.gridx = 5;
		gbc_textField_38.gridy = 1;
		panel_4.add(textField_38, gbc_textField_38);

		label_23 = new JLabel("R07");
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.anchor = GridBagConstraints.EAST;
		gbc_label_23.insets = new Insets(0, 0, 5, 5);
		gbc_label_23.gridx = 6;
		gbc_label_23.gridy = 1;
		panel_4.add(label_23, gbc_label_23);

		textField_39 = new JTextField();
		textField_39.setColumns(10);
		GridBagConstraints gbc_textField_39 = new GridBagConstraints();
		gbc_textField_39.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_39.insets = new Insets(0, 0, 5, 0);
		gbc_textField_39.gridx = 7;
		gbc_textField_39.gridy = 1;
		panel_4.add(textField_39, gbc_textField_39);

		label_24 = new JLabel("R08");
		GridBagConstraints gbc_label_24 = new GridBagConstraints();
		gbc_label_24.anchor = GridBagConstraints.EAST;
		gbc_label_24.insets = new Insets(0, 0, 5, 5);
		gbc_label_24.gridx = 0;
		gbc_label_24.gridy = 2;
		panel_4.add(label_24, gbc_label_24);

		textField_40 = new JTextField();
		textField_40.setColumns(10);
		GridBagConstraints gbc_textField_40 = new GridBagConstraints();
		gbc_textField_40.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_40.insets = new Insets(0, 0, 5, 5);
		gbc_textField_40.gridx = 1;
		gbc_textField_40.gridy = 2;
		panel_4.add(textField_40, gbc_textField_40);

		label_25 = new JLabel("R09");
		GridBagConstraints gbc_label_25 = new GridBagConstraints();
		gbc_label_25.anchor = GridBagConstraints.EAST;
		gbc_label_25.insets = new Insets(0, 0, 5, 5);
		gbc_label_25.gridx = 2;
		gbc_label_25.gridy = 2;
		panel_4.add(label_25, gbc_label_25);

		textField_41 = new JTextField();
		textField_41.setColumns(10);
		GridBagConstraints gbc_textField_41 = new GridBagConstraints();
		gbc_textField_41.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_41.insets = new Insets(0, 0, 5, 5);
		gbc_textField_41.gridx = 3;
		gbc_textField_41.gridy = 2;
		panel_4.add(textField_41, gbc_textField_41);

		label_26 = new JLabel("R0A");
		GridBagConstraints gbc_label_26 = new GridBagConstraints();
		gbc_label_26.anchor = GridBagConstraints.EAST;
		gbc_label_26.insets = new Insets(0, 0, 5, 5);
		gbc_label_26.gridx = 4;
		gbc_label_26.gridy = 2;
		panel_4.add(label_26, gbc_label_26);

		textField_42 = new JTextField();
		textField_42.setColumns(10);
		GridBagConstraints gbc_textField_42 = new GridBagConstraints();
		gbc_textField_42.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_42.insets = new Insets(0, 0, 5, 5);
		gbc_textField_42.gridx = 5;
		gbc_textField_42.gridy = 2;
		panel_4.add(textField_42, gbc_textField_42);

		label_27 = new JLabel("R0B");
		GridBagConstraints gbc_label_27 = new GridBagConstraints();
		gbc_label_27.anchor = GridBagConstraints.EAST;
		gbc_label_27.insets = new Insets(0, 0, 5, 5);
		gbc_label_27.gridx = 6;
		gbc_label_27.gridy = 2;
		panel_4.add(label_27, gbc_label_27);

		textField_43 = new JTextField();
		textField_43.setColumns(10);
		GridBagConstraints gbc_textField_43 = new GridBagConstraints();
		gbc_textField_43.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_43.insets = new Insets(0, 0, 5, 0);
		gbc_textField_43.gridx = 7;
		gbc_textField_43.gridy = 2;
		panel_4.add(textField_43, gbc_textField_43);

		label_28 = new JLabel("R0C");
		GridBagConstraints gbc_label_28 = new GridBagConstraints();
		gbc_label_28.anchor = GridBagConstraints.EAST;
		gbc_label_28.insets = new Insets(0, 0, 5, 5);
		gbc_label_28.gridx = 0;
		gbc_label_28.gridy = 3;
		panel_4.add(label_28, gbc_label_28);

		textField_44 = new JTextField();
		textField_44.setColumns(10);
		GridBagConstraints gbc_textField_44 = new GridBagConstraints();
		gbc_textField_44.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_44.insets = new Insets(0, 0, 5, 5);
		gbc_textField_44.gridx = 1;
		gbc_textField_44.gridy = 3;
		panel_4.add(textField_44, gbc_textField_44);

		label_29 = new JLabel("R0D");
		GridBagConstraints gbc_label_29 = new GridBagConstraints();
		gbc_label_29.anchor = GridBagConstraints.EAST;
		gbc_label_29.insets = new Insets(0, 0, 5, 5);
		gbc_label_29.gridx = 2;
		gbc_label_29.gridy = 3;
		panel_4.add(label_29, gbc_label_29);

		textField_45 = new JTextField();
		textField_45.setColumns(10);
		GridBagConstraints gbc_textField_45 = new GridBagConstraints();
		gbc_textField_45.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_45.insets = new Insets(0, 0, 5, 5);
		gbc_textField_45.gridx = 3;
		gbc_textField_45.gridy = 3;
		panel_4.add(textField_45, gbc_textField_45);

		label_30 = new JLabel("R0E");
		GridBagConstraints gbc_label_30 = new GridBagConstraints();
		gbc_label_30.anchor = GridBagConstraints.EAST;
		gbc_label_30.insets = new Insets(0, 0, 5, 5);
		gbc_label_30.gridx = 4;
		gbc_label_30.gridy = 3;
		panel_4.add(label_30, gbc_label_30);

		textField_46 = new JTextField();
		textField_46.setColumns(10);
		GridBagConstraints gbc_textField_46 = new GridBagConstraints();
		gbc_textField_46.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_46.insets = new Insets(0, 0, 5, 5);
		gbc_textField_46.gridx = 5;
		gbc_textField_46.gridy = 3;
		panel_4.add(textField_46, gbc_textField_46);

		label_31 = new JLabel("R0F");
		GridBagConstraints gbc_label_31 = new GridBagConstraints();
		gbc_label_31.anchor = GridBagConstraints.EAST;
		gbc_label_31.insets = new Insets(0, 0, 5, 5);
		gbc_label_31.gridx = 6;
		gbc_label_31.gridy = 3;
		panel_4.add(label_31, gbc_label_31);

		textField_47 = new JTextField();
		textField_47.setColumns(10);
		GridBagConstraints gbc_textField_47 = new GridBagConstraints();
		gbc_textField_47.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_47.insets = new Insets(0, 0, 5, 0);
		gbc_textField_47.gridx = 7;
		gbc_textField_47.gridy = 3;
		panel_4.add(textField_47, gbc_textField_47);

		btnNewButton_1 = new JButton(">");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
