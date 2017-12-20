package version11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;

public class Algorithm2 {

	static final double power=2;
	static final double norm=10000;
	static final double sigDiff=0.4;
	static final double minDiff=3;
	static final double noSignal=-120;
	static final double diffNoSignal=100;

	public locationSignal algorithem2(outputTable tbl, List<String> macs, List<Double> signals){
		Algo2 algo = new Algo2();
		for (int i=0; i < tbl.size() ;i++) {
			// look for mac in row
			outputRow row = tbl.getRow(i);
			if (row.haveAnyMac(macs)) {
				double pi = 1;
				for (int j=0; j< macs.size(); j++) {	
					double signal = row.getSignal(macs.get(j));
					double diff;
					if (signal == Double.NaN){
						signal = noSignal;
						diff = diffNoSignal;
					}
					double sigInput = signals.get(j);
					diff = Math.max(Math.abs(sigInput-sigInput),minDiff);
					double weight = norm/(Math.pow(diff,sigDiff )*Math.pow(sigInput,power));
					pi *= weight;
				}
				algo.add(pi,i);
			}
		}
		algo.sort();
		double sumLat=0, sumLon=0, sumAlt=0, sumWeight=0;
		int min = Math.min(3, algo.size());
		for (int k=0; k<min; k++){
			int index = algo.get(k).getIndex();
			double pi = algo.get(k).getPi();
			double lat = tbl.getRow(index).getLat();
			double lon = tbl.getRow(index).getLon();
			double alt= tbl.getRow(index).getAlt();
			sumLat+=lat * pi;
			sumLon+=lon * pi;
			sumAlt+=alt *pi;
			sumWeight+=pi;
		}

		locationSignal ls=new locationSignal();
		if(sumWeight >0){
			double avgLat=sumLat/sumWeight;
			double avgLon=sumLon/sumWeight;
			double avgAlt=sumAlt/sumWeight;

			ls.setAll(avgLat,avgLon,avgAlt,0);
			return ls;

		}
		else{
			System.out.println("no mac found:"+macs.toString());
			return null;
		}
	}
	/**
	 * gets the signal from our csv that matches the mac we received from the client and the signal he entered.
	 * calculation: calculating the difference between them both and then calculating theirs average  = 1/difference^0.4 * signal received^2
	 * @param sig
	 * @param sigInput
	 * @return
	 */

	/*
	public double algoWeight2(double sig, double sigInput){
		double diff;
		if(sig == sigInput){
			diff = 100;
		}
		else{
			diff = Math.max(Math.abs(sigInput-sig),3);
		}
		return 1/(Math.pow(diff,0.4 )*Math.pow(sigInput,2 ));

	}

	//אמור להיות החישוב הסופי יחד עם האלגוריתם הראשון
	public void algoSum2(){

	}


	 */



}
