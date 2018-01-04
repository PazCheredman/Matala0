package version14;


import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import version2.arrayRowMeasurement;

public class table {
	
	/**
	 * this class is the builder of table 
	 */
	
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
	
}
