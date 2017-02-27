package de.init.ddltransformer.model;

import java.util.HashMap;

public class Table {

	private String name;
	private HashMap<String,String> elementsMap = new HashMap<>();
	
	public Table(String name){
		this.name = name;
	}
	
	public void addElement(String key, String value){
		elementsMap.put(key, value);
	}

	public String getName() {
		return name;
	}

	public HashMap<String, String> getElementsMap() {
		return elementsMap;
	}

	@Override
	public String toString() {
		return "Table [name=" + name + ", elementsMap=" + elementsMap + "]";
	}
	
	
	
}
