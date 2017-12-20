package version6;
import javax.xml.*;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@XmlRootElement(name="Placemark List")
public class Placemark {

	private String time;
	private String id; 
	private String description;
	private Point point;


	@XmlElement(name="description")
	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name="Time")
	public void setTime(String time) {
		this.time = time;
	}

	@XmlElement(name="Id")
	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name="Point")
	public void setPoint(Point point) {
		this.point = point;
	}

	/*
	@XmlElement(name="description of wifi network")
	public void setDescription(String ssid, String mac, double frequncy, double signal) {
		for(int i=0; i<description.length; i++){
			description[i].setAll(ssid, mac, frequncy, signal);
		}
	}*/


	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Point getPoint() {
		return point;
	}

	public String getTime() {
		return time;
	}

	public void setDescription(String string, String string2, int i, int j) {
		// TODO Auto-generated method stub

	}

}
