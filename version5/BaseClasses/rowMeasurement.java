package version5.BaseClasses;

public class rowMeasurement {

	private static String Time;
	private static String ID;
	private static String LAT;
	private static String LON;
	private static String ALT;
	private static String SSID;
	private static String MAC;
	private static String Frequncy;
	private static String SIGNAL;


	public static void addAll(String time,String id,String lat,String lon,String alt,String ssid,String mac,String frequncy, String signal){
		Time = time;
		ID = id;
		LAT = lat;
		LON = lon;
		ALT = alt;
		SSID = ssid;
		SIGNAL = signal;
		MAC = mac;
		Frequncy = frequncy;

	}
	
	public static void setTime(String time) {
		Time = time;
	}

	public static void setID(String iD) {
		ID = iD;
	}

	public static void setLAT(String lAT) {
		LAT = lAT;
	}

	public static void setLON(String lON) {
		LON = lON;
	}

	public static void setALT(String aLT) {
		ALT = aLT;
	}

	public static void setSSID(String sSID) {
		SSID = sSID;
	}

	public static void setMAC(String mAC) {
		MAC = mAC;
	}

	public static void setFrequncy(String frequncy) {
		Frequncy = frequncy;
	}

	public static void setSIGNAL(String sIGNAL) {
		SIGNAL = sIGNAL;
	}

	public static String getTime() {
		return Time;
	}
	public static String getID() {
		return ID;
	}
	public static String getLAT() {
		return LAT;
	}
	public static String getLON() {
		return LON;
	}
	public static String getALT() {
		return ALT;
	}
	public static String getSSID() {
		return SSID;
	}
	public static String getSIGNAL() {
		return SIGNAL;
	}
	public static String getMAC() {
		return MAC;
	}
	public static String getFrequncy() {
		return Frequncy;
	}

	@Override
	public String toString() {
		return "rowMeasurement []"+Time+","+ID+","+LAT+","+LON+","+ALT+","+SSID+","+MAC+","+Frequncy+","+SIGNAL;
	}

}
