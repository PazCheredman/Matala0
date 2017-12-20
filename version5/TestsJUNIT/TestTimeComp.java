package version5.TestsJUNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import version5.BaseClasses.arrayOfArrayRow;
import version5.BaseClasses.arrayRowMeasurement;
import version5.BaseClasses.rowMeasurement;

public class TestTimeComp {

	@Test
	public void TestTimeCompRowMeasurement() {
		rowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("time".equals(rowMeasurement.getTime())==false)
			fail("TestTimeComp of RowMeasurement failed");
	}

	@Test
	public void TestTimeCompArrayRowMeasurement() {
		arrayRowMeasurement.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("time".equals(rowMeasurement.getTime())==false)
			fail("TestTimeComp of arrayRowMeasurement failed");
	}

	@Test
	public void TestTimeCompArrayOfArray() {
		arrayOfArrayRow.addAll("time", "id", "lat", "lon", "alt", "ssid", "mac", "frequncy", "signal");
		if("time".equals(rowMeasurement.getTime())==false)
			fail("TestTimeComp of arrayOfArray failed");
	}

	
	
	
}

