package version10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Algorithm {

	/**
	 * Evaluate place of every mac
	 */
	public static void algorithem1(ArrayList<ArrayList<String>> csvArr, String mac) throws IOException{
		//  enter path name here format: "pathAddredd\\mac.csv"
		FileWriter writer = new FileWriter("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\mac.csv");

		// write header line
		writer.write("MAC Recieved: " + mac);




	}

	/**
	 * gets csvAlgo, calculates the weight of the signal by 1/(signal)^2
	 * takes every parameter of the location and duplicates it by the weight of the signal:
	 * wLat= lat*weight
	 * wLon= lon*weight
	 * wAlt= alt*weight
	 */
	public void algoWeight1(){

	}

	/**
	 * gets columns of each parameter and sums it 
	 */
	public void algoSum1(){

	}

	/**
	 * gets the sums of the columns and diverge it by the wSignal
	 */
	public void algoFinalSum1(){

	}

	/**
	 * WiFi: לשיערוך מיקום עצמי לפי דגימות 
	 */
	public static void algorithem2(ArrayList<ArrayList<String>> csvArr){
		System.out.println("please insert 3 mac and signal in this order: 'mac signal' while the signal is negative\n" );
		MacSignal ms = new MacSignal();
		Scanner sc= new Scanner(System.in);
		String mac1 = sc.next();
		String signal1 = sc.next();
		ms.add(signal1, mac1);
		String mac2 = sc.next();
		String signal2 = sc.next();
		ms.add(signal2, mac2);
		String mac3 = sc.next();
		String signal3 = sc.next();
		ms.add(signal3, mac3);


		if(csvArr.get(0).contains(mac1)){
			int count = 0;
			for (int i = 0; i < csvArr.get(0).size() && count < 5; i++) {
				if(csvArr.get(0).get(i).contains(mac1)){
					count++;
					//System.out.println("mac " + csvArr.get(0).get(i) + "  sig "+ csvArr.get(0).get(i+2));
					double weight = algoWeight2(Double.parseDouble(csvArr.get(0).get(i+2)), Double.parseDouble(signal1));
					System.out.println(weight);
				}

			}
		}

	}


	public static double algoWeight2(double sig, double sigInput){
		double diff;
		if(sig == sigInput){
			diff = 100;
		}
		else{
			diff = Math.max(Math.abs(sigInput-sig),3);
		}
		return 1/(Math.pow(diff,0.4 )*Math.pow(sigInput,2 ));

	}

	public void algoSum2(){

	}

}
