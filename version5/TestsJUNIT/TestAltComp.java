package version5.TestsJUNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import version5.BaseClasses.arrayOfArrayRow;
import version5.BaseClasses.arrayRowMeasurement;
import version5.BaseClasses.rowMeasurement;

public class TestAltComp {

	@Test
	public void TestAltCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("alt".equals(rowMeasurement.getALT())==false)
			fail("TestAltComp of RowMeasurement failed");
	}

	@Test
	public void TestAltCompArrayRowMeasurement() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("alt".equals(rowMeasurement.getALT())==false)
			fail("TestAltComp of arrayRowMeasurement failed");
	}

	@Test
	public void TestAltCompArrayOfArray() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("alt".equals(rowMeasurement.getALT())==false)
			fail("TestAltComp of arrayOfArray failed");
	}

}
