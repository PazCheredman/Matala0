package version10;

import java.util.Comparator;

public class sortAlgoByMac implements Comparator<rowMeasurement>{

	/**
	 * this class is a comparator of mac
	 */

	public int compare(rowMeasurement o1, rowMeasurement o2) {
		//compare mac
		int res;
		if(o1.getMAC().equals(o2.getMAC())){
			res =1;
		}
		else res=0;
		if(res!=0) return res;

		return 0;
	}

}
