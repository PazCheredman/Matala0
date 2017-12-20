package version11;

import java.io.IOException;
import java.util.ArrayList;

public class Algorithm3 {

	private outputTable tbl;

	public void setSignalData(outputTable gmon) {
		tbl = gmon;
	}

	public outputTable searchByRadious(double lat, double lon, double alt, double rad) throws IOException {
		locationSignal current = new locationSignal();
		current.setAll(lat, lon, alt, 0);
		outputTable inRange = new outputTable();
		for (int i = 0; i < tbl.size(); i++) {
			outputRow row = tbl.getRow(i);
			locationSignal loc = new locationSignal();
			loc.setAll(row.getLat(), row.getLon(), row.getAlt(),0);
			if (loc.dist(current) <= rad) {
					inRange.add(row);
				}
			}
		return inRange;

	}
}