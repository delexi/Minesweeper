package de.lexi.view;

import java.awt.Color;
import java.awt.Graphics;

import de.lexi.model.FieldModel;

public class ClassicFieldView extends AbstractFieldView {

	private static final long serialVersionUID = -7470690920589079171L;

	public ClassicFieldView(FieldModel model, int tileSize){
		super();
		super.setTileSize(tileSize);
		super.setModel(model);
	}

	@Override
	public void drawBackground(int x, int y, Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x,y,super.getTileSize(),super.getTileSize());
		g.setColor(oldColor);
	}

	@Override
	public void drawBomb(int x, int y, Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillOval(x+5, y+5, super.getTileSize()-10, super.getTileSize()-10);
		g.setColor(oldColor);
	}

	@Override
	public void drawBorder(int x, int y, Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.BLACK);
		g.drawRect(x, y, super.getTileSize(), super.getTileSize());
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x + 1, y + 1, super.getTileSize() - 2, super.getTileSize() - 2);
		g.setColor(Color.GRAY);
		g.drawRect(x + 2, y + 2, super.getTileSize() - 4, super.getTileSize() - 4);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x + 3, y + 3, super.getTileSize() - 6, super.getTileSize() - 6);
		g.setColor(oldColor);
	}

	@Override
	public void drawMark(int x, int y, Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(x+5, y+5, super.getTileSize()-10, super.getTileSize()-10);
		g.setColor(oldColor);
	}

	@Override
	public void drawTile(int x, int y, Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.BLUE);
		g.fillRect(x, y, super.getTileSize(), super.getTileSize());
		g.setColor(oldColor);
	}

	@Override
	public void drawNumber(int x, int y, Graphics g, int number) {
		Color oldColor = g.getColor();
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(number), x+20, y+35);
		g.setColor(oldColor);
	}

	@Override
	public void drawGrid(int x, int y, Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.BLACK);
		g.drawRect(x, y, super.getTileSize(), super.getTileSize());
		g.setColor(oldColor);
	}

}
