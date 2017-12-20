package version4;

import java.io.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import version2.rowMeasurement;
import version2.timeComp;
import version2.arrayOfArrayRow;
import version2.arrayRowMeasurement;

public class csvVersion2 {
	private static String fileName;
	private static ArrayList <arrayOfArrayRow> arraysArray = new ArrayList<arrayOfArrayRow>();
	private static ArrayList <arrayRowMeasurement> arraysRow = new ArrayList<arrayRowMeasurement>();
	private static ArrayList <arrayRowMeasurement> arraySortBySignal = new ArrayList<arrayRowMeasurement>();
	private static ArrayList <arrayRowMeasurement> arraySortByTime = new ArrayList<arrayRowMeasurement>();
	private static File folder = new File("C:/Users/InnaPC/Desktop/munhe/Lenovo");
	private static File[] files = folder.listFiles();

	/**
	 * readFile function- trying to read from the file and add it to the array of the row measurement
	 * @param String fileName
	 * @return arrayRowMeasurement
	 */
	public static arrayRowMeasurement readFile (String fileName){
		arrayRowMeasurement temp2 = new arrayRowMeasurement();
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
				rowMeasurement temp = new rowMeasurement();
				temp.setID(id);
				//temp= organizeCsv(temp);
				temp2.setRowM(temp);
				str = br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		return temp2;
	}

	/**
	 * sortArrayByTime function- sorts the array by time
	 * @param ArrayList<rowMeasurement> arr
	 * @return ArrayList<arrayRowMeasurement>
	 */
	public static ArrayList<arrayRowMeasurement> sortArrayByTime(ArrayList<rowMeasurement> arr){
		Collections.sort(arraySortByTime, new timeComp()); //sorts the array by time
		ArrayList <arrayRowMeasurement> result = new ArrayList<>();
		int count = 0;
		int k =1; 
		for (int i = 0; i < arraySortByTime.size()-1; i++) {
			count=0;
			rowMeasurement temp = new rowMeasurement();
			while(arraySortByTime.get(i).getTime().equals(arraySortByTime.get(k).getTime()) && i < arraySortByTime.size() && count <11){
				temp.setTime(arraySortByTime.get(i));
				count++;
				k++;
			}
			//צריך לבדוק שגם אם לא שווים לשורות אחרות בכל זאת להוסיף את השורה הנוכחית של הזמן
			//צריך להוסיף החל מהטור ה6 במידה והזמנים שווים.
			result.add(temp);
			//Collections.sort(arraySortByTime, new signalComp());	
		}
	}

	/**
	 * writeFile function- trying to write the rows into an array of row arrays
	 * @param arrayRowMeasurement arr
	 * @return void
	 */
	/*public static void writeFile (arrayRowMeasurement arr){

		try{
			FileWriter writeCsv = new FileWriter("C:/Users/InnaPC/Desktop/munhe/Lenovo/gmon.csv");
			arrayOfArrayRow temp = new arrayOfArrayRow();
			temp.get().stream().collect(Collectors.joining(","));
		}
		catch(IOException ex) {
			System.out.print("Error writing file\n" + ex);
			System.exit(2);

		}
	}*/
}

