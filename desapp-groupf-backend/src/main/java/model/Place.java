package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name = "place")
public class Place implements Serializable {

	private static final long serialVersionUID = 9188790034869116102L;
	@XmlElement
	private Integer idPlace;
	@XmlElement
	private String name;
	@XmlElement
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
