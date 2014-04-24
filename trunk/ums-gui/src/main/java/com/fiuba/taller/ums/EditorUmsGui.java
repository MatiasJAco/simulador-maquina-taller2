package com.fiuba.taller.ums;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import com.fiuba.taller.ums.action.AboutAction;
import com.fiuba.taller.ums.action.ExitAction;
import com.fiuba.taller.ums.action.NewFileAction;
import com.fiuba.taller.ums.action.OpenFileAction;
import com.fiuba.taller.ums.action.SaveFileAction;
import com.fiuba.taller.ums.component.JMenuHelpContents;
import com.fiuba.taller.ums.component.StatusBar;
import com.fiuba.taller.ums.component.TextLineNumber;

public class EditorUmsGui {

	private final static int WINDOW_POSITION_X = 100;
	private final static int WINDOW_POSITION_Y = 100;
	private final static int WINDOW_HEIGH_SIZE = 600;
	private final static int WINDOW_WIDTH_SIZE = 800;
	private final static String DEFAULT_NEWFILE_NAME = "new ";

	private int newFileCounter = 1;
	private String fileName = DEFAULT_NEWFILE_NAME + newFileCounter++;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorUmsGui window = new EditorUmsGui();
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
	public EditorUmsGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(fileName + " - UMS Code Editor");
		frame.setBounds(WINDOW_POSITION_X, WINDOW_POSITION_Y,
				WINDOW_WIDTH_SIZE, WINDOW_HEIGH_SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Scrollable text area with line numbers
		JTextPane editorText = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(editorText);
		TextLineNumber textLineNumber = new TextLineNumber(editorText);
		scrollPane.setRowHeaderView(textLineNumber);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		// Menu bar at top of window
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);

		// File operations menu
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		// New file item @ File operations menu
		JMenuItem newFileMenuItem = new JMenuItem("New");
		newFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/NewFile.png")));
		fileMenu.add(newFileMenuItem);
		newFileMenuItem.addActionListener(new NewFileAction(editorText));

		// Open file item @ File operations menu
		JMenuItem openFileMenuItem = new JMenuItem("Open File...");
		fileMenu.add(openFileMenuItem);
		openFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/OpenFile.png")));
		openFileMenuItem
				.addActionListener(new OpenFileAction(frame, editorText));

		JSeparator openFileSeparator = new JSeparator();
		fileMenu.add(openFileSeparator);

		// Close file item @ File operations menu
		JMenuItem closeFileMenuItem = new JMenuItem("Close");
		closeFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/CloseFile.png")));
		fileMenu.add(closeFileMenuItem);

		// Separator between Close file operation and Save file operations @
		// File operations menu
		JSeparator closeFileSeparator = new JSeparator();
		fileMenu.add(closeFileSeparator);

		// Save As file item @ File operations menu
		JMenuItem saveAsFileMenuItem = new JMenuItem("Save As...");
		saveAsFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/SaveAsFile.png")));
		fileMenu.add(saveAsFileMenuItem);
		saveAsFileMenuItem.addActionListener(new SaveFileAction(frame,
				editorText, fileName));

		// Save file item @ File operations menu
		JMenuItem saveFileMenuItem = new JMenuItem("Save");
		saveFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/SaveFile.png")));
		fileMenu.add(saveFileMenuItem);
		openFileMenuItem.addActionListener(new SaveFileAction(frame,
				editorText, fileName));

		// Separator between Save file operations and exit program @ File
		// operations menu
		JSeparator saveFileSeparator = new JSeparator();
		fileMenu.add(saveFileSeparator);

		// Exit program item @ File operations menu
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		exitMenuItem.addActionListener(new ExitAction());

		// Language menu
		JMenu languageCode = new JMenu("Language Code");
		menuBar.add(languageCode);

		// Assembler codification item @ Language menu
		JRadioButtonMenuItem assemblerRadioItem = new JRadioButtonMenuItem(
				"Assembler");
		languageCode.add(assemblerRadioItem);

		// Machine code codification item @ Language menu
		JRadioButtonMenuItem machineCodeRadioItem = new JRadioButtonMenuItem(
				"Machine Code");
		languageCode.add(machineCodeRadioItem);

		// Group the radio buttons.
		ButtonGroup languageCodeGroup = new ButtonGroup();
		languageCodeGroup.add(assemblerRadioItem);
		languageCodeGroup.add(machineCodeRadioItem);

		// Project menu
		JMenu projectMenu = new JMenu("Project");
		menuBar.add(projectMenu);

		// Compile code item @ Project menu
		JMenuItem compileMenuItem = new JMenuItem("Compile");
		projectMenu.add(compileMenuItem);
		compileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/CompileFile.png")));

		// Convert code menu @ Project menu
		JMenu converterMenu = new JMenu("Converter");
		projectMenu.add(converterMenu);

		// Compile code item @ Convert code menu
		JMenuItem assemToCodMachMenuItem = new JMenuItem(
				"Assembler to Code Machine");
		converterMenu.add(assemToCodMachMenuItem);

		// Help menu
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		// Help Contents item @ Help menu
		JMenuItem helpContentsMenuItem = new JMenuHelpContents("Help Contents", frame);
		helpContentsMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/HelpContents.png")));
		helpMenu.add(helpContentsMenuItem);		

		// Separator between Help contents and about @ Help menu
		JSeparator helpContentsSeparator = new JSeparator();
		helpMenu.add(helpContentsSeparator);

		// About item @ Help menu
		JMenuItem aboutHelpMenuItem = new JMenuItem("About UMS");
		helpMenu.add(aboutHelpMenuItem);
		aboutHelpMenuItem.addActionListener(new AboutAction(frame));

		// Status bar at the bottom of the window
		StatusBar statusBar = new StatusBar();
		frame.add(statusBar, BorderLayout.SOUTH);

	}
}
