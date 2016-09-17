package model;

public class Actived extends State {

	@Override
	public boolean isAvaliable() {
		return true;
	}

	@Override
	public void active(Event event) {
		return;
		
	}

	@Override
	public void cancel(Event event) {
		event.setState(new Canceled());
		event.setStateMessage("El evento a sido cancelado.");
		event.setChange();
		event.notifyObservers();
	}

	@Override
	public void finish(Event event) {

		event.setState(new Finished());
		event.setStateMessage("El evento a finalizo en forma correceta.");
		event.setChange();
		event.notifyObservers();

	}

}
