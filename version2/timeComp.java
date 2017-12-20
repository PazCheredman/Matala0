package version2;

import java.util.ArrayList;
import java.util.Comparator;

public class timeComp implements Comparator<ArrayList<String>>{

	@Override
	public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {
		// TODO Auto-generated method stub

		return arg0.get(0).compareTo(arg1.get(0));
	}
	

}
