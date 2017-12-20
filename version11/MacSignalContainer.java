package version11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MacSignalContainer {

	/**
	 * this class is a container of all mac and signal
	 */

	
	private ArrayList<MacSignal> data;


	public MacSignalContainer(String filename){
		data =new ArrayList<MacSignal>();
		readCsvFile(filename);
	}

	public String getMac(int index){
		return data.get(index).getMac();
	}
	public MacSignal MacFind(String mac){
		for (int i=0; i< data.size();i++) {
			if (data.get(i).getMac().equals(mac))
				return data.get(i);
		}
		return null;
	}
    public MacSignal get(int index) {
    	return data.get(index);
    }
    
	/**
	 * 
	 * @param mac
	 * @param lat
	 * @param lon
	 * @param alt
	 * @param signal
	 * 
	 * look for mac: add specific data for mac 
	 * and add mac if needed
	 * 
	 */
	public void add(String mac, double lat, double lon, double alt,double signal){
		MacSignal mc = MacFind(mac);
		if (mc != null) {
	     	mc.add(lat, lon, alt, signal);
		}
		else {
		mc =new MacSignal(mac);
		mc.add(lat, lon, alt, signal);
		data.add(mc);
		}
	}

	/**
	 * reads the gmon csv and adds to an csv array so we can get to each parameter inside 
	 * @param fileName
	 */
	public void readCsvFile (String fileName){
		ArrayList<String> temp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;
			str = br.readLine();
			str = br.readLine();

			while(str != null){
				List <String> line= Arrays.asList(str.split(","));
				double lat= Double.parseDouble(line.get(2));
				double lon= Double.parseDouble(line.get(3));
				double alt= Double.parseDouble(line.get(4));

				for (int i = 7; i < line.size(); i = i+4) { //get mac from csv
					String mac= line.get(i);
					String signalStr= line.get(i+2);
					if(signalStr !=null){
						double signal = Double.parseDouble(signalStr);
						add(mac, lat, lon, alt, signal);
					}
				}
				str = br.readLine();
			}

			br.close();
			fr.close();
		}

		catch(IOException ex) {
			System.out.print("Error reading file:"+fileName+"(" + ex+")\n");
			System.exit(2);
		}
	}

	public ArrayList<MacSignal> getData() {
		return data;
	}

	public void setData(ArrayList<MacSignal> data) {
		this.data = data;
	}

	public int size(){
		return data.size();
	}


}

