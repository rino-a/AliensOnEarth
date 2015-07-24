package com.multunus.alien;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.multunus.alien.datawriter.ExportToFile;


/**
 * @author Rino Alias
 *
 */
public class AlienMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	private static String alienHomePlanet, alienBloodColor, alienCodeName;
	private static int alienLegCount, alienAntennaCount;
	public static void main(String[] args) throws IOException {
		//Get input from user about Alien details
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Welcome to Alien Registration \n");
        getCodeDetails(br);
		getBloodDetails(br);
		getAntennaDetails(br);
		getLegDetails(br);
		getPlanetDetails(br);
		int optionSelected = showExportOptions(br);
		doOperation(optionSelected);
	}

	private static void getPlanetDetails(BufferedReader br) throws IOException {
		System.out.println("Enter Alien's Home Planet");
		alienHomePlanet = br.readLine();
	}

	private static void getBloodDetails(BufferedReader br) throws IOException {
		System.out.println("Enter Alien's Blood Color");
		alienBloodColor = br.readLine();
	}

	private static void getCodeDetails(BufferedReader br) throws IOException {
		System.out.println("Enter Alien's Code Name");
        alienCodeName = br.readLine();
	}

	private static void getLegDetails(BufferedReader br) throws IOException {
		System.out.println("Enter Alien's Number of Legs");
		try {
			alienLegCount = Integer.parseInt(br.readLine());
		} catch(NumberFormatException e) {
			System.out.print("Invalid Entry\n");
			getLegDetails(br);
		}
	}

	private static void getAntennaDetails(BufferedReader br) throws IOException {
		System.out.println("Enter Alien's Number of Antennas");
		try {
			alienAntennaCount = Integer.parseInt(br.readLine());
		} catch(NumberFormatException e) {
			System.out.print("Invalid Entry\n");
			getAntennaDetails(br);
		}
	}

	private static void doOperation(int optionSelected) throws NumberFormatException, IOException {
		ExportToFile export = new ExportToFile();
		switch (optionSelected) {
		case 1:
			export.toPDF(alienCodeName, alienBloodColor, alienAntennaCount, alienLegCount, alienHomePlanet);
			System.out.println("Details exported as PDF");
			break;
		case 2:
			export.toPlainText(alienCodeName, alienBloodColor, alienAntennaCount, alienLegCount, alienHomePlanet);
			System.out.println("Details Exported as Plain Text");
			break;
		default:
			System.out.println("Invalid Option Selected");
			int option = showExportOptions(new BufferedReader(new InputStreamReader(System.in)));
			doOperation(option);
			break;
		}
	}

	private static int showExportOptions(BufferedReader br) throws NumberFormatException, IOException {
		System.out.print("Export the details based on options below\n");
		System.out.print("Press 1 to export details as PDF\n");
		System.out.print("Press 2 to export details as Plain Text\n");
		int option = 100;
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.print("Invalid Option Selected\n");
			showExportOptions(br);
		}
		return option;
	}
	
}
