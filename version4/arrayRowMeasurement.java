package version4;

public class arrayRowMeasurement extends rowMeasurement {

	private static rowMeasurement rowM;
	private static int counter=0;
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int count) {
		counter = count;
	}

	public static rowMeasurement getRowM() {
		return rowM;
	}

	public static void setRowM(rowMeasurement rm) {
		rowM = rm;
	}
	
	public arrayRowMeasurement(){
		super();
		rowMeasurement.getTime();
		rowMeasurement.getID();
		rowMeasurement.getLAT();
		rowMeasurement.getLON();
		rowMeasurement.getALT();
		rowMeasurement.getSSID();		
		rowMeasurement.getMAC();
		rowMeasurement.getFrequncy();
		rowMeasurement.getSIGNAL();
	}
	
	public String toString(){
		return rowMeasurement.getTime()+","+rowMeasurement.getID()+","+rowMeasurement.getLAT()+","+rowMeasurement.getLON()+","+rowMeasurement.getALT()+","+rowMeasurement.getSSID()+","+rowMeasurement.getMAC()+","+rowMeasurement.getFrequncy()+","+rowMeasurement.getSIGNAL();
	}	
}
