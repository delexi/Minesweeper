package de.lexi.model;

public class Game implements FieldModelListener {

	public enum State {NOT_STARTED,STARTED,WIN,LOSE};
	private State gameState;

	@Override
	public void bombActivated(int x, int y) {
		if(gameState == State.STARTED){
			gameState = State.LOSE;
		}
	}

	@Override
	public void tileChanged(int x, int y) {
		// FIXME Auto-generated method stub

	}

}
