package stream.file.file;

import java.util.ArrayList;
import java.util.List;

public class Subregion {
    private int id;
    private String name;
    private int regionId;
    private String wikiDataId;
    
    private Regions regions;
    private List<Country> countries;

    public Subregion(String[] subregions) {
        this(
            Integer.parseInt(subregions[0]),        // id
            subregions[1],                           // name
            Integer.parseInt(subregions[2]),        // regionId
            subregions[3]                            // wikiDataId
        );
    }

    public Subregion(int id, String name, int regionId, String wikiDataId) {
        this.id = id;
        this.name = name;
        this.regionId = regionId;
        this.wikiDataId = wikiDataId;
        this.countries = new ArrayList<>();
    }
    
    

    public Regions getRegions() {
		return regions;
	}

	public void setRegions(Regions regions) {
		this.regions = regions;
	}


	
	
	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getRegionId() {
        return this.regionId;
    }

    public String getWikiDataId() {
        return this.wikiDataId;
    }

	@Override
	public String toString() {
		return "Subregions [id=" + id + ", name=" + name + ", regionId=" + regionId + ", wikiDataId=" + wikiDataId
				+ ", regions=" + regions + ", countries=" + countries + "]";
	}

	
    
 
}
