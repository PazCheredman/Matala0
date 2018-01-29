package version14;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class orFil {

	//private table tables;
	private outputTable orFil;
	private String filename1="",filename2="";
	
	public String getFilename1() {
		return filename1;
	}

	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}

	public String getFilename2() {
		return filename2;
	}

	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}

	public outputTable getOrFil() {
		return orFil;
	}


	/**
	 * read file after file and add to each row of filter chosen to arrayList
	 * parameters: 
	 * 1. String folder- the path where we want to save the output to it 
	 * 2. String filename- the first chosen
	 */
	public void readFolder(String folderpath, String filename){
		File folder=new File(folderpath);
		//tables=new table();
		File[] files = folder.listFiles();
		for(int i=0; i<files.length; i++){
			folderpath = files[i].getPath();
			if(folderpath.contains(filename))	{
				orFil.read(folderpath+"\\"+filename, true);
			}
			continue;
		}		
	}


	/**
	 * this function writes the array to csv file according the filters chosen
	 * parameters: 
	 * 1. arrayList that contains all the rows of the filter
	 * 2. String folder- the path where we want to save the output to it
	 * 3. String filename1- the first filter chosen
	 * 4. String filename2- the second filter chosen
	 * 
	 * filename1 && filename2 contains ".csv" ending
	 * fil1, fil2 = filename1, filename2 without ".csv" ending
	 * @throws IOException 
	 * 
	 */
	public void writeFileCsv(outputTable orFil, String folder, 
			String filename1, String filename2) throws IOException{
		this.filename1=filename1;
		this.filename2=filename2;
		String fil1= filename1.substring(0,filename1.length()-4);
		String fil2= filename2.substring(0,filename2.length()-4);
	
		orFil.write(folder+"\\"+fil1+fil2+".csv");
	}



	/**
	 * gets arrayList as a parameter and write the array to kml file
	 */
	public void writeFileKml(){

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
