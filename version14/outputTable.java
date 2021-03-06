package version14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class outputTable {

//	private String user= "oop1";
//	private String password="Lambda1();";
	private String ip=""; 
	private int port=-1; 
	private String username="";
	private String password="";
	private String database="";
	private String tables="";
	private String url= "jdbc:mysql://";
	boolean sqlOkay=false; 
	
	/**
	 * this class represents output csv table builder
	 */

	private ArrayList<outputRow> ls;

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String ip, int port, String database) {
		this.url +=ip +":"+ port+ "/"+database;
	}

	public outputTable() {
		ls = new ArrayList<outputRow>();
	}

	public void deleteAllData() {
		ls.clear();
	}

	public void deleteAllData2() {
		for (int i = 0; i < ls.size(); i++) {
			ls.remove(i);
		}
	}

	public int size() {
		return ls.size();
	}

	public outputRow getRow(int i) {
		return ls.get(i);
	}

	public int getWifiCount(int i) {
		return ls.get(i).getWifiCount();
	}

	public void add(outputRow row) {
		ls.add(row);
	}

	public void read_file(String fileName, boolean head) {
		ArrayList<String> temp = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;
			if (head)
				str = br.readLine();
			str = br.readLine();
			while (str != null) {
				List<String> line = Arrays.asList(str.split(","));
				outputRow row = new outputRow();
				if (line.size() > 5) {
					String time = line.get(0);
					String id = line.get(1);
					String num;
					double lat, lon, alt;

					num = line.get(2);
					if (num.equals("?")) {
						lat = Double.NaN;
					} else {
						lat = Double.parseDouble(num);
					}

					num = line.get(3);
					if (num.equals("?")) {
						lon = Double.NaN;
					} else {
						lon = Double.parseDouble(num);
					}

					num = line.get(4);
					if (num.equals("?")) {
						alt = Double.NaN;
					} else {
						alt = Double.parseDouble(num);
					}

					row.set(time, id, lat, lon, alt);
					for (int i = 6; i < line.size(); i += 4) { // get mac from
						// csv
						String ssid = line.get(i);
						String mac = line.get(i + 1);
						String signalStr = line.get(i + 3);
						if (signalStr != null) {
							double signal = Double.parseDouble(signalStr);
							double frequncy = Double.parseDouble(line.get(i + 2));
							row.addWifi(ssid, mac, frequncy, signal);
						}
					}
					add(row);
				}
				str = br.readLine();
			}

			br.close();
			fr.close();
		}

		catch (IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}

	public void read_mysql(String filename) throws SQLException, IOException{
		// get the connection to the database
		Connection myConnection = DriverManager.getConnection(url,username,password);
		//create a statement
		Statement myState = myConnection.createStatement();
		// execute SQL query
		ResultSet myRes = myState.executeQuery("select * from ex4_db");
		
		//process the result set
		while(myRes.next()){
			outputRow row = new outputRow();
			String time = myRes.getString(2);
			String id = myRes.getString(3);
			String num;
			double lat, lon, alt;
			num = myRes.getString(4);
			lat = Double.parseDouble(num);
			num = myRes.getString(5);
			lon = Double.parseDouble(num);
			num = myRes.getString(6);
			alt = Double.parseDouble(num);
			row.set(time, id, lat, lon, alt);
			int wifiCount = Integer.parseInt(myRes.getString(7));			
			if(wifiCount > row.getWifiCounter()){
					wifiCount= row.getWifiCounter()-1;
				}
			for (int i = 0; i < wifiCount; i++) { // get mac from
				
				// csv
				String mac = myRes.getString(8+i*2);
				String signalStr = myRes.getString(8 + i*2+1);
				if (signalStr != null) {
					double signal = Double.parseDouble(signalStr);
					row.addWifi("x", mac, 0, signal);
				}
			}
			add(row);
		}
		write(filename);
	}

	public void read(String filename, boolean head) throws SQLException, IOException{
		read_file(filename,head);
		read_mysql(filename);
	}
	
	public void setDataSql(String ip, int port, String username, String password,
			String database, String table){
		this.ip=ip;
		this.port=port;
		this.username=username;
		this.password=password;
		this.database=database;
		this.tables=table;
	}
	
	public void write(String filename) throws IOException {
		/**
		 * enter path name here format: "pathAddredd\\filename.csv"
		 */
		FileWriter writer = new FileWriter(filename);
		/**
		 * write header line
		 */
		writer.write("Time,ID,Lat,Lon,Alt,#WiFi networks,SSID1,MAC1,Frequncy1,Signal1"+
				",SSID2,MAC2,Frequncy2,Signal2,SSID3,MAC3,Frequncy3,Signal3"+
				",SSID4,MAC4,Frequncy4,Signal4,SSID5,MAC5,Frequncy5,Signal5"+
				",SSID6,MAC6,Frequncy6,Signal6,SSID7,MAC7,Frequncy7,Signal7"+
				",SSID8,MAC8,Frequncy8,Signal8,SSID9,MAC9,Frequncy9,Signal9"+
				",SSID10,MAC10,Frequncy10,Signal10");
		writer.write("\n");

		for (int i = 0; i < ls.size(); i++) {
			outputRow row = ls.get(i);
			if (row.getWifiCount() > 0) {
				writer.write(row.toString());
				writer.write("\n");
			}
		}
		writer.close();
	}

}
