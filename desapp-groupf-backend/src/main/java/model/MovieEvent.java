package model;

public class MovieEvent extends Event {

	private String genero;
	
	@Override
	public Boolean isCompatible(Profile profile) {
			
		return profile.getMoviegeneres().contains(genero);
	}

}
