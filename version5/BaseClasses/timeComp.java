package version5.BaseClasses;

import java.util.ArrayList;
import java.util.Comparator;

public class timeComp implements Comparator<arrayRowMeasurement>{

	@Override
	public int compare(arrayRowMeasurement arg0, arrayRowMeasurement arg1) {
		// TODO Auto-generated method stub

		return arg0.getTime().compareTo(arg1.getTime());
	}


}
