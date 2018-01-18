package version14;

import java.io.IOException;
import java.sql.Time;
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
	 * searches who isn't in the radius inserted 
	 * @param lat
	 * @param lon
	 * @param alt
	 * @param rad
	 * @return outputTable
	 * @throws IOException
	 */
	public outputTable searchByRadiousNot(double lat, double lon, double alt, double rad) throws IOException {
		locationSignal current = new locationSignal();
		current.setAll(lat, lon, alt, 0);
		outputTable inRange = new outputTable();
		for (int i = 0; i < tbl.size(); i++) {
			outputRow row = tbl.getRow(i);
			locationSignal loc = new locationSignal();
			loc.setAll(row.getLat(), row.getLon(), row.getAlt(),0);
			if (loc.dist(current) > rad) {
				inRange.add(row);
			}
		}
		return inRange;
	}

	/**
	 * searchByLocation searches who is in the range inserted
	 * @param latMax
	 * @param lonMax
	 * @param altMax
	 * @param latMin
	 * @param lonMin
	 * @param altMin
	 * @return outputTable
	 * @throws IOException
	 */
	public outputTable searchByLocation(double latMax, double lonMax, double altMax, double latMin, double lonMin, double altMin) throws IOException {
		outputTable inRange = new outputTable();
		for (int i = 0; i < tbl.size(); i++) {
			outputRow row = tbl.getRow(i);
			locationSignal loc = new locationSignal();
			loc.setAll(row.getLat(), row.getLon(), row.getAlt(),0);
			if (loc.getLat() <= latMax && loc.getLat() >= latMin && loc.getLon() <= lonMax && loc.getLon() >= lonMin && loc.getAlt() <= altMax && loc.getAlt() >= altMin) {
				inRange.add(row);
			}
		}
		return inRange;
	}

	/**
	 * searchByLocationNot searches who isn't in the range inserted
	 * @param latMax
	 * @param lonMax
	 * @param altMax
	 * @param latMin
	 * @param lonMin
	 * @param altMin
	 * @return outputTable
	 * @throws IOException
	 */
	public outputTable searchByLocationNot(double latMax, double lonMax, double altMax, double latMin, double lonMin, double altMin) throws IOException {
		outputTable inRange = new outputTable();
		for (int i = 0; i < tbl.size(); i++) {
			outputRow row = tbl.getRow(i);
			locationSignal loc = new locationSignal();
			loc.setAll(row.getLat(), row.getLon(), row.getAlt(),0);
			if (loc.getLat() > latMax && loc.getLat() < latMin && loc.getLon() > lonMax && loc.getLon() < lonMin &&
					loc.getAlt() > altMax && loc.getAlt() < altMin) {
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
	 * searches id inserted if exists in the gmon.csv, prints what is not this id
	 * @param id
	 * @return outputTable
	 * @throws IOException
	 */
	public outputTable searchByIDNot(String id) throws IOException {
		outputTable exist = new outputTable();
		for (int i = 0; i < tbl.size(); i++) {
			outputRow row = tbl.getRow(i);
			if(!row.getId().equals(id))
				exist.add(row);
		}
		return exist;
	}

	/**
	 * searches what is in the range of time inserted
	 * @param time
	 * @return outputTable 
	 * @throws IOException
	 */
	public outputTable searchByTime(String timeMin, String timeMax)  {
		outputTable timeExist = new outputTable();
		String secMin = "00";
		String secMax = "00";
		for (int i = 0; i < tbl.size(); i++) {
			outputRow row = tbl.getRow(i);

			if(timeMin.length() >= 6 )
				secMin = timeMin.substring(6,8);
			String hourMin = timeMin.substring(0,2);
			String mintuesMin = timeMin.substring(3,5);

			if(timeMax.length() >= 6)
				secMax = timeMax.substring(6,8);
			String hourMax = timeMax.substring(0,2);
			String minutesMax = timeMax.substring(3,5);

			int timehourMin = Integer.parseInt(hourMin);
			int timemintuesMin = Integer.parseInt(mintuesMin);
			int timesecMin = Integer.parseInt(secMin);

			int timehourMax = Integer.parseInt(hourMax);
			int timeminutesMax = Integer.parseInt(minutesMax);
			int timesecMax = Integer.parseInt(secMax);

			int currTimeHour = Integer.parseInt(row.getTime().substring(11,13));
			int currTimeMinutes = Integer.parseInt(row.getTime().substring(14,16));
			int currTimeSec = Integer.parseInt(row.getTime().substring(17,19));

			if(currTimeHour > timehourMin && currTimeHour < timehourMax)
				timeExist.add(row);
			else if(currTimeHour >= timehourMin && currTimeHour <= timehourMax)
				if(currTimeMinutes > timemintuesMin &&  currTimeMinutes < timeminutesMax)
					timeExist.add(row);
				else if(currTimeMinutes >= timemintuesMin &&  currTimeMinutes <= timeminutesMax)
					if(currTimeMinutes == timemintuesMin){
						if(currTimeSec >= timesecMin)
							timeExist.add(row);
					}
					else if(currTimeMinutes == timeminutesMax){
						if(currTimeSec <= timesecMax)
							timeExist.add(row);
					}
					else if(currTimeSec >= timesecMin && currTimeSec <= timesecMax)
						timeExist.add(row);
		}
		return timeExist;
	}

	/**
	 * searches what isn't in the range of time inserted
	 * @param time
	 * @return outputTable 
	 * @throws IOException
	 */
	public outputTable searchByTimeNot(String timeMin, String timeMax)  {
		outputTable timeExist = new outputTable();
		String secMin = "00";
		String secMax = "00";
		for (int i = 0; i < tbl.size(); i++) {
			outputRow row = tbl.getRow(i);

			if(timeMin.length() >= 6 )
				secMin = timeMin.substring(6,8);
			String hourMin = timeMin.substring(0,2);
			String mintuesMin = timeMin.substring(3,5);

			if(timeMax.length() >= 6)
				secMax = timeMax.substring(6,8);
			String hourMax = timeMax.substring(0,2);
			String minutesMax = timeMax.substring(3,5);

			int timehourMin = Integer.parseInt(hourMin);
			int timemintuesMin = Integer.parseInt(mintuesMin);
			int timesecMin = Integer.parseInt(secMin);

			int timehourMax = Integer.parseInt(hourMax);
			int timeminutesMax = Integer.parseInt(minutesMax);
			int timesecMax = Integer.parseInt(secMax);

			int currTimeHour = Integer.parseInt(row.getTime().substring(11,13));
			int currTimeMinutes = Integer.parseInt(row.getTime().substring(14,16));
			int currTimeSec = Integer.parseInt(row.getTime().substring(17,19));

			if(currTimeHour > timehourMin && currTimeHour < timehourMax)
				timeExist.add(row);
			else if(currTimeHour >= timehourMin && currTimeHour <= timehourMax){
				if(currTimeMinutes < timemintuesMin){
					if(currTimeSec < timesecMin)
						timeExist.add(row);
					else if(currTimeSec > timesecMax)
						timeExist.add(row);
				}
				else if(currTimeMinutes > timeminutesMax){
					if(currTimeSec < timesecMin)
						timeExist.add(row);
					if(currTimeSec > timesecMax)
						timeExist.add(row);
				}
				else if(currTimeMinutes == timemintuesMin && currTimeMinutes == timeminutesMax ){
					if(currTimeSec < timesecMin)
						timeExist.add(row);
					else if( currTimeSec > timesecMax)
						timeExist.add(row);
				}
			}
		}
		return timeExist;
	}

}