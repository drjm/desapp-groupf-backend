package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Event {

	private Long id;
	private String starTime;
	private String endTime;
	private Date date;
	private String description;
	private List<Long> idsSuggestionsRelation;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
	private int price;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStarTime() {
		return starTime;
	}
	public void setStarTime(String starTime) {
		this.starTime = starTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Long> getIdsSuggestionsRelation() {
		return idsSuggestionsRelation;
	}
	public void setIdsSuggestionsRelation(List<Long> idsSuggestionsRelation) {
		this.idsSuggestionsRelation = idsSuggestionsRelation;
	}
	public SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}
	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}
	
}
