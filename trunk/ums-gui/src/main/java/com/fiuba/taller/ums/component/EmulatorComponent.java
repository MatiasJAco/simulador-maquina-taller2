/*
 * Creation : 19/02/2015
 */
package com.fiuba.taller.ums.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.lang.model.element.NestingKind;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.fiuba.taller.ums.Cell;
import com.fiuba.taller.ums.ControlUnit;
import com.fiuba.taller.ums.CycleController;
import com.fiuba.taller.ums.action.NextStepAction;
import com.fiuba.taller.ums.action.RunAction;

public class EmulatorComponent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Color WHITE_COLOR = new Color(255, 255, 255);

	private JPanel cpuPanel;
	private JToolBar toolBar;
	private JButton btnRun;
	private JButton btnNext;
	private JButton btnStop;
	private JButton btnPause;
	private JPanel pipeLinePanel;
	private JPanel aluPanel;
	private JPanel pcPanel;
	private JTextField pcTextField;
	private JLabel pcLabel;
	private JTextField regAaluTextField;
	private JTextField regBaluTextField;
	private JTextField regRaluTextField;
	private JLabel regAaluLabel;
	private JLabel regBaluLabel;
	private JLabel regRaluLabel;
	private JCheckBox overflowCheckbox;
	private JCheckBox zeroCheckbox;
	private JLabel flagsLabel;
	private JLabel arrowLabel;
	private JTextField fetchTextField;
	private JLabel fetchLabel;
	private JTextField decodeTextField;
	private JLabel decodeLabel;
	private JTextField excecutionTextField;
	private JLabel excecutionLabel;
	private JTextField bitsLostTextField;
	private JLabel bitsLostLabel;

	private GridPanel registryPanel;
	private GridPanel memoryPanel;

	private ControlUnit controlUnit;
	private CycleController cicleControl;

	public CycleController getCicleControl() {
		return cicleControl;
	}

	/**
	 * Create the application.
	 */
	public EmulatorComponent(ControlUnit controlUnit, CycleController cicleControl) {
		this.controlUnit = controlUnit;
		this.cicleControl=cicleControl;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 650, 689);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 650, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 163, 258, 185, 0 };
		this.getContentPane().setLayout(gridBagLayout);

		initToolbar();

		// --- <REGISTRY> ---
		initRegistry();

		// --- <CPU> ---
		initCPUPanel();

		// --- <MEMORY> ---
		initMemory();
	}

	private void initMemory() {
		List<Cell> memoryCells = controlUnit.getMem().getCells();
		memoryPanel = new GridPanel("Memory", memoryCells, 4, true);
		memoryPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		memoryPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		memoryPanel.setBorder(new TitledBorder(null, "Memory",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_memoryPanel = new GridBagConstraints();
		gbc_memoryPanel.fill = GridBagConstraints.BOTH;
		gbc_memoryPanel.insets = new Insets(0, 0, 5, 0);
		gbc_memoryPanel.gridx = 0;
		gbc_memoryPanel.gridy = 3;
		this.getContentPane().add(memoryPanel, gbc_memoryPanel);
	}

	private void initRegistry() {
		List<Cell> registers = controlUnit.getRegMem().getRegisters();
		registryPanel = new GridPanel("Registry", registers, 4, false);
		registryPanel.setBorder(new TitledBorder(null, "Regristry",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_registryPanel = new GridBagConstraints();
		gbc_registryPanel.fill = GridBagConstraints.BOTH;
		gbc_registryPanel.insets = new Insets(0, 0, 5, 0);
		gbc_registryPanel.gridx = 0;
		gbc_registryPanel.gridy = 1;
		this.getContentPane().add(registryPanel, gbc_registryPanel);
	}

	private void initToolbar() {
		toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		this.getContentPane().add(toolBar, gbc_toolBar);

		btnRun = new JButton("Run");
		btnRun.addActionListener(new RunAction(this));
		toolBar.add(btnRun);

		btnPause = new JButton("Pause");
		toolBar.add(btnPause);

		btnStop = new JButton("Stop");
		toolBar.add(btnStop);

		btnNext = new JButton("NextStep");
		btnNext.addActionListener(new NextStepAction(this));
		toolBar.add(btnNext);
	}

	private void initCPUPanel() {
		cpuPanel = new JPanel();
		cpuPanel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "CPU", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_cpuPanel = new GridBagConstraints();
		gbc_cpuPanel.fill = GridBagConstraints.BOTH;
		gbc_cpuPanel.insets = new Insets(0, 0, 5, 0);
		gbc_cpuPanel.gridx = 0;
		gbc_cpuPanel.gridy = 2;
		this.getContentPane().add(cpuPanel, gbc_cpuPanel);
		GridBagLayout gbl_cpuPanel = new GridBagLayout();
		gbl_cpuPanel.columnWidths = new int[] { 200, 200 };
		gbl_cpuPanel.rowHeights = new int[] { 25, 200 };
		gbl_cpuPanel.columnWeights = new double[] { 1.0, 1.0 };
		gbl_cpuPanel.rowWeights = new double[] { 1.0, 1.0 };
		cpuPanel.setLayout(gbl_cpuPanel);

		pcPanel = new JPanel();
		GridBagConstraints gbc_pcPanel = new GridBagConstraints();
		gbc_pcPanel.gridwidth = 2;
		gbc_pcPanel.insets = new Insets(0, 0, 5, 5);
		gbc_pcPanel.fill = GridBagConstraints.BOTH;
		gbc_pcPanel.gridx = 0;
		gbc_pcPanel.gridy = 0;
		cpuPanel.add(pcPanel, gbc_pcPanel);

		pcLabel = new JLabel("PC");
		pcPanel.add(pcLabel);

		pcTextField = new JTextField();
		pcPanel.add(pcTextField);
		pcTextField.setColumns(10);
		
		pipeLinePanel = new JPanel();
		pipeLinePanel.setBorder(new TitledBorder(null, "PipeLine",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pipeLinePanel = new GridBagConstraints();
		gbc_pipeLinePanel.insets = new Insets(0, 0, 0, 5);
		gbc_pipeLinePanel.fill = GridBagConstraints.BOTH;
		gbc_pipeLinePanel.gridx = 0;
		gbc_pipeLinePanel.gridy = 1;
		cpuPanel.add(pipeLinePanel, gbc_pipeLinePanel);
		GridBagLayout gbl_pipeLinePanel = new GridBagLayout();
		gbl_pipeLinePanel.columnWidths = new int[] { 0, 0 };
		gbl_pipeLinePanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_pipeLinePanel.columnWeights = new double[] { 0.0, 1.0 };
		gbl_pipeLinePanel.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		pipeLinePanel.setLayout(gbl_pipeLinePanel);

		fetchLabel = new JLabel("Fetch");
		GridBagConstraints gbc_fetchLabel = new GridBagConstraints();
		gbc_fetchLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fetchLabel.anchor = GridBagConstraints.EAST;
		gbc_fetchLabel.gridx = 0;
		gbc_fetchLabel.gridy = 0;
		pipeLinePanel.add(fetchLabel, gbc_fetchLabel);

		fetchTextField = new JTextField();
		GridBagConstraints gbc_fetchTextField = new GridBagConstraints();
		gbc_fetchTextField.insets = new Insets(0, 0, 5, 0);
		gbc_fetchTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fetchTextField.gridx = 1;
		gbc_fetchTextField.gridy = 0;
		pipeLinePanel.add(fetchTextField, gbc_fetchTextField);
		controlUnit.getObsFetch().addObserver(new CPURegisterObserver(fetchTextField));
		fetchTextField.setColumns(10);

		decodeLabel = new JLabel("Decode");
		GridBagConstraints gbc_decodeLabel = new GridBagConstraints();
		gbc_decodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_decodeLabel.anchor = GridBagConstraints.EAST;
		gbc_decodeLabel.gridx = 0;
		gbc_decodeLabel.gridy = 1;
		pipeLinePanel.add(decodeLabel, gbc_decodeLabel);

		decodeTextField = new JTextField();
		GridBagConstraints gbc_decodeTextField = new GridBagConstraints();
		gbc_decodeTextField.insets = new Insets(0, 0, 5, 0);
		gbc_decodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_decodeTextField.gridx = 1;
		gbc_decodeTextField.gridy = 1;
		pipeLinePanel.add(decodeTextField, gbc_decodeTextField);
		controlUnit.getObsDecode().addObserver(new CPURegisterObserver(decodeTextField));
		decodeTextField.setColumns(10);

		excecutionLabel = new JLabel("Excecution");
		GridBagConstraints gbc_excecutionLabel = new GridBagConstraints();
		gbc_excecutionLabel.insets = new Insets(0, 0, 0, 5);
		gbc_excecutionLabel.anchor = GridBagConstraints.EAST;
		gbc_excecutionLabel.gridx = 0;
		gbc_excecutionLabel.gridy = 2;
		pipeLinePanel.add(excecutionLabel, gbc_excecutionLabel);

		excecutionTextField = new JTextField();
		GridBagConstraints gbc_excecutionTextField = new GridBagConstraints();
		gbc_excecutionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_excecutionTextField.gridx = 1;
		gbc_excecutionTextField.gridy = 2;		
		pipeLinePanel.add(excecutionTextField, gbc_excecutionTextField);
		controlUnit.getObsExec().addObserver(new CPURegisterObserver(excecutionTextField));
		excecutionTextField.setColumns(10);

//		aluPanel = new JPanel();
//		aluPanel.setBorder(new TitledBorder(null, "ALU", TitledBorder.LEADING,
//				TitledBorder.TOP, null, null));
//		GridBagConstraints gbc_aluPanel = new GridBagConstraints();
//		gbc_aluPanel.fill = GridBagConstraints.BOTH;
//		gbc_aluPanel.gridx = 1;
//		gbc_aluPanel.gridy = 1;
//		cpuPanel.add(aluPanel, gbc_aluPanel);
//		GridBagLayout gbl_aluPanel = new GridBagLayout();
//		gbl_aluPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
//		gbl_aluPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
//		gbl_aluPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0,
//				Double.MIN_VALUE };
//		gbl_aluPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//				0.0, Double.MIN_VALUE };
//		aluPanel.setLayout(gbl_aluPanel);
//
//		regAaluLabel = new JLabel("A");
//		GridBagConstraints gbc_regAaluLabel = new GridBagConstraints();
//		gbc_regAaluLabel.anchor = GridBagConstraints.EAST;
//		gbc_regAaluLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_regAaluLabel.gridx = 0;
//		gbc_regAaluLabel.gridy = 1;
//		aluPanel.add(regAaluLabel, gbc_regAaluLabel);
//
//		regAalu = new JTextField();
//		GridBagConstraints gbc_regAalu = new GridBagConstraints();
//		gbc_regAalu.insets = new Insets(0, 0, 5, 5);
//		gbc_regAalu.fill = GridBagConstraints.HORIZONTAL;
//		gbc_regAalu.gridx = 1;
//		gbc_regAalu.gridy = 1;
//		aluPanel.add(regAalu, gbc_regAalu);
//		regAalu.setColumns(10);
//
//		arrowLabel = new JLabel("->");
//		GridBagConstraints gbc_arrowLabel = new GridBagConstraints();
//		gbc_arrowLabel.gridheight = 3;
//		gbc_arrowLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_arrowLabel.gridx = 2;
//		gbc_arrowLabel.gridy = 1;
//		aluPanel.add(arrowLabel, gbc_arrowLabel);
//
//		regRaluLabel = new JLabel("R");
//		GridBagConstraints gbc_regRaluLabel = new GridBagConstraints();
//		gbc_regRaluLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_regRaluLabel.anchor = GridBagConstraints.EAST;
//		gbc_regRaluLabel.gridx = 3;
//		gbc_regRaluLabel.gridy = 2;
//		aluPanel.add(regRaluLabel, gbc_regRaluLabel);
//
//		regRaluTextField = new JTextField();
//		GridBagConstraints gbc_regRaluTextField = new GridBagConstraints();
//		gbc_regRaluTextField.insets = new Insets(0, 0, 5, 0);
//		gbc_regRaluTextField.fill = GridBagConstraints.HORIZONTAL;
//		gbc_regRaluTextField.gridx = 4;
//		gbc_regRaluTextField.gridy = 2;
//		aluPanel.add(regRaluTextField, gbc_regRaluTextField);
//		regRaluTextField.setColumns(10);
//
//		regBaluLabel = new JLabel("B");
//		GridBagConstraints gbc_regBaluLabel = new GridBagConstraints();
//		gbc_regBaluLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_regBaluLabel.anchor = GridBagConstraints.EAST;
//		gbc_regBaluLabel.gridx = 0;
//		gbc_regBaluLabel.gridy = 3;
//		aluPanel.add(regBaluLabel, gbc_regBaluLabel);
//
//		regBalu = new JTextField();
//		GridBagConstraints gbc_regBalu = new GridBagConstraints();
//		gbc_regBalu.insets = new Insets(0, 0, 5, 5);
//		gbc_regBalu.fill = GridBagConstraints.HORIZONTAL;
//		gbc_regBalu.gridx = 1;
//		gbc_regBalu.gridy = 3;
//		aluPanel.add(regBalu, gbc_regBalu);
//		regBalu.setColumns(10);
//
//		flagsLabel = new JLabel("Flags:");
//		GridBagConstraints gbc_flagsLabel = new GridBagConstraints();
//		gbc_flagsLabel.anchor = GridBagConstraints.WEST;
//		gbc_flagsLabel.insets = new Insets(0, 0, 5, 0);
//		gbc_flagsLabel.gridx = 4;
//		gbc_flagsLabel.gridy = 4;
//		aluPanel.add(flagsLabel, gbc_flagsLabel);
//
//		overflowCheckbox = new JCheckBox("overflow");
//		GridBagConstraints gbc_overflowCheckbox = new GridBagConstraints();
//		gbc_overflowCheckbox.anchor = GridBagConstraints.WEST;
//		gbc_overflowCheckbox.insets = new Insets(0, 0, 5, 0);
//		gbc_overflowCheckbox.gridx = 4;
//		gbc_overflowCheckbox.gridy = 5;
//		aluPanel.add(overflowCheckbox, gbc_overflowCheckbox);
//
////		zeroCheckbox = new JCheckBox("zero");
////		GridBagConstraints gbc_zeroCheckbox = new GridBagConstraints();
////		gbc_zeroCheckbox.anchor = GridBagConstraints.WEST;
////		gbc_zeroCheckbox.gridx = 4;
////		gbc_zeroCheckbox.gridy = 6;
////		aluPanel.add(zeroCheckbox, gbc_zeroCheckbox);
//		
//		bitsLostLabel = new JLabel("BitsLost");
//		GridBagConstraints gbc_bitsLostLabel = new GridBagConstraints();
//		gbc_bitsLostLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_bitsLostLabel.anchor = GridBagConstraints.WEST;
//		gbc_bitsLostLabel.gridx = 4;
//		gbc_bitsLostLabel.gridy = 6;
//		aluPanel.add(bitsLostLabel, gbc_bitsLostLabel);
//
//		bitsLostTextField = new JTextField();
//		GridBagConstraints gbc_bitsLostTextField = new GridBagConstraints();
//		gbc_bitsLostTextField.insets = new Insets(0, 0, 5, 0);
//		gbc_bitsLostTextField.fill = GridBagConstraints.WEST;
//		gbc_bitsLostTextField.gridx = 5;
//		gbc_bitsLostTextField.gridy = 6;
//		aluPanel.add(bitsLostTextField, gbc_bitsLostTextField);
//		regRaluTextField.setColumns(10);
		
		aluPanel = new JPanel();
		aluPanel.setBorder(new TitledBorder(null, "ALU", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_aluPanel = new GridBagConstraints();
		gbc_aluPanel.fill = GridBagConstraints.BOTH;
		gbc_aluPanel.gridx = 1;
		gbc_aluPanel.gridy = 1;
		cpuPanel.add(aluPanel, gbc_aluPanel);
		GridBagLayout gbl_aluPanel = new GridBagLayout();
		gbl_aluPanel.columnWidths = new int[] {0, 15, 0, 32, 0, 0};
		gbl_aluPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_aluPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_aluPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		aluPanel.setLayout(gbl_aluPanel);
		
		regAaluLabel = new JLabel("A");
		GridBagConstraints gbc_regAaluLabel = new GridBagConstraints();
		gbc_regAaluLabel.insets = new Insets(0, 0, 5, 5);
		gbc_regAaluLabel.gridx = 0;
		gbc_regAaluLabel.gridy = 1;
		aluPanel.add(regAaluLabel, gbc_regAaluLabel);
		
		
		regAaluTextField = new JTextField();
		GridBagConstraints gbc_regAaluTextField = new GridBagConstraints();
		gbc_regAaluTextField.gridwidth = 2;
		gbc_regAaluTextField.insets = new Insets(0, 0, 5, 5);
		gbc_regAaluTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_regAaluTextField.gridx = 1;
		gbc_regAaluTextField.gridy = 1;
		aluPanel.add(regAaluTextField, gbc_regAaluTextField);
		controlUnit.getAlu().getObsReg1().addObserver(new CPURegisterObserver(regAaluTextField));
		regAaluTextField.setColumns(10);
		
		arrowLabel = new JLabel("->");
		GridBagConstraints gbc_arrowLabel = new GridBagConstraints();
		gbc_arrowLabel.gridwidth = 2;
		gbc_arrowLabel.gridheight = 3;
		gbc_arrowLabel.insets = new Insets(0, 0, 5, 5);
		gbc_arrowLabel.gridx = 3;
		gbc_arrowLabel.gridy = 1;
		aluPanel.add(arrowLabel, gbc_arrowLabel);
		
		regRaluLabel = new JLabel("R");
		GridBagConstraints gbc_regRaluLabel = new GridBagConstraints();
		gbc_regRaluLabel.insets = new Insets(0, 0, 5, 5);
		gbc_regRaluLabel.anchor = GridBagConstraints.EAST;
		gbc_regRaluLabel.gridx = 5;
		gbc_regRaluLabel.gridy = 2;
		aluPanel.add(regRaluLabel, gbc_regRaluLabel);
		
		regRaluTextField = new JTextField();
		GridBagConstraints gbc_regRaluTextField = new GridBagConstraints();
		gbc_regRaluTextField.insets = new Insets(0, 0, 5, 0);
		gbc_regRaluTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_regRaluTextField.gridx = 6;
		gbc_regRaluTextField.gridy = 2;
		aluPanel.add(regRaluTextField, gbc_regRaluTextField);
		controlUnit.getAlu().getObsRegRes().addObserver(new CPURegisterObserver(regRaluTextField));
		regRaluTextField.setColumns(10);
		
		regBaluLabel = new JLabel("B");
		GridBagConstraints gbc_regBaluLabel = new GridBagConstraints();
		gbc_regBaluLabel.insets = new Insets(0, 0, 5, 5);
		gbc_regBaluLabel.anchor = GridBagConstraints.EAST;
		gbc_regBaluLabel.gridx = 0;
		gbc_regBaluLabel.gridy = 3;
		aluPanel.add(regBaluLabel, gbc_regBaluLabel);
		
		regBaluTextField = new JTextField();
		GridBagConstraints gbc_regBaluTextField = new GridBagConstraints();
		gbc_regBaluTextField.gridwidth = 2;
		gbc_regBaluTextField.insets = new Insets(0, 0, 5, 5);
		gbc_regBaluTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_regBaluTextField.gridx = 1;
		gbc_regBaluTextField.gridy = 3;
		aluPanel.add(regBaluTextField, gbc_regBaluTextField);
		controlUnit.getAlu().getObsReg2().addObserver(new CPURegisterObserver(regBaluTextField));
		regBaluTextField.setColumns(10);
		
		flagsLabel = new JLabel("Flags:");
		GridBagConstraints gbc_flagsLabel = new GridBagConstraints();
		gbc_flagsLabel.anchor = GridBagConstraints.WEST;
		gbc_flagsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_flagsLabel.gridx = 4;
		gbc_flagsLabel.gridy = 4;
		aluPanel.add(flagsLabel, gbc_flagsLabel);
		
		overflowCheckbox = new JCheckBox("overflow");
		GridBagConstraints gbc_overflowCheckbox = new GridBagConstraints();
		gbc_overflowCheckbox.anchor = GridBagConstraints.WEST;
		gbc_overflowCheckbox.insets = new Insets(0, 0, 5, 0);
		gbc_overflowCheckbox.gridx = 6;
		gbc_overflowCheckbox.gridy = 5;
		aluPanel.add(overflowCheckbox, gbc_overflowCheckbox);
		
		bitsLostLabel = new JLabel("BitsLost");
		GridBagConstraints gbc_bitsLostLabel = new GridBagConstraints();
		gbc_bitsLostLabel.anchor = GridBagConstraints.WEST;
		gbc_bitsLostLabel.insets = new Insets(0, 0, 0, 5);
		gbc_bitsLostLabel.gridx = 4;
		gbc_bitsLostLabel.gridy = 6;
		aluPanel.add(bitsLostLabel, gbc_bitsLostLabel);
		
		bitsLostTextField = new JTextField();
		GridBagConstraints gbc_bitsLostTextField = new GridBagConstraints();
		gbc_bitsLostTextField.gridwidth = 2;
		gbc_bitsLostTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bitsLostTextField.gridx = 5;
		gbc_bitsLostTextField.gridy = 6;
		aluPanel.add(bitsLostTextField, gbc_bitsLostTextField);
		bitsLostTextField.setColumns(10);
	}

	public void cleanGridsColor() {
		registryPanel.applyBackgroundColor(WHITE_COLOR);
		memoryPanel.applyBackgroundColor(WHITE_COLOR);
	}

	public JPanel getCpuPanel() {
		return cpuPanel;
	}

	public void setCpuPanel(JPanel cpuPanel) {
		this.cpuPanel = cpuPanel;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(JToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public JButton getBtnRun() {
		return btnRun;
	}

	public void setBtnRun(JButton btnRun) {
		this.btnRun = btnRun;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JButton getBtnStop() {
		return btnStop;
	}

	public void setBtnStop(JButton btnStop) {
		this.btnStop = btnStop;
	}

	public JButton getBtnPause() {
		return btnPause;
	}

	public void setBtnPause(JButton btnPause) {
		this.btnPause = btnPause;
	}

	public JPanel getPipeLinePanel() {
		return pipeLinePanel;
	}

	public void setPipeLinePanel(JPanel pipeLinePanel) {
		this.pipeLinePanel = pipeLinePanel;
	}

	public JPanel getAluPanel() {
		return aluPanel;
	}

	public void setAluPanel(JPanel aluPanel) {
		this.aluPanel = aluPanel;
	}

	public JPanel getPcPanel() {
		return pcPanel;
	}

	public void setPcPanel(JPanel pcPanel) {
		this.pcPanel = pcPanel;
	}

	public JTextField getPcTextField() {
		return pcTextField;
	}

	public void setPcTextField(JTextField pcTextField) {
		this.pcTextField = pcTextField;
	}

	public JLabel getPcLabel() {
		return pcLabel;
	}

	public void setPcLabel(JLabel pcLabel) {
		this.pcLabel = pcLabel;
	}

	public JTextField getRegAaluTextField() {
		return regAaluTextField;
	}

	public void setRegAaluTextField(JTextField regAaluTextField) {
		this.regAaluTextField = regAaluTextField;
	}

	public JTextField getRegBaluTextField() {
		return regBaluTextField;
	}

	public void setRegBaluTextField(JTextField regBaluTextField) {
		this.regBaluTextField = regBaluTextField;
	}

	public JTextField getRegRaluTextField() {
		return regRaluTextField;
	}

	public void setRegRaluTextField(JTextField regRaluTextField) {
		this.regRaluTextField = regRaluTextField;
	}

	public JLabel getRegAaluLabel() {
		return regAaluLabel;
	}

	public void setRegAaluLabel(JLabel regAaluLabel) {
		this.regAaluLabel = regAaluLabel;
	}

	public JLabel getRegBaluLabel() {
		return regBaluLabel;
	}

	public void setRegBaluLabel(JLabel regBaluLabel) {
		this.regBaluLabel = regBaluLabel;
	}

	public JLabel getRegRaluLabel() {
		return regRaluLabel;
	}

	public void setRegRaluLabel(JLabel regRaluLabel) {
		this.regRaluLabel = regRaluLabel;
	}

	public JCheckBox getOverflowCheckbox() {
		return overflowCheckbox;
	}

	public void setOverflowCheckbox(JCheckBox overflowCheckbox) {
		this.overflowCheckbox = overflowCheckbox;
	}

	public JCheckBox getZeroCheckbox() {
		return zeroCheckbox;
	}

	public void setZeroCheckbox(JCheckBox zeroCheckbox) {
		this.zeroCheckbox = zeroCheckbox;
	}

	public JLabel getFlagsLabel() {
		return flagsLabel;
	}

	public void setFlagsLabel(JLabel flagsLabel) {
		this.flagsLabel = flagsLabel;
	}

	public JLabel getArrowLabel() {
		return arrowLabel;
	}

	public void setArrowLabel(JLabel arrowLabel) {
		this.arrowLabel = arrowLabel;
	}

	public JTextField getFetchTextField() {
		return fetchTextField;
	}

	public void setFetchTextField(JTextField fetchTextField) {
		this.fetchTextField = fetchTextField;
	}

	public JLabel getFetchLabel() {
		return fetchLabel;
	}

	public void setFetchLabel(JLabel fetchLabel) {
		this.fetchLabel = fetchLabel;
	}

	public JTextField getDecodeTextField() {
		return decodeTextField;
	}

	public void setDecodeTextField(JTextField decodeTextField) {
		this.decodeTextField = decodeTextField;
	}

	public JLabel getDecodeLabel() {
		return decodeLabel;
	}

	public void setDecodeLabel(JLabel decodeLabel) {
		this.decodeLabel = decodeLabel;
	}

	public JTextField getExcecutionTextField() {
		return excecutionTextField;
	}

	public void setExcecutionTextField(JTextField excecutionTextField) {
		this.excecutionTextField = excecutionTextField;
	}

	public JLabel getExcecutionLabel() {
		return excecutionLabel;
	}

	public void setExcecutionLabel(JLabel excecutionLabel) {
		this.excecutionLabel = excecutionLabel;
	}

	public GridPanel getRegistryPanel() {
		return registryPanel;
	}

	public void setRegistryPanel(GridPanel registryPanel) {
		this.registryPanel = registryPanel;
	}

	public GridPanel getMemoryPanel() {
		return memoryPanel;
	}

	public void setMemoryPanel(GridPanel memoryPanel) {
		this.memoryPanel = memoryPanel;
	}

	public ControlUnit getControlUnit() {
		return controlUnit;
	}

	public void setControlUnit(ControlUnit controlUnit) {
		this.controlUnit = controlUnit;
	}

	public JTextField getBitsLostTextField() {
		return bitsLostTextField;
	}

	public void setBitsLostTextField(JTextField bitsLostTextField) {
		this.bitsLostTextField = bitsLostTextField;
	}

	public JLabel getBitsLostLabel() {
		return bitsLostLabel;
	}

	public void setBitsLostLabel(JLabel bitsLostLabel) {
		this.bitsLostLabel = bitsLostLabel;
	}
	
	
}
