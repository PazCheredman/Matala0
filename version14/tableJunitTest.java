package version14;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class tableJunitTest {

	/**
	 * checks the add function in table class
	 * @throws ErrorInInputEception
	 */
	@Test
	public void testTable() throws ErrorInInputEception {
		List<String> ls = Arrays.asList("Hello", "Worl", "Wor", "11", "55", "13", "12", "55", "22");
		String id = "012";
		rowMeasurement row = new rowMeasurement(ls, id);
		table tb = new table();
		tb.add(row);
		if(tb.size() == 0)
			fail("Not yet implemented");
	}

}
