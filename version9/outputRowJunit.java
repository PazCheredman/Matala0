package version9;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class outputRowJunit {

	private ArrayList<outputRow> ls;
	private outputRow row;
	private outputRow row1 =new outputRow();
	private List<String> tempfilesArray;

	@Test
	public void testSet() throws ErrorInInputEception {
		tempfilesArray.add("time");
		tempfilesArray.add("id");
		tempfilesArray.add("lat");
		tempfilesArray.add("lon");
		tempfilesArray.add("alt");
		tempfilesArray.add("ssid");
		tempfilesArray.add("mac");
		tempfilesArray.add("frequncy");
		tempfilesArray.add("signal");
		
		rowMeasurement row=new rowMeasurement(tempfilesArray, "id");
		outputRow newRow =new outputRow();
		row.setAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		newRow.set(row.getTime(),row.getID(),row.getLAT(),row.getLON(), row.getALT());
		newRow.addWifi(row.getSSID(), row.getMAC(),row.getFrequncy(), row.getSIGNAL());
		
		ls.add(newRow);
		if(ls.isEmpty())
			fail("Cannot add elements to arrayList");
	}
	
	@Test
	public void testSize() {
		ls.add(row);
		row.set("time", "id", 1.0, 2.0, 3.0);
		row.addWifi("ssid", "mac", 4.0, -5.0);
		ls.add(row1);
		row.set("time1", "id1", 1.1, 2.1, 3.1);
		row.addWifi("ssid1", "mac1", 4.1, -5.1);
		if(ls.size()!=2)
			fail("Not yet implemented");
	}
	
	@Test
	public void testGetRow() {
		row.set("time", "id", 1.0, 2.0, 3.0);
		row.addWifi("ssid", "mac", 4.0, -5.0);
		if(!ls.get(0).equals(row))
				fail("Not yet implemented");
	}

	
	
}
