package version7;

import java.util.ArrayList;

public class outputTable {

	//this class represents output csv table builder 
	private ArrayList<outputRow> ls;
	
	public outputTable(){
		ls= new ArrayList<outputRow>();
	}
	
	public int size(){
		return ls.size();
	}
	
	public outputRow getRow(int i){
		return ls.get(i);
	}
	
	public void add(outputRow row){
		ls.add(row);
	}
	
}
