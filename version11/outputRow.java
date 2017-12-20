package version11;

import java.util.List;

/**
 * 
 * 
 *
 */
public class outputRow {

	private String Time,ID;
	private double Lat, Lon, Alt;
	private wifiNetworks wifi [];

	private int wifiCount;

	/**
	 * this is output row in organized csv table builder
	 */
	public outputRow(){
		wifiCount=0;
		wifi= new wifiNetworks[10];
		for(int i=0; i<10; i++){
			wifi[i]= new wifiNetworks();
		}
	}

	/**
	 * adds ssid mac frequency and signal to the wifi columns 
	 * @param ssid
	 * @param mac
	 * @param frequncy
	 * @param signal
	 */
	public void addWifi(String ssid, String mac, double frequncy,double signal){
		wifi[wifiCount].setSsid(ssid);
		wifi[wifiCount].setMac(mac);
		wifi[wifiCount].setFrequncy(frequncy);
		wifi[wifiCount].setSignal(signal);
		wifiCount++;

	}

	public String toString(){
		String ans="";
		ans+=Time+","+ID+","+Lat+","+Lon+","+Alt+","+wifiCount;
		for(int i=0; i<wifiCount; i++){
			ans+=","+wifi[i].toString();
		}
		return ans;
	}

	public boolean set(String time, String id, double lat, double lon, double alt){
		if(time==null || id==null ) return false;
		this.Time=time; 
		this.ID=id;
		this.Lat=lat;
		this.Lon=lon;
		this.Alt=alt;
		return true;
	}

	wifiNetworks getWifi(int index) {
		return wifi[index];
	}


	public int getWifiCount() {
		return wifiCount;
	}

	public double getSignal(String mac) {
		for (int i=0; i<wifiCount; i++) {
			if (wifi[i].getMac().equals(mac))
				return wifi[i].getSignal();
		}
		return Double.NaN;
	}

	public double getSignal(int index) {
		return wifi[index].getSignal();
	}
	
	public boolean haveAnyMac(List<String> macs) {
		for(int i=0; i<macs.size(); i++){
			for (int j=0; j<wifiCount; j++) {
				if(macs.get(i).equals(wifi[j].getMac())) 
					return true;
			}
		}
		return false;
	}
    public void setLocation(double lat,double lon,double alt) {
    	this.Lat = lat;
    	this.Lon = lon;
    	this.Alt = alt;
    }
	
    public double getLat() {
		return Lat;
	}

	public double getLon() {
		return Lon;
	}

	public double getAlt() {
		return Alt;
	}

	public String getMac(int index){
		return wifi[index].getMac();
	}
	
	public String getId(){
		return ID;
	}
	
	public String getTime(){
		return Time;
	}

}
