package version14;

import java.io.File;
import java.io.IOException;
import javax.print.attribute.standard.MediaSize.Other;

public class mainRun {

	private csv tab;
	private testKml kml= new testKml();
	private String kmlPath;
	
	public mainRun(){
		tab=new csv();
		kml= new testKml();
	}
	
	public void delete(){
		tab.getOutTabCsv().deleteAllData2();
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
		kml.readCsvFile(path , fileNameOfCsvUnited);
		return kml;
	}
	
	public boolean readFolderOk(String directory){
		File folder=new File(directory);
			if(directory.contains(".csv"))	{
				return true;
			}
		return false;
	}
	
	public boolean okay(String path){
		boolean result= readFolderOk(path);
		if (result){
			return true;
		}
		return false;
	}
	
	
	public static void main(String args[]){
		mainRun f= new mainRun();
		f.init("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\creategmon",
				"C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon", "gmon.csv");
		f.initiliaze("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon", "gmon.csv");
		boolean ok=f.okay("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon\\"+"gmon.csv");
		System.out.println(ok);
		//f.tab.delete();
		
	}



}
