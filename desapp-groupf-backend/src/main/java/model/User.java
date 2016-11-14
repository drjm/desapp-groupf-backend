package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class User implements Observer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5279960171841695330L;
	private Integer idUser;
	private Profile profile;
//	private HandlerEvent handlerEvent;
	private String name;
	private String surname;
	private String nik;
//	private FriendHandler frienHandler;
	private List<String> messages = new ArrayList<String>();
	private String mail;
	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

//	public FriendHandler getFrienHandler() {
//		return frienHandler;
//	}

//	public void setFrienHandler(FriendHandler frienHandler) {
//		this.frienHandler = frienHandler;
//	}

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

//	public HandlerEvent getHandlerEvent() {
//		return handlerEvent;
//	}

//	public void setHandlerEvent(HandlerEvent handlerEvent) {
//		this.handlerEvent = handlerEvent;
//	}

//	public void invited(Event event) {
//		this.getHandlerEvent().addPendingEvent(event);
//		event.addObserver(this);
//	}

//	public void acceptEvent(Event event) {
//		if (this.getHandlerEvent().getPendingEvents().contains(event)) {
//			this.getHandlerEvent().acceptEvent(event);
//			event.whereAddYou(this);
//		}
//	}

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
}
