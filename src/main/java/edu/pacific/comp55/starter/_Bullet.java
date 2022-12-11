package edu.pacific.comp55.starter;

/** 
 * This program is for creating and displaying the bullet on the MainApplication screen
 * 
 * @author Nathan Osorio, Miguel Constantino-Guzman, Manohar V. Dhulipala, and Divine Atah
 * Main contributors: Divine, Veasna, and Miguel
 */

import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class _Bullet /*implements Shape*/ /*extends GraphicsProgram implements ActionListener*/ {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int BULLET_LENGTH = 25;
	public static final int BULLET_WIDTH = 3;
	public static final int MS = 1;
	public static final int SPEED = -5;
	public static final int BULLET_SPAWN_Y = PROGRAM_HEIGHT - 40;
	private ArrayList<GRect> bullets;
	Timer t;
	MainApplication app;
	private AudioPlayer pSound;
	private final String SOUND = "sounds"; 
	private final String BULLET = "BulletSound.mp3";
	
	// used in the ToolDesign.java class
	// Assigns MainApplication object and array to "bullets" of type GRect
	public _Bullet(MainApplication app) {
		this.app = app;
		bullets = new ArrayList<GRect>();
		// TODO: says "null" when invoking this method
		//enemies = tool.getEnemies();
	}
	
	// Only for displaying a graphics program for this class
	/*
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}

	public void run() {
		bullets = new ArrayList<GRect>();
		addMouseListeners();
		t = new Timer(MS, this);
		t.start();
	}
	*/
	
	// play sound whenever bullets are shot
	public void playSound() {
		pSound = AudioPlayer.getInstance();
		pSound.playSound(SOUND, BULLET);
	}
	// detects mouse being pressed and unpressed
	public void mousePressed(MouseEvent e) {
		newBullet(e.getX(), e.getY());
	}	
	
	/**
	 * makes bullet of colors Cyan (for border) and Magenta (filled)
	 * Then, adds it to the MainApplication screen
	 * @param x --> rectangle width
	 * @param y --> rectangle height
	 * @return returns bullet for newBullet()
	 */
	private GRect makeBullet(double x, double y) {
		GRect temp = new GRect(x - BULLET_WIDTH / 2, y, BULLET_WIDTH, BULLET_LENGTH);
		temp.setColor(Color.CYAN);
		temp.setFillColor(Color.magenta);
		temp.setFilled(true);
		app.add(temp);
		return temp;
	}
	
	/**
	 * calls makeBullet() to assign it to a GRect object and then adds it to both the MainApplication screen
	 * and ArrayList of type GRect
	 * @param x --> parameter for makeBullet()
	 * @param y --> parameter for makeBullet()
	 */
	public void newBullet(double x, double y) {
		GRect bullet = makeBullet(x, y);
		bullets.add(bullet); // adds to ArrayList
		app.add(bullet);	 // adds to "screen"
		playSound();
	}

	// removes bullets if bullet is out of bounds (y-coordinates)
	public void removeBullet() {
		for (GRect bullet : bullets) {
			if (bullet.getY() < 0) {
				app.remove(bullet);
				bullets.remove(bullet);
				return;
			}
		}
	}
	
	// Shoots bullet at a rate of SPEED meters/second
	// TODO: work on collision detection; Having difficulty using the methods below to help me detect
	// the presence of a GImage object.
	public void shoot() {
		// ArrayList<GImage> allE = tool.getEnemies();
		//tool.temp;
		
		for (GRect bullet : bullets) {
			bullet.move(0, SPEED);
			/*
			int i = 0;
			for (GImage enemy : enemies) {
				GOval tempObj = new GOval(bullet.getX() + bullet.getWidth() + 1, bullet.getY() + (bullet.getHeight() / 2));
				if (tempObj.contains(enemy)) {
					tool.removeEnemyAtIndex(i);
				}
				++i;
			}
			*/
		}
		
	}
		
	// Use only when wanting to run a Graphics Program for this particular class
	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		shoot();
		removeBullet();
	}
	
	public static void main(String[] args) {
		new _Bullet().start();
	}
	 */
	
	
}
	

	

