package model;

public class MovieDTO {
	private int id;
	private String title;
	private String type;
	private int runtime;
	private String start_date;
	private String end_date;
	private String Genre;
	private double rating;
	private int rateUser;
	private double sumOfRating;
	private String director_name;
	
	
	
	
	
	public String getDirector_name() {
		return director_name;
	}
	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}
	public int getRateUser() {
		return rateUser;
	}
	public void setRateUser(int rateUser) {
		this.rateUser = rateUser;
	}
	public double getSumOfRating() {
		return sumOfRating;
	}
	public void setSumOfRating(double sumOfRating) {
		this.sumOfRating = sumOfRating;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", title=" + title + ", type=" + type + ", runtime=" + runtime + ", start_date="
				+ start_date + ", end_date=" + end_date + ", Genre=" + Genre + ", rating=" + rating + "]";
	}
}
