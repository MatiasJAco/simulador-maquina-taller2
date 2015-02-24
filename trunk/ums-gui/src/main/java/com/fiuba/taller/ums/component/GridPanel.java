package com.fiuba.taller.ums.component;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
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
		
	private int columnsToShow;
	private boolean hexaRegistryNames;
	private List<Cell> cellList;
	private List<JTextField> textFieldList = new ArrayList<JTextField>();
	private JPanel viewPanel;

	public GridPanel(String title, List<Cell> cellList, int columnsToShow, boolean hexaRegistryNames){
		viewPanel = new JPanel();
		viewPanel.setBorder(null);
		viewPanel.setAlignmentY(0.0f);
		viewPanel.setAlignmentX(0.0f);
		this.setViewportView(viewPanel);
		GridBagLayout gbl_panel = new GridBagLayout();
		viewPanel.setLayout(gbl_panel);
		
		this.cellList = cellList;
		this.columnsToShow = columnsToShow;
		this.hexaRegistryNames = hexaRegistryNames;
		
		createGrid();
	}

	private void createGrid() {
		int counter = 0;
		int rowsToShow = (int) Math.ceil((double) cellList.size() / columnsToShow);
		for (int i = 0 ; i < rowsToShow && counter < cellList.size() ; i++){
			for (int j = 0 ; j < columnsToShow * 2 && counter < cellList.size() ; j++){
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
				viewPanel.add(regLabel, gbc_label);

				j++;
				Cell cell = cellList.get(counter);
				JTextField regTextField = new JTextField(cell.getData());
				regTextField.setHorizontalAlignment(SwingConstants.RIGHT);
				regTextField.setDisabledTextColor(Color.BLACK);
				regTextField.setColumns(10);
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.gridx = j;
				gbc_textField.gridy = i;
				viewPanel.add(regTextField, gbc_textField);
				textFieldList.add(regTextField);

				cell.addObserver(new CellObserver(regTextField));
				
				counter++;
			}
		}
	}
	
	public void applyBackgroundColor(Color color){
		Iterator<JTextField> it = textFieldList.iterator();
		while(it.hasNext()){
			JTextField textField = it.next();
			textField.setBackground(color);
		}
	}
	
}
