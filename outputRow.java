package version6;

public class outputRow {

	// this is output row in organized csv table builder
	
	
	private String Time,ID;
	private double Lat, Lon, Alt;	private wifiNetworks wifi [];

	private int wifiCount;
	
	public outputRow(){
		wifiCount=0;
		wifi= new wifiNetworks[10];
		for(int i=0; i<10; i++){
			wifi[i]= new wifiNetworks();
		}
	}
	
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

	public int getWifiCount() {
		return wifiCount;
	}
	
}
