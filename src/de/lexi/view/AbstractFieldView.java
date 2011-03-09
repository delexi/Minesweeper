package de.lexi.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import de.lexi.model.FieldModel;
import de.lexi.model.FieldModelListener;

public abstract class AbstractFieldView
extends JPanel
implements FieldModelListener {

	private static final long serialVersionUID = -2355007143684102381L;

	private FieldModel model;

	private int tileSize;

	private final boolean bombHitted = false;

	public Point convertPixelToTileGrid(Point pixel){
		Point pGrid = new Point();
		pGrid.x = pixel.x/tileSize;
		pGrid.y = pixel.y/tileSize;
		return pGrid;
	}

	public Rectangle convertTileGridToPixel(Point tileGrid){
		Rectangle r = new Rectangle();
		r.x = tileGrid.x * tileSize;
		r.y = tileGrid.y * tileSize;
		r.width = tileSize;
		r.height = tileSize;
		return r;
	}

	public FieldModel getModel() {
		return model;
	}

	public void setModel(FieldModel model) {
		this.model = model;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		if(!bombHitted){

			for (int x = 0; x < model.getSize().width; x ++) {
				for (int y = 0; y < model.getSize().height; y++) {

					if(!model.isFlipped(x, y)){
						drawTile(x*tileSize,y*tileSize,g);
						drawBorder(x*tileSize,y*tileSize,g);
						if(model.isMarked(x, y)){
							drawMark(x*tileSize,y*tileSize,g);
						}
					}
					else{
						drawBackground(x*tileSize,y*tileSize,g);
						drawGrid(x*tileSize,y*tileSize,g);
						if(model.hasBomb(x, y)){
							drawBomb(x*tileSize,y*tileSize,g);
						}else{
							drawNumber(x*tileSize,y*tileSize,g,model.getNumber(x, y));
						}
					}

				}
			}
		}else{
			Color oldColor = g.getColor();
			g.setColor(Color.RED);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(oldColor);
		}
	}

	public abstract void drawGrid(int x, int y, Graphics g);

	public abstract void drawBomb(int x, int y, Graphics g);

	public abstract void drawMark(int x, int y, Graphics g);

	public abstract void drawBorder(int x, int y, Graphics g);

	public abstract void drawTile(int x, int y, Graphics g);

	public abstract void drawBackground(int x, int y, Graphics g);

	public abstract void drawNumber(int x, int y, Graphics g, int number);

	@Override
	public void bombActivated(int x, int y) {
		//		for(int i = 0; i < 5; i++){
		//			bombHitted = true;
		//			repaint();
		//			bombHitted = false;
		//			try {
		//				Thread.sleep(100);
		//			} catch (InterruptedException e) {
		//				e.printStackTrace();
		//			}
		//			repaint();
		//		}
	}

	@Override
	public void tileChanged(int x, int y) {
		repaint(convertTileGridToPixel(new Point(x,y)));
	}

}
