package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "profile")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1365365124943834617L;

	private Integer idProfile;
	@JsonProperty("musicalGeneres")
	private List<GenderMusical> musicalGeneres = new ArrayList<GenderMusical>();
	@JsonProperty("moviegeneres")
	private List<GenderMovie> moviegeneres = new ArrayList<GenderMovie>();
	@JsonProperty("foodTastes")
	private List<TypeFood> foodTastes = new ArrayList<TypeFood>();
	@JsonProperty("otherLikes")
	private List<OtherLike> otherLikes = new ArrayList<OtherLike>();
	private Long amountMax;
	private String conveyance;
	private String startTime;
	private String nik;

	public Profile() {

	}

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	public List<GenderMusical> getMusicalGeneres() {
		return musicalGeneres;
	}

	public void setMusicalGeneres(List<GenderMusical> musicalGeneres) {
		this.musicalGeneres = musicalGeneres;
	}

	public List<GenderMovie> getMoviegeneres() {
		return moviegeneres;
	}

	public void setMoviegeneres(List<GenderMovie> moviegeneres) {
		this.moviegeneres = moviegeneres;
	}

	public List<TypeFood> getFoodTastes() {
		return foodTastes;
	}

	public void setFoodTastes(List<TypeFood> foodTastes) {
		this.foodTastes = foodTastes;
	}

	public List<OtherLike> getOtherLikes() {
		return otherLikes;
	}

	public void setOtherLikes(List<OtherLike> otherLikes) {
		this.otherLikes = otherLikes;
	}

	public void setAmountMax(Long amuntMax) {
		this.amountMax = amuntMax;
	}

	public long getAmountMax() {
		return amountMax;
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

	public void addFood(TypeFood food) {
		this.getFoodTastes().add(food);
	}

	public void addMovie(GenderMovie movie) {
		this.getMoviegeneres().add(movie);
	}

	public void addMusic(GenderMusical music) {
		this.getMusicalGeneres().add(music);
	}

	public void addOther(OtherLike other) {
		this.getOtherLikes().add(other);
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String toString() {
		String ret = "\n ------PROFILE------- \n{";
		ret += "\n NIK: " + this.getNik();
		ret += "\n Amount max: " + this.getAmountMax();
		ret += "\n Conveyance: " + this.getConveyance();
		ret += "\n}\n ------PROFILE-------";
		return ret;
	}
}
