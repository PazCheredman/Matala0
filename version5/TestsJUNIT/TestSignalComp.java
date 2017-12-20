package version5.TestsJUNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import version5.BaseClasses.arrayOfArrayRow;
import version5.BaseClasses.arrayRowMeasurement;
import version5.BaseClasses.rowMeasurement;

public class TestSignalComp {

	@Test
	public void TestSignalCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("signal".equals(rowMeasurement.getSIGNAL())==false)
			fail("TestSignalComp of RowMeasurement failed");
	}

	@Test
	public void TestSignalCompArrayRowMeasurement() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("signal".equals(rowMeasurement.getSIGNAL())==false)
			fail("TestSignalComp of arrayRowMeasurement failed");
	}

	@Test
	public void TestSignalCompArrayOfArray() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("signal".equals(rowMeasurement.getSIGNAL())==false)
			fail("TestSignalComp of arrayOfArray failed");
	}

}
