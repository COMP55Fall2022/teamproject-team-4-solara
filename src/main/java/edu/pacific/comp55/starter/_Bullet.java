package edu.pacific.comp55.starter;

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.*;

public class _Bullet implements Shape /*extends GraphicsProgram implements ActionListener*/ {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int BULLET_LENGTH = 25;
	public static final int BULLET_WIDTH = 3;
	public static final int MS = 1;
	public static final int SPEED = -2;
	public static final int BULLET_SPAWN_Y = PROGRAM_HEIGHT - 50;
	private ArrayList<GRect> bullets;
	private ArrayList<GImage> enemy;
	Timer t;
	MainApplication app;
	private _ToolDesign tool; 

	private AudioPlayer pSound; 
	private final String SOUND = "sounds"; 
	private final String BULLET = "BulletSound.mp3";
	
	
	

	public _Bullet(MainApplication app) {
		this.app = app;
		bullets = new ArrayList<GRect>();
		
	}
	
	
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
	
	public void playSound() {
		pSound = AudioPlayer.getInstance();
		pSound.playSound(SOUND, BULLET);
	}
	public void mousePressed(MouseEvent e) {
		
		newBullet(e.getX());
		
	}
	
	
	private GRect makeBullet(double x, double y) {
		GRect temp = new GRect(x - BULLET_WIDTH / 2, y, BULLET_WIDTH, BULLET_LENGTH);
		temp.setColor(Color.CYAN);
		temp.setFillColor(Color.magenta);
		temp.setFilled(true);
		app.add(temp);
		return temp;
	}
	
	public void newBullet(double x) {
		GRect bullet = makeBullet(x, BULLET_SPAWN_Y);
		bullets.add(bullet); // adds to ArrayList
		app.add(bullet);	 // adds to "screen"
		playSound();
	}


	public void removeBullet() {
		
		for (GRect bullet : bullets) {
			if (bullet.getY() < 0) {
				app.remove(bullet);
				bullets.remove(bullet);
				return;
			}
		}
	}

	public void shoot() {
		// ArrayList<GImage> allE = tool.getEnemies();
		boolean isPresent = false;
		
		for (GRect bullet : bullets) {
			bullet.move(0, SPEED);
			
			if (bullet.contains(bullet.getX() + bullet.getWidth() + 1, bullet.getY() + (bullet.getHeight() / 2))) {
				tool.removeEnemy();
			}
		/*	GRectangle r1 = bullet.getBounds();
			
			for( GImage e : allE) {
				
				GRectangle r2 = e.getBounds();
				
				if(r1.intersects(r2)) {
					app.remove(e);
				}*/
			}
		}


	/*
	 * All these methods are required for the "Shape" interface; I'll leave them be for now
	 */
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean contains(Point2D p) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean intersects(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean intersects(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean contains(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean contains(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		// TODO Auto-generated method stub
		return null;
	}
		
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
	

	

