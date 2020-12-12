package model;

public class EpisodeDTO {
	private String movie_title;
	private int season;
	private int episodeNum;
	private String episodeTitle;
	private int episodeRuntime;
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public int getEpisodeNum() {
		return episodeNum;
	}
	public void setEpisodeNum(int episodeNum) {
		this.episodeNum = episodeNum;
	}
	public String getEpisodeTitle() {
		return episodeTitle;
	}
	public void setEpisodeTitle(String episodeTitle) {
		this.episodeTitle = episodeTitle;
	}
	public int getEpisodeRuntime() {
		return episodeRuntime;
	}
	public void setEpisodeRuntime(int episodeRuntime) {
		this.episodeRuntime = episodeRuntime;
	}
	
	
}
