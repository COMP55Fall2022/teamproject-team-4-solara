package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;


public class _ToolDesign implements ActionListener{
	
	private _Ships balanced; 
	private _Ships tank; 
	private _Ships Speed;
	private ArrayList<GRect> enemies;
	private ArrayList<GRect> bullets; 
	private RandomGenerator rgen; 
	private Timer movement; 
	private int moveDirector;
	private int numTimes; 
	private MainApplication mainScreen;
	private GObject bulletCheck;
	
	public _ToolDesign (MainApplication app) {
		mainScreen = app;
		moveDirector = 1;
	}
	
	public  GRect makeEnemy(double y) { 
		GRect temp = new GRect(y, 0, 50, 50);
		temp.setColor(Color.GREEN);
		temp.setFilled(true);
		return temp;
	}
	
	private void moveAllEnemiesOnce() {
		int dx = (moveDirector > 0) ? -2 : 2;
		moveDirector += (moveDirector > 0) ? 1 : -1;
		if (moveDirector > 30) moveDirector = -1;
		if (moveDirector < -30) moveDirector = 1;
		
		for(GRect rect: enemies) {
			rect.move(dx,0);
			
		}
	}

	private void addAnEnemy() {
		GRect e = makeEnemy(rgen.nextInt(0, 1000));
		enemies.add(e); 
		mainScreen.add(e); 
	}

	
	public void run() {
		rgen = RandomGenerator.getInstance(); 
		enemies = new ArrayList<GRect>(); 
		bullets = new ArrayList<GRect>(); 
		movement = new Timer(50, this); 
		movement.start(); 
		
	}
	
	public void actionPerformed(ActionEvent e) {
		numTimes += -1; 
		if(numTimes % 100 == 0) {
			addAnEnemy(); 
			addBullet();
		
		}
		moveAllEnemiesOnce(); 
		moveAllBulletsOnce();
	}
	
	public GRect makeBullet(double x, double y) {
		
		GRect bull = new GRect (500, 0, 5, 10); 
		bull.setColor(Color.RED); 
		bull.setFilled(true);
		return bull; 
		
	}
	
	public void addBullet() {
		GRect b = makeBullet(rgen.nextInt(0,575), 0); 
		bullets.add(b); 
		mainScreen.add(b); 
	}
	public void moveAllBulletsOnce() {
		for (GRect bullet: bullets) {
			bullet.move(0, 10);
			
			// bulletCheck = getElementAt(bullet.getX() + (bullet.getWidth() + 1), bullet.getY() + (bullet.getHeight() / 2)); // check for bullet collision 
		}
	}
	// come back to this and make another enemy type to add another line of enemie below the ones already made 
}
