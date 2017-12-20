package version7;
import version6.rowMes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import version2.arrayRowMeasurement;

public class table {
	
	//this class is the builder of table 
	
	private ArrayList<rowMeasurement> ls; 
	
	public table(){
		ls= new ArrayList<rowMeasurement>();
	}
	
	public rowMeasurement getRow(int i){
		return ls.get(i);
	}
	
	public int size(){
		return ls.size();
	}
	
	public void add(rowMeasurement row){
		ls.add(row);
	}
	
	public String toString(){
		String ans="";
		for(int i=0; i<ls.size(); i++){
			ans+=ls.get(i).toString();
		}
		return ans;
	}
	
	public void sort(){
		Collections.sort(ls, new rowMeasurementComp());
	}
	
	/*public static void main (String [] args){
		rowMes row= new rowMes();
		rowMes row1= new rowMes();

		row.addAll("1","2", "3","4", "5", "6", "7", "8", "9");
		row1.addAll("0","2", "3","7", "5", "6", "7", "8", "9");
		table a= new table();
		a.add(row);
		a.add(row1);
		System.out.println(a);
	}
	*/
}
