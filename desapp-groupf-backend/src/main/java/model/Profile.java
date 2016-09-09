package model;

import java.util.List;

public class Profile {
	
	private Long id;
	private List<String> musicalGeneres;
	private List<String> moviegeneres;
	private List<String> foodTastes;
	private Long amuntMax;
	private String conveyance;
	
	
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
	public void setAmuntMax(long amuntMax) {
		this.amuntMax = amuntMax;
	}
	public String getConveyance() {
		return conveyance;
	}
	public void setConveyance(String conveyance) {
		this.conveyance = conveyance;
	}
	
	
}
