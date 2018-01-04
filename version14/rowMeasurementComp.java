package version14;

import java.util.Comparator;

public class rowMeasurementComp implements Comparator<rowMeasurement>{

/**
 * 	this class is a comparator of time, id, lat, lon, alt, signal
 */
	
	@Override
	public int compare(rowMeasurement o1, rowMeasurement o2) {
		//compare time 
		int res=o1.getTime().compareTo(o2.getTime());
		if(res!=0) return res;
	
		//compare id
		res=o1.getID().compareTo(o2.getID());
		if(res!=0) return res;
		
		//compare lat
		if(o1.getLAT() > o2.getLAT()){
			res =1;
		}
		else if(o1.getLAT() < o2.getLAT()){
			res=-1;
		}
		else res=0;
		if(res!=0) return res;
		
		//compare lon
		if(o1.getLON() > o2.getLON()){
			res =1;
		}
		else if(o1.getLON() < o2.getLON()){
			res=-1;
		}
		else res=0;
		if(res!=0) return res;
		
		//compare alt
		if(o1.getALT() > o2.getALT()){
			res =1;
		}
		else if(o1.getALT() < o2.getALT()){
			res=-1;
		}
		else res=0;
		if(res!=0) return res;
		
		//compare signal
		if(o1.getSIGNAL() > o2.getSIGNAL()){
			res =-1;
		}
		else if(o1.getSIGNAL() < o2.getSIGNAL()){
			res=1;
		}
		else res=0;
		if(res!=0) return res;
		
		return 0;
	}

	
}
