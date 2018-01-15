package version14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class main {

	/**
	 * runs algorithms 1, 2, and filters 
	 * @param args
	 * @throws IOException
	 */

	private String csvPath;
	private String wigglePath;


	public String getCsvPath() {
		return csvPath;
	}

	public void setCsvPath(String dataPath) {
		this.csvPath = dataPath;
	}

	public String getWigPath() {
		return wigglePath;
	}

	public void setWigPath(String wigPath) {
		this.wigglePath = wigPath;
	}



	/**
	 * algorithm 1 : given specific mac, it calculate its' location by lat lon alt parameters
	 * @throws IOException
	 */
	public void algorithm1(String path) throws IOException{
		//EX2:algorithm1
		MacSignalContainer msc= new MacSignalContainer(path);
		Algorithm1 algo1= new Algorithm1();
		algo1.setSignalData(msc);
		String sub= path.substring(0,path.length()-9);
		algo1.algorithem1(sub+"\\alg1.csv");
	}

	/**
	 * algorithm 2 : 
	 * option A -enter file name .csv and it will show you the accurate location by the whole row.
	 * option B- enter 3 pairs of mac and signal and it will show you the accurate location by these pairs.
	 * @throws IOException
	 */


	public void algorithm2OptionA(String path, String pathAll,String pathMiss) throws IOException{
		//EX2:algorithm2OptionA
		MacSignalContainer msc= new MacSignalContainer(path);
		outputTable data =new outputTable();
		data.read(pathAll, false);
		outputTable input =new outputTable();
		input.read(pathMiss, false);

		locationSignal ls;
		for (int i = 0; i <input.size(); i++) {
			List<String> macs = new ArrayList<>();
			List<Double> signals = new ArrayList<>();
			outputRow row= input.getRow(i);
			for (int j = 0; j < row.getWifiCount(); j++) {
				macs.add(row.getMac(j));
				signals.add(row.getSignal(j));	
			}

			Algorithm2 algo2= new Algorithm2(); 
			ls = algo2.algorithem2(data, macs, signals);
			if(ls !=null){
				row.setLocation(ls.getLat(), ls.getLon(), ls.getAlt());		
			}
		}
		String sub= path.substring(0,path.length()-9);
		input.write(sub+"\\alg2OptionA.csv");
	}


	public void algorithm2OptionB(String path,String mac1,String signal1,String mac2,String signal2,String mac3,String signal3) throws IOException{
		//EX2:algorithm2OptionB
		List<String> macs = new ArrayList<>();
		List<Double> signals = new ArrayList<>();
		macs.add(mac1);
		signals.add(Double.parseDouble(signal1));
		macs.add(mac2);
		signals.add(Double.parseDouble(signal2));
		macs.add(mac3);
		signals.add(Double.parseDouble(signal3));

		locationSignal ls = new locationSignal();
		outputTable input =new outputTable();
		input.read(path, true);
		for (int k = 0; k <input.size(); k++){
			outputRow row = input.getRow(k);
			Algorithm2 algo2= new Algorithm2(); 
			ls = algo2.algorithem2(input, macs, signals);
			if(ls !=null){
				row.setLocation(ls.getLat(), ls.getLon(), ls.getAlt());		
			}
		}
		String sub= path.substring(0,path.length()-9);
		input.write(sub+"\\alg2OptionB.csv");
		JOptionPane.showMessageDialog(null, "this is the sum average of the router: " + ls.toStringLocation());
	}


	public void radius(String path, String lat1, String lon1, String alt1, String rad1, boolean NotFilter) throws IOException{
		//EX1: Algorithm3- searchByRadious
		Algorithm3 searchRad =new Algorithm3();
		outputTable tbl =new outputTable();
		tbl.read(path,true);
		searchRad.setSignalData(tbl); 
		double lat=Double.parseDouble(lat1);
		double lon=Double.parseDouble(lon1);	
		double alt=Double.parseDouble(alt1);
		double radious=Double.parseDouble(rad1);	

		if(!NotFilter){
			outputTable output= searchRad.searchByRadious(lat, lon, alt, radious);
			if(output.size()>0){
				String sub= path.substring(0, path.length()-9);
				String file= sub+"\\rad.csv";
				output.write(file);
			}
			else {
				JOptionPane.showMessageDialog(null, "no wifi networks within range found");
			}
		}
		else{
			outputTable output= searchRad.searchByRadiousNot(lat, lon, alt, radious);
			if(output.size()>0){
				String sub= path.substring(0, path.length()-9);
				String file= sub+"\\radNOT.csv";
				output.write(file);
			}
			else {
				JOptionPane.showMessageDialog(null, "no wifi networks within range found");
			}
		}
	}



	/**
	 * filter searches by range location inserted in the csv gmon and outputs a new csv
	 * @throws IOException
	 */
	public void location(String path, String latmin, String lonmin, String altmin,
			String latmax, String lonmax, String altmax, boolean NotFilter) throws IOException{
		//EX3: Algorithm3- searchBylocation
		Algorithm3 searchRad =new Algorithm3();
		outputTable tbl =new outputTable();
		tbl.read(path,true);
		searchRad.setSignalData(tbl); 
		double latMin=Double.parseDouble(latmin);
		double lonMin=Double.parseDouble(lonmin);
		double altMin=Double.parseDouble(altmin);
		double latMax=Double.parseDouble(latmax);
		double lonMax=Double.parseDouble(lonmax);	
		double altMax=Double.parseDouble(altmax);

		if(!NotFilter){
			outputTable output= searchRad.searchByLocation(latMax, lonMax, altMax, latMin, lonMin, altMin);
			if(output.size()>0){
				String sub= path.substring(0,path.length()-9);
				String file= sub+"\\locFil.csv";
				output.write(file);
			}

			else {
				JOptionPane.showMessageDialog(null, "no wifi networks within range found");
			}
		}
		else{
			outputTable output= searchRad.searchByLocationNot(latMax, lonMax, altMax, latMin, lonMin, altMin);
			if(output.size()>0){
				String sub= path.substring(0,path.length()-9);
				String file= sub+"\\locFilNOT.csv";
				output.write(file);
			}

			else {
				JOptionPane.showMessageDialog(null, "no wifi networks within range found");
			}
		}
	}

	/**
	 * filter searches by id inserted in the csv gmon and outputs a new csv and kml
	 * @throws IOException
	 */
	public void id(String path, String id, boolean NotFilter) throws IOException{
		//EX1: Algorithm3- searchByID
		Algorithm3 searchId =new Algorithm3();
		outputTable tbl =new outputTable();
		tbl.read(path,true);
		searchId.setSignalData(tbl); 

		if(!NotFilter){
			outputTable output= searchId.searchByID(id);
			if(output.size()>0){
				String sub= path.substring(0,path.length()-9);
				String file= sub+"\\id.csv";
				output.write(file);
			}
			else {
				JOptionPane.showMessageDialog(null, "no id specified found");
			}
		}
		else{
			outputTable output= searchId.searchByIDNot(id);
			if(output.size()>0){
				String sub= path.substring(0,path.length()-9);
				String file= sub+"\\idNOT.csv";
				output.write(file);
			}
			else {
				JOptionPane.showMessageDialog(null, "no id specified found");
			}
		}
	}

	/**
	 * filter searches by time inserted in the csv gmon and outputs a new csv and kml
	 * @throws IOException
	 */
	public void time(String path,String timeMin,String timeMax, boolean NotFilter) throws IOException{
		//EX3: Algorithm3- searchByTime
		Algorithm3 searchTime =new Algorithm3();
		outputTable tbl =new outputTable();
		tbl.read(path,true);
		searchTime.setSignalData(tbl); 

		if(!NotFilter){
			outputTable output= searchTime.searchByTime(timeMin, timeMax);
			if(output.size()>0){
				String sub= path.substring(0,path.length()-9);
				String file1= sub+"\\time.csv";
				output.write(file1);
			}	
			else{
				JOptionPane.showMessageDialog(null, "no time specified found");
			}
		}
		else{
			outputTable output= searchTime.searchByTimeNot(timeMin, timeMax);
			if(output.size()>0){
				String sub= path.substring(0,path.length()-9);
				String file1= sub+"\\timeNOT.csv";
				output.write(file1);
			}	
			else{
				JOptionPane.showMessageDialog(null, "no time specified found");
			}
		}
	}
}
