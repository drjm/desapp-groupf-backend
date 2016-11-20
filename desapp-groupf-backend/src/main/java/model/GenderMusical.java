package model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GenderMusical implements Like, Serializable {

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

	public Integer getId() {
		return this.idGMusical;
	}

	public void setId(Integer id) {
		this.idGMusical = id;

	}

	public String getName() {

		return this.nameGMusical;
	}

	public void setName(String name) {
		this.nameGMusical = name;

	}

	public boolean isEquals(String name) {
		return this.getName().equals(name);
	}
}
