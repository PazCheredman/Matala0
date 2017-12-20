package version9;

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
import de.micromata.opengis.kml.v_2_2_0.xal.AddressDetails.Address;

public class testKml {

	private static String Id ="";
	private static Double Lat =0.0;
	private static Double Lon =0.0;
	private static Double Alt =0.0;
	private static ArrayList<ArrayList<String>> csvArray = new ArrayList<ArrayList<String>>();

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * You need to enter the address of the csv file:
	 * 1) Make sure your address contains '\\' between each folder.
	 * 2) Make sure your address ends with 'filename.csv', 
	 * otherwise the program will throw you out.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		readCsvFile("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon.csv");
		System.out.println("go to folder C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10 to see the file");

	}

	/**
	 * 
	 * @param fileName
	 * This function is trying to read from the final
	 * csv file and turns it into kml with timestamp.
	 */
	public static void readCsvFile (String fileName){
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
			kml.marshal(new File("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\kml.kml"));
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}

	/**
	 * changeByFilter is changing the kml by a filter we get from the user ( id\ time\ location)
	 * we took this func from stackoverflow
	 */

	//need to update it!
	private static void changeByFilter(String filter, List<ArrayList<String>> currentcsv, String theFilter){
		if(filter.equals("id")){
			Predicate<ArrayList<String>> id=s -> s.get(1).contains(theFilter);
			List<ArrayList<String>> afterFilter=filterby(currentcsv ,id);
			currentcsv=afterFilter;
			//System.out.println(afterFilter.size());
		}
		if(filter.equals("time")){
			Predicate<ArrayList<String>> time=s -> s.get(0).contains(theFilter);
			List<ArrayList<String>> afterFilter=filterby(currentcsv ,time);	
			currentcsv=afterFilter;
		}
		if(filter.equals("location")){
			Predicate<ArrayList<String>> location=s -> s.get(1).contains(theFilter);
			List<ArrayList<String>> afterFilter=filterby(currentcsv ,location);	
			currentcsv=afterFilter;
		}
	}

	/**
	 * this function help me to filter the list by interface
	 * we took this func from stackoverflow
	 */
	
	//need to update it!!
	private static List<ArrayList<String>> filterby(List<ArrayList<String>> data, Predicate<ArrayList<String>> term)
	{

		List<ArrayList<String>> out=new ArrayList<ArrayList<String>>(); 

		for(int i=1; i<data.size(); i++)
		{
			System.out.println("v");
			if(term.test(data.get(i))==false)
			{
				out.add(data.get(i));
			}
		}
		return out;


	}

}
