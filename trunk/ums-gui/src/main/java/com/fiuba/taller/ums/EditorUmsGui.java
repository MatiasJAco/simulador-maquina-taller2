package com.fiuba.taller.ums;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import com.fiuba.taller.ums.action.ExitAction;
import com.fiuba.taller.ums.action.NewFileAction;
import com.fiuba.taller.ums.action.OpenFileAction;
import com.fiuba.taller.ums.action.SaveFileAction;
import com.fiuba.taller.ums.component.StatusBar;
import com.fiuba.taller.ums.component.TextLineNumber;

import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

public class EditorUmsGui {

	private final static int WINDOW_POSITION_X = 100;
	private final static int WINDOW_POSITION_Y = 100;
	private final static int WINDOW_HEIGH_SIZE = 600;
	private final static int WINDOW_WIDTH_SIZE = 800;
	private final static String DEFAULT_NEWFILE_NAME = "new ";

	private int newFileCounter = 1;
	private String fileName = DEFAULT_NEWFILE_NAME + newFileCounter++;

	private JFrame frmUms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorUmsGui window = new EditorUmsGui();
					window.frmUms.setVisible(true);
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
		frmUms = new JFrame();
		frmUms.setTitle(fileName + " - UMS Code Editor");
		frmUms.setBounds(WINDOW_POSITION_X, WINDOW_POSITION_Y,
				WINDOW_WIDTH_SIZE, WINDOW_HEIGH_SIZE);
		frmUms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Scrollable text area with line numbers
		JTextPane editorText = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(editorText);
		TextLineNumber textLineNumber = new TextLineNumber(editorText);
		scrollPane.setRowHeaderView(textLineNumber);
		frmUms.getContentPane().add(scrollPane, BorderLayout.CENTER);

		// Menu bar at top of window
		JMenuBar menuBar = new JMenuBar();
		frmUms.getContentPane().add(menuBar, BorderLayout.NORTH);

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
		openFileMenuItem.addActionListener(new OpenFileAction(frmUms,
				editorText));
		
		
		JSeparator openFileSeparator = new JSeparator();
		fileMenu.add(openFileSeparator);

		// Close file item @ File operations menu
		JMenuItem closeFileMenuItem = new JMenuItem("Close");
		closeFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/CloseFile.png")));
		fileMenu.add(closeFileMenuItem);
		
		// Separator between Close file operation and Save file operations @ File operations menu
		JSeparator closeFileSeparator = new JSeparator();
		fileMenu.add(closeFileSeparator);

		// Save As file item @ File operations menu
		JMenuItem saveAsFileMenuItem = new JMenuItem("Save As...");
		saveAsFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/SaveAsFile.png")));
		fileMenu.add(saveAsFileMenuItem);
		saveAsFileMenuItem.addActionListener(new SaveFileAction(frmUms,
				editorText, fileName));

		// Save file item @ File operations menu
		JMenuItem saveFileMenuItem = new JMenuItem("Save");
		saveFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/SaveFile.png")));
		fileMenu.add(saveFileMenuItem);
		openFileMenuItem.addActionListener(new SaveFileAction(frmUms,
				editorText, fileName));

		// Separator between Save file operations and exit program @ File operations menu
		JSeparator saveFileSeparator = new JSeparator();
		fileMenu.add(saveFileSeparator);

		// Exit program item @ File operations menu
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		exitMenuItem.addActionListener(new ExitAction());

		// Language menu
		JMenu language = new JMenu("Language");
		menuBar.add(language);

		// Assembler codification item @ Language menu
		JRadioButtonMenuItem assemblerRadioItem = new JRadioButtonMenuItem(
				"Assembler");
		language.add(assemblerRadioItem);

		// Machine code codification item @ Language menu
		JRadioButtonMenuItem machineCodeRadioItem = new JRadioButtonMenuItem(
				"Machine Code");
		language.add(machineCodeRadioItem);

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
		JMenuItem helpContentsMenuItem = new JMenuItem("Help Contents");
		helpContentsMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/HelpContents.png")));
		helpMenu.add(helpContentsMenuItem);

		// Separator between Help contents and about @ Help menu
		JSeparator helpContentsSeparator = new JSeparator();
		helpMenu.add(helpContentsSeparator);

		// About item @ Help menu
		JMenuItem aboutHelpMenuItem = new JMenuItem("About UMS");
		helpMenu.add(aboutHelpMenuItem);

		// Status bar at the bottom of the window
		StatusBar statusBar = new StatusBar();
		frmUms.add(statusBar, BorderLayout.SOUTH);

	}
}
