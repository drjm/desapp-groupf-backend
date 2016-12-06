package model;

public class TypeFood implements Like {

	private Integer id;
	private String name;

	public TypeFood(String name) {
		this.name = name;
	}

	public TypeFood() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEquals(String name) {
		return this.getName().equals(name);
	}

}
