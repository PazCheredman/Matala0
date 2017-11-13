package munhe;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Csv {
	private static String fileName;
	private static ArrayList <ArrayList <String>> arraysArray = new ArrayList<ArrayList <String>>();
	private static ArrayList <ArrayList <String>> arraySortBySignal = new ArrayList<ArrayList <String>>();
	private static ArrayList <ArrayList <String>> arraySortByTime = new ArrayList<ArrayList <String>>();
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
				ArrayList <String> temp = new ArrayList<String>(tempfilesArray);
				temp.add(id);
				temp= organizeCsv(temp);
				arraysArray.add(temp);
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

	private static ArrayList<String> organizeCsv(ArrayList<String> arr){
		ArrayList <String> temp = new ArrayList<String>();
		temp.add(arr.get(3));
		temp.add(arr.get(11));
		temp.add(arr.get(6));
		temp.add(arr.get(7));
		temp.add(arr.get(8));
		temp.add(arr.get(1));
		temp.add(arr.get(0));
		temp.add(arr.get(4));
		temp.add(arr.get(5));
		return temp;
	}

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
				
//			if(arraySortByTime.get(i).get(2) == arraySortByTime.get(i+1).get(2))
//				System.out.println(arraySortByTime.get(i).get(2));
		}
			if(count > 10){
				Collections.sort(arraySortBySignal, new signalComp());
			}
		}
	}

	public static void main(String[] args) throws URISyntaxException,IOException {
		for(int i=0; i<files.length; i++){
			fileName = files[i].getPath();
			readFile(fileName);
		}
		sortArray(arraysArray);
		for (int i = 0; i < arraysArray.size(); i++) 
			System.out.println(arraysArray.get(i));
	}
}


