package version7;

import java.io.IOException;

public class rowMeasurement {
	//this class contains the parameters of csv table
	
	
	private  String Time;
	private  String ID;
	private  double LAT;
	private  double LON;
	private  double ALT;
	private  String SSID;
	private  String MAC;
	private  double Frequncy;
	private  double SIGNAL;


	public boolean setAll(String time,String id,String lat,String lon,String alt,String ssid,String mac,String frequncy, String signal){
		Time = time;
		ID = id;
		SSID = ssid;
		MAC = mac;
		try{
			LAT = Double.parseDouble(lat);
			LON = Double.parseDouble(lon);
			ALT = Double.parseDouble(alt);
			SIGNAL = Double.parseDouble(signal);
			Frequncy = Double.parseDouble(frequncy);
		}
		catch(NumberFormatException ex) {
			System.out.print("Error converting doubles\n" + ex);
			return false;
		}
		return true;
	}

	public String getTime() {
		return Time;
	}

	public String getID() {
		return ID;
	}

	public double getLAT() {
		return LAT;
	}

	public double getLON() {
		return LON;
	}

	public double getALT() {
		return ALT;
	}

	public double getSIGNAL() {
		return SIGNAL;
	}

	public String getSSID() {
		return SSID;
	}

	public String getMAC() {
		return MAC;
	}

	public double getFrequncy() {
		return Frequncy;
	}

	@Override
	public String toString() {
		return Time+","+ID+","+LAT+","+LON+","+ALT+","+SSID+","+MAC+","+Frequncy+","+SIGNAL+"\n";
	}

}
