package version4;

import java.util.ArrayList;
import java.util.Comparator;

public class signalComp implements Comparator<ArrayList<String>> {

	@Override
	public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {
		// TODO Auto-generated method stub

		return arg0.get(8).compareTo(arg1.get(8));
	}
}
