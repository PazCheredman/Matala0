package version5.BaseClasses;
	import java.util.ArrayList;
	import java.util.Comparator;

	public class latComp implements Comparator<arrayRowMeasurement>{

		@Override
		public int compare(arrayRowMeasurement arg0, arrayRowMeasurement arg1) {
			// TODO Auto-generated method stub

			return arg0.getLAT().compareTo(arg1.getLAT());
		}
}
