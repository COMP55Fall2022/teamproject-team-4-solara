package edu.pacific.comp55.starter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;


public class _Bullet extends GraphicsProgram {
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int RECT_SIZE = 100;
	
	public static final int NUM_BULLETS = 2; 
	private ArrayList<GRect> bulletArray;
	private GRect bullet;
	private int xVelocity;
	private int numTimes; 
	private _ShipType playerT; 
	private Timer t; 
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		requestFocus();
	}
		
	public GRect makeBullet() {
		t = new Timer(30,this);
		t.start();
		bulletArray = new ArrayList<GRect>();
		bullet = new GRect (500,500,3, 20);
		bullet.setColor(Color.BLACK);
		bullet.setFillColor(Color.MAGENTA);
		bullet.setFilled(true);
		add(bullet);
		bulletArray.add(bullet);
		return bullet; 
	}
	
	
	public void removeBullet() {
		bulletArray.remove(bullet);
		remove(bullet);
	}
	
	
	public void pauseBullet() {
		t.stop();
	}

	public void resumeBullet() {
		t.start();
	}
	
	public void restartBullet() {
		t.restart();
		//makeBullet();
		 
	}
	
	public void bulletSound() {
		
	}
	
	public void boundsChecking() {
		// will change this to instance of enemy (GImage) 
		if (bullet.getY() <= 1.0){
			removeBullet();
			restartBullet();
			makeBullet();
		}
		
	}

	public void run() {
		ArrayList<GRect> bulletArray = new ArrayList<GRect>();
		bulletArray.add(bullet);	
		makeBullet();
		//moveBullet();
	}
	
	public void actionPerformed(ActionEvent e){
		bullet.move(0,-5);
		boundsChecking();
		if (numTimes == -5 ) {
			t.restart();
		}
	}
		
	@Override
	public String toString() {
		return "_Bullet [bullets=" + bulletArray + "]";
	}
 	
	public static void main(String[] args) {
		new _Bullet().start();
	} 
}
