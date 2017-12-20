package version4;

import static org.junit.Assert.*;

import org.junit.Test;

public class aRmTest {
rowMeasurement rm=new rowMeasurement();

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
	
	//test for arrayRowMeasurement
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
	
	
	//test for arrayOfArrayRow
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
