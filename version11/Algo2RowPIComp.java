package version11;

import java.util.Comparator;

public class Algo2RowPIComp implements Comparator<Algo2Row> {

	@Override
	public int compare(Algo2Row o1, Algo2Row o2) {
		if(o1.getPi()>o2.getPi()) return 1;
		if(o1.getPi()<o2.getPi()) return -1;
		return 0;
	}

}
