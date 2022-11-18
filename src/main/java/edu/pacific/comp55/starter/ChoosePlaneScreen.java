package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class ChoosePlaneScreen extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
				// all of the GraphicsProgram calls
	private GButton enterGame;
	private GImage	choosePlane;
	private GButton menuReturn; 
	

	public ChoosePlaneScreen(MainApplication app) {
		this.program = app;
		choosePlane= new GImage("media/Stats for airplanes (1).jpg", 0, 0);
		enterGame = new GButton ("Enter Game", 340,450, 150, 100);
		menuReturn = new GButton ("Return", 800,450, 100, 100);
		menuReturn.setColor(Color.GREEN);
		menuReturn.setFillColor(Color.BLACK);
		enterGame.setColor(Color.GREEN);
		enterGame.setFillColor(Color.BLACK);
		
		
	}

	@Override
	public void showContents() {
		program.add(choosePlane);
		program.add(enterGame);
		program.add(menuReturn);
		
		
	}

	@Override
	public void hideContents() {
		program.remove(choosePlane);
		program.remove(enterGame);
		program.remove(menuReturn);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == enterGame) {
			program.playButtonSound();
			program.switchToLevel();
		}
		else if( obj == menuReturn) {
			program.playButtonSound();
			program.switchToMenu();
		}
	}
}
