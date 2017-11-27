package version8;

import static org.junit.Assert.*;

import org.junit.Test;

import version5.BaseClasses.rowMeasurement;

public class sortCompJunit {

	@Test
	public void TestTimeCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("time".equals(rowMeasurement.getTime())==false)
			fail("TestTimeComp of RowMeasurement failed");
	}


	@Test
	public void TestSignalCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("signal".equals(rowMeasurement.getSIGNAL())==false)
			fail("TestSignalComp of RowMeasurement failed");
	}

	@Test
	public void TestLonCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lon".equals(rowMeasurement.getLON())==false)
			fail("TestAltComp of RowMeasurement failed");
	}

	@Test
	public void TestLatCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lat".equals(rowMeasurement.getLAT())==false)
			fail("TestLatComp of RowMeasurement failed");
	}
	
	@Test
	public void TestAltCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("alt".equals(rowMeasurement.getALT())==false)
			fail("TestAltComp of RowMeasurement failed");
	}
	
	
}
