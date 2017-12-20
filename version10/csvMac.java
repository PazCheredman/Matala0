package version10;

public class csvMac {
	private readFolder rf;
	private table inTab = rf.getTables();
	private outputTable outTab;
	
	
	/**
	 * Processing data and creating new output table
	 */
	public void process(){
		outTab = new outputTable();
		inTab.sort();
		outputRow newRow= new outputRow();
		sortComp sorter= new sortComp();
		boolean first=false;
		rowMeasurement row =inTab.getRow(0);
		newRow.set(row.getTime(),row.getID(),row.getLAT(),row.getLON(), row.getALT());
		newRow.addWifi(row.getSSID(), row.getMAC(),row.getFrequncy(), row.getSIGNAL());

		for(int i=1; i<inTab.size(); i++){
			row =inTab.getRow(i);
			newRow.set(row.getTime(),row.getID(),row.getLAT(),row.getLON(), row.getALT());
			if(sorter.compare(row,inTab.getRow(i-1))==0 || first){
				first=false;
				if(newRow.getWifiCount()<10){
					newRow.addWifi(row.getSSID(), row.getMAC(),row.getFrequncy(), row.getSIGNAL());
				}
				else continue;
			}
			else{
				first= true;
				outTab.add(newRow);
				newRow= new outputRow();
			}
		}
	}
	


}
