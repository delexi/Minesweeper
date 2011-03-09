package de.lexi.model;

import java.awt.Dimension;

public interface FieldModel {

	/**
	 * Flips the tile at [x,y] or throws
	 * an exception if there is none at [x,y].
	 * If the tile has already been flipped,
	 * this method does nothing.
	 * 
	 * @param x the X-coordinate. Begins with 0 and increases from left to right.
	 * @param y the Y-coordinate. Begins with 0 and increases from top to bottom.
	 */
	public void flipTile(int x, int y);

	/**
	 * Returns if the tile at [x,y] has been flipped or
	 * throws an exception if there is no tile at [x,y].
	 * 
	 * @param x the X-coordinate. Begins with 0 and increases from left to right.
	 * @param y the Y-coordinate. Begins with 0 and increases from top to bottom.
	 * 
	 * @return if a tile is flipped.
	 */
	public boolean isFlipped(int x, int y);

	/**
	 * Returns whether there is a tile at [x,y] or
	 * throws an exception if there is no tile at [x,y].
	 * 
	 * @param x the X-coordinate. Begins with 0 and increases from left to right.
	 * @param y the Y-coordinate. Begins with 0 and increases from top to bottom.
	 * 
	 * @return if there is a bomb at [x,y]
	 */
	public boolean hasBomb(int x, int y);

	/**
	 * Marks the tile at [x,y]. If the tile has already
	 * been flipped before, this method does nothing.
	 * If there is no tile at [x,y] an exception is thrown.
	 * 
	 * @param x the X-coordinate. Begins with 0 and increases from left to right.
	 * @param y the Y-coordinate. Begins with 0 and increases from top to bottom.
	 */
	public void markTile(int x, int y);

	/**
	 * Unmarks the tile at [x,y]. If the tile has already
	 * been flipped before or if the tile is not marked, this
	 * method does nothing.
	 * If there is no tile at [x,y] an exception is thrown.
	 * 
	 * @param x the X-coordinate. Begins with 0 and increases from left to right.
	 * @param y the Y-coordinate. Begins with 0 and increases from top to bottom.
	 */
	public void unmarkTile(int x, int y);

	/**
	 * Returns true if the tile at [x,y] has been marked
	 * before, otherwise false. If there is no tile at [x,y]
	 * an exception is thrown.
	 * 
	 * @param x the X-coordinate. Begins with 0 and increases from left to right.
	 * @param y the Y-coordinate. Begins with 0 and increases from top to bottom.
	 * 
	 * @return whether tile is marked or not.
	 */
	public boolean isMarked(int x, int y);

	/**
	 * Returns the field's width and height
	 * 
	 * @return the field's size.
	 */
	public Dimension getSize();

	/**
	 * Adds a FieldModelListener to the model's list of
	 * Listeners being informed about changes on this model.
	 * 
	 * @param l the listener to add
	 */
	public void addFieldModelListener(FieldModelListener l);

	/**
	 * Removes the FieldModelListener l from the model's list
	 * of listeners if the list contains it.
	 * 
	 * @param l the listener to remove
	 */
	public void removeFieldModelListener(FieldModelListener l);

	/**
	 * Returns the number of bombs distributed all over the field.
	 * 
	 * @return number of bombs on the field.
	 */
	public int getNumberOfBombs();

	/**
	 * Returns the number of bombs in the neighbourhood of the tile
	 * at [x,y]. The neighbourhood are the tiles bordering on the
	 * specified one. The maximum return value is 8.
	 * 
	 * @return number of bombs in neighbourhood.
	 */
	public int getNumber(int x, int y);
}
