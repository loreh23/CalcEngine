package com.wkfsfrc.ce.AppCore.test.integrationTest;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.wkfsfrc.ce.AppCore.MainApp;

@RunWith(JUnit4.class)
public class TestCalcEngineIntegrationTest {

	private String[] files = {".\\input.txt",".\\output.txt",".\\configFile.properties"};
	private File expectedOutputFile = new File(".\\output_expected.txt");
	private File outputFile=new File(".\\output.txt");
	

	@Test
	public void myTestMethod() {
		
		MainApp.main(files);
		
		try {
			assertTrue("The files differ!", FileUtils.contentEquals(outputFile, expectedOutputFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
