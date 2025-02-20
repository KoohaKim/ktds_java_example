package stream.file.file;

import java.util.ArrayList;
import java.util.List;

public class States {
	private int id;
	private String name;
	private int countryId;
	private String countryNameCode;
	private String countryNameString;
	private String stateCode;
	private String type;
	private double latitude;
	private double longitude;

	private Country countries;
	private List<City> cities;
	
	public States(String[] stateData) {
		this(
				Integer.parseInt(stateData[0]),
				stateData[1],
				Integer.parseInt(stateData[2]),
				stateData[3],
				stateData[4],
				stateData[5],
				stateData[6],
				stateData.length > 7 ? Double.parseDouble(stateData[7]) : 0,
				stateData.length > 8 ? Double.parseDouble(stateData[8]) : 0
		);
	}

	
	public States(int id, String name, int countryId, String countryNameCode, String countryNameString,
			String stateCode, String type, double latitude, double longitude) {
		this.id = id;
		this.name = name;
		this.countryId = countryId;
		this.countryNameCode = countryNameCode;
		this.countryNameString = countryNameString;
		this.stateCode = stateCode;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
		this.cities = new ArrayList<>();
	}

	
	
	
	public Country getCountries() {
		return countries;
	}


	public void setCountries(Country countries) {
		this.countries = countries;
	}


	public List<City> getCities() {
		return cities;
	}


	public void setCities(List<City> cities) {
		this.cities = cities;
	}


	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getCountryId() {
		return this.countryId;
	}

	public String getCountryNameCode() {
		return this.countryNameCode;
	}

	public String getCountryNameString() {
		return this.countryNameString;
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public String getType() {
		return this.type;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}


	@Override
	public String toString() {
		return "States [id=" + id + ", name=" + name + ", countryId=" + countryId + ", countryNameCode="
				+ countryNameCode + ", countryNameString=" + countryNameString + ", stateCode=" + stateCode + ", type="
				+ type + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
	

}
