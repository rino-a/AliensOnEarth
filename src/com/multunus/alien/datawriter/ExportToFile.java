package com.multunus.alien.datawriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportToFile implements DataWriter {

	public void toPDF(String alienCodeName, String alienBloodColor, int alienAntennaCount, int alienLegCount, String alienHomePlanet) {
		Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("AlienDetails.pdf"));
	         document.open();
	         document.addTitle("Alien Registration Details");
	         document.add(new Paragraph("Alien\'s Code Name : "+alienCodeName+"\n"));
	         document.add(new Paragraph("Alien\'s Blood Color : "+alienBloodColor+"\n"));
	         document.add(new Paragraph("Alien\'s Antenna Count : "+alienAntennaCount+"\n"));
	         document.add(new Paragraph("Alien\'s Leg Count : "+alienLegCount+"\n"));
	         document.add(new Paragraph("Alien\'s Home Planet : "+alienHomePlanet+"\n"));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         System.out.println("Exporting Failed, Please try again");
	      } catch (FileNotFoundException e)
	      {
	         System.out.println("Exporting Failed, Please try again");
	      }
	}

	public void toPlainText(String alienCodeName, String alienBloodColor, int alienAntennaCount, int alienLegCount, String alienHomePlanet) throws IOException {
		String separator = System.getProperty("line.separator");
		File exportFile = new File("AlienDetails.txt");
		Writer alienDetailsWriter = new BufferedWriter(new FileWriter(exportFile));
		alienDetailsWriter.write("Alien\'s Code Name : "+alienCodeName+separator);
		alienDetailsWriter.write("Alien\'s Blood Color : "+alienBloodColor+separator);
		alienDetailsWriter.write("Alien\'s Antenna Count : "+alienAntennaCount+separator);
		alienDetailsWriter.write("Alien\'s Leg Count : "+alienLegCount+separator);
		alienDetailsWriter.write("Alien\'s Home Planet : "+alienHomePlanet+separator);
		alienDetailsWriter.write(separator+separator);
		alienDetailsWriter.close();
	}

}
