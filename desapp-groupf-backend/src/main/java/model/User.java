package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.persistence.Transient;

public class User implements Observer, Serializable {

	private static final long serialVersionUID = -5279960171841695330L;
	private Integer idUser;
	private Profile profile;
	@Transient
	private HandlerEvent handlerEvent;
	private String name;
	private String surname;
	private String nik;
	@Transient
	private FriendHandler frienHandler;
	private List<String> messages = new ArrayList<String>();
	private String mail;
	private List<Event> eventsToattend = new ArrayList<Event>();
	private List<Event> myEvents = new ArrayList<Event>();
	private List<User> listFriends = new ArrayList<User>();

	public User() {

	}

	public User(String name, String surname, String nik, String mail) {
		this.name = name;
		this.surname = surname;
		this.nik = nik;
		this.mail = mail;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public FriendHandler friendHandrler() {
		return frienHandler;
	}

	public void frienHandler(FriendHandler frienHandler) {
		this.frienHandler = frienHandler;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public HandlerEvent eventHandler() {
		return handlerEvent;
	}

	public void eventHandler(HandlerEvent handlerEvent) {
		this.handlerEvent = handlerEvent;
	}

	public void invited(Event event) {
		this.eventHandler().addPendingEvent(event);
		event.addObserver(this);
	}

	public void acceptEvent(Event event) {
		if (this.eventHandler().getPendingEvents().contains(event)) {
			this.eventHandler().acceptEvent(event);
			event.whereAddYou(this);
		}
	}

	public void attendEvent(Event event) {
		this.getEventsToattend().add(event);
	
	}

	public void addFood(TypeFood food) {
		this.getProfile().addFood(food);
	}

	public void addMovie(GenderMovie movie) {
		this.getProfile().addMovie(movie);
	}

	public void addMusic(GenderMusical music) {
		this.getProfile().addMusic(music);
	}

	public void addOther(OtherLike other) {
		this.getProfile().addOther(other);
	}

	public void update(Observable o, Object arg) {

		Event event = (Event) o;
		this.recivrMessage("El Evento: " + event.getIdEvent() + "fue suspendido por el organizador del mismo");

	}

	private void recivrMessage(String string) {

		this.getMessages().add(string);
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Event> getEventsToattend() {
		return eventsToattend;
	}

	public void setEventsToattend(List<Event> eventsToattend) {
		this.eventsToattend = eventsToattend;
	}

	public void addToMyEvents(Event event) {
		this.getMyEvents().add(event);

	}

	public List<Event> getMyEvents() {
		return myEvents;
	}

	public void setMyEvents(List<Event> myEvents) {
		this.myEvents = myEvents;
	}

	public List<User> getListFriends() {
		return listFriends;
	}

	public void setListFriends(List<User> listFriends) {
		this.listFriends = listFriends;
	}

	public void addFrien(User friend) {
		this.getListFriends().add(friend);
		friend.getListFriends().add(this);
	}

}
