package com.log.readLogs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;

public class GetErrorCount {

	// Input log file to be read

	public static final String FILEPATH = "application.log";

	public static void main(String[] args) {

		try {
			String lines = Utility.readFile(FILEPATH);
			LinkedHashSet<String> setOfErrors = findErrors(lines);
			System.out.println("\n\n\n Total no. of unique errors present in the log file: " + setOfErrors.size());
			pritnErrosToConsole(setOfErrors);
			Utility.writeErrorsToFile(setOfErrors);
			System.out.println("\n\n\n Total no. of unique errors present in the log file: " + setOfErrors.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Parses the file and returns a unique set of lines contain only errors
	 * 
	 * @param lines
	 * @return returns a unique set of lines contain only errors maintaining the
	 *         order
	 */
	private static LinkedHashSet<String> findErrors(String lines) {

		LinkedHashSet<String> setOfErrors = new LinkedHashSet<String>();
		try {

			String linesArr[] = lines.split("\n");
			for (String line : linesArr) {
				if (line.contains("] ERROR ")) {

					setOfErrors.add(line);
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return setOfErrors;
	}

		/**
	 * Prints the set of unique errors to the console.
	 * 
	 * @param setOfErrors
	 */

	private static void pritnErrosToConsole(LinkedHashSet<String> setOfErrors) {

		System.out.println(
				"\n\n\n -------------------------------------------------------------------------------------------------------------------------");
		setOfErrors.forEach(System.out::println);
	}
}
