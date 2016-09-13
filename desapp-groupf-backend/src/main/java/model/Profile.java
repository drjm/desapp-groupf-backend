package model;

import java.util.List;

public class Profile {
	
	private Long id;
	private List<String> musicalGeneres;
	private List<String> moviegeneres;
	private List<String> foodTastes;
	private List<String> otherLikes;
	private Long amuntMax;
	private String conveyance;
	private String startTime;

	
	public List<String> getOtherLikes() {
		return otherLikes;
	}
	public void setOtherLikes(List<String> otherLikes) {
		this.otherLikes = otherLikes;
	}
	public void setAmuntMax(Long amuntMax) {
		this.amuntMax = amuntMax;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<String> getMusicalGeneres() {
		return musicalGeneres;
	}
	public void setMusicalGeneres(List<String> musicalGeneres) {
		this.musicalGeneres = musicalGeneres;
	}
	public List<String> getMoviegeneres() {
		return moviegeneres;
	}
	public void setMoviegeneres(List<String> moviegeneres) {
		this.moviegeneres = moviegeneres;
	}
	public List<String> getFoodTastes() {
		return foodTastes;
	}
	public void setFoodTastes(List<String> foodTastes) {
		this.foodTastes = foodTastes;
	}
	public long getAmuntMax() {
		return amuntMax;
	}
	public String getConveyance() {
		return conveyance;
	}
	public void setConveyance(String conveyance) {
		this.conveyance = conveyance;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	
}
