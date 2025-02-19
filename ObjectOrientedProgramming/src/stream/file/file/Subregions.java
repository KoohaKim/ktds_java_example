package stream.file.file;

public class Subregions {
    private int id;
    private String name;
    private int regionId;
    private String wikiDataId;

    public Subregions(String[] subregions) {
        this(
            Integer.parseInt(subregions[0]),        // id
            subregions[1],                           // name
            Integer.parseInt(subregions[2]),        // regionId
            subregions[3]                            // wikiDataId
        );
    }

    public Subregions(int id, String name, int regionId, String wikiDataId) {
        this.id = id;
        this.name = name;
        this.regionId = regionId;
        this.wikiDataId = wikiDataId;
    }

    // Getter 메소드들
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
				+ "]";
	}
    
    
    
}
