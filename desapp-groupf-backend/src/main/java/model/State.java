package model;

public abstract class State {

	public abstract boolean isAvaliable();

	public abstract void active(Event event);

	public abstract void cancel(Event event);

	public abstract void finish(Event event);

}
