package model;

public class OtherLike implements Like {

	private Integer id;
	private String name;

	public OtherLike(String string) {
		this.name = string;
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
