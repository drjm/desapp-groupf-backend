package model;

public class GenderMusical implements Like {

	private Integer id;
	private String name;

	public GenderMusical(String name) {
		this.name = name;
		
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id= id;
		
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public boolean isEquals(String name) {
		return this.getName().equals(name);
	}
}
