package version7;

public class wifiNetworks {
	
	//class contains 4 parameters for wifi network: ssid, mac, frequncy, signal
	
	
	private String ssid=new String(); 
	private String mac=new String();
	private double frequncy, signal;
	
	public String toString(){
		return ssid+","+mac+","+frequncy+","+signal;
	}
	

	public boolean setAll(String ssid,String mac,double frequncy, double signal){
		this.ssid=ssid;
		this.mac= mac;
		this.frequncy=frequncy;
		this.signal=signal;
		return true;
	}
	

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public void setFrequncy(double frequncy) {
		this.frequncy = frequncy;
	}

	public void setSignal(double signal) {
		this.signal = signal;
	}
}
