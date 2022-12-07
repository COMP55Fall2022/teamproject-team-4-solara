package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to all of the GraphicsProgram calls
	private GButton PlayGame;
	private GButton howToPlay; 
	private GButton quit; 
	private GImage MainMenu;
	private GLabel title; 
	private static int SCREEN_WIDTH = 1920;
	private static int SCREEN_HEIGHT = 1080;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		MainMenu = new GImage ("media/Space_background.jpg",0,0);
		MainMenu.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		PlayGame = new GButton("Play Game", (SCREEN_WIDTH / 2) - 300, 355, 210, 50);
		howToPlay = new GButton("How To Play", (SCREEN_WIDTH / 2) - 300, 420, 210, 50);
		quit = new GButton ("QUIT", (SCREEN_WIDTH / 2) - 300, 480, 210, 50);
		title = new GLabel("DOGFIGHT", 650, 150); 
		title.setFont("Arial-bold-50");
		
		
		
		quit.setColor(Color.GREEN);
		howToPlay.setColor(Color.GREEN);
		PlayGame.setColor(Color.GREEN);
		
		quit.setFillColor(Color.BLACK);
		howToPlay.setFillColor(Color.BLACK);
		PlayGame.setFillColor(Color.BLACK);
	}

	@Override
	public void showContents() {
		program.add(MainMenu);
		program.add(PlayGame);
		program.add(howToPlay);
		program.add(quit);
		program.add(title);
	}

	@Override
	public void hideContents() {
		program.remove(MainMenu);
		program.remove(PlayGame);
		program.remove(howToPlay);
		program.remove(quit);
		program.remove(title);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == howToPlay) {
			program.playButtonSound();
			program.switchToHowToPlay(); 
		}
		else if (obj == PlayGame){ 
			program.playButtonSound();
			program.switchToChoosePlane();
		}
		else if (obj == quit) {
			program.playButtonSound();
			System.exit(0);
		}
	}
}
