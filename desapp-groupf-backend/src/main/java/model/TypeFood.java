package model;

public class TypeFood implements Like{

	private Integer id;
	private String nameFood;

	
	public TypeFood(String name) {
	this.nameFood = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return nameFood;
	}


	public void setName(String name) {
		this.nameFood = name;
	}


	public boolean isEquals(String name) {
		return this.getName().equals(name);
	}


}
