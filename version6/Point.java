package version6;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Point {

		private String coordinates;

		public String getCoordinates() {
			return coordinates;
		}
	
		@XmlElement
		public void setCoordinates(String coordinates) {
			this.coordinates = coordinates;
		}
	}

