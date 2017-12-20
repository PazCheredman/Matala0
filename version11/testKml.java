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
	//final static String path= "C:\\Users\\InnaPC\\Desktop\\munhe\\gmon";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter path of csv file:");
		//enter the folder that contains the file created in class "csv"
		String path= sc.nextLine(); //enter: C:\\Users\\InnaPC\\Desktop\\munhe\\gmon"
		System.out.println("please enter name of csv file:");
		//enter the file name of the file created in class "csv"
		String insertFileName= sc.nextLine(); //enter: gmon.csv
		readCsvFile(path+"\\"+insertFileName, path);
		
		System.out.println("please go to "+path+ " to see the file\n");
		
		System.out.println("please enter the kind of filter you are intrested in : id / time / location");
		String filterName = sc.nextLine();
		changeByFilter(filterName);
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
			System.out.println("please enter file name with .kml ending:"); //enter: kml.kml
			Scanner sc= new Scanner(System.in);
			String filename= sc.nextLine();
			
			kml.marshal(new File(path+"\\"+filename));
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}

	/**
	 * changeByFilter is changing the kml by a filter we get from the user ( id\ time\ location)
	 * @throws IOException 
	 */
	public static void changeByFilter(String filter) throws IOException{
		
		if(filter.equals("id"))// filter by ID
		{
			main.id();
		}
		else if(filter.equals("time"))//filter by Time
		{
			main.time();
		}
		else // filter by Location
		{
			main.radius();
		}
	}
}
