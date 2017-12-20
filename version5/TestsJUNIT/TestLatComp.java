package version5.TestsJUNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import version5.BaseClasses.arrayOfArrayRow;
import version5.BaseClasses.arrayRowMeasurement;
import version5.BaseClasses.rowMeasurement;

public class TestLatComp {

	@Test
	public void TestLatCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lat".equals(rowMeasurement.getLAT())==false)
			fail("TestLatComp of RowMeasurement failed");
	}

	@Test
	public void TestLatCompArrayRowMeasurement() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lat".equals(rowMeasurement.getLAT())==false)
			fail("TestLatComp of arrayRowMeasurement failed");
	}

	@Test
	public void TestLatCompArrayOfArray() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("lat".equals(rowMeasurement.getLAT())==false)
			fail("TestLatComp of arrayOfArray failed");
	}

}
