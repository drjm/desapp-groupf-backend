package model;

public class Canceled extends State {

	@Override
	public boolean isAvaliable() {
		return false;
	}

	@Override
	public void active(Event event) {

		event.setState(new Actived());
		event.setStateMessage("El evento a sido reactivado");
		event.setChange();
		event.notifyObservers();

	}

	@Override
	public void cancel(Event event) {
		return;
	}

	@Override
	public void finish(Event event) {

		event.setState(new Finished());
		event.setStateMessage("El evento finalizo en forma correcta");
		event.setChange();
		event.notifyObservers();

	}

}
