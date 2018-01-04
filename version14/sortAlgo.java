package version14;

import java.util.Comparator;

public class sortAlgo implements Comparator<rowMeasurement>{

	/**
	 * this class is a comparator of signal
	 */

	public int compare(rowMeasurement o1, rowMeasurement o2) {
		//compare signal
		int res;
		if(o1.getSIGNAL() > o2.getSIGNAL()){
			res =1;
		}
		else if(o1.getSIGNAL() < o2.getSIGNAL()){
			res=-1;
		}
		else res=0;
		if(res!=0) return res;

		return 0;
	}

}
