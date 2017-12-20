package version11;
/**
 * 
 * @author InnaPC
 *
 */
import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public class testKml {

	private static String Id ="";
	private static Double Lat =0.0;
	private static Double Lon =0.0;
	private static Double Alt =0.0;
	private static ArrayList<ArrayList<String>> csvArray = new ArrayList<ArrayList<String>>();
	//final static String path= "C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\creategmon";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter path of csv file:");
		//enter the folder that contains the file created in class "csv"
		String path= sc.nextLine(); //enter: C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\creategmon"
		System.out.println("please enter name of csv file:");
		//enter the file name of the file created in class "csv"
		String insertFileName= sc.nextLine(); //enter: gmon.csv
		readCsvFile(path+"\\"+insertFileName, path);
		System.out.println("enter lat: "); 
		double lat = sc.nextDouble();
		System.out.println("enter lon: "); 
		double lon = sc.nextDouble();
		System.out.println("enter radious: "); 
		double radius = sc.nextDouble();
		
		String location= lat+","+lon+","+radius;
		changeByFilter("location", csvArray, location);
		
		System.out.println("please go to "+path+ " to see the file");
		
	}

	/**
	 * 
	 * try to read from the final csv file and turns it into kml with timestamp
	 * @param fileName
	 */
	public static void readCsvFile (String fileName, String path){
		final  Kml kml = new Kml();
		de.micromata.opengis.kml.v_2_2_0.Document doc = kml.createAndSetDocument();
		ArrayList<String> temp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;

			str = br.readLine();
			str = br.readLine();
			List <String> secondLine= Arrays.asList(str.split(","));
			String time = secondLine.get(0);
			String id = secondLine.get(1);
			String lat = secondLine.get(2);
			String lon = secondLine.get(3);
			String alt = secondLine.get(4);

			temp.addAll(secondLine);
			csvArray.add(temp);

			while(str != null){
				Id = id;
				Lat = Double.parseDouble(lat);
				Lon = Double.parseDouble(lon);
				Alt = Double.parseDouble(alt);

				List <String> tempfilesArray= Arrays.asList(str.split(","));
				time = tempfilesArray.get(0);
				id = tempfilesArray.get(1);
				lat = tempfilesArray.get(2);
				lon = tempfilesArray.get(3);
				alt = tempfilesArray.get(4);

				temp.addAll(tempfilesArray);
				csvArray.add(temp);

				time = time.replace(' ','T');
				time = time+'Z';

				Placemark p = KmlFactory.createPlacemark();
				p.createAndSetTimeStamp().withWhen(time);

				doc.createAndAddPlacemark().withName(Id).withTimePrimitive(p.getTimePrimitive())
				.createAndSetPoint().addToCoordinates(Lon, Lat);

				str = br.readLine();
			}
			str = br.readLine();
			str = br.readLine();
			br.close();
			fr.close();
			Scanner sc= new Scanner(System.in);
			String filename= sc.nextLine();
			//enter: kml.kml
			kml.marshal(new File(path+"\\"+filename));
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}

	/**
	 * changeByFilter is changing the kml by a filter we get from the user ( id\ time\ location)
	 * we took this func from stackoverflow
	 * @throws IOException 
	 */
	public static void changeByFilter(String filter, List<ArrayList<String>> currentcsv, String theFilter){
		Predicate<ArrayList<String>> condition1;
		List<ArrayList<String>> afterFilter;
		if(filter.equals("id"))// filter by ID
		{
			condition1=s -> s.get(1).contains(theFilter);
			 afterFilter=filterby(currentcsv ,condition1);
		}
		else if(filter.equals("time"))//filter by Time
		{
			condition1=s -> s.get(0).contains(theFilter);
			afterFilter=filterby(currentcsv ,condition1);
		}
		else // filter by Location
		{
			String str;
			str = theFilter;
			List <String> st= Arrays.asList(str.split(","));
			String stfilter = st.get(0) + "," + st.get(1);

			condition1=s -> s.get(2).contains(stfilter) & s.get(3).contains(stfilter);
			double lat1 = Double.parseDouble(st.get(0));
			double lon1 = Double.parseDouble(st.get(1));
			double rad = Double.parseDouble(st.get(2));
			for(int i=0; i< csvArray.size(); i++){
				double lat2 = Double.parseDouble(csvArray.get(i).get(2));
				double lon2 = Double.parseDouble(csvArray.get(i).get(3));
				if(isRadius(lat1, lat2, lon1, lon2, rad)){
					 afterFilter=filterby(currentcsv ,condition1);
					currentcsv=afterFilter;
//inna: we dont need this syso! it prints a lot of this :[]					
				//	System.out.println( afterFilter);
				}
			}
		}
	}

	/**
	 * checks if the point lat2, lon2 is in the radius from the point lat1,lon1
	 * @param lat1
	 * @param lat2
	 * @param lon1
	 * @param lon2
	 * @param radius
	 * @return true/false
	 */
	private static boolean isRadius(double lat1, double lat2, double lon1, double lon2, double radius){
		double dis = Math.sqrt(Math.pow((lat1-lat2),2)+Math.pow((lon1-lon2),2));
		if(dis <= radius) return true;
		return false;
	}

	/**
	 * this function help me to filter the list by interface
	 * we took this func from stackoverflow
	 */
	private static List<ArrayList<String>> filterby(List<ArrayList<String>> data, Predicate<ArrayList<String>> term){
		List<ArrayList<String>> out=new ArrayList<ArrayList<String>>(); 
		for(int i=1; i<data.size(); i++){
			if(term.test(data.get(i))){
				out.add(data.get(i));
			}
		}
		return out;
	}
}
