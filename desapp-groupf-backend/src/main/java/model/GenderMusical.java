package model;

public class GenderMusical implements Like {

	private Integer id;
	private String name;

	public GenderMusical(String name) {
		this.name = name;

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
