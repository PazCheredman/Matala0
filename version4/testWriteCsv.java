package version4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import munhe.CsvNew;

public class testWriteCsv {
	private static String fileName;
	private static File folder = new File("C:/Users/InnaPC/Desktop/munhe/Lenovo");
	private static File[] files = folder.listFiles();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1line();
		
	}
	public static void test1line(){
		for(int i=0; i<files.length; i++){
			fileName = files[i].getPath();
			System.out.println(csvVersion2.readFile(fileName));
		} 
		
		/*ArrayList <ArrayList <String>> st = new ArrayList <ArrayList <String>>();
		st.add(new ArrayList<String>());
		st.get(0).add("hello");
		Collections.addAll(st.get(0), "time", "id", "vt", "ddd", "ffff", "ddd", "ssss", "ccc", "fmfn", "xxxx");
		CsvNew.writeFile(st);*/
	}
	public static void test2line(){
		ArrayList <ArrayList <String>> st = new ArrayList <ArrayList <String>>();
		st.add(new ArrayList<String>());
		st.get(0).add("hello");
		Collections.addAll(st.get(0), "time", "id", "vt", "ddd");
		st.add(new ArrayList<String>());
		st.get(1).add("hello");
		Collections.addAll(st.get(1),"ffff", "ddd", "ssss", "ccc", "fmfn", "xxxx");
		CsvNew.writeFile(st);
	}
	
	public static void sortArrayByTime(){
		ArrayList <ArrayList <String>> st = new ArrayList <ArrayList <String>>();
		st.add(new ArrayList<String>());
		Collections.addAll(st.get(0), "2017-10-27 16:16:26");
		st.add(new ArrayList<String>());
		Collections.addAll(st.get(1), "2017-10-27 16:16:56");
		st.add(new ArrayList<String>());
		Collections.addAll(st.get(2), "2017-10-27 16:16:36");
		st.add(new ArrayList<String>());
		Collections.addAll(st.get(3), "2017-10-27 16:16:54");
		st.add(new ArrayList<String>());
		Collections.addAll(st.get(4), "2017-10-27 16:16:54");
		System.out.println(CsvNew.sortArrayByTime(st));
	}

}
