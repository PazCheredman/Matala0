package version11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Paz Cheredman
 *
 * this class is a container of mac data
 */

public class MacSignal {
	private String mac;
	private ArrayList<locationSignal> data= new ArrayList<>();

	public MacSignal(String mac)
	{
		this.mac = mac;
	}
	public locationSignal get(int index) {
		return data.get(index);
	}
	public int getSize(){
		return data.size();
	}
	
	public String getMac() {
		return mac;
	}
	
	public double getLat(int index){
		return data.get(index).getLat();	
	}
	
	public double getLon(int index){
		return data.get(index).getLon();
	}
	
	public double getAlt(int index){
		return data.get(index).getAlt();
	}
	
	public double getSignal(int index){
		return data.get(index).getSignal();
	}	
	
	/**
	 * add location and signal data for mac
	 */

	public void add(double lat, double lon, double alt,double signal){
		locationSignal locSig = new locationSignal();
		locSig.setAll(lat, lon, alt, signal);
		data.add(locSig);
	}
	


}
