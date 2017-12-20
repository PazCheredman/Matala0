package version9;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
//import com.opencsv.CSVReader;
import java.util.Scanner;

public class csv {
	private table inTab;
	private outputTable outTab;

	/**
	 * enter path name here
	 */
	public void read(){
		readFolder rf= new readFolder("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10");
		inTab=rf.getTables();
	}

	/**
	 * Processing data and creating new output table
	 */
	public void process(){
		outTab = new outputTable();
		inTab.sort();
		outputRow newRow= new outputRow();
		sortComp sorter= new sortComp();
		boolean first=false;
		rowMeasurement row =inTab.getRow(0);
		newRow.set(row.getTime(),row.getID(),row.getLAT(),row.getLON(), row.getALT());
		newRow.addWifi(row.getSSID(), row.getMAC(),row.getFrequncy(), row.getSIGNAL());

		for(int i=1; i<inTab.size(); i++){
			row =inTab.getRow(i);
			newRow.set(row.getTime(),row.getID(),row.getLAT(),row.getLON(), row.getALT());
			if(sorter.compare(row,inTab.getRow(i-1))==0 || first){
				first=false;
				if(newRow.getWifiCount()<10){
					newRow.addWifi(row.getSSID(), row.getMAC(),row.getFrequncy(), row.getSIGNAL());
				}
				else continue;
			}
			else{
				first= true;
				outTab.add(newRow);
				newRow= new outputRow();
			}
		}
	}

	/**
	 * writing new csv table
	 * @throws IOException
	 */
	public void write() throws IOException{ 
		/**
		 *  enter path name here format: "pathAddredd\\filename.csv"
		 */
		FileWriter writer = new FileWriter("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon.csv");
		/**
		 * write header line
		 */
		writer.write("Time"+","+"ID"+","+"Lat"+","+"Lon"+","+"Alt"+","+"#WiFi networks"+
				","+"SSID1"+","+"MAC1"+","+"Frequncy1"+","+"Signal1"+
				","+"SSID2"+","+"MAC2"+","+"Frequncy2"+","+"Signal2"+
				","+"SSID3"+","+"MAC3"+","+"Frequncy3"+","+"Signal3"+
				","+"SSID4"+","+"MAC4"+","+"Frequncy4"+","+"Signal4"+
				","+"SSID5"+","+"MAC5"+","+"Frequncy5"+","+"Signal5"+
				","+"SSID6"+","+"MAC6"+","+"Frequncy6"+","+"Signal6"+
				","+"SSID7"+","+"MAC7"+","+"Frequncy7"+","+"Signal7"+
				","+"SSID8"+","+"MAC8"+","+"Frequncy8"+","+"Signal8"+
				","+"SSID9"+","+"MAC9"+","+"Frequncy9"+","+"Signal9"+
				","+"SSID10"+","+"MAC10"+","+"Frequncy10"+","+"Signal10");

		for(int i=0; i<outTab.size(); i++){
			outputRow row= outTab.getRow(i);
			if(row.getWifiCount()>0){
				writer.write(row.toString());
				writer.write("\n");
			}
		}	
		writer.close();
	}

	public String toString() {
		return inTab.toString();
	}

	public static void main(String [] args) throws IOException{
		csv tab=new csv();
		tab.read();
		tab.process();
		tab.write();
		System.out.println("go to folder C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10 to see the files");
	}
}
