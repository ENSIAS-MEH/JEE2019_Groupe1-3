package beans;

public class Terrain {
	private String description;
	private String image;
	private int id_terrain;
	private double prix;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId_terrain() {
		return id_terrain;
	}

	public void setId_terrain(int id_terrain) {
		this.id_terrain = id_terrain;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}
