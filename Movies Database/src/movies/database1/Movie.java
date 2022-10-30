package movies.database1;

public class Movie {
	private String name;
	private String category;
	private double rate;
	private int releaseDate;

	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public double getRate() {
		return rate;
	}
	
	public int getReleaseDate() {
		return releaseDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCategory(String category) {
		this.category = category.toLowerCase();
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
}
