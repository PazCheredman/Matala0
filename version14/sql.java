package version14;

import java.sql.*;
import java.util.ArrayList;

public class sql {
	
	public static void main(String[] args){
		try{
			ArrayList<String> table = new ArrayList<>();
			// get the connection to the database
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://5.29.193.52:3306/oop_course_ariel", "oop1","Lambda1();");
			//create a statement
			Statement myState = myConnection.createStatement();
			// execute SQL query
			ResultSet myRes = myState.executeQuery("select * from ex4_db");
			//process the result set
			while(myRes.next()){
				System.out.println(myRes.getString(7));
			//	System.out.println(myRes.getInt(10));
				table.add(myRes.getString("time"));
				//System.out.println(myRes.getString("time"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
