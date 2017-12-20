package version2;

import java.util.ArrayList;

public class compTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		timeCompTest();
		signalCompTest();
	}

	public static void timeCompTest(){
		ArrayList<String> test= new ArrayList<String>();
		test.add("12:34");
		test.add("12:34");

		if(test.get(0).compareTo(test.get(1)) != 0){
			System.out.println(("timeCompTest failed"));
		}
		else System.out.println("timeCompTest successfully completed");
	}


	public static void signalCompTest(){
		ArrayList<String> test= new ArrayList<String>();
		test.add("-113");
		test.add("-113");

		if(test.get(0).compareTo(test.get(1)) != 0){
			System.out.println(("signalCompTest failed"));
		}
		else System.out.println("signalCompTest successfully completed");

	}
}
