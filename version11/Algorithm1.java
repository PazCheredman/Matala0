package version11;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import version11.locationSignal;

public class Algorithm1 {

	private MacSignalContainer macSignals;

	public void setSignalData(MacSignalContainer msc) {
		macSignals = msc;
	}

	/**
	 * Evaluate place of every mac
	 */
	public void algorithem1(String file) throws IOException {
		FileWriter writer = new FileWriter(file);
		writer.write("mac,lat,lon,alt\n");
		for (int i = 0; i < macSignals.size(); i++) {
			MacSignal mc = macSignals.get(i);
			String mac = mc.getMac();
			double sumLat = 0, sumLon = 0, sumAlt = 0, sumWeight = 0;
			for (int j = 0; j < mc.getSize(); j++) {
				double weight = algoWeight1(mc.getSignal(j));
				sumLat += mc.getLat(j) * weight;
				sumLon += mc.getLon(j) * weight;
				sumAlt += mc.getAlt(j) * weight;
				sumWeight += weight;
			}
			if (sumWeight > 0) {
				double avgLat = sumLat / sumWeight;
				double avgLon = sumLon / sumWeight;
				double avgAlt = sumAlt / sumWeight;

				writer.write(mac + "," + avgLat + "," + avgLon + "," + avgAlt + "\n");

			} else {
				System.out.println("mac not found");
			}
		}
		writer.close();
	}

	/**
	 * 
	 * @param signal
	 * @return 1/(signal*signal)
	 */
	public double algoWeight1(double signal) {
		return 1 / (signal * signal);
	}
}
