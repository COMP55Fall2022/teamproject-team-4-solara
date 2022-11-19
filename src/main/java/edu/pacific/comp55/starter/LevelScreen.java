package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class LevelScreen extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
				// all of the GraphicsProgram calls
	private GImage level; 
	

	public LevelScreen(MainApplication app) {
		this.program = app;
		level = new GImage("media/Space Background.jpg", 0, 0);
		}

	@Override
	public void showContents() {
		program.add(level);

	}

	@Override
	public void hideContents() {
		program.remove(level);	
	}

	//@Override
	/*public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == returnButton) {
			program.switchToMenu();
		} */
	}

