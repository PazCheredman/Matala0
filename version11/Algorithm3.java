package version11;

import java.io.IOException;
import java.util.ArrayList;

public class Algorithm3 {

	private outputTable tbl;

	public void setSignalData(outputTable gmon) {
		tbl = gmon;
	}

	/**
	 * searches who is in the radius inserted 
	 * @param lat
	 * @param lon
	 * @param alt
	 * @param rad
	 * @return outputTable
	 * @throws IOException
	 */
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
	
	/**
	 * searches id inserted if exists in the gmon.csv
	 * @param id
	 * @return outputTable
	 * @throws IOException
	 */
	public outputTable searchByID(String id) throws IOException {
		outputTable exist = new outputTable();
		for (int i = 0; i < tbl.size(); i++) {
			outputRow row = tbl.getRow(i);
			if(row.getId().equals(id))
				exist.add(row);
		}
		return exist;
	}
	
	/**
	 * searches time inserted if exists in the gmon.csv
	 * @param time
	 * @return outputTable 
	 * @throws IOException
	 */
	public outputTable searchByTime(String time) throws IOException {
		outputTable exist = new outputTable();
		for (int i = 0; i < tbl.size(); i++) {
			outputRow row = tbl.getRow(i);
			if(row.getTime().contains(time))
				exist.add(row);
		}
		return exist;
	}
	
}