package version5.BaseClasses;

public class arrayOfArrayRow extends arrayRowMeasurement{

	private static arrayRowMeasurement aRowM;

	public static arrayRowMeasurement getaRowM() {
		return aRowM;
	}

	public static void setaRowM(arrayRowMeasurement aRowM) {
		arrayOfArrayRow.aRowM = aRowM;
	}

	public arrayOfArrayRow(){
		super();
		arrayOfArrayRow.addAll(getTime(), getID(), getLAT(), getLON(), getALT(), getSSID(), getMAC(), getFrequncy(), getSIGNAL());
	}

	public String toString(){
		return "arrayOfArrayRow []"+getRowM();
	}	
}
