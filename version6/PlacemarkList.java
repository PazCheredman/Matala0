package version6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Placemark List")
public class PlacemarkList {

	private List<Placemark> placeList;
	
	public PlacemarkList(){
		placeList = new ArrayList<Placemark>();
	}
	

	@XmlElement(name="Placemark")
	public void setPlaceList(List<Placemark> placeList) {
		this.placeList = placeList;
	}

	public void add(Placemark place){
		if( this.placeList == null ){
			this.placeList = new ArrayList<Placemark>();
		}
		this.placeList.add( place);
	}
	

	public List<Placemark> getPlaceList() {
		return placeList;
	}
	
}