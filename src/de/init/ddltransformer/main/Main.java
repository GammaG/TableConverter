package de.init.ddltransformer.main;

import java.io.IOException;
import java.util.ArrayList;

import de.init.ddltransformer.converter.Converter;
import de.init.ddltransformer.loader.FileReader;
import de.init.ddltransformer.model.Table;
import de.init.ddltransformer.writer.CSVWriter;

public class Main {


	public static void main(String[] args) throws IOException {
		
		String path = "";
		if (args.length == 0) {
			System.out.println("No file was given.");
			System.exit(0);
		} else {
			path = args[0];
		}
		
		ArrayList<Table> tables = new Converter(new FileReader().readFile(path)).parseTables();
		System.out.println("There have been "+ tables.size() + " tables been found.");
		new CSVWriter().createCSV(tables);
		
	}
}
