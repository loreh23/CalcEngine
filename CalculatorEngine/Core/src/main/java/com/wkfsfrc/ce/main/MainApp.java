package com.wkfsfrc.ce.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.wkfsfrc.ce.Exception.InvalidStatementException;
import com.wkfsfrc.ce.FileHandler.FileHandler;
public class MainApp {

	static private String inputFile;
	static private String configFile;
	public static void main(String[] args) {
		inputFile = args[0];
		configFile= args[1];
		Calculator calculator=new Calculator();
		String lineContent;
		
		Properties classes=new Properties();
		InputStream input=null;
		try {
			input= new FileInputStream(configFile);
			classes.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		calculator.setMathOperationsList(classes);
		
		FileHandler fileHandler = new FileHandler(inputFile);
		fileHandler.createOutputFileIfNotExists();
		fileHandler.createOutputFileWriter();
		fileHandler.setBufferedReader();
		try {
			while((lineContent=fileHandler.getBufferedReader().readLine())!=null){
				try {
				calculator.calculate(lineContent);
				if(!(calculator.getResult()==null)) {
				fileHandler.getBufferedWriter().write(calculator.getResult());
				fileHandler.getBufferedWriter().newLine();
				System.out.println(calculator.getResult());
				}
			}catch(InvalidStatementException e) {
				System.out.println(e.getMessage());
			}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileHandler.getBufferedWriter().flush();
				fileHandler.getBufferedWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
