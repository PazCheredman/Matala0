package version2;

public class arrayOfArrayRow extends arrayRowMeasurement{

	private arrayRowMeasurement arrRowMea;
	private int size;
	
	public arrayRowMeasurement getarrRowMea() {
		return arrRowMea;
	}

	public void setArrRowMea(arrayRowMeasurement arm) {
		this.arrRowMea = arm;
	}
	
	public int Size(){
		return size;
	}
	
	public arrayOfArrayRow(){
		arrayOfArrayRow.addAll(getTime(), getID(), getLAT(), getLON(), getALT(), getSSID(), getMAC(), getFrequncy(), getSIGNAL());
	}

	public arrayRowMeasurement arrayOfArrayRow(arrayRowMeasurement arm) {
		return arm;
	}

	@Override
	public String toString() {
		return "arrayOfArrayRow []"+getRowM();
	}

	
}
