package com.fiuba.taller.ums.component;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.fiuba.taller.ums.action.FileType;

public class FileEditorPane extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6899634953116260814L;

	private JTextPane editorText;
	private String filePath;
	private FileType fileType;

	public FileEditorPane(String fileName, String filePath, FileType fileType) {
		// Scrollable text area with line numbers
		editorText = new JTextPane();
		this.setViewportView(editorText);
		TextLineNumber textLineNumber = new TextLineNumber(editorText);
		this.setRowHeaderView(textLineNumber);
		this.setName(fileName);
		this.filePath = filePath;
		this.fileType = fileType;
	}

	public FileEditorPane(String fileName, String filePath, String fileContent,
			FileType fileType) {
		this(fileName, filePath, fileType);
		editorText.setText(fileContent);
	}

	public String getContent() {
		return editorText.getText();
	}

	public JTextPane getEditorText() {
		return editorText;
	}

	public void setEditorText(JTextPane editorText) {
		this.editorText = editorText;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

}
