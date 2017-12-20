package version6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;


public class kml {
	
	private static TimeStamp ts = new TimeStamp();
	
	private static void readCsvFile(String fileName){
		// try read from the file
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;

			str = br.readLine();
			str = br.readLine();
			List <String> secondLine= Arrays.asList(str.split(","));
			String time = secondLine.get(0);
			String id = secondLine.get(1);
			String lat = secondLine.get(2);
			String lon = secondLine.get(3);
			String alt = secondLine.get(4);

			while(str != null){
				addTimeElem(time);
				List <String> tempfilesArray= Arrays.asList(str.split(","));
				time = tempfilesArray.get(0);
				id = tempfilesArray.get(1);
				ts.addToObjectSimpleExtension(time);
				ts.addToObjectSimpleExtension(id);

				str = br.readLine();

			}


			str = br.readLine();
			str = br.readLine();
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}
	private static void addTimeElem(String time){
		headerKml hk= new headerKml();
		Placemark p1= new Placemark();
		p1.setTime(time);
		PlacemarkList pcl= hk.getPl();
		pcl.add(p1);
		//System.out.println(p1.getTime());
		try {

			File file = new File("C:\\Users\\InnaPC\\Desktop\\munhe\\Lenovo\\kml.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(headerKml.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(hk, file);
			jaxbMarshaller.marshal(hk, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args) throws IOException{

		//csv table= new csv(); 
		//table.write();
		String filepath="C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\gmon.csv"; 
		readCsvFile(filepath);


		/*
		headerKml hk= new headerKml();

		//placemark1- initiliazing placemark + enter data 
		Placemark p1= new Placemark();
		p1.setTime("12:34");
		p1.setId("Dell");
		Point po1= new Point();
		po1.setCoordinates("3.4, 22.0 ,2");
		p1.setPoint(po1);
		p1.setDescription("ssid1");

		//placemark1- initiliazing placemark + enter data 
		Placemark p2= new Placemark();
		p2.setTime("12:35");
		p2.setId("Lenovo");
		Point po2= new Point(); 
		po2.setCoordinates("1.8, 2.0, 2");
		p2.setPoint(po2);
		p2.setDescription("ssid2");

		//placemarkList- initiliazing placemarkList + enter placemark
		PlacemarkList pcl= hk.getPl();
		pcl.add(p1);
		pcl.add(p2);


		try {

			File file = new File("C:\\Users\\Paz Cheredman\\Desktop\\munchex0\\27.10\\kml.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(headerKml.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(hk, file);
			jaxbMarshaller.marshal(hk, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}



		 */
	}


}
