package stream.file.file;

public class City {
    private int id;
    private String name;
    private int stateId;
    private String stateCode;
    private String stateName;
    private int countryId;
    private String countryCode;
    private String countryName;
    private double latitude;
    private double longitude;
    private String wikiDataId;

    public City(String[] city) {
        this(
            Integer.parseInt(city[0]),         // id
            city[1],                           // name
            Integer.parseInt(city[2]),         // stateId
            city[3],                           // stateCode
            city[4],                           // stateName
            Integer.parseInt(city[5]),         // countryId
            city[6],                           // countryCode
            city[7],                           // countryName
            Double.parseDouble(city[8]),       // latitude
            Double.parseDouble(city[9]),       // longitude
            city.length > 10 ? city[10] : ""    // wikiDataId
        );
    }

    
    public City(int id, String name, int stateId, String stateCode, 
                String stateName, int countryId, String countryCode, String countryName, 
                double latitude, double longitude, String wikiDataId) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.countryId = countryId;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.wikiDataId = wikiDataId;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getStateId() {
        return this.stateId;
    }

    public String getStateCode() {
        return this.stateCode;
    }

    public String getStateName() {
        return this.stateName;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getWikiDataId() {
        return this.wikiDataId;
    }


	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", stateId=" + stateId + ", stateCode=" + stateCode
				+ ", stateName=" + stateName + ", countryId=" + countryId + ", countryCode=" + countryCode
				+ ", countryName=" + countryName + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", wikiDataId=" + wikiDataId + "]";
	}
    
    
}
