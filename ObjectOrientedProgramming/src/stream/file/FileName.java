package stream.file;

public enum FileName {
	CITIES("cities.csv"),
	COUNTRIES("countries.csv"),
	REGIONS("regions.csv"),
	STATES("states.csv"),
	SUBREGIONS("subregions.csv");
	
	
	public String fileName;
	
	private FileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
