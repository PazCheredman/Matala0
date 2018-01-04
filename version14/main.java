package version14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	final static String path= "C:\\Users\\InnaPC\\Desktop\\munhe\\runCheck";
	final static String path1="C:\\Users\\InnaPC\\Desktop\\munhe\\gmon";

	/**
	 * runs the 2 algorithms 1, 2
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		algorithm1();
		algorithm2();
	}

	/**
	 * algorithm 1 : given specific mac, it calculate its' location by lat lon alt parameters
	 * @throws IOException
	 */
	public static void algorithm1() throws IOException{
 
		System.out.println("please enter name of csv file:"); //enter: gmon.csv
		Scanner fileName= new Scanner(System.in);
		String insertFileName= fileName.nextLine();
		MacSignalContainer msc= new MacSignalContainer(path1+"\\"+ insertFileName);
		//EX2:algorithm1
		System.out.println("\nyou are now running algorithm1");
		Algorithm1 algo1= new Algorithm1();
		algo1.setSignalData(msc);
		System.out.println("please enter file name:"); //enter: alg1.csv
		Scanner fileScanner= new Scanner(System.in);
		String file= fileScanner.next();
		algo1.algorithem1(path+"\\"+file);
		System.out.println("please go to " +path+ " to see the csv file");
	}

	/**
	 * algorithm 2 : 
	 * option A -enter file name .csv and it will show you the accurate location by the whole row.
	 * option B- enter 3 pairs of mac and signal and it will show you the accurate location by these pairs.
	 * @throws IOException
	 */
	public static void algorithm2() throws IOException{
		System.out.println("please enter name of csv file:"); //enter: gmon.csv
		Scanner fileName= new Scanner(System.in);
		String insertFileName= fileName.nextLine();
		MacSignalContainer msc= new MacSignalContainer(path1+"\\"+ insertFileName);
		//EX2:algorithm2
		System.out.println("\nyou are now running algorithm2");
		System.out.println("choose which way you want to apply this algorithm:\n"
				+ "option A ( enter A )- enter file name .csv and it will show you the accurate location by the whole row.\n"
				+ "option B ( enter B )- enter 3 pairs of mac and signal and it will show you the accurate location by these pairs.");
		Scanner choice= new Scanner(System.in); 
		String userChoice = choice.next();

		if(userChoice.equals("A")){
			Scanner sc1= new Scanner(System.in); 
			System.out.println("please enter data file name:"); //enter: _comb_all_BM2_.csv
			String dataFile =sc1.nextLine(); 
			outputTable data =new outputTable();
			data.read(path+"\\"+dataFile, false);
			System.out.println("please enter input file name:"); //enter: _comb_no_gps_ts1.csv
			String inputFile =sc1.next(); 
			outputTable input =new outputTable();
			input.read(path+"\\"+inputFile, false);

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
			System.out.println("please enter file name:"); //enter: alg2.csv
			Scanner sc3= new Scanner(System.in);
			String scan= sc3.next();
			input.write(path+"\\"+scan);
			System.out.println("please go to " +path+ " to see the csv file");
		}
		else if(userChoice.equals("B")){
			System.out.println("please insert 3 mac and signal in this order: 'mac signal' while the signal is negative\n" );
			Scanner sc= new Scanner(System.in);
			List<String> macs = new ArrayList<>();
			List<Double> signals = new ArrayList<>();
			for (int i = 0 ;i < 3;i++) {
				String mac = sc.next();
				String signal = sc.next();
				macs.add(mac);
				signals.add(Double.parseDouble(signal));
			}
			locationSignal ls = new locationSignal();
			outputTable input =new outputTable();
			input.read(path1+"\\"+insertFileName, true);
			for (int k = 0; k <input.size(); k++){
				outputRow row = input.getRow(k);
				Algorithm2 algo2= new Algorithm2(); 
				ls = algo2.algorithem2(input, macs, signals);
				if(ls !=null){
					row.setLocation(ls.getLat(), ls.getLon(), ls.getAlt());		
				}
			}
			
			System.out.println("this is the sum average of the router: " + ls.toStringLocation()); 
		}
		else {
			System.out.println("unvalid choice, try again");
			algorithm2();
		}
		
	}

	/**
	 * filter searches by radius inserted in the csv gmon and outputs a new csv and kml
	 * @throws IOException
	 */
	public static void radius() throws IOException{
		//EX1: Algorithm3- searchByRadious
		System.out.println("\nyou are now running algorithm3- searchByRadious");
		Algorithm3 searchRad =new Algorithm3();
		outputTable tbl =new outputTable();
		String fileName = "gmon.csv";
		tbl.read(path1+"\\"+ fileName,true);
		searchRad.setSignalData(tbl); 
		Scanner rad= new Scanner(System.in);
		System.out.println("enter lat: "); 
		double lat=Double.parseDouble(rad.next());
		System.out.println("enter lon: ");
		double lon=Double.parseDouble(rad.next());	
		System.out.println("enter alt: ");
		double alt=Double.parseDouble(rad.next());
		System.out.println("enter radious: ");
		double radious=Double.parseDouble(rad.next());	
		outputTable output= searchRad.searchByRadious(lat, lon, alt, radious);
		if(output.size()>0){
			System.out.println("please enter file name:"); //enter: rad.csv
			Scanner fileScanner1= new Scanner(System.in);
			String file1= fileScanner1.next();
			output.write(path+"\\"+file1);
			testKml.readCsvFile(path+"\\"+file1,path);
			System.out.println("please go to " +path+ " to see the csv and kml file");
		}
		else System.out.println("no wifi networks within range found");
	}
	
	/**
	 * filter searches by range location inserted in the csv gmon and outputs a new csv
	 * @throws IOException
	 */
	public static void location() throws IOException{
		//EX3: Algorithm3- searchBylocation
		System.out.println("\nyou are now running algorithm3- searchByLocation");
		Algorithm3 searchRad =new Algorithm3();
		outputTable tbl =new outputTable();
		String fileName = "gmon.csv";
		tbl.read(path1+"\\"+ fileName,true);
		searchRad.setSignalData(tbl); 
		Scanner loc= new Scanner(System.in);
		System.out.println("enter lat min: "); 
		double latMin=Double.parseDouble(loc.next());
		System.out.println("enter lon min: ");
		double lonMin=Double.parseDouble(loc.next());
		System.out.println("enter alt Min: ");
		double altMin=Double.parseDouble(loc.next());
		
		System.out.println("enter lat max: "); 
		double latMax=Double.parseDouble(loc.next());
		System.out.println("enter lon max: ");
		double lonMax=Double.parseDouble(loc.next());	
		System.out.println("enter alt Max: ");
		double altMax=Double.parseDouble(loc.next());
		
			
		outputTable output= searchRad.searchByLocation(latMax, lonMax, altMax, latMin, lonMin, altMin);
		if(output.size()>0){
			System.out.println("please enter file name with .csv ending:"); //enter: loc.csv
			Scanner fileScanner1= new Scanner(System.in);
			String file1= fileScanner1.next();
			output.write(path+"\\"+file1);
			System.out.println("please go to " +path+ " to see the csv file");
		}
		else System.out.println("no wifi networks within range found");
	}

	/**
	 * filter searches by id inserted in the csv gmon and outputs a new csv and kml
	 * @throws IOException
	 */
	public static void id() throws IOException{
		//EX1: Algorithm3- searchByID
		System.out.println("\nyou are now running algorithm3- searchByID");
		Algorithm3 searchId =new Algorithm3();
		outputTable tbl =new outputTable();
		String fileName = "gmon.csv";
		tbl.read(path1+"\\"+ fileName,true);
		searchId.setSignalData(tbl); 
		Scanner Id= new Scanner(System.in);
		System.out.println("enter id: "); 
		String id=Id.next();
		outputTable output= searchId.searchByID(id);
		if(output.size()>0){
			System.out.println("please enter file name:"); //enter: id.csv
			Scanner fileScanner1= new Scanner(System.in);
			String file1= fileScanner1.next();
			output.write(path+"\\"+file1);
			testKml.readCsvFile(path+"\\"+file1,path);
			System.out.println("please go to " +path+ " to see the csv and kml file");
		}
		else System.out.println("no id specified found");
	}

	/**
	 * filter searches by time inserted in the csv gmon and outputs a new csv and kml
	 * @throws IOException
	 */
	public static void time() throws IOException{
		//EX3: Algorithm3- searchByTime
		System.out.println("\nyou are now running algorithm3- searchByTime");
		Algorithm3 searchTime =new Algorithm3();
		outputTable tbl =new outputTable();
		String fileName = "gmon.csv";
		tbl.read(path1+"\\"+ fileName,true);
		searchTime.setSignalData(tbl); 
		Scanner tm= new Scanner(System.in);
		System.out.println("enter time: ");  // enter: year-month-day |& time by 24 format (not 12 format am.pm)
		String timeMin=tm.next();
		String timeMax=tm.next();
		outputTable output= searchTime.searchByTime(timeMin, timeMax);
		if(output.size()>0){
			System.out.println("please enter file name with .csv ending:"); //enter: time.csv
			Scanner fileScanner1= new Scanner(System.in);
			String file1= fileScanner1.next();
			output.write(path+"\\"+file1);
			testKml.readCsvFile(path+"\\"+file1,path);
			System.out.println("please go to " +path+ " to see the csv and kml file");
		}
		else System.out.println("no time specified found");
	}

}