package persistence;

import model.Place;

public class PlaceRepository extends HibernateGenericDAO<Place> implements GenericRepository<Place> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9091266587325221855L;

	protected Class<Place> getDomainClass() {
		return Place.class;
	}

}
