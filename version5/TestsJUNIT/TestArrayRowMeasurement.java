package version5.TestsJUNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import version4.arrayRowMeasurement;

public class TestArrayRowMeasurement {

	@Test
	public void getTimeRowTest() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("time".equals(arrayRowMeasurement.getTime())==false)
			fail("getTimeRowTest failed");
	}

	@Test
	public void getIDRowTest() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("id".equals(arrayRowMeasurement.getID())==false)
			fail("getIDRowTest failed");
	}
	@Test
	public void getLatRowTest() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lat".equals(arrayRowMeasurement.getLAT())==false)
			fail("getLatRowTest failed");
	}
	@Test
	public void getLonRowTest() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lon".equals(arrayRowMeasurement.getLON())==false)
			fail("getLonRowTest failed");
	}
	@Test
	public void getAltRowTest() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("alt".equals(arrayRowMeasurement.getALT())==false)
			fail("getAltRowTest failed");
	}
	@Test
	public void getSsidRowTest() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("ssid".equals(arrayRowMeasurement.getSSID())==false)
			fail("getSsidRowTest failed");
	}
	@Test
	public void getMacRowTest() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("mac".equals(arrayRowMeasurement.getMAC())==false)
			fail("getMacRowTest failed");
	}
	@Test
	public void getFrequncyRowTest() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("frequncy".equals(arrayRowMeasurement.getFrequncy())==false)
			fail("getFrequncyRowTest failed");
	}
	@Test
	public void getSignalRowTest() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("signal".equals(arrayRowMeasurement.getSIGNAL())==false){
			fail("getSignalRowTest failed");
		}
	}

}
