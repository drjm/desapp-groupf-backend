package model;

public class MovieEvent extends Event {

	private String genere;
	
	public MovieEvent(String genero){
		
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

	
}
