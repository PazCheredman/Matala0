package version14;

public class locationSignal {
	
	/**
	 * class contains 3 parameters for location+signal: lat, lon, alt, signal
	 */

	private double lat,lon,alt,signal; 
	
	
	
	public String toStringLocation(){
		return lat+","+lon+","+alt;
	}
	
	public String toStringLocationSignal(){
		return lat+","+lon+","+alt+","+signal;
	}
	
	/**
	 * 
	 * @param lat
	 * @param lon
	 * @param alt
	 * @param signal
	 * @return 
	 * 
	 */
	
	public boolean setAll(double lat, double lon, double alt,double signal){
		this.lat=lat;
		this.lon=lon;
		this.alt=alt;
		this.signal=signal;
		return true;
	}

    public double dist(locationSignal ls){
    	double dlat = lat - ls.lat;
    	double dlon = lon - ls.lon;
    	double dalt = alt - ls.alt;
    	return Math.sqrt(dlat * dlat + dlon*dlon + dalt*dalt);
    }
    
	public double getSignal() {
		return signal;
	}

	public void setSignal(double signal) {
		this.signal = signal;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}


	public void setLon(double lon) {
		this.lon = lon;
	}


	public double getAlt() {
		return alt;
	}


	public void setAlt(double alt) {
		this.alt = alt;
	}	
}
