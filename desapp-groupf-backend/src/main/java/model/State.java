package model;

public abstract class State {

	private Integer idState;

	public abstract boolean isAvaliable();

	public abstract void active(Event event);

	public abstract void cancel(Event event);

	public abstract void finish(Event event);

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

}
