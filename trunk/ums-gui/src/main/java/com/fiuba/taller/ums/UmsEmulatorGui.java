/*
 * Creation : 19/02/2015
 */
package com.fiuba.taller.ums;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class UmsEmulatorGui {

	private JFrame frame;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel registryPanel;
	private JLabel label_1;
	private JTextField textField;
	private JLabel label_2;
	private JTextField textField_1;
	private JLabel label_3;
	private JTextField textField_2;
	private JLabel label_4;
	private JTextField textField_3;
	private JLabel label_5;
	private JTextField textField_4;
	private JLabel label_6;
	private JTextField textField_5;
	private JLabel label_7;
	private JTextField textField_6;
	private JLabel label_8;
	private JTextField textField_7;
	private JLabel label_9;
	private JTextField textField_8;
	private JLabel label_10;
	private JTextField textField_9;
	private JLabel label_11;
	private JTextField textField_10;
	private JLabel label_12;
	private JTextField textField_11;
	private JLabel label_13;
	private JTextField textField_12;
	private JLabel label_14;
	private JTextField textField_13;
	private JLabel label_15;
	private JTextField textField_14;
	private JLabel label_16;
	private JTextField textField_15;
	private JPanel registryMatrixPanel;
	private JPanel panel_4;
	private JLabel label;
	private JTextField textField_16;
	private JLabel label_17;
	private JTextField textField_17;
	private JLabel label_18;
	private JTextField textField_18;
	private JLabel label_19;
	private JTextField textField_19;
	private JLabel label_20;
	private JTextField textField_20;
	private JLabel label_21;
	private JTextField textField_21;
	private JLabel label_22;
	private JTextField textField_22;
	private JLabel label_23;
	private JTextField textField_23;
	private JLabel label_24;
	private JTextField textField_24;
	private JLabel label_25;
	private JTextField textField_25;
	private JLabel label_26;
	private JTextField textField_26;
	private JLabel label_27;
	private JTextField textField_27;
	private JLabel label_28;
	private JTextField textField_28;
	private JLabel label_29;
	private JTextField textField_29;
	private JLabel label_30;
	private JTextField textField_30;
	private JLabel label_31;
	private JTextField textField_31;
	private JPanel cpuPanel;
	private JToolBar toolBar;
	private JButton btnRun;
	private JButton btnNext;
	private JButton btnStop;
	private JButton btnPause;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JTextField textField_32;
	private JLabel lblPc;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JLabel lblR;
	private JLabel lblR_1;
	private JLabel lblNewLabel;
	private JCheckBox chckbxOverflow;
	private JCheckBox chckbxZero;
	private JLabel lblStatus;
	private JLabel lblNewLabel_1;
	private JTextField textField_36;
	private JLabel lblFetch;
	private JTextField textField_37;
	private JLabel lblDecode;
	private JTextField textField_38;
	private JLabel lblExcecute;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UmsEmulatorGui window = new UmsEmulatorGui();
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
	public UmsEmulatorGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[]{579, 0};
				gridBagLayout.rowHeights = new int[]{23, 163, 258, 185, 0};
				gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
				gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				frame.getContentPane().setLayout(gridBagLayout);
						
						toolBar = new JToolBar();
						GridBagConstraints gbc_toolBar = new GridBagConstraints();
						gbc_toolBar.anchor = GridBagConstraints.WEST;
						gbc_toolBar.insets = new Insets(0, 0, 5, 0);
						gbc_toolBar.gridx = 0;
						gbc_toolBar.gridy = 0;
						frame.getContentPane().add(toolBar, gbc_toolBar);
						
						btnRun = new JButton("Run");
						toolBar.add(btnRun);
						
						btnPause = new JButton("Pause");
						toolBar.add(btnPause);
						
						btnStop = new JButton("Stop");
						toolBar.add(btnStop);
						
						btnNext = new JButton("NextStep");
						toolBar.add(btnNext);
				
						// --- <REGISTRY> ---
				
						registryPanel = new JPanel();
						registryPanel.setBorder(new TitledBorder(null, "Regristry",
								TitledBorder.LEADING, TitledBorder.TOP, null, null));
						GridBagConstraints gbc_registryPanel = new GridBagConstraints();
						gbc_registryPanel.fill = GridBagConstraints.BOTH;
						gbc_registryPanel.insets = new Insets(0, 0, 5, 0);
						gbc_registryPanel.gridx = 0;
						gbc_registryPanel.gridy = 1;
						frame.getContentPane().add(registryPanel, gbc_registryPanel);
						GridBagLayout gbl_registryPanel = new GridBagLayout();
						gbl_registryPanel.columnWeights = new double[] { 0.0 };
						gbl_registryPanel.rowWeights = new double[] { 0.0 };
						registryPanel.setLayout(gbl_registryPanel);
						
								registryMatrixPanel = new JPanel();
								registryMatrixPanel.setPreferredSize(new Dimension(480, 120));
								registryMatrixPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
								registryMatrixPanel.setAlignmentY(Component.TOP_ALIGNMENT);
								registryMatrixPanel.setBorder(null);
								GridBagConstraints gbc_registryMatrixPanel = new GridBagConstraints();
								gbc_registryMatrixPanel.ipady = 1;
								gbc_registryMatrixPanel.ipadx = 1;
								gbc_registryMatrixPanel.anchor = GridBagConstraints.NORTHWEST;
								gbc_registryMatrixPanel.gridx = 0;
								gbc_registryMatrixPanel.gridy = 0;
								registryPanel.add(registryMatrixPanel, gbc_registryMatrixPanel);
								GridBagLayout gbl_registryMatrixPanel = new GridBagLayout();
								gbl_registryMatrixPanel.columnWidths = new int[] { 30, 60, 30, 60, 30, 60, 30, 60 };
								gbl_registryMatrixPanel.rowHeights = new int[] { 30, 30, 30, 30 };
								gbl_registryMatrixPanel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0,
										1.0, 0.0, 1.0 };
								gbl_registryMatrixPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
								registryMatrixPanel.setLayout(gbl_registryMatrixPanel);
								
										label_1 = new JLabel("R00");
										GridBagConstraints gbc_label_1 = new GridBagConstraints();
										gbc_label_1.anchor = GridBagConstraints.EAST;
										gbc_label_1.insets = new Insets(0, 0, 5, 5);
										gbc_label_1.gridx = 0;
										gbc_label_1.gridy = 0;
										registryMatrixPanel.add(label_1, gbc_label_1);
										
												textField = new JTextField();
												textField.setDisabledTextColor(new Color(0, 0, 0));
												textField.setHorizontalAlignment(SwingConstants.RIGHT);
												textField.setText("00000000");
												textField.setColumns(10);
												GridBagConstraints gbc_textField = new GridBagConstraints();
												gbc_textField.fill = GridBagConstraints.HORIZONTAL;
												gbc_textField.insets = new Insets(0, 0, 5, 5);
												gbc_textField.gridx = 1;
												gbc_textField.gridy = 0;
												registryMatrixPanel.add(textField, gbc_textField);
												
														label_2 = new JLabel("R01");
														GridBagConstraints gbc_label_2 = new GridBagConstraints();
														gbc_label_2.anchor = GridBagConstraints.EAST;
														gbc_label_2.insets = new Insets(0, 0, 5, 5);
														gbc_label_2.gridx = 2;
														gbc_label_2.gridy = 0;
														registryMatrixPanel.add(label_2, gbc_label_2);
														
																textField_1 = new JTextField();
																textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
																textField_1.setText("00000000");
																textField_1.setColumns(10);
																GridBagConstraints gbc_textField_1 = new GridBagConstraints();
																gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
																gbc_textField_1.insets = new Insets(0, 0, 5, 5);
																gbc_textField_1.gridx = 3;
																gbc_textField_1.gridy = 0;
																registryMatrixPanel.add(textField_1, gbc_textField_1);
																
																		label_3 = new JLabel("R02");
																		GridBagConstraints gbc_label_3 = new GridBagConstraints();
																		gbc_label_3.anchor = GridBagConstraints.EAST;
																		gbc_label_3.insets = new Insets(0, 0, 5, 5);
																		gbc_label_3.gridx = 4;
																		gbc_label_3.gridy = 0;
																		registryMatrixPanel.add(label_3, gbc_label_3);
																		
																				textField_2 = new JTextField();
																				textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
																				textField_2.setText("00000000");
																				textField_2.setColumns(10);
																				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
																				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
																				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
																				gbc_textField_2.gridx = 5;
																				gbc_textField_2.gridy = 0;
																				registryMatrixPanel.add(textField_2, gbc_textField_2);
																				
																						label_4 = new JLabel("R03");
																						GridBagConstraints gbc_label_4 = new GridBagConstraints();
																						gbc_label_4.anchor = GridBagConstraints.EAST;
																						gbc_label_4.insets = new Insets(0, 0, 5, 5);
																						gbc_label_4.gridx = 6;
																						gbc_label_4.gridy = 0;
																						registryMatrixPanel.add(label_4, gbc_label_4);
																						
																								textField_3 = new JTextField();
																								textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
																								textField_3.setText("00000000");
																								textField_3.setColumns(10);
																								GridBagConstraints gbc_textField_3 = new GridBagConstraints();
																								gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
																								gbc_textField_3.insets = new Insets(0, 0, 5, 0);
																								gbc_textField_3.gridx = 7;
																								gbc_textField_3.gridy = 0;
																								registryMatrixPanel.add(textField_3, gbc_textField_3);
																								
																										label_5 = new JLabel("R04");
																										GridBagConstraints gbc_label_5 = new GridBagConstraints();
																										gbc_label_5.anchor = GridBagConstraints.EAST;
																										gbc_label_5.insets = new Insets(0, 0, 5, 5);
																										gbc_label_5.gridx = 0;
																										gbc_label_5.gridy = 1;
																										registryMatrixPanel.add(label_5, gbc_label_5);
																										
																												textField_4 = new JTextField();
																												textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
																												textField_4.setText("00000000");
																												textField_4.setColumns(10);
																												GridBagConstraints gbc_textField_4 = new GridBagConstraints();
																												gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
																												gbc_textField_4.insets = new Insets(0, 0, 5, 5);
																												gbc_textField_4.gridx = 1;
																												gbc_textField_4.gridy = 1;
																												registryMatrixPanel.add(textField_4, gbc_textField_4);
																												
																														label_6 = new JLabel("R05");
																														GridBagConstraints gbc_label_6 = new GridBagConstraints();
																														gbc_label_6.anchor = GridBagConstraints.EAST;
																														gbc_label_6.insets = new Insets(0, 0, 5, 5);
																														gbc_label_6.gridx = 2;
																														gbc_label_6.gridy = 1;
																														registryMatrixPanel.add(label_6, gbc_label_6);
																														
																																textField_5 = new JTextField();
																																textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
																																textField_5.setText("00000000");
																																textField_5.setColumns(10);
																																GridBagConstraints gbc_textField_5 = new GridBagConstraints();
																																gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
																																gbc_textField_5.insets = new Insets(0, 0, 5, 5);
																																gbc_textField_5.gridx = 3;
																																gbc_textField_5.gridy = 1;
																																registryMatrixPanel.add(textField_5, gbc_textField_5);
																																
																																		label_7 = new JLabel("R06");
																																		GridBagConstraints gbc_label_7 = new GridBagConstraints();
																																		gbc_label_7.anchor = GridBagConstraints.EAST;
																																		gbc_label_7.insets = new Insets(0, 0, 5, 5);
																																		gbc_label_7.gridx = 4;
																																		gbc_label_7.gridy = 1;
																																		registryMatrixPanel.add(label_7, gbc_label_7);
																																		
																																				textField_6 = new JTextField();
																																				textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
																																				textField_6.setText("00000000");
																																				textField_6.setColumns(10);
																																				GridBagConstraints gbc_textField_6 = new GridBagConstraints();
																																				gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
																																				gbc_textField_6.insets = new Insets(0, 0, 5, 5);
																																				gbc_textField_6.gridx = 5;
																																				gbc_textField_6.gridy = 1;
																																				registryMatrixPanel.add(textField_6, gbc_textField_6);
																																				
																																						label_8 = new JLabel("R07");
																																						GridBagConstraints gbc_label_8 = new GridBagConstraints();
																																						gbc_label_8.anchor = GridBagConstraints.EAST;
																																						gbc_label_8.insets = new Insets(0, 0, 5, 5);
																																						gbc_label_8.gridx = 6;
																																						gbc_label_8.gridy = 1;
																																						registryMatrixPanel.add(label_8, gbc_label_8);
																																						
																																								textField_7 = new JTextField();
																																								textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
																																								textField_7.setText("00000000");
																																								textField_7.setColumns(10);
																																								GridBagConstraints gbc_textField_7 = new GridBagConstraints();
																																								gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
																																								gbc_textField_7.insets = new Insets(0, 0, 5, 0);
																																								gbc_textField_7.gridx = 7;
																																								gbc_textField_7.gridy = 1;
																																								registryMatrixPanel.add(textField_7, gbc_textField_7);
																																								
																																										label_9 = new JLabel("R08");
																																										GridBagConstraints gbc_label_9 = new GridBagConstraints();
																																										gbc_label_9.anchor = GridBagConstraints.EAST;
																																										gbc_label_9.insets = new Insets(0, 0, 5, 5);
																																										gbc_label_9.gridx = 0;
																																										gbc_label_9.gridy = 2;
																																										registryMatrixPanel.add(label_9, gbc_label_9);
																																										
																																												textField_8 = new JTextField();
																																												textField_8.setHorizontalAlignment(SwingConstants.RIGHT);
																																												textField_8.setText("00000000");
																																												textField_8.setColumns(10);
																																												GridBagConstraints gbc_textField_8 = new GridBagConstraints();
																																												gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
																																												gbc_textField_8.insets = new Insets(0, 0, 5, 5);
																																												gbc_textField_8.gridx = 1;
																																												gbc_textField_8.gridy = 2;
																																												registryMatrixPanel.add(textField_8, gbc_textField_8);
																																												
																																														label_10 = new JLabel("R09");
																																														GridBagConstraints gbc_label_10 = new GridBagConstraints();
																																														gbc_label_10.anchor = GridBagConstraints.EAST;
																																														gbc_label_10.insets = new Insets(0, 0, 5, 5);
																																														gbc_label_10.gridx = 2;
																																														gbc_label_10.gridy = 2;
																																														registryMatrixPanel.add(label_10, gbc_label_10);
																																														
																																																textField_9 = new JTextField();
																																																textField_9.setHorizontalAlignment(SwingConstants.RIGHT);
																																																textField_9.setText("00000000");
																																																textField_9.setColumns(10);
																																																GridBagConstraints gbc_textField_9 = new GridBagConstraints();
																																																gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
																																																gbc_textField_9.insets = new Insets(0, 0, 5, 5);
																																																gbc_textField_9.gridx = 3;
																																																gbc_textField_9.gridy = 2;
																																																registryMatrixPanel.add(textField_9, gbc_textField_9);
																																																
																																																		label_11 = new JLabel("R0A");
																																																		GridBagConstraints gbc_label_11 = new GridBagConstraints();
																																																		gbc_label_11.anchor = GridBagConstraints.EAST;
																																																		gbc_label_11.insets = new Insets(0, 0, 5, 5);
																																																		gbc_label_11.gridx = 4;
																																																		gbc_label_11.gridy = 2;
																																																		registryMatrixPanel.add(label_11, gbc_label_11);
																																																		
																																																				textField_10 = new JTextField();
																																																				textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
																																																				textField_10.setText("00000000");
																																																				textField_10.setColumns(10);
																																																				GridBagConstraints gbc_textField_10 = new GridBagConstraints();
																																																				gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
																																																				gbc_textField_10.insets = new Insets(0, 0, 5, 5);
																																																				gbc_textField_10.gridx = 5;
																																																				gbc_textField_10.gridy = 2;
																																																				registryMatrixPanel.add(textField_10, gbc_textField_10);
																																																				
																																																						label_12 = new JLabel("R0B");
																																																						GridBagConstraints gbc_label_12 = new GridBagConstraints();
																																																						gbc_label_12.anchor = GridBagConstraints.EAST;
																																																						gbc_label_12.insets = new Insets(0, 0, 5, 5);
																																																						gbc_label_12.gridx = 6;
																																																						gbc_label_12.gridy = 2;
																																																						registryMatrixPanel.add(label_12, gbc_label_12);
																																																						
																																																								textField_11 = new JTextField();
																																																								textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
																																																								textField_11.setText("00000000");
																																																								textField_11.setColumns(10);
																																																								GridBagConstraints gbc_textField_11 = new GridBagConstraints();
																																																								gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
																																																								gbc_textField_11.insets = new Insets(0, 0, 5, 0);
																																																								gbc_textField_11.gridx = 7;
																																																								gbc_textField_11.gridy = 2;
																																																								registryMatrixPanel.add(textField_11, gbc_textField_11);
																																																								
																																																										label_13 = new JLabel("R0C");
																																																										GridBagConstraints gbc_label_13 = new GridBagConstraints();
																																																										gbc_label_13.anchor = GridBagConstraints.EAST;
																																																										gbc_label_13.insets = new Insets(0, 0, 0, 5);
																																																										gbc_label_13.gridx = 0;
																																																										gbc_label_13.gridy = 3;
																																																										registryMatrixPanel.add(label_13, gbc_label_13);
																																																										
																																																												textField_12 = new JTextField();
																																																												textField_12.setHorizontalAlignment(SwingConstants.RIGHT);
																																																												textField_12.setText("00000000");
																																																												textField_12.setColumns(10);
																																																												GridBagConstraints gbc_textField_12 = new GridBagConstraints();
																																																												gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
																																																												gbc_textField_12.insets = new Insets(0, 0, 0, 5);
																																																												gbc_textField_12.gridx = 1;
																																																												gbc_textField_12.gridy = 3;
																																																												registryMatrixPanel.add(textField_12, gbc_textField_12);
																																																												
																																																														label_14 = new JLabel("R0D");
																																																														GridBagConstraints gbc_label_14 = new GridBagConstraints();
																																																														gbc_label_14.anchor = GridBagConstraints.EAST;
																																																														gbc_label_14.insets = new Insets(0, 0, 0, 5);
																																																														gbc_label_14.gridx = 2;
																																																														gbc_label_14.gridy = 3;
																																																														registryMatrixPanel.add(label_14, gbc_label_14);
																																																														
																																																																textField_13 = new JTextField();
																																																																textField_13.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																textField_13.setText("00000000");
																																																																textField_13.setColumns(10);
																																																																GridBagConstraints gbc_textField_13 = new GridBagConstraints();
																																																																gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
																																																																gbc_textField_13.insets = new Insets(0, 0, 0, 5);
																																																																gbc_textField_13.gridx = 3;
																																																																gbc_textField_13.gridy = 3;
																																																																registryMatrixPanel.add(textField_13, gbc_textField_13);
																																																																
																																																																		label_15 = new JLabel("R0E");
																																																																		GridBagConstraints gbc_label_15 = new GridBagConstraints();
																																																																		gbc_label_15.anchor = GridBagConstraints.EAST;
																																																																		gbc_label_15.insets = new Insets(0, 0, 0, 5);
																																																																		gbc_label_15.gridx = 4;
																																																																		gbc_label_15.gridy = 3;
																																																																		registryMatrixPanel.add(label_15, gbc_label_15);
																																																																		
																																																																				textField_14 = new JTextField();
																																																																				textField_14.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																				textField_14.setText("00000000");
																																																																				textField_14.setColumns(10);
																																																																				GridBagConstraints gbc_textField_14 = new GridBagConstraints();
																																																																				gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
																																																																				gbc_textField_14.insets = new Insets(0, 0, 0, 5);
																																																																				gbc_textField_14.gridx = 5;
																																																																				gbc_textField_14.gridy = 3;
																																																																				registryMatrixPanel.add(textField_14, gbc_textField_14);
																																																																				
																																																																						label_16 = new JLabel("R0F");
																																																																						GridBagConstraints gbc_label_16 = new GridBagConstraints();
																																																																						gbc_label_16.anchor = GridBagConstraints.EAST;
																																																																						gbc_label_16.insets = new Insets(0, 0, 0, 5);
																																																																						gbc_label_16.gridx = 6;
																																																																						gbc_label_16.gridy = 3;
																																																																						registryMatrixPanel.add(label_16, gbc_label_16);
																																																																						
																																																																								textField_15 = new JTextField();
																																																																								textField_15.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																								textField_15.setText("00000000");
																																																																								textField_15.setColumns(10);
																																																																								GridBagConstraints gbc_textField_15 = new GridBagConstraints();
																																																																								gbc_textField_15.insets = new Insets(0, 0, 5, 0);
																																																																								gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
																																																																								gbc_textField_15.gridx = 7;
																																																																								gbc_textField_15.gridy = 3;
																																																																								registryMatrixPanel.add(textField_15, gbc_textField_15);
						
						cpuPanel = new JPanel();
						cpuPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CPU", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						GridBagConstraints gbc_cpuPanel = new GridBagConstraints();
						gbc_cpuPanel.fill = GridBagConstraints.BOTH;
						gbc_cpuPanel.insets = new Insets(0, 0, 5, 0);
						gbc_cpuPanel.gridx = 0;
						gbc_cpuPanel.gridy = 2;
						frame.getContentPane().add(cpuPanel, gbc_cpuPanel);
						GridBagLayout gbl_cpuPanel = new GridBagLayout();
						gbl_cpuPanel.columnWidths = new int[] {200, 200};
						gbl_cpuPanel.rowHeights = new int[] {25, 200};
						gbl_cpuPanel.columnWeights = new double[]{1.0, 1.0};
						gbl_cpuPanel.rowWeights = new double[]{1.0, 1.0};
						cpuPanel.setLayout(gbl_cpuPanel);
						
						panel_7 = new JPanel();
						GridBagConstraints gbc_panel_7 = new GridBagConstraints();
						gbc_panel_7.gridwidth = 2;
						gbc_panel_7.insets = new Insets(0, 0, 5, 5);
						gbc_panel_7.fill = GridBagConstraints.BOTH;
						gbc_panel_7.gridx = 0;
						gbc_panel_7.gridy = 0;
						cpuPanel.add(panel_7, gbc_panel_7);
						
						lblPc = new JLabel("PC");
						panel_7.add(lblPc);
						
						textField_32 = new JTextField();
						panel_7.add(textField_32);
						textField_32.setColumns(10);
						
						panel_5 = new JPanel();
						panel_5.setBorder(new TitledBorder(null, "PipeLine", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						GridBagConstraints gbc_panel_5 = new GridBagConstraints();
						gbc_panel_5.insets = new Insets(0, 0, 0, 5);
						gbc_panel_5.fill = GridBagConstraints.BOTH;
						gbc_panel_5.gridx = 0;
						gbc_panel_5.gridy = 1;
						cpuPanel.add(panel_5, gbc_panel_5);
						GridBagLayout gbl_panel_5 = new GridBagLayout();
						gbl_panel_5.columnWidths = new int[] {0, 0};
						gbl_panel_5.rowHeights = new int[] {0, 0, 0};
						gbl_panel_5.columnWeights = new double[]{0.0, 1.0};
						gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0};
						panel_5.setLayout(gbl_panel_5);
						
						lblFetch = new JLabel("Fetch");
						GridBagConstraints gbc_lblFetch = new GridBagConstraints();
						gbc_lblFetch.insets = new Insets(0, 0, 5, 5);
						gbc_lblFetch.anchor = GridBagConstraints.EAST;
						gbc_lblFetch.gridx = 0;
						gbc_lblFetch.gridy = 0;
						panel_5.add(lblFetch, gbc_lblFetch);
						
						textField_36 = new JTextField();
						GridBagConstraints gbc_textField_36 = new GridBagConstraints();
						gbc_textField_36.insets = new Insets(0, 0, 5, 0);
						gbc_textField_36.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_36.gridx = 1;
						gbc_textField_36.gridy = 0;
						panel_5.add(textField_36, gbc_textField_36);
						textField_36.setColumns(10);
						
						lblDecode = new JLabel("Decode");
						GridBagConstraints gbc_lblDecode = new GridBagConstraints();
						gbc_lblDecode.insets = new Insets(0, 0, 5, 5);
						gbc_lblDecode.anchor = GridBagConstraints.EAST;
						gbc_lblDecode.gridx = 0;
						gbc_lblDecode.gridy = 1;
						panel_5.add(lblDecode, gbc_lblDecode);
						
						textField_37 = new JTextField();
						GridBagConstraints gbc_textField_37 = new GridBagConstraints();
						gbc_textField_37.insets = new Insets(0, 0, 5, 0);
						gbc_textField_37.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_37.gridx = 1;
						gbc_textField_37.gridy = 1;
						panel_5.add(textField_37, gbc_textField_37);
						textField_37.setColumns(10);
						
						lblExcecute = new JLabel("Excecution");
						GridBagConstraints gbc_lblExcecute = new GridBagConstraints();
						gbc_lblExcecute.insets = new Insets(0, 0, 0, 5);
						gbc_lblExcecute.anchor = GridBagConstraints.EAST;
						gbc_lblExcecute.gridx = 0;
						gbc_lblExcecute.gridy = 2;
						panel_5.add(lblExcecute, gbc_lblExcecute);
						
						textField_38 = new JTextField();
						GridBagConstraints gbc_textField_38 = new GridBagConstraints();
						gbc_textField_38.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_38.gridx = 1;
						gbc_textField_38.gridy = 2;
						panel_5.add(textField_38, gbc_textField_38);
						textField_38.setColumns(10);
						
						panel_6 = new JPanel();
						panel_6.setBorder(new TitledBorder(null, "ALU", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						GridBagConstraints gbc_panel_6 = new GridBagConstraints();
						gbc_panel_6.fill = GridBagConstraints.BOTH;
						gbc_panel_6.gridx = 1;
						gbc_panel_6.gridy = 1;
						cpuPanel.add(panel_6, gbc_panel_6);
						GridBagLayout gbl_panel_6 = new GridBagLayout();
						gbl_panel_6.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
						gbl_panel_6.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
						gbl_panel_6.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
						gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
						panel_6.setLayout(gbl_panel_6);
						
						lblR = new JLabel("A");
						GridBagConstraints gbc_lblR = new GridBagConstraints();
						gbc_lblR.insets = new Insets(0, 0, 5, 5);
						gbc_lblR.gridx = 0;
						gbc_lblR.gridy = 1;
						panel_6.add(lblR, gbc_lblR);
						
						textField_33 = new JTextField();
						GridBagConstraints gbc_textField_33 = new GridBagConstraints();
						gbc_textField_33.insets = new Insets(0, 0, 5, 5);
						gbc_textField_33.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_33.gridx = 1;
						gbc_textField_33.gridy = 1;
						panel_6.add(textField_33, gbc_textField_33);
						textField_33.setColumns(10);
						
						lblNewLabel_1 = new JLabel("->");
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.gridheight = 3;
						gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_1.gridx = 2;
						gbc_lblNewLabel_1.gridy = 1;
						panel_6.add(lblNewLabel_1, gbc_lblNewLabel_1);
						
						lblNewLabel = new JLabel("R");
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
						gbc_lblNewLabel.gridx = 3;
						gbc_lblNewLabel.gridy = 2;
						panel_6.add(lblNewLabel, gbc_lblNewLabel);
						
						textField_35 = new JTextField();
						GridBagConstraints gbc_textField_35 = new GridBagConstraints();
						gbc_textField_35.insets = new Insets(0, 0, 5, 0);
						gbc_textField_35.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_35.gridx = 4;
						gbc_textField_35.gridy = 2;
						panel_6.add(textField_35, gbc_textField_35);
						textField_35.setColumns(10);
						
						lblR_1 = new JLabel("B");
						GridBagConstraints gbc_lblR_1 = new GridBagConstraints();
						gbc_lblR_1.insets = new Insets(0, 0, 5, 5);
						gbc_lblR_1.anchor = GridBagConstraints.EAST;
						gbc_lblR_1.gridx = 0;
						gbc_lblR_1.gridy = 3;
						panel_6.add(lblR_1, gbc_lblR_1);
						
						textField_34 = new JTextField();
						GridBagConstraints gbc_textField_34 = new GridBagConstraints();
						gbc_textField_34.insets = new Insets(0, 0, 5, 5);
						gbc_textField_34.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_34.gridx = 1;
						gbc_textField_34.gridy = 3;
						panel_6.add(textField_34, gbc_textField_34);
						textField_34.setColumns(10);
						
						lblStatus = new JLabel("Flags:");
						GridBagConstraints gbc_lblStatus = new GridBagConstraints();
						gbc_lblStatus.anchor = GridBagConstraints.WEST;
						gbc_lblStatus.insets = new Insets(0, 0, 5, 0);
						gbc_lblStatus.gridx = 4;
						gbc_lblStatus.gridy = 4;
						panel_6.add(lblStatus, gbc_lblStatus);
						
						chckbxOverflow = new JCheckBox("overflow");
						GridBagConstraints gbc_chckbxOverflow = new GridBagConstraints();
						gbc_chckbxOverflow.anchor = GridBagConstraints.WEST;
						gbc_chckbxOverflow.insets = new Insets(0, 0, 5, 0);
						gbc_chckbxOverflow.gridx = 4;
						gbc_chckbxOverflow.gridy = 5;
						panel_6.add(chckbxOverflow, gbc_chckbxOverflow);
						
						chckbxZero = new JCheckBox("zero");
						GridBagConstraints gbc_chckbxZero = new GridBagConstraints();
						gbc_chckbxZero.anchor = GridBagConstraints.WEST;
						gbc_chckbxZero.gridx = 4;
						gbc_chckbxZero.gridy = 6;
						panel_6.add(chckbxZero, gbc_chckbxZero);
				
						// --- </REGISTRY> ---
				
						// --- <MEMORY> ---
				
						panel_2 = new JPanel();
						panel_2.setAlignmentY(Component.TOP_ALIGNMENT);
						panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
						panel_2.setBorder(new TitledBorder(null, "Memory",
								TitledBorder.LEADING, TitledBorder.TOP, null, null));
						GridBagConstraints gbc_panel_2 = new GridBagConstraints();
						gbc_panel_2.fill = GridBagConstraints.BOTH;
						gbc_panel_2.gridx = 0;
						gbc_panel_2.gridy = 3;
						frame.getContentPane().add(panel_2, gbc_panel_2);
						GridBagLayout gbl_panel_2 = new GridBagLayout();
						gbl_panel_2.columnWidths = new int[] { 25, 480, 25 };
						gbl_panel_2.rowHeights = new int[] { 20 };
						gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, 0.0 };
						gbl_panel_2.rowWeights = new double[] { 1.0 };
						panel_2.setLayout(gbl_panel_2);
						
								btnNewButton = new JButton("<");
								btnNewButton.setPreferredSize(new Dimension(40, 100));
								GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
								gbc_btnNewButton.fill = GridBagConstraints.BOTH;
								gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
								gbc_btnNewButton.gridx = 0;
								gbc_btnNewButton.gridy = 0;
								panel_2.add(btnNewButton, gbc_btnNewButton);
								
										btnNewButton_1 = new JButton(">");
										btnNewButton_1.setPreferredSize(new Dimension(40, 100));
										btnNewButton_1.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
											}
										});
										
												panel_4 = new JPanel();
												panel_4.setPreferredSize(new Dimension(480, 120));
												panel_4.setBorder(null);
												panel_4.setAlignmentY(0.0f);
												panel_4.setAlignmentX(0.0f);
												GridBagConstraints gbc_panel_4 = new GridBagConstraints();
												gbc_panel_4.insets = new Insets(0, 0, 0, 5);
												gbc_panel_4.fill = GridBagConstraints.BOTH;
												gbc_panel_4.gridx = 1;
												gbc_panel_4.gridy = 0;
												panel_2.add(panel_4, gbc_panel_4);
												GridBagLayout gbl_panel_4 = new GridBagLayout();
												gbl_panel_4.columnWidths = new int[] { 30, 60, 30, 60, 30, 60, 30, 60 };
												gbl_panel_4.rowHeights = new int[] { 30, 30, 30, 30 };
												gbl_panel_4.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0,
														1.0, 0.0, 1.0 };
												gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
												panel_4.setLayout(gbl_panel_4);
												
														label = new JLabel("R00");
														GridBagConstraints gbc_label = new GridBagConstraints();
														gbc_label.anchor = GridBagConstraints.EAST;
														gbc_label.insets = new Insets(0, 0, 5, 5);
														gbc_label.gridx = 0;
														gbc_label.gridy = 0;
														panel_4.add(label, gbc_label);
														
																textField_16 = new JTextField();
																textField_16.setText("00000000");
																textField_16.setHorizontalAlignment(SwingConstants.RIGHT);
																textField_16.setDisabledTextColor(Color.BLACK);
																textField_16.setColumns(10);
																GridBagConstraints gbc_textField_16 = new GridBagConstraints();
																gbc_textField_16.fill = GridBagConstraints.HORIZONTAL;
																gbc_textField_16.insets = new Insets(0, 0, 5, 5);
																gbc_textField_16.gridx = 1;
																gbc_textField_16.gridy = 0;
																panel_4.add(textField_16, gbc_textField_16);
																
																		label_17 = new JLabel("R01");
																		GridBagConstraints gbc_label_17 = new GridBagConstraints();
																		gbc_label_17.anchor = GridBagConstraints.EAST;
																		gbc_label_17.insets = new Insets(0, 0, 5, 5);
																		gbc_label_17.gridx = 2;
																		gbc_label_17.gridy = 0;
																		panel_4.add(label_17, gbc_label_17);
																		
																				textField_17 = new JTextField();
																				textField_17.setText("00000000");
																				textField_17.setHorizontalAlignment(SwingConstants.RIGHT);
																				textField_17.setColumns(10);
																				GridBagConstraints gbc_textField_17 = new GridBagConstraints();
																				gbc_textField_17.fill = GridBagConstraints.HORIZONTAL;
																				gbc_textField_17.insets = new Insets(0, 0, 5, 5);
																				gbc_textField_17.gridx = 3;
																				gbc_textField_17.gridy = 0;
																				panel_4.add(textField_17, gbc_textField_17);
																				
																						label_18 = new JLabel("R02");
																						GridBagConstraints gbc_label_18 = new GridBagConstraints();
																						gbc_label_18.anchor = GridBagConstraints.EAST;
																						gbc_label_18.insets = new Insets(0, 0, 5, 5);
																						gbc_label_18.gridx = 4;
																						gbc_label_18.gridy = 0;
																						panel_4.add(label_18, gbc_label_18);
																						
																								textField_18 = new JTextField();
																								textField_18.setText("00000000");
																								textField_18.setHorizontalAlignment(SwingConstants.RIGHT);
																								textField_18.setColumns(10);
																								GridBagConstraints gbc_textField_18 = new GridBagConstraints();
																								gbc_textField_18.fill = GridBagConstraints.HORIZONTAL;
																								gbc_textField_18.insets = new Insets(0, 0, 5, 5);
																								gbc_textField_18.gridx = 5;
																								gbc_textField_18.gridy = 0;
																								panel_4.add(textField_18, gbc_textField_18);
																								
																										label_19 = new JLabel("R03");
																										GridBagConstraints gbc_label_19 = new GridBagConstraints();
																										gbc_label_19.anchor = GridBagConstraints.EAST;
																										gbc_label_19.insets = new Insets(0, 0, 5, 5);
																										gbc_label_19.gridx = 6;
																										gbc_label_19.gridy = 0;
																										panel_4.add(label_19, gbc_label_19);
																										
																												textField_19 = new JTextField();
																												textField_19.setText("00000000");
																												textField_19.setHorizontalAlignment(SwingConstants.RIGHT);
																												textField_19.setColumns(10);
																												GridBagConstraints gbc_textField_19 = new GridBagConstraints();
																												gbc_textField_19.fill = GridBagConstraints.HORIZONTAL;
																												gbc_textField_19.insets = new Insets(0, 0, 5, 0);
																												gbc_textField_19.gridx = 7;
																												gbc_textField_19.gridy = 0;
																												panel_4.add(textField_19, gbc_textField_19);
																												
																														label_20 = new JLabel("R04");
																														GridBagConstraints gbc_label_20 = new GridBagConstraints();
																														gbc_label_20.anchor = GridBagConstraints.EAST;
																														gbc_label_20.insets = new Insets(0, 0, 5, 5);
																														gbc_label_20.gridx = 0;
																														gbc_label_20.gridy = 1;
																														panel_4.add(label_20, gbc_label_20);
																														
																																textField_20 = new JTextField();
																																textField_20.setText("00000000");
																																textField_20.setHorizontalAlignment(SwingConstants.RIGHT);
																																textField_20.setColumns(10);
																																GridBagConstraints gbc_textField_20 = new GridBagConstraints();
																																gbc_textField_20.fill = GridBagConstraints.HORIZONTAL;
																																gbc_textField_20.insets = new Insets(0, 0, 5, 5);
																																gbc_textField_20.gridx = 1;
																																gbc_textField_20.gridy = 1;
																																panel_4.add(textField_20, gbc_textField_20);
																																
																																		label_21 = new JLabel("R05");
																																		GridBagConstraints gbc_label_21 = new GridBagConstraints();
																																		gbc_label_21.anchor = GridBagConstraints.EAST;
																																		gbc_label_21.insets = new Insets(0, 0, 5, 5);
																																		gbc_label_21.gridx = 2;
																																		gbc_label_21.gridy = 1;
																																		panel_4.add(label_21, gbc_label_21);
																																		
																																				textField_21 = new JTextField();
																																				textField_21.setText("00000000");
																																				textField_21.setHorizontalAlignment(SwingConstants.RIGHT);
																																				textField_21.setColumns(10);
																																				GridBagConstraints gbc_textField_21 = new GridBagConstraints();
																																				gbc_textField_21.fill = GridBagConstraints.HORIZONTAL;
																																				gbc_textField_21.insets = new Insets(0, 0, 5, 5);
																																				gbc_textField_21.gridx = 3;
																																				gbc_textField_21.gridy = 1;
																																				panel_4.add(textField_21, gbc_textField_21);
																																				
																																						label_22 = new JLabel("R06");
																																						GridBagConstraints gbc_label_22 = new GridBagConstraints();
																																						gbc_label_22.anchor = GridBagConstraints.EAST;
																																						gbc_label_22.insets = new Insets(0, 0, 5, 5);
																																						gbc_label_22.gridx = 4;
																																						gbc_label_22.gridy = 1;
																																						panel_4.add(label_22, gbc_label_22);
																																						
																																								textField_22 = new JTextField();
																																								textField_22.setText("00000000");
																																								textField_22.setHorizontalAlignment(SwingConstants.RIGHT);
																																								textField_22.setColumns(10);
																																								GridBagConstraints gbc_textField_22 = new GridBagConstraints();
																																								gbc_textField_22.fill = GridBagConstraints.HORIZONTAL;
																																								gbc_textField_22.insets = new Insets(0, 0, 5, 5);
																																								gbc_textField_22.gridx = 5;
																																								gbc_textField_22.gridy = 1;
																																								panel_4.add(textField_22, gbc_textField_22);
																																								
																																										label_23 = new JLabel("R07");
																																										GridBagConstraints gbc_label_23 = new GridBagConstraints();
																																										gbc_label_23.anchor = GridBagConstraints.EAST;
																																										gbc_label_23.insets = new Insets(0, 0, 5, 5);
																																										gbc_label_23.gridx = 6;
																																										gbc_label_23.gridy = 1;
																																										panel_4.add(label_23, gbc_label_23);
																																										
																																												textField_23 = new JTextField();
																																												textField_23.setText("00000000");
																																												textField_23.setHorizontalAlignment(SwingConstants.RIGHT);
																																												textField_23.setColumns(10);
																																												GridBagConstraints gbc_textField_23 = new GridBagConstraints();
																																												gbc_textField_23.fill = GridBagConstraints.HORIZONTAL;
																																												gbc_textField_23.insets = new Insets(0, 0, 5, 0);
																																												gbc_textField_23.gridx = 7;
																																												gbc_textField_23.gridy = 1;
																																												panel_4.add(textField_23, gbc_textField_23);
																																												
																																														label_24 = new JLabel("R08");
																																														GridBagConstraints gbc_label_24 = new GridBagConstraints();
																																														gbc_label_24.anchor = GridBagConstraints.EAST;
																																														gbc_label_24.insets = new Insets(0, 0, 5, 5);
																																														gbc_label_24.gridx = 0;
																																														gbc_label_24.gridy = 2;
																																														panel_4.add(label_24, gbc_label_24);
																																														
																																																textField_24 = new JTextField();
																																																textField_24.setText("00000000");
																																																textField_24.setHorizontalAlignment(SwingConstants.RIGHT);
																																																textField_24.setColumns(10);
																																																GridBagConstraints gbc_textField_24 = new GridBagConstraints();
																																																gbc_textField_24.fill = GridBagConstraints.HORIZONTAL;
																																																gbc_textField_24.insets = new Insets(0, 0, 5, 5);
																																																gbc_textField_24.gridx = 1;
																																																gbc_textField_24.gridy = 2;
																																																panel_4.add(textField_24, gbc_textField_24);
																																																
																																																		label_25 = new JLabel("R09");
																																																		GridBagConstraints gbc_label_25 = new GridBagConstraints();
																																																		gbc_label_25.anchor = GridBagConstraints.EAST;
																																																		gbc_label_25.insets = new Insets(0, 0, 5, 5);
																																																		gbc_label_25.gridx = 2;
																																																		gbc_label_25.gridy = 2;
																																																		panel_4.add(label_25, gbc_label_25);
																																																		
																																																				textField_25 = new JTextField();
																																																				textField_25.setText("00000000");
																																																				textField_25.setHorizontalAlignment(SwingConstants.RIGHT);
																																																				textField_25.setColumns(10);
																																																				GridBagConstraints gbc_textField_25 = new GridBagConstraints();
																																																				gbc_textField_25.fill = GridBagConstraints.HORIZONTAL;
																																																				gbc_textField_25.insets = new Insets(0, 0, 5, 5);
																																																				gbc_textField_25.gridx = 3;
																																																				gbc_textField_25.gridy = 2;
																																																				panel_4.add(textField_25, gbc_textField_25);
																																																				
																																																						label_26 = new JLabel("R0A");
																																																						GridBagConstraints gbc_label_26 = new GridBagConstraints();
																																																						gbc_label_26.anchor = GridBagConstraints.EAST;
																																																						gbc_label_26.insets = new Insets(0, 0, 5, 5);
																																																						gbc_label_26.gridx = 4;
																																																						gbc_label_26.gridy = 2;
																																																						panel_4.add(label_26, gbc_label_26);
																																																						
																																																								textField_26 = new JTextField();
																																																								textField_26.setText("00000000");
																																																								textField_26.setHorizontalAlignment(SwingConstants.RIGHT);
																																																								textField_26.setColumns(10);
																																																								GridBagConstraints gbc_textField_26 = new GridBagConstraints();
																																																								gbc_textField_26.fill = GridBagConstraints.HORIZONTAL;
																																																								gbc_textField_26.insets = new Insets(0, 0, 5, 5);
																																																								gbc_textField_26.gridx = 5;
																																																								gbc_textField_26.gridy = 2;
																																																								panel_4.add(textField_26, gbc_textField_26);
																																																								
																																																										label_27 = new JLabel("R0B");
																																																										GridBagConstraints gbc_label_27 = new GridBagConstraints();
																																																										gbc_label_27.anchor = GridBagConstraints.EAST;
																																																										gbc_label_27.insets = new Insets(0, 0, 5, 5);
																																																										gbc_label_27.gridx = 6;
																																																										gbc_label_27.gridy = 2;
																																																										panel_4.add(label_27, gbc_label_27);
																																																										
																																																												textField_27 = new JTextField();
																																																												textField_27.setText("00000000");
																																																												textField_27.setHorizontalAlignment(SwingConstants.RIGHT);
																																																												textField_27.setColumns(10);
																																																												GridBagConstraints gbc_textField_27 = new GridBagConstraints();
																																																												gbc_textField_27.fill = GridBagConstraints.HORIZONTAL;
																																																												gbc_textField_27.insets = new Insets(0, 0, 5, 0);
																																																												gbc_textField_27.gridx = 7;
																																																												gbc_textField_27.gridy = 2;
																																																												panel_4.add(textField_27, gbc_textField_27);
																																																												
																																																														label_28 = new JLabel("R0C");
																																																														GridBagConstraints gbc_label_28 = new GridBagConstraints();
																																																														gbc_label_28.anchor = GridBagConstraints.EAST;
																																																														gbc_label_28.insets = new Insets(0, 0, 0, 5);
																																																														gbc_label_28.gridx = 0;
																																																														gbc_label_28.gridy = 3;
																																																														panel_4.add(label_28, gbc_label_28);
																																																														
																																																																textField_28 = new JTextField();
																																																																textField_28.setText("00000000");
																																																																textField_28.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																textField_28.setColumns(10);
																																																																GridBagConstraints gbc_textField_28 = new GridBagConstraints();
																																																																gbc_textField_28.fill = GridBagConstraints.HORIZONTAL;
																																																																gbc_textField_28.insets = new Insets(0, 0, 0, 5);
																																																																gbc_textField_28.gridx = 1;
																																																																gbc_textField_28.gridy = 3;
																																																																panel_4.add(textField_28, gbc_textField_28);
																																																																
																																																																		label_29 = new JLabel("R0D");
																																																																		GridBagConstraints gbc_label_29 = new GridBagConstraints();
																																																																		gbc_label_29.anchor = GridBagConstraints.EAST;
																																																																		gbc_label_29.insets = new Insets(0, 0, 0, 5);
																																																																		gbc_label_29.gridx = 2;
																																																																		gbc_label_29.gridy = 3;
																																																																		panel_4.add(label_29, gbc_label_29);
																																																																		
																																																																				textField_29 = new JTextField();
																																																																				textField_29.setText("00000000");
																																																																				textField_29.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																				textField_29.setColumns(10);
																																																																				GridBagConstraints gbc_textField_29 = new GridBagConstraints();
																																																																				gbc_textField_29.fill = GridBagConstraints.HORIZONTAL;
																																																																				gbc_textField_29.insets = new Insets(0, 0, 0, 5);
																																																																				gbc_textField_29.gridx = 3;
																																																																				gbc_textField_29.gridy = 3;
																																																																				panel_4.add(textField_29, gbc_textField_29);
																																																																				
																																																																						label_30 = new JLabel("R0E");
																																																																						GridBagConstraints gbc_label_30 = new GridBagConstraints();
																																																																						gbc_label_30.anchor = GridBagConstraints.EAST;
																																																																						gbc_label_30.insets = new Insets(0, 0, 0, 5);
																																																																						gbc_label_30.gridx = 4;
																																																																						gbc_label_30.gridy = 3;
																																																																						panel_4.add(label_30, gbc_label_30);
																																																																						
																																																																								textField_30 = new JTextField();
																																																																								textField_30.setText("00000000");
																																																																								textField_30.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																								textField_30.setColumns(10);
																																																																								GridBagConstraints gbc_textField_30 = new GridBagConstraints();
																																																																								gbc_textField_30.fill = GridBagConstraints.HORIZONTAL;
																																																																								gbc_textField_30.insets = new Insets(0, 0, 0, 5);
																																																																								gbc_textField_30.gridx = 5;
																																																																								gbc_textField_30.gridy = 3;
																																																																								panel_4.add(textField_30, gbc_textField_30);
																																																																								
																																																																										label_31 = new JLabel("R0F");
																																																																										GridBagConstraints gbc_label_31 = new GridBagConstraints();
																																																																										gbc_label_31.anchor = GridBagConstraints.EAST;
																																																																										gbc_label_31.insets = new Insets(0, 0, 0, 5);
																																																																										gbc_label_31.gridx = 6;
																																																																										gbc_label_31.gridy = 3;
																																																																										panel_4.add(label_31, gbc_label_31);
																																																																										
																																																																												textField_31 = new JTextField();
																																																																												textField_31.setText("00000000");
																																																																												textField_31.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																												textField_31.setColumns(10);
																																																																												GridBagConstraints gbc_textField_31 = new GridBagConstraints();
																																																																												gbc_textField_31.insets = new Insets(0, 0, 5, 0);
																																																																												gbc_textField_31.fill = GridBagConstraints.HORIZONTAL;
																																																																												gbc_textField_31.gridx = 7;
																																																																												gbc_textField_31.gridy = 3;
																																																																												panel_4.add(textField_31, gbc_textField_31);
																																																																												GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
																																																																												gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
																																																																												gbc_btnNewButton_1.gridx = 2;
																																																																												gbc_btnNewButton_1.gridy = 0;
																																																																												panel_2.add(btnNewButton_1, gbc_btnNewButton_1);

		// --- </MEMORY> ---
	}
}
