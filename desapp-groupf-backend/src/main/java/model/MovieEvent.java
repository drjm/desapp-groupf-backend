package model;

import java.time.LocalDate;

public class MovieEvent extends Event {

	private GenderMovie genere;

	public MovieEvent(GenderMovie genero, String statTime, String endTime, LocalDate fecha, String descripcion,
			Long price, Boolean alone, Boolean inTwosome, Boolean inGroup, Place place) {

		super(statTime, endTime, fecha, descripcion, price, alone, inTwosome, inGroup, null, place);

		this.genere = genero;

	}

	public MovieEvent() {
		super(null, null, null, null, null, null, null, null, null, null);
	}

	public GenderMovie getGenere() {
		return genere;
	}

	public void setGenere(GenderMovie genere) {
		this.genere = genere;
	}

	@Override
	public Boolean isCompatible(Profile profile) {

		boolean ret = false;

		for (GenderMovie gm : profile.getMoviegeneres()) {
			ret = ret || gm.getName().equals(this.getGenere().getName());
		}
		return ret;

	}

	@Override
	public Boolean couldBelong(Profile profile) {
		return !profile.getMoviegeneres().isEmpty();
	}

	@Override
	public void whereAddYou(User user) {
		user.addMovie(this.getGenere());
	}

}
