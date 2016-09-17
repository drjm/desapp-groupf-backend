package model;

public class Finished extends State {

	@Override
	public boolean isAvaliable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void active(Event event) {
		return;
	}

	@Override
	public void cancel(Event event) {
		return;

	}

	@Override
	public void finish(Event event) {
		return;

	}

}
