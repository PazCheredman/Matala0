package version5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import version2.arrayOfArrayRow;
import version2.arrayRowMeasurement;
import version2.rowMeasurement;

public class readFolder {

	private static File folder = new File("C:/Users/InnaPC/Desktop/New folder/Lenovo");
	private static File[] files = folder.listFiles();

	
	public static void readFile (String fileName){
		// try read from the file
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;

			str = br.readLine();
			List <String> firstLine= Arrays.asList(str.split(","));
			String id = firstLine.get(4);

			str = br.readLine();
			//str = br.readLine();
			while(str != null){
				List <String> tempfilesArray= Arrays.asList(str.split(","));
				arrayOfArrayRow temp = new arrayOfArrayRow();
				temp.setID(id);
	//			temp= organizeCsv(temp);
		//		arraysArray.add(temp);
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
	
	
	private static arrayRowMeasurement organizeCsv(arrayRowMeasurement arr){
		arrayRowMeasurement temp = new arrayRowMeasurement();
		temp.addAll(arr.getTime(), arr.getID(), arr.getLAT(), arr.getLON(), arr.getALT(), arr.getSSID(), arr.getMAC(), arr.getFrequncy(), arr.getSIGNAL());
		return temp;
	}
	
}
