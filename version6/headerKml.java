package version6;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="kml")
public class headerKml {
	
	private PlacemarkList pl= new PlacemarkList();
	
	public PlacemarkList getPl() {
		return pl;
	}
	
	@XmlElement(name="Placemark List")
	public void setPl(PlacemarkList pl) {
		this.pl = pl;
	}
	
	
	
}
