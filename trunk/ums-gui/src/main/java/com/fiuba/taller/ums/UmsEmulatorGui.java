/*
 * Creation : 19/02/2015
 */
package com.fiuba.taller.ums;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.fiuba.taller.ums.component.GridPanel;

public class UmsEmulatorGui {

	public static Color WHITE_COLOR = new Color(255, 255, 255);

	private JFrame frame;
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
	private JTextField regAalu;
	private JTextField regBalu;
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

	private GridPanel registryPanel;
	private GridPanel memoryPanel;

	private Memory myMemory;
	private ControlUnit myControlUnit;

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
		frame.setBounds(100, 100, 650, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 650, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 163, 258, 185, 0 };
		frame.getContentPane().setLayout(gridBagLayout);

		initToolbar();

		// Initialization Emulator
		initEmulator();

		// --- <REGISTRY> ---
		initRegistry();

		// --- <CPU> ---
		initCPUPanel();

		// --- <MEMORY> ---
		initMemory();
	}

	private void initEmulator() {
		myMemory = new Memory();
		myControlUnit = new ControlUnit(myMemory);
	}

	private void initMemory() {
		List<Cell> memoryCells = myControlUnit.getMem().getCells();
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
		frame.getContentPane().add(memoryPanel, gbc_memoryPanel);
	}

	private void initRegistry() {
		List<Cell> registers = myControlUnit.getRegMem().getRegisters();
		registryPanel = new GridPanel("Registry", registers, 4, false);
		registryPanel.setBorder(new TitledBorder(null, "Regristry",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_registryPanel = new GridBagConstraints();
		gbc_registryPanel.fill = GridBagConstraints.BOTH;
		gbc_registryPanel.insets = new Insets(0, 0, 5, 0);
		gbc_registryPanel.gridx = 0;
		gbc_registryPanel.gridy = 1;
		frame.getContentPane().add(registryPanel, gbc_registryPanel);
	}

	private void initToolbar() {
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
		frame.getContentPane().add(cpuPanel, gbc_cpuPanel);
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
		excecutionTextField.setColumns(10);

		aluPanel = new JPanel();
		aluPanel.setBorder(new TitledBorder(null, "ALU", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_aluPanel = new GridBagConstraints();
		gbc_aluPanel.fill = GridBagConstraints.BOTH;
		gbc_aluPanel.gridx = 1;
		gbc_aluPanel.gridy = 1;
		cpuPanel.add(aluPanel, gbc_aluPanel);
		GridBagLayout gbl_aluPanel = new GridBagLayout();
		gbl_aluPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_aluPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_aluPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_aluPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		aluPanel.setLayout(gbl_aluPanel);

		regAaluLabel = new JLabel("A");
		GridBagConstraints gbc_regAaluLabel = new GridBagConstraints();
		gbc_regAaluLabel.anchor = GridBagConstraints.EAST;
		gbc_regAaluLabel.insets = new Insets(0, 0, 5, 5);
		gbc_regAaluLabel.gridx = 0;
		gbc_regAaluLabel.gridy = 1;
		aluPanel.add(regAaluLabel, gbc_regAaluLabel);

		regAalu = new JTextField();
		GridBagConstraints gbc_regAalu = new GridBagConstraints();
		gbc_regAalu.insets = new Insets(0, 0, 5, 5);
		gbc_regAalu.fill = GridBagConstraints.HORIZONTAL;
		gbc_regAalu.gridx = 1;
		gbc_regAalu.gridy = 1;
		aluPanel.add(regAalu, gbc_regAalu);
		regAalu.setColumns(10);

		arrowLabel = new JLabel("->");
		GridBagConstraints gbc_arrowLabel = new GridBagConstraints();
		gbc_arrowLabel.gridheight = 3;
		gbc_arrowLabel.insets = new Insets(0, 0, 5, 5);
		gbc_arrowLabel.gridx = 2;
		gbc_arrowLabel.gridy = 1;
		aluPanel.add(arrowLabel, gbc_arrowLabel);

		regRaluLabel = new JLabel("R");
		GridBagConstraints gbc_regRaluLabel = new GridBagConstraints();
		gbc_regRaluLabel.insets = new Insets(0, 0, 5, 5);
		gbc_regRaluLabel.anchor = GridBagConstraints.EAST;
		gbc_regRaluLabel.gridx = 3;
		gbc_regRaluLabel.gridy = 2;
		aluPanel.add(regRaluLabel, gbc_regRaluLabel);

		regRaluTextField = new JTextField();
		GridBagConstraints gbc_regRaluTextField = new GridBagConstraints();
		gbc_regRaluTextField.insets = new Insets(0, 0, 5, 0);
		gbc_regRaluTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_regRaluTextField.gridx = 4;
		gbc_regRaluTextField.gridy = 2;
		aluPanel.add(regRaluTextField, gbc_regRaluTextField);
		regRaluTextField.setColumns(10);

		regBaluLabel = new JLabel("B");
		GridBagConstraints gbc_regBaluLabel = new GridBagConstraints();
		gbc_regBaluLabel.insets = new Insets(0, 0, 5, 5);
		gbc_regBaluLabel.anchor = GridBagConstraints.EAST;
		gbc_regBaluLabel.gridx = 0;
		gbc_regBaluLabel.gridy = 3;
		aluPanel.add(regBaluLabel, gbc_regBaluLabel);

		regBalu = new JTextField();
		GridBagConstraints gbc_regBalu = new GridBagConstraints();
		gbc_regBalu.insets = new Insets(0, 0, 5, 5);
		gbc_regBalu.fill = GridBagConstraints.HORIZONTAL;
		gbc_regBalu.gridx = 1;
		gbc_regBalu.gridy = 3;
		aluPanel.add(regBalu, gbc_regBalu);
		regBalu.setColumns(10);

		flagsLabel = new JLabel("Flags:");
		GridBagConstraints gbc_flagsLabel = new GridBagConstraints();
		gbc_flagsLabel.anchor = GridBagConstraints.WEST;
		gbc_flagsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_flagsLabel.gridx = 4;
		gbc_flagsLabel.gridy = 4;
		aluPanel.add(flagsLabel, gbc_flagsLabel);

		overflowCheckbox = new JCheckBox("overflow");
		GridBagConstraints gbc_overflowCheckbox = new GridBagConstraints();
		gbc_overflowCheckbox.anchor = GridBagConstraints.WEST;
		gbc_overflowCheckbox.insets = new Insets(0, 0, 5, 0);
		gbc_overflowCheckbox.gridx = 4;
		gbc_overflowCheckbox.gridy = 5;
		aluPanel.add(overflowCheckbox, gbc_overflowCheckbox);

		zeroCheckbox = new JCheckBox("zero");
		GridBagConstraints gbc_zeroCheckbox = new GridBagConstraints();
		gbc_zeroCheckbox.anchor = GridBagConstraints.WEST;
		gbc_zeroCheckbox.gridx = 4;
		gbc_zeroCheckbox.gridy = 6;
		aluPanel.add(zeroCheckbox, gbc_zeroCheckbox);
	}

	public void cleanGridsColor() {
		registryPanel.applyBackgroundColor(WHITE_COLOR);
		memoryPanel.applyBackgroundColor(WHITE_COLOR);
	}
}
