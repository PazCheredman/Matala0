package version14;

import static org.junit.Assert.*;

import org.junit.Test;

public class rowMeasurementJunit {

	@Test
	public void getTimeTest() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("time".equals(rowMeasurement.getTime())==false)
			fail("getTimeTest failed");
	}

	@Test
	public void getIDTest() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("id".equals(rowMeasurement.getID())==false)
			fail("getIDTest failed");
	}
	@Test
	public void getLatTest() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lat".equals(rowMeasurement.getLAT())==false)
			fail("getLatTest failed");
	}
	@Test
	public void getLonTest() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lon".equals(rowMeasurement.getLON())==false)
			fail("getLonTest failed");
	}
	@Test
	public void getAltTest() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("alt".equals(rowMeasurement.getALT())==false)
			fail("getAltTest failed");
	}
	@Test
	public void getSsidTest() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("ssid".equals(rowMeasurement.getSSID())==false)
			fail("getSSIDTest failed");
	}
	@Test
	public void getMacTest() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("mac".equals(rowMeasurement.getMAC())==false)
			fail("getMacTest failed");
	}
	@Test
	public void getFrequncyTest() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("frequncy".equals(rowMeasurement.getFrequncy())==false)
			fail("getFrequncyTest failed");
	}
	@Test
	public void getSignalTest() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("signal".equals(rowMeasurement.getSIGNAL())==false)
			fail("getSignalTest failed");
	}
	


}
