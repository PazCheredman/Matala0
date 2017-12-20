package version5.TestsJUNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import version5.BaseClasses.arrayOfArrayRow;
import version5.BaseClasses.arrayRowMeasurement;
import version5.BaseClasses.rowMeasurement;

public class TestLonComp {

	@Test
	public void TestLonCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lon".equals(rowMeasurement.getLON())==false)
			fail("TestAltComp of RowMeasurement failed");
	}

	@Test
	public void TestLonCompArrayRowMeasurement() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lon".equals(rowMeasurement.getLON())==false)
			fail("TestAltComp of arrayRowMeasurement failed");
	}

	@Test
	public void TestLonCompArrayOfArray() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lon".equals(rowMeasurement.getLON())==false)
			fail("TestAltComp of arrayOfArray failed");
	}

}
