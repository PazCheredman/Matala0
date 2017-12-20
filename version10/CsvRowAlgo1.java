package version10;

import java.util.List;

public class CsvRowAlgo1 {

	private  double LAT;
	private  double LON;
	private  double ALT;	
	private  double SIGNAL;

	
	/**
	 * 
	 * @param tempfilesArray
	 * @throws ErrorInInputException
	 * 
	 * if setAll !=true throw Exception
	 * 
	 */
	public CsvRowAlgo1(List<String> tempfilesArray) throws ErrorInInputException{
		boolean ok=setAll(tempfilesArray.get(0), tempfilesArray.get(1),
				tempfilesArray.get(2), tempfilesArray.get(3));
		if (!ok){
			throw new ErrorInInputException();
		}
	}
	/**
	 * 
	 * @param lat
	 * @param lon
	 * @param alt
	 * @param signal
	 * 
	 * set all parameters
	 * if input incorrect than throw NumberFormatException exception
	 * @return
	 */
	public boolean setAll(String lat, String lon, String alt, String signal){
		try{
			LAT = Double.parseDouble(lat);
			LON = Double.parseDouble(lon);
			ALT = Double.parseDouble(alt);
			SIGNAL = Double.parseDouble(signal);
		}
		catch(NumberFormatException ex) {
			System.out.print("Error converting doubles\n" + ex);
			return false;
		}
		return true;
	}

	public double getLAT() {
		return LAT;
	}

	public double getLON() {
		return LON;
	}

	public double getALT() {
		return ALT;
	}

	public double getSIGNAL() {
		return SIGNAL;
	}
	
	@Override
	public String toString() {
		return LAT+","+LON+","+ALT+","+SIGNAL+"\n";
	}
}
