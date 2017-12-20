package version10;

import java.io.FileWriter;
import java.io.IOException;

public class Algorithem {

	/**
	 * Evaluate place of every mac
	 */
	public void algorithem1(String mac, double signal) throws IOException{
	
		/**
		 * function that writes to csvAlgo:
		 * row0: header line: mac received
		 * row1: header line: "lat, lon, alt, signal"
		 * row2-csv.size(): data received
		 */
		
		// enter path name here format: "pathAddredd\\mac.csv"
		FileWriter writer = new FileWriter("C:\\Users\\InnaPC\\Desktop\\munhe\\data\\mac.csv");
		
		// write header line
		writer.write("MAC Recieved: " + mac);
		writer.write("\n");
		writer.write("Lat"+","+"Lon"+","+"Alt"+","+"signal");
		
		for (int i=0; i<csv.size(); i++) {
			
		}

		
		

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
	public void algorithem2(){


	}
	
	public void algoWeight2(){

	}
	
	public void algoSum2(){

	}
}
