package version10;

import java.util.ArrayList;

public class DataBase {

	private ArrayList<MacSignal> Samples;
	
	private EarthCoordinate macLocation= new EarthCoordinate();
	
	public void getMacLocation(){
		macLocation.getMacLocation("fff");
	}
	
	public void getLocation(){
	
	}
	void readCsv(String fileName);
	
}
