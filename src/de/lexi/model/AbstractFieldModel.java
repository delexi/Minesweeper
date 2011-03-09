package de.lexi.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFieldModel implements FieldModel {
	private final List<FieldModelListener> listeners = new ArrayList<FieldModelListener>();

	@Override
	public void addFieldModelListener(FieldModelListener l) {
		listeners.add(l);
	}

	@Override
	public void removeFieldModelListener(FieldModelListener l) {
		listeners.remove(l);
	}

	protected void fireTileChanged(int x, int y){
		for(FieldModelListener l: listeners){
			l.tileChanged(x, y);
		}
	}

	protected void fireBombActivated(int x, int y){
		for(FieldModelListener l: listeners){
			l.bombActivated(x, y);
		}
	}
}
