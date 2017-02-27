package de.init.ddltransformer.converter;

import java.util.ArrayList;

import de.init.ddltransformer.model.Table;

public class Converter {

	ArrayList<String> queries = new ArrayList<String>();
	
	public Converter(ArrayList<String> queries){
		this.queries = queries;
	}
	
	public ArrayList<Table> parseTables(){
		ArrayList<Table> localQueries = new ArrayList<Table>();
		for(String line: queries){
			if(line.contains("DDL for Table")){
				Table table = new Table(getName(line));
				table = fillElements(line, table);
				localQueries.add(table);
			}	
		}
		return localQueries;	
	}
	
	private String getName(String line){
		String name = line.substring(74, line.indexOf("CREATE"));
		name = name.replaceAll("-", "");
		return name;
	}
	
	private Table fillElements(String line, Table table){
		
		String index = "CREATE TABLE \"IFOS_APP\".";
		String elements = line.substring(line.indexOf(index), line.indexOf("SEGMENT CREATION"));
		elements = elements.substring(elements.indexOf("(") + 1, elements.lastIndexOf(")"));
		String[] items = elements.split("\\t");
		for(String item:items){
			item = item.trim();
			if(item.isEmpty())
				continue;
			String key = item.substring(0, item.indexOf(" ")).replaceAll("\"", "");
			String value = item.substring(item.indexOf(" ")+1,item.length()-1);	
			table.addElement(key, value);			
		}
		return table;
	}
	
	
}
