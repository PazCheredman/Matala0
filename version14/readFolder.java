package version14;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.activation.FileDataSource;

public class readFolder {
	
	private table tables;
	
	/**
	 * fileName is a folder name that contains the csv files.
	 * @param directory
	 */
	public readFolder(String directory){
		File folder=new File(directory);
		tables=new table();
		File[] files = folder.listFiles();
		for(int i=0; i<files.length; i++){
			directory = files[i].getPath();
			if(directory.contains(".csv"))	{
				readFile(directory);
			}
			continue;
		}		
	}
	/**
	 * read file, parse row and add it to table
	 * @param fileName
	 */
	private void readFile (String fileName){
		// try read from the file
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;

			str = br.readLine();
			List <String> firstLine= Arrays.asList(str.split(","));
			String id = firstLine.get(4);

			str = br.readLine();
			str = br.readLine();
			while(str != null){
				List <String> tempfilesArray= Arrays.asList(str.split(","));
				
				try {
					rowMeasurement row= new rowMeasurement(tempfilesArray,id);
					tables.add(row);
				} catch (ErrorInInputEception e) {
					e.printStackTrace();
				}

				str = br.readLine();

			}
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}
	
	
	public table getTables() {
		return tables;
	}
	
	
	
}
