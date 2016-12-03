package dtos;

import java.util.ArrayList;
import java.util.List;

import model.Profile;

public class UserDTO {

	private Integer idUser;
	private Profile profile;
	private String name;
	private String surname;
	private String nik;
	private List<String> messages = new ArrayList<String>();
	private String mail;
	private List<EventDTO> eventsToattend = new ArrayList<EventDTO>();
	private List<EventDTO> myEvents = new ArrayList<EventDTO>();
	private List<UserDTO> listFriends = new ArrayList<UserDTO>();
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
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
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<EventDTO> getEventsToattend() {
		return eventsToattend;
	}
	public void setEventsToattend(List<EventDTO> eventsToattend) {
		this.eventsToattend = eventsToattend;
	}
	public List<EventDTO> getMyEvents() {
		return myEvents;
	}
	public void setMyEvents(List<EventDTO> myEvents) {
		this.myEvents = myEvents;
	}
	public List<UserDTO> getListFriends() {
		return listFriends;
	}
	public void setListFriends(List<UserDTO> listFriends) {
		this.listFriends = listFriends;
	}

	
}
