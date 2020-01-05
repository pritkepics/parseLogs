package com.log.readLogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;

public class Utility {

	
	public static final String FILE_PATH="output.txt";
	
	/**
	 * This function is used to read a file .
	 * 
	 * @param filePath : the path to the file user wants to read
	 * @return: returns String containing all lines of the file
	 */

	public static String readFile(String filePath) {

		String strLines = "";
		try {

			BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

			while (br.readLine() != null) {

				strLines = strLines + br.readLine() + "\n";

			}

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return strLines;

	}

	/**
	 * Writes the unique set of errors to a file "output.txt" inside the project
	 * 
	 * @param setOfErrors
	 * @throws IOException
	 */

	public static void writeErrorsToFile(LinkedHashSet<String> setOfErrors) throws IOException {

		try {
			FileWriter fw = new FileWriter(FILE_PATH);

			for (String uniqueError : setOfErrors) {
				fw.write("\n" + uniqueError);
			}
			fw.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}


	
}
