package com.wkfsfrc.ce.FileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	String fileName;
	BufferedReader bufferedReader = null;
	BufferedWriter bufferedWriter = null;
	FileWriter fileWriter = null;
	File file = null;
	String path = null;
	File outputFile = null;

	public FileHandler(String file) {
		this.fileName=file;
	}
	
	public void createOutputFileWriter() {
		try {
			this.setFileWriter(new FileWriter(this.outputFile)); 
			this.setBufferedWriter(new BufferedWriter(fileWriter));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	public void createOutputFileIfNotExists() {
		this.setFile(new File(this.getFileName())); 
		this.setPath(this.file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\") + 1)); 
		 this.setOutputFile(new File(this.path + "\\output.txt"));
		 //creates the outputfile if it does not exist
	 if (!this.getOutputFile().exists()) {
	     try {
	    	 this.getOutputFile().createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	}

	BufferedReader createBufferedReader(File file) {
		try {
			return new BufferedReader(new FileReader(this.getFileName()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	public File getFile() {
		return file;
	}

	public void setFile(File f) {
		this.file = f;
	}
	
	public File getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	public void setBufferedReader() {
		this.bufferedReader = this.createBufferedReader(this.file);
	}

	public BufferedWriter getBufferedWriter() {
		return bufferedWriter;
	}

	public void setBufferedWriter(BufferedWriter bw) {
		this.bufferedWriter = bw;
	}

	public FileWriter getFileWriter() {
		return fileWriter;
	}

	public void setFileWriter(FileWriter fw) {
		this.fileWriter = fw;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String file) {
		this.fileName = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setBufferedReader(BufferedReader br) {
		this.bufferedReader = br;
	}
}
