package version14;

import java.io.IOException;

import javax.print.attribute.standard.MediaSize.Other;

public class mainRun {

	private csv tab;
	private testKml kml;
	private String kmlPath;
	
	public mainRun(){
		tab=new csv();
		kml= new testKml();
	}
	
	public csv delete(csv tab){
		if(tab.getCsv().size()<1){
			return tab;
		}
		else{
			tab.delete();
			return tab;
		}
	}
	
	public csv init(String wigfile,String otrfdr, String filename) {
		try {
			kmlPath= otrfdr;
			tab.read(wigfile);
			tab.process();
			tab.write(otrfdr+"\\"+filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tab;
	}
	
	public String getKmlPath() {
		return kmlPath;
	}

	
	public testKml initiliaze(String path, String fileNameOfCsvUnited){
		//String path = getKmlPath();
		kml.readCsvFile(path, fileNameOfCsvUnited);
		return kml;
	}
	
	/*
	public static void main(String args[]){
		mainRun f= new mainRun();
		f.init("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\creategmon",
				"C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon", "gmon.csv");
		f.initiliaze("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon", "gmon.csv");
		
		
	}
*/


}
