package de.lexi.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import de.lexi.model.FieldModel;
import de.lexi.view.AbstractFieldView;

public class FieldController extends MouseAdapter {
	private final AbstractFieldView view;
	private final FieldModel model;

              // Test Edit ( this can be deleted )

	public FieldController(AbstractFieldView view, FieldModel model){
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent me){
		Point posOfCursor = me.getPoint();
		Point gridCoordinates = view.convertPixelToTileGrid(posOfCursor);
		int gCX = gridCoordinates.x;
		int gCY = gridCoordinates.y;
		if(!me.isMetaDown()){
			model.flipTile(gCX, gCY);
		}
		else if(!model.isMarked(gCX, gCY)){
			model.markTile(gCX, gCY);
		}
		else{
			model.unmarkTile(gCX, gCY);
		}
	}
}
