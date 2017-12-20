package version5.TestsJUNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import version4.arrayOfArrayRow;

public class TestArrayOfArrayRow {

	@Test
	public void getTimeArrayRowTest() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("time".equals(arrayOfArrayRow.getTime())==false)
			fail("getTimeArrayRowTest failed");
	}

	@Test
	public void getIDArrayRowTest() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("id".equals(arrayOfArrayRow.getID())==false)
			fail("getIDArrayRowTest failed");
	}
	@Test
	public void getLatArrayRowTest() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lat".equals(arrayOfArrayRow.getLAT())==false)
			fail("getLatArrayRowTest failed");
	}
	@Test
	public void getLonArrayRowTest() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lon".equals(arrayOfArrayRow.getLON())==false)
			fail("getLonArrayRowTest failed");
	}
	@Test
	public void getAltArrayRowTest() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("alt".equals(arrayOfArrayRow.getALT())==false)
			fail("getAltArrayRowTest failed");
	}
	@Test
	public void getSsidArrayRowTest() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("ssid".equals(arrayOfArrayRow.getSSID())==false)
			fail("getSsidArrayRowTest failed");
	}
	@Test
	public void getMacArrayRowTest() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("mac".equals(arrayOfArrayRow.getMAC())==false)
			fail("getMacArrayRowTest failed");
	}
	@Test
	public void getFrequncyArrayRowTest() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("frequncy".equals(arrayOfArrayRow.getFrequncy())==false)
			fail("getFrequncyArrayRowTest failed");
	}
	@Test
	public void getSignalArrayRowTest() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("signal".equals(arrayOfArrayRow.getSIGNAL())==false){
			fail("getSignalArrayRowTest failed");
		}
	}


}
