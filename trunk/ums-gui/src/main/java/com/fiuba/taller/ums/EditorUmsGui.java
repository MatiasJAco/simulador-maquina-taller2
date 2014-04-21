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

		// Menu bar
		JMenuBar menuBar = new JMenuBar();
		frmUms.getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem newFileMenuItem = new JMenuItem("New");
		newFileMenuItem
				.setIcon(new ImageIcon(
						"C:\\Users\\Federico\\Downloads\\splashy_icons_icons_pack_120729\\document_a4_new.png"));
		fileMenu.add(newFileMenuItem);
		newFileMenuItem.addActionListener(new NewFileAction(editorText));

		JMenuItem openFileMenuItem = new JMenuItem("Open File...");
		fileMenu.add(openFileMenuItem);
		openFileMenuItem
				.setIcon(new ImageIcon(
						"C:\\Users\\Federico\\Downloads\\splashy_icons_icons_pack_120729\\folder_classic_opened_stuffed.png"));
		openFileMenuItem.addActionListener(new OpenFileAction(frmUms,
				editorText));

		JSeparator openFileSeparator = new JSeparator();
		fileMenu.add(openFileSeparator);

		JMenuItem closeFileMenuItem = new JMenuItem("Close");
		closeFileMenuItem
				.setIcon(new ImageIcon(
						"C:\\Users\\Federico\\Downloads\\splashy_icons_icons_pack_120729\\close.png"));
		fileMenu.add(closeFileMenuItem);

		JSeparator closeFileSeparator = new JSeparator();
		fileMenu.add(closeFileSeparator);

		JMenuItem saveAsFileMenuItem = new JMenuItem("Save As...");
		saveAsFileMenuItem
				.setIcon(new ImageIcon(
						"C:\\Users\\Federico\\Downloads\\splashy_icons_icons_pack_120729\\documents_okay.png"));
		fileMenu.add(saveAsFileMenuItem);
		saveAsFileMenuItem.addActionListener(new SaveFileAction(frmUms,
				editorText, fileName));

		JMenuItem saveFileMenuItem = new JMenuItem("Save");
		saveFileMenuItem
				.setIcon(new ImageIcon(
						"C:\\Users\\Federico\\Downloads\\splashy_icons_icons_pack_120729\\document_a4_okay.png"));
		fileMenu.add(saveFileMenuItem);
		openFileMenuItem.addActionListener(new SaveFileAction(frmUms,
				editorText, fileName));

		JSeparator saveFileSeparator = new JSeparator();
		fileMenu.add(saveFileSeparator);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		exitMenuItem.addActionListener(new ExitAction());

		JMenu language = new JMenu("Language");
		menuBar.add(language);
		
		JRadioButtonMenuItem assemblerRadioItem = new JRadioButtonMenuItem("Assembler");
		language.add(assemblerRadioItem);
		
		JRadioButtonMenuItem machineCodeRadioItem = new JRadioButtonMenuItem("Machine Code");
		language.add(machineCodeRadioItem);

		JMenu projectMenu = new JMenu("Project");
		menuBar.add(projectMenu);

		JMenuItem buildMenuItem = new JMenuItem("Compile");
		projectMenu.add(buildMenuItem);

		JMenu converterMenu = new JMenu("Converter");
		projectMenu.add(converterMenu);

		JMenuItem assemToCodMachMenuItem = new JMenuItem(
				"Assembler to Code Machine");
		converterMenu.add(assemToCodMachMenuItem);

		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		JMenuItem helpContentsMenuItem = new JMenuItem("Help Contents");
		helpContentsMenuItem
				.setIcon(new ImageIcon(
						"C:\\Users\\Federico\\Downloads\\splashy_icons_icons_pack_120729\\help.png"));
		helpMenu.add(helpContentsMenuItem);

		JSeparator helpContentsSeparator = new JSeparator();
		helpMenu.add(helpContentsSeparator);

		JMenuItem aboutHelpMenuItem = new JMenuItem("About UMS");
		helpMenu.add(aboutHelpMenuItem);

	}
}
