package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class Event {

	private Long id;
	private String starTime;
	private String endTime;
	private Date date;
	private String description;
	private List<Long> idsSuggestionsRelation;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
	private Long price;
	private Boolean alone;
	private Boolean inTwosome;
	private Boolean inGruop;
	private State state;


	public Event(String statTime, String endTime, Date fecha, String descripcion, Long price, Boolean alone, Boolean inTwosome, Boolean inGroup){
		
		this.starTime = statTime;
		this.endTime = endTime;
		this.date = fecha;
		this.description = descripcion;
		this.price = price;
		this.alone = alone;
		this.inTwosome = inTwosome;
		this.inGruop = inGroup;
		this.state = new Actived();
	}
	
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
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
	public Boolean getAlone() {
		return alone;
	}
	public void setAlone(Boolean alone) {
		this.alone = alone;
	}
	public Boolean getInTwosome() {
		return inTwosome;
	}
	public void setInTwosome(Boolean inTwosome) {
		this.inTwosome = inTwosome;
	}
	public Boolean getInGruop() {
		return inGruop;
	}
	public void setInGruop(Boolean inGruop) {
		this.inGruop = inGruop;
	}
	
	public abstract Boolean isCompatible(Profile profile);
	
	public abstract Boolean couldBelong(Profile profile);
	
	public Boolean isAvaliable(){
		return this.getState().isAvaliable();
	}

}
