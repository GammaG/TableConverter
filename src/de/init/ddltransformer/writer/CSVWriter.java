package de.init.ddltransformer.writer;

import java.util.ArrayList;
import java.util.HashMap;
import de.init.ddltransformer.model.Table;

public class CSVWriter {

	public void createCSV(ArrayList<Table> tableItems) {

		// Write the first text line
		StringBuilder sbOut = new StringBuilder();	

		try {
			// fill in the information
			for (Table table : tableItems) {
				sbOut.append(CsvUtil.quotedColumnSemicolon(table.getName()));
				sbOut.append("\n");
				sbOut.append("\n");
				HashMap<String, String> elements = table.getElementsMap();
				for(String key: elements.keySet()){					
				sbOut.append(CsvUtil.quotedColumnSemicolon(key));
				sbOut.append(CsvUtil.quotedColumnSemicolon(elements.get(key)));		
				sbOut.append("\n");
				}
				sbOut.append("\n");
			}
			CsvUtil.saveFile("Tabellen", sbOut.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
