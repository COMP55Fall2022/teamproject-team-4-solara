package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.management.monitor.GaugeMonitor;
import javax.swing.Timer;

import acm.graphics.G3DRect;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;


public class MenuPane extends GraphicsPane implements ActionListener {
	private MainApplication program; // you will use program to get access to all of the GraphicsProgram calls
	private GButton PlayGame;
	private GButton howToPlay; 
	private GButton quit; 
	private GImage MainMenu;
	private GLabel title; 
	private static int SCREEN_WIDTH = 1920;
	private static int SCREEN_HEIGHT = 1080;
	 
	private int redC = 100; 
	private int greenC = 165; 
	private int blueC = 232;
	private boolean redF = true;
	private boolean blueF = true;
	private boolean greenF = true;
	private Color color; 
	private int i; 
	private GParagraph sure; 
	private G3DRect rect;  

	public MenuPane(MainApplication app) {
		super();
		program = app;
		MainMenu = new GImage ("media/Space_background.jpg",0,0);
		MainMenu.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		PlayGame = new GButton("Play Game", (SCREEN_WIDTH / 2) - 300, 355, 210, 50);
		howToPlay = new GButton("How To Play", (SCREEN_WIDTH / 2) - 300, 420, 210, 50);
		quit = new GButton ("QUIT", (SCREEN_WIDTH / 2) - 300, 480, 210, 50);
		sure = new GParagraph ("Are you sure you'd \n like to quit?", 550, 300);
		rect = new G3DRect(550,300,400,300);
		
		
		rect.setColor(Color.WHITE) ;
		rect.setFillColor(Color.GRAY);
		rect.setFilled(true);
		sure.setFont("Arial-bold-20");
		sure.setColor(Color.WHITE);
			
		
		
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
		
		
		
		
		title = new GLabel("DOGFIGHT", 525, 200); 
		title.setFont("Impact-italic-125");
		
		program.add(title);
		
		Timer t = new Timer(25,this);
		t.start();
		
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
			program.add(rect);
			program.add(sure);
			//System.exit(0);
		}
	}
	@Override 
	public void actionPerformed (ActionEvent e){ 
		
		 i += 50; 
		 
		
		color = new Color(redC, blueC, greenC); 
		title.setColor(color);
		
		
		if (redC == 0 ) {
			redF = true; 
		}
		
		else if (redC == 255) {
			redF = false; 
		}
		
		if (blueC == 50) {
			blueF = true; 
		}
		
		else if (blueC == 232) {
			blueF = false;
		}
		
		if (greenC == 20) {
			greenF = true;
		}
		
		else if (greenC == 165) {
			greenF = false; 
		}
		
		if(redF) {
			++redC;
		}
		else {
			--redC; 
		}
		
		if(blueF) {
			++blueC;
		}
		else {
			--blueC;
		}
		
		if(greenF) {
			++greenC;
		}
		else {
			--greenC;
		}
	}
	
	
}
