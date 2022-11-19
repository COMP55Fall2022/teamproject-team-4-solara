package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.KeyEvent;
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
		MainMenu = new GImage ("media/Space_background.jpg",0,0);
		MainMenu.setSize(1080,1080);
		PlayGame = new GButton("Play Game", 355, 355, 210, 50);
		howToPlay = new GButton("How To Play", 355, 420, 210, 50);
		quit = new GButton ("QUIT", 355, 480, 210, 50);
		
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
	}

	@Override
	public void hideContents() {
		program.remove(MainMenu);
		program.remove(PlayGame);
		program.remove(howToPlay);
		program.remove(quit);
		
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
	
	@Override
	public void keyPressed (KeyEvent e) { 
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

}
