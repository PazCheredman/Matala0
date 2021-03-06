package version14;
/**
 * 
 * @author Inna & Paz
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

	private  String Id ="";
	private  Double Lat =0.0;
	private  Double Lon =0.0;
	private  Double Alt =0.0;
	private  ArrayList<ArrayList<String>> csvArray = new ArrayList<ArrayList<String>>();

	/*
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter path of csv file:");
		//enter the folder that contains the file created in class "csv"
		String path= sc.nextLine(); //enter: C:\\Users\\InnaPC\\Desktop\\munhe\\gmon
		System.out.println("please enter name of csv file:");
		//enter the file name of the file created in class "csv"
		String insertFileName= sc.nextLine(); //enter: gmon.csv
		//readCsvFile(path+"\\",insertFileName);

		System.out.println("please go to "+path+ " to see the file\n");

		System.out.println("please enter the kind of filter you are intrested in : id / time / location");
		String filterName = sc.nextLine();
		//changeByFilter(filterName);
	}
	*/

	/**
	 * 
	 * try to read from the final csv file and turns it into kml with timestamp
	 * @param fileName
	 */
	public void readCsvFile (String path, String fileName){
		final Kml kml = new Kml();
		de.micromata.opengis.kml.v_2_2_0.Document doc = kml.createAndSetDocument();
		ArrayList<String> temp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(path+"\\"+fileName);
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
			kml.marshal(new File(path+"\\kml.kml"));
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
	/*
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
			System.out.println("choose which way you want to apply this algorithm:\n"
					+ "option A ( enter A )- enter lat lon alt and radius.\n"
					+ "option B ( enter B )- enter max lat lon alt and min lat lon alt.");
			Scanner choice= new Scanner(System.in); 
			String userChoice = choice.next();

			if(userChoice.equals("A"))
				main.radius();
			else if(userChoice.equals("B"))
				main.location();
			else{
				System.out.println("unvalid choice, try again");
				changeByFilter(filter);
			}
		}
	}*/
}
