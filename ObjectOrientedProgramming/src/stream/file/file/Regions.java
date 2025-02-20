package stream.file.file;

import java.util.ArrayList;
import java.util.List;

public class Regions {
    private int id;
    private String name;
    private String wikiDataId;

    private List<Subregion> subregions;	//has a 관계
  

    public Regions(String[] region) {
        this(
            Integer.parseInt(region[0]),  // id
            region[1],                     // name
            region[2]                      // wikiDataId
        );
    }

    public Regions(int id, String name, String wikiDataId) {
        this.id = id;
        this.name = name;
        this.wikiDataId = wikiDataId;
        this.subregions = new ArrayList<>();
    }

    
    
    public List<Subregion> getSubregions() {
		return this.subregions;
	}

	public void setSubregions(List<Subregion> subregions) {
		this.subregions = subregions;
	}

	public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getWikiDataId() {
        return this.wikiDataId;
    }

	@Override
	public String toString() {
		return "Regions [id=" + id + ", name=" + name + ", wikiDataId=" + wikiDataId + ", subregions=" + subregions
				+ "]";
	}



    
    
}
