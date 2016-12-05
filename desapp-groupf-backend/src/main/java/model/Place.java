package model;

import java.io.Serializable;

public class Place implements Serializable {

	private static final long serialVersionUID = 9188790034869116102L;
	private Integer idPlace;
	private String name;
	private String address;

	public Place() {

	}

	public Place(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Integer id) {
		this.idPlace = id;
	}

}
