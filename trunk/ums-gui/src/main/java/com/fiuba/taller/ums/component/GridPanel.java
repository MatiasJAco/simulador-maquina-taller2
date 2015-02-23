package com.fiuba.taller.ums.component;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.fiuba.taller.ums.Cell;
import com.fiuba.taller.ums.HexaConverter;

public class GridPanel extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3195171533787130559L;
	
	private int columnsToShow, rowsToShow;
	private boolean hexaRegistryNames = false;
	private List<JTextField> jTextFieldList = new ArrayList<JTextField>();
//	private List<JLabel> jLabelList = new ArrayList<JLabel>();
	private List<Cell> registryList = new ArrayList<Cell>();
	private int counter = 0;
	private int actualPage = 1;
	private int totalPages;
	private JPanel panel;

	public GridPanel(String title, List<Cell> registryList, int columnsToShow, int rowsToShow, boolean hexaRegistryNames){
		panel = new JPanel();
		//panel.setPreferredSize(new Dimension(480, 120));
		panel.setBorder(null);
		panel.setAlignmentY(0.0f);
		panel.setAlignmentX(0.0f);
		this.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		this.registryList = registryList;
		this.columnsToShow = columnsToShow;
		this.rowsToShow = rowsToShow;
		this.hexaRegistryNames = hexaRegistryNames;
		
		createGrid();
	}

	private void createGrid() {
				
		for (int i = 0 ; i < rowsToShow && counter < registryList.size() ; i++){
			for (int j = 0 ; j < columnsToShow * 2 && counter < registryList.size() ; j++){
				String label = Integer.toString(counter);
				if(hexaRegistryNames){
					label = HexaConverter.decimalToBase(counter, 16, 8);
				}
				JLabel regLabel = new JLabel(label +":");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = j;
				gbc_label.gridy = i;
				panel.add(regLabel, gbc_label);
				//jLabelList.add(regLabel);

				j++;
				JTextField regTextField = new JTextField(registryList.get(counter).getData());
				regTextField.setHorizontalAlignment(SwingConstants.RIGHT);
				regTextField.setDisabledTextColor(Color.BLACK);
				regTextField.setColumns(10);
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.gridx = j;
				gbc_textField.gridy = i;
				panel.add(regTextField, gbc_textField);
				//jTextFieldList.add(regField);
				
				counter++;
			}
		}
	}
	
}
