package model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;

public class GenderMusical implements Like, Serializable {

	private static final long serialVersionUID = -7819380468207842602L;
	private Integer id;
	private String name;

	@JsonCreator
	public GenderMusical(String name) {
		this.name = name;

	}

	public GenderMusical() {

	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;

	}

	public String getName() {

		return this.name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public boolean isEquals(String name) {
		return this.getName().equals(name);
	}
}
