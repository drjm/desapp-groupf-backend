package model;

import java.util.Date;

public class MovieEvent extends Event {

	private String genere;
	
	public MovieEvent(String genero,String statTime, String endTime, Date fecha, String descripcion, Long price, Boolean alone, Boolean inTwosome, Boolean inGroup){
		
		super(statTime,  endTime, fecha, descripcion,  price, alone,inTwosome,inGroup);	

		genere = genero;
		
	}
	
	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	@Override
	public Boolean isCompatible(Profile profile) {
			
		return profile.getMoviegeneres().contains(this.getGenere());
	}

	@Override
	public Boolean couldBelong(Profile profile) {
		return ! profile.getMoviegeneres().isEmpty();
	}
	
	@Override
	public void whereAddYou(User user) {
		user.addMovie(this.getGenere());
	}
	
}
