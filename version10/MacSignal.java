package version10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MacSignal {
	private static String mac;
	private static String signal;
	ArrayList<String> MacSignal =  new ArrayList<String>();
	private static ArrayList<ArrayList<String>> csvArray = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName= "C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon.csv";
		readCsvFile(fileName);
		Algorithm.algorithem1(csvArray,fileName);
		Algorithm.algorithem2(csvArray);
	}

	/**
	 * 
	 * @param signal
	 * @param mac
	 * this function adds mac & signal to array
	 */
	public void add(String signal, String mac){
		MacSignal.add(mac);
		MacSignal.add(signal);
	}

	public int getSize(){
		return MacSignal.size();
	}

	/**
	 * 
	 * @param fileName
	 * this function reads csv created at EX0
	 */
	public static void readCsvFile (String fileName){
		ArrayList<String> temp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;

			str = br.readLine();
			str = br.readLine();
			List <String> secondLine= Arrays.asList(str.split(","));
			for (int i = 7; i < 47; i = i+2) {
				if(secondLine.size() >= i){
					mac = secondLine.get(i);
					signal = secondLine.get(i);
				}
			}

			temp.addAll(secondLine);
			csvArray.add(temp);

			while(str != null){
				List <String> tempfilesArray= Arrays.asList(str.split(","));
				for (int i = 7; i < 47; i = i+2) {
					if(tempfilesArray.size() >= i){
						mac = tempfilesArray.get(i);
						signal = tempfilesArray.get(i);
					}
				}
				temp.addAll(tempfilesArray);
				csvArray.add(temp);
				str = br.readLine();
			}
			str = br.readLine();
			str = br.readLine();
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}

}
