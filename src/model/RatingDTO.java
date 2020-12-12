package model;

public class RatingDTO {
	private int movie_id;
	private int account_id;
	private String account_username;
	private String movie_title;
	private String movie_type;
	private int movie_runtime;
	private String movie_start_date;
	private String movie_end_date;
	private String movie_genre;
	private double movie_rating;
	
	private double my_rating;
	private String my_comments;
	
	
	
	
	public String getAccount_username() {
		return account_username;
	}
	public void setAccount_username(String account_username) {
		this.account_username = account_username;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getMovie_genre() {
		return movie_genre;
	}
	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getMovie_type() {
		return movie_type;
	}
	public void setMovie_type(String movie_type) {
		this.movie_type = movie_type;
	}
	public int getMovie_runtime() {
		return movie_runtime;
	}
	public void setMovie_runtime(int movie_runtime) {
		this.movie_runtime = movie_runtime;
	}
	public String getMovie_start_date() {
		return movie_start_date;
	}
	public void setMovie_start_date(String movie_start_date) {
		this.movie_start_date = movie_start_date;
	}
	public String getMovie_end_date() {
		return movie_end_date;
	}
	public void setMovie_end_date(String movie_end_date) {
		this.movie_end_date = movie_end_date;
	}
	public double getMovie_rating() {
		return movie_rating;
	}
	public void setMovie_rating(double movie_rating) {
		this.movie_rating = movie_rating;
	}
	public double getMy_rating() {
		return my_rating;
	}
	public void setMy_rating(double my_rating) {
		this.my_rating = my_rating;
	}
	public String getMy_comments() {
		return my_comments;
	}
	public void setMy_comments(String my_comments) {
		this.my_comments = my_comments;
	}
	
	@Override
	public String toString() {
		return "RatingDTO [movie_id=" + movie_id + ", movie_title=" + movie_title + ", movie_type=" + movie_type
				+ ", movie_runtime=" + movie_runtime + ", movie_start_date=" + movie_start_date + ", movie_end_date="
				+ movie_end_date + ", movie_genre=" + movie_genre + ", movie_rating=" + movie_rating + ", my_rating="
				+ my_rating + ", my_comments=" + my_comments + "]";
	}
	

}
