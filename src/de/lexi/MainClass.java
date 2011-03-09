package de.lexi;

import javax.swing.JFrame;

import de.lexi.controller.FieldController;
import de.lexi.model.DefaultFieldModel;
import de.lexi.model.FieldModel;
import de.lexi.view.AbstractFieldView;
import de.lexi.view.ClassicFieldView;

public class MainClass {

	public static void main(String[] args) {
		//Create an instance of DefaultFieldModel
		FieldModel model = new DefaultFieldModel(10,10,12);
		//Create an instance of ClassicFieldView
		AbstractFieldView view = new ClassicFieldView(model, 50);
		//Create an instance of FieldController
		FieldController controller = new FieldController(view, model);
		//register view on the model
		model.addFieldModelListener(view);
		// register the controller as a MouseListener on the view
		view.addMouseListener(controller);
		// Initialize Frame
		JFrame frame = new JFrame("Minesweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Put the view into a Frame
		frame.add(view);
		// Make the frame visible
		frame.setVisible(true);
	}
}