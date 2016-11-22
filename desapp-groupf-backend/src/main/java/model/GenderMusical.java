package model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GenderMusical implements Serializable {

	private static final long serialVersionUID = -7819380468207842602L;
	@JsonProperty
	private Integer idGMusical;
	@JsonProperty
	private String nameGMusical;

	@JsonCreator
	public GenderMusical(String name) {
		this.idGMusical = null;
		this.nameGMusical = name;

	}

	public GenderMusical() {

	}

	public Integer getIdGMusical() {
		return idGMusical;
	}

	public void setIdGMusical(Integer idGMusical) {
		this.idGMusical = idGMusical;
	}

	public String getNameGMusical() {
		return nameGMusical;
	}

	public void setNameGMusical(String nameGMusical) {
		this.nameGMusical = nameGMusical;
	}

	public boolean isEquals(String name) {
		return this.getNameGMusical().equals(name);
	}
}
