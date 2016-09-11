package model;

public class User {
	
	private Profile profile;
	private HandlerEvent handlerEvent;
	private String name;
	private String surname;
	private String nik;
	
	
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
	public HandlerEvent getHandlerEvent() {
		return handlerEvent;
	}
	public void setHandlerEvent(HandlerEvent handlerEvent) {
		this.handlerEvent = handlerEvent;
	}
	
	
}
