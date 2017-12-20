package version10;

import static org.junit.Assert.*;

import org.junit.Test;

import version4.rowMeasurement;

public class sortAlgoByMacJunit {

	
	
	@Test
	public void test() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		sortAlgoByMac sorter=new sortAlgoByMac();
		if("mac".equals(rowMeasurement.getMAC())==false)
			fail("getMacTest failed");
	}
	

}
