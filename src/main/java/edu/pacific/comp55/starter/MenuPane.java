package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton PlayGame;
	private GButton howToPlay; 
	private GButton quit; 
	private GImage MainMenu;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		MainMenu = new GImage ("media/DOGFIGHT MAIN MENU.jpg",0,0);
		PlayGame = new GButton("Play Game", 355, 355, 210, 50);
		howToPlay = new GButton("How To Play", 355, 420, 210, 50);
		quit = new GButton ("QUIT", 355, 480, 210, 50);
		howToPlay.setFillColor(Color.WHITE);
		PlayGame.setFillColor(Color.WHITE);
	}

	@Override
	public void showContents() {
		program.add(MainMenu);
		program.add(PlayGame);
		program.add(howToPlay);
		program.add(quit);
	}

	@Override
	public void hideContents() {
		program.remove(PlayGame);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == PlayGame) {
			program.switchToSome(); // change this to switch to level... 
		}
		else if (obj == howToPlay ) { 
			program.switchToHowToPlay(); 
		}
	}
}
