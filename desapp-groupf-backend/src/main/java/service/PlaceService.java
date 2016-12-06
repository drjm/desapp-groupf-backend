package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Place;
import util.ConsumeDBBA;

public class PlaceService extends GenericService<Place> implements Initialize {

	private static final long serialVersionUID = -538179626253059031L;

	@Transactional
	public void initialize() {
		ConsumeDBBA consume = new ConsumeDBBA();
		List<Place> places = consume.getElements();

		for (Place place : places) {
			this.getRepository().save(place);
		}

	}

}
