package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class HowToPlayScreen extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
				// all of the GraphicsProgram calls
	private GButton returnButton; 
	private GImage	howToPlay;
	private GParagraph para;

	public HowToPlayScreen(MainApplication app) {
		this.program = app;
		howToPlay= new GImage("media/How to play screen.jpg", 0, 0);
		returnButton = new GButton ("Return", 340, 425, 210, 50);
		returnButton.setColor(Color.GREEN);
		returnButton.setFillColor(Color.BLACK);
		
	}

	@Override
	public void showContents() {
		program.add(howToPlay);
		program.add(returnButton);
		
	}

	@Override
	public void hideContents() {
		program.remove(howToPlay);
		program.remove(returnButton);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == returnButton) {
			program.playButtonSound();
			program.switchToMenu();
		}
	}
}
