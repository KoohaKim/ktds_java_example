package stream.file.file;

public class Regions {
    private int id;
    private String name;
    private String wikiDataId;

  

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
		return "Regions [id=" + id + ", name=" + name + ", wikiDataId=" + wikiDataId + "]";
	}
    
    
    
}
