package com.fiuba.taller.ums;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.fiuba.taller.ums.action.CloseFileAction;
import com.fiuba.taller.ums.action.CompileAction;
import com.fiuba.taller.ums.action.ConvertAction;
import com.fiuba.taller.ums.action.DecToHexCalcAction;
import com.fiuba.taller.ums.action.ExitAction;
import com.fiuba.taller.ums.action.NewFileAction;
import com.fiuba.taller.ums.action.OpenFileAction;
import com.fiuba.taller.ums.action.SaveFileAction;
import com.fiuba.taller.ums.component.ExtraMenu;
import com.fiuba.taller.ums.component.FileMenu;
import com.fiuba.taller.ums.component.HelpMenu;
import com.fiuba.taller.ums.component.LanguageCodeMenu;
import com.fiuba.taller.ums.component.MultiTabPane;
import com.fiuba.taller.ums.component.ProjectMenu;
import com.fiuba.taller.ums.component.StatusBar;

public class UmsEditorGui {

	private final static int WINDOW_POSITION_X = 100;
	private final static int WINDOW_POSITION_Y = 100;
	private final static int WINDOW_HEIGH_SIZE = 600;
	private final static int WINDOW_WIDTH_SIZE = 800;

	private JFrame frame;

	private MultiTabPane multiTabPane;
	private StatusBar statusBar;

	private JMenuBar menuBar;
	private FileMenu fileMenu;
	private LanguageCodeMenu languageCodeMenu;
	private ProjectMenu projectMenu;
	private HelpMenu helpMenu;
	private ExtraMenu extraMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UmsEditorGui window = new UmsEditorGui();
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
	public UmsEditorGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("UMS Code Editor");
		frame.setBounds(WINDOW_POSITION_X, WINDOW_POSITION_Y,
				WINDOW_WIDTH_SIZE, WINDOW_HEIGH_SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		multiTabPane = new MultiTabPane();
		frame.getContentPane().add(multiTabPane, BorderLayout.CENTER);

		// Menu bar at top of window
		menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);

		// File operations menu
		fileMenu = new FileMenu(this);
		menuBar.add(fileMenu);
		
		// Project menu
		projectMenu = new ProjectMenu(this);
		menuBar.add(projectMenu);

		// Extra menu
		extraMenu = new ExtraMenu();
		menuBar.add(extraMenu);
		
		// Help menu
		helpMenu = new HelpMenu();
		menuBar.add(helpMenu);

		// Status bar at the bottom of the window
		StatusBar statusBar = new StatusBar();
		frame.getContentPane().add(statusBar, BorderLayout.SOUTH);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public StatusBar getStatusBar() {
		return statusBar;
	}

	public void setStatusBar(StatusBar statusBar) {
		this.statusBar = statusBar;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public FileMenu getFileMenu() {
		return fileMenu;
	}

	public void setFileMenu(FileMenu fileMenu) {
		this.fileMenu = fileMenu;
	}

	public LanguageCodeMenu getLanguageCodeMenu() {
		return languageCodeMenu;
	}

	public void setLanguageCodeMenu(LanguageCodeMenu languageCodeMenu) {
		this.languageCodeMenu = languageCodeMenu;
	}

	public ProjectMenu getProjectMenu() {
		return projectMenu;
	}

	public void setProjectMenu(ProjectMenu projectMenu) {
		this.projectMenu = projectMenu;
	}

	public HelpMenu getHelpMenu() {
		return helpMenu;
	}

	public void setHelpMenu(HelpMenu helpMenu) {
		this.helpMenu = helpMenu;
	}

	public MultiTabPane getMultiTabPane() {
		return multiTabPane;
	}

	public void setEditorPane(MultiTabPane multiTabPane) {
		this.multiTabPane = multiTabPane;
	}
}
