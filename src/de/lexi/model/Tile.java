package de.lexi.model;


public class Tile {
	private boolean flipped, bomb, marked;
	private int number;
	private int x, y;

	public Tile(int x, int y, boolean flipped, boolean bomb, boolean marked, int number) {
		super();
		this.flipped = flipped;
		this.bomb = bomb;
		this.marked = marked;
		this.number = number;
	}

	protected int getX() {
		return x;
	}

	protected void setX(int x) {
		this.x = x;
	}

	protected int getY() {
		return y;
	}

	protected void setY(int y) {
		this.y = y;
	}

	protected void setFlipped(boolean flipped) {
		this.flipped = flipped;
	}

	protected void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	public boolean isFlipped() {
		return flipped;
	}

	public boolean hasBomb() {
		return bomb;
	}

	public boolean isMarked() {
		return marked;
	}

	protected void setMarked(boolean marked) {
		this.marked = marked;
	}

	protected void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
