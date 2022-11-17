package edu.pacific.comp55.starter;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class SomePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage	howToPlay;
	private GParagraph para;

	public SomePane(MainApplication app) {
		this.program = app;
		howToPlay= new GImage("media/How to play screen.jpg", 0, 0);
		
	}

	@Override
	public void showContents() {
		program.add(howToPlay);
		
	}

	@Override
	public void hideContents() {
		program.remove(howToPlay);
		program.remove(para);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	/*	para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == MainMenu) {
			program.switchToMenu();
		} */ // MODIFY THIS TO SWITCH SCREENS WITH BUTTONS INSTEAD 
	}
}
