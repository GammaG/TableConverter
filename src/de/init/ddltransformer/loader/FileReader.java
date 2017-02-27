package de.init.ddltransformer.loader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {

	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;

	public ArrayList<String> readFile(String path) throws IOException {
		
		try {
			// open input stream test.txt for reading purpose.
			is = new FileInputStream(path);

			// create new input stream reader
			isr = new InputStreamReader(is);

			// create new buffered reader
			br = new BufferedReader(isr);

			String currentLine;
			StringBuffer stringBuffer = new StringBuffer();
			// reads to the end of the stream
			while ((currentLine = br.readLine()) != null) {
				stringBuffer.append(currentLine);
			}
			return splitQuery(stringBuffer.toString());	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// releases resources associated with the streams
			if (is != null)
				is.close();
			if (isr != null)
				isr.close();
			if (br != null)
				br.close();
		}
		return null;
	}
	
	private ArrayList<String> splitQuery(String fullQuery){
		ArrayList<String> arrayList = new ArrayList<>();
		String[] queries = fullQuery.split("[;]+");
		for(String query: queries){
			arrayList.add(query);
		}		
		return arrayList;
	}
}
