package model;

public class GenderMovie implements Like{

	private Integer id;
	private String name;

	public GenderMovie(String aCCION) {
		this.name = aCCION;
	}

	public GenderMovie() {
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
