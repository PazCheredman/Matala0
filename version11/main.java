package version11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	final static String path= "C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\runCheck";
	final static String path1="C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\creategmon";

	public static void main(String[] args) throws IOException {


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


		//EX2:algorithm2
		System.out.println("\nyou are now running algorithm2");
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

		/*		
		 use this in ex3:
		  System.out.println("please insert 3 mac and signal in this order: 'mac signal' while the signal is negative\n" );
		Scanner sc= new Scanner(System.in);
		 for (int i = 0 ;i <  ;i++) {
			String mac = sc.next();
			String signal = sc.next();
			macs.add(mac);
			signals.add(signal);
		}
		 */


		//EX1: Algorithm3- searchByRadious
		System.out.println("\nyou are now running algorithm3- searchByRadious");
		Algorithm3 searchRad =new Algorithm3();
		outputTable tbl =new outputTable();
		tbl.read(path1+"\\"+ insertFileName,true);
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
			System.out.println("please go to " +path+ " to see the csv file");
		}
		else System.out.println("no wifi networks within range found");
	}

}