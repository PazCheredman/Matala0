package version5;

import java.io.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import version2.arrayOfArrayRow;
import version2.arrayRowMeasurement;
import version2.rowMeasurement;

public class Csv {
	private static String fileName;
	private static rowMeasurement row= new rowMeasurement();
	private static arrayRowMeasurement arrRow= new arrayRowMeasurement();
	private static arrayOfArrayRow arrayArray = new arrayOfArrayRow();
	//	private static ArrayList <ArrayList <String>> arraySortBySignal = new ArrayList<ArrayList <String>>();
	// 	private static ArrayList <ArrayList <String>> arraySortByTime = new ArrayList<ArrayList <String>>();
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
			str = br.readLine();
			while(str != null){
				List <String> tempfilesArray= Arrays.asList(str.split(","));
				arrayRowMeasurement temp = new arrayRowMeasurement();
				temp.setID(id);;
				temp= organizeCsv(temp);
				arrayArray.setArrRowMea(temp);
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

	/*public static void main(String[] args) throws URISyntaxException,IOException {
		for(int i=0; i<files.length; i++){
			fileName = files[i].getPath();
			if(fileName.contains(".csv")==true)	{
				readFile(fileName);
			}
			continue;
		}*/

	/*sortArray(arraysArray);
		for (int i = 0; i < arraysArray.size(); i++) 
			System.out.println(arraysArray.get(i));
	}*/



	//	public static void writeCsv(ArrayList arrayList) throws IOException{
	//		String input = "[";
	//		for (int i = 0; i < arraysArray.size(); i++) {
	//			input += ""+arraysArray.get(i);
	//		}
	//		input = input.substring(1, input.length()); // get rid of brackets
	//		String[] split = input.split(",");
	//		FileWriter writer = new FileWriter("C:/Users/InnaPC/Desktop/New folder/gmon.csv");
	//		List<String> test = new ArrayList<>();
	//		for (int i = 0; i < arraysArray.size(); i++) {
	//			test.addAll(arraysArray.get(i));
	//			writer.write("\n");
	//		}
	//		String collect = test.stream().collect(Collectors.joining(","));
	//		//System.out.println(collect);
	//		writer.write(collect);
	//		writer.close();
	//
	//	}
	/*
	private static void sortArray(ArrayList<ArrayList<String>> arr){
		arraySortByTime = arr;
		Collections.sort(arraySortByTime, new timeComp());
		ArrayList <String> temp = new ArrayList<String>();
		int count = 0;
		int k =1; 
		for (int i = 0; i < arraySortByTime.size(); i++) {
			while(arraySortByTime.get(i) == arraySortByTime.get(k) && i < arraySortByTime.size()){
				temp.addAll(arraySortByTime.get(i));
				count++;
				k++;
	 */			
	//			if(arraySortByTime.get(i).get(2) == arraySortByTime.get(i+1).get(2))
	//				System.out.println(arraySortByTime.get(i).get(2));
	//	if(count > 10){
	//	Collections.sort(arraySortBySignal, new signalComp());




	public static void main(String[] args) throws URISyntaxException,IOException {
		for(int i=0; i<files.length; i++){
			fileName = files[i].getPath();
			if(fileName.contains(".csv")==true)	{
				readFile(fileName);
			}
			continue;
		}
		
		for (int i = 0; i < arrayArray.Size(); i++){ 
			System.out.println(arrayArray.getarrRowMea().getRowM());
	}
		/*
		sortArray(arraysArray);
		*/
	}
}