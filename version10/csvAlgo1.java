package version10;

import java.util.ArrayList;

/**
 * 
 * @author Paz Cheredman
 *
 */

public class csvAlgo1 {
	
	private ArrayList<CsvRowAlgo1> ls;
	
	public csvAlgo1(){
		ls= new ArrayList<CsvRowAlgo1>();
	}
	
	public int size(){
		return ls.size();
	}
	
	public CsvRowAlgo1 getRow(int i){
		return ls.get(i);
	}
	
	public void add(CsvRowAlgo1 row){
		ls.add(row);
	}
	
	
}
