package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idEventT")
public class Event extends Observable {

	private Integer idEvent;
	private String title;
	private String starTime;
	private String endTime;
	private LocalDate date;
	private String description;
	private List<Integer> idsSuggestionsRelation;
	private Integer cantPerson;
	private Long price;
	private Boolean alone;
	private Boolean inTwosome;
	private Boolean inGruop;
	private State state;
	private String stateMessage;
	private Place place;
	private List<User> users = new ArrayList<User>();

	public Event(String title, String statTime, String endTime, LocalDate fecha, String descripcion, Long price,
			Boolean alone, Boolean inTwosome, Boolean inGroup, Integer cantPerson, Place placeP) {

		this.title = title;
		this.starTime = statTime;
		this.endTime = endTime;
		this.date = fecha;
		this.description = descripcion;
		this.price = price;
		this.alone = alone;
		this.inTwosome = inTwosome;
		this.inGruop = inGroup;
		this.state = new Actived();
		this.cantPerson = 10;
		this.place = placeP;
		this.setStateMessage("Tiene un nuevo evento asignado:" + descripcion);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Long getPrice() {
		return price;

	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer id) {
		this.idEvent = id;
	}

	public String getStarTime() {
		return starTime;
	}

	public void setStarTime(String starTime) {
		this.starTime = starTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getIdsSuggestionsRelation() {
		return idsSuggestionsRelation;
	}

	public void setIdsSuggestionsRelation(List<Integer> idsSuggestionsRelation) {
		this.idsSuggestionsRelation = idsSuggestionsRelation;
	}

	public Boolean getAlone() {
		return alone;
	}

	public void setAlone(Boolean alone) {
		this.alone = alone;
	}

	public Boolean getInTwosome() {
		return inTwosome;
	}

	public void setInTwosome(Boolean inTwosome) {
		this.inTwosome = inTwosome;
	}

	public Boolean getInGruop() {
		return inGruop;
	}

	public void setInGruop(Boolean inGruop) {
		this.inGruop = inGruop;
	}

	public Boolean isCompatible(Profile profile) {
		try {
			throw new Exception("Implementar");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Boolean couldBelong(Profile profile) {
		try {
			throw new Exception("Implementar");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@JsonIgnore
	public Boolean isAvaliable() {
		return this.getState().isAvaliable();

	}

	public void active() {
		this.getState().active(this);
	}

	public void cancel() {
		this.getState().cancel(this);
	}

	public void finish() {
		this.getState().finish(this);
	}

	public boolean timeStartIn(Profile profile, String currentTime, String endTime2) {

		return true;
	}

	public void whereAddYou(User user) {
		try {
			throw new Exception("Implementar");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setChange() {
		this.setChanged();
	}

	public String getStateMessage() {
		return stateMessage;
	}

	public void setStateMessage(String mensajeEstado) {
		this.stateMessage = mensajeEstado;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Integer getCantPerson() {
		return cantPerson;
	}

	public void setCantPerson(Integer cantPerson) {
		this.cantPerson = cantPerson;
	}

	public void addUser(User user) {
		this.getUsers().add(user);
	}

}
