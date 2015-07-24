package com.multunus.alien.datawriter;

import java.io.IOException;

/**
 * @author Rino Alias
 *
 */
public interface DataWriter {
	//interface used for exporting data
	abstract void toPDF(String alienCodeName, String alienBloodColor, int alienAntennaCount, int alienLegCount, String alienHomePlanet);
	abstract void toPlainText(String alienCodeName, String alienBloodColor, int alienAntennaCount, int alienLegCount, String alienHomePlanet) throws IOException;
}
