package de.lexi.model;


public interface FieldModelListener {
	void tileChanged(int x, int y);
	void bombActivated(int x, int y);
}
