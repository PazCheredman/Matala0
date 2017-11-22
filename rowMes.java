package version6;

public class rowMes {

	//this class is not used at the end!! 
	
	
	private String Time;
	private String ID;
	private String LAT;
	private String LON;
	private String ALT;
	private String SSID;
	private String MAC;
	private String Frequncy;
	private String SIGNAL;


	public void addAll(String time,String id,String lat,String lon,String alt,String ssid,String mac,String frequncy, String signal){
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

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getLAT() {
		return LAT;
	}

	public void setLAT(String lAT) {
		LAT = lAT;
	}

	public String getLON() {
		return LON;
	}

	public void setLON(String lON) {
		LON = lON;
	}

	public String getALT() {
		return ALT;
	}

	public void setALT(String aLT) {
		ALT = aLT;
	}

	public String getSSID() {
		return SSID;
	}

	public void setSSID(String sSID) {
		SSID = sSID;
	}

	public String getMAC() {
		return MAC;
	}

	public void setMAC(String mAC) {
		MAC = mAC;
	}

	public String getFrequncy() {
		return Frequncy;
	}

	public void setFrequncy(String frequncy) {
		Frequncy = frequncy;
	}

	public String getSIGNAL() {
		return SIGNAL;
	}

	public void setSIGNAL(String sIGNAL) {
		SIGNAL = sIGNAL;
	}

	@Override
	public String toString() {
		return ","+ Time+","+ID+","+LAT+","+LON+","+ALT+","+SSID+","+MAC+","+Frequncy+","+SIGNAL;
	}



}
