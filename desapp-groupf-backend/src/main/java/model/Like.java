package model;

public interface Like {

	public Integer getId();

	public void setId(Integer id);

	public String getName();

	public void setName(String name);

	public boolean isEquals(String name);

}
