package dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Place;
import model.State;

public class EventDTO {

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
	private List<UserDTO> users = new ArrayList<UserDTO>();

	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Integer getCantPerson() {
		return cantPerson;
	}

	public void setCantPerson(Integer cantPerson) {
		this.cantPerson = cantPerson;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getStateMessage() {
		return stateMessage;
	}

	public void setStateMessage(String stateMessage) {
		this.stateMessage = stateMessage;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

}
