package version11;

import java.util.ArrayList;
import java.util.Collections;

public class Algo2 {
	
	private ArrayList<Algo2Row> tbl = new ArrayList<>();

	public void add(double pi, int index) {
		Algo2Row row= new Algo2Row(pi, index);
		tbl.add(row);
	}

	public void sort() {
		Collections.sort(tbl, new Algo2RowPIComp());
	}

	public Algo2Row get(int k) {
		return tbl.get(k);
	}

	public int size() {
		return tbl.size();
	}

	
}
