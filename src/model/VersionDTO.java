package model;

public class VersionDTO {
	private int movie_id;
	private int nationality_id;
	private String version_title;
	private String is_original;
	private String movie_title;
	private String nationality_short;
	
	
	
	
	public String getNationality_short() {
		return nationality_short;
	}
	public void setNationality_short(String nationality_short) {
		this.nationality_short = nationality_short;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getNationality_id() {
		return nationality_id;
	}
	public void setNationality_id(int nationality_id) {
		this.nationality_id = nationality_id;
	}
	public String getVersion_title() {
		return version_title;
	}
	public void setVersion_title(String version_title) {
		this.version_title = version_title;
	}
	public String getIs_original() {
		return is_original;
	}
	public void setIs_original(String is_original) {
		this.is_original = is_original;
	}
	
	
	
}
