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
	public static final int BREAK_MS = 30;
	public static final int INIT_X_VELOCITY = 5;
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
	/*
	public void actionPerformed(ActionEvent e){
		bullet.move(0, -5);
		// change to bound checking to restart movement of bullet 
		if (numTimes == -5 ) {
			t.restart();
		}
	}
	*/
	
		
	public GRect makeBullet() {
		bulletArray = new ArrayList<GRect>();
		bullet = new GRect (500,500,5, 20);
		bullet.setColor(Color.BLACK);
		bullet.setFillColor(Color.MAGENTA);
		bullet.setFilled(true);
		add(bullet);
		bulletArray.add(bullet);
		return bullet; 
	}
	public void addBullets() {
		// somehow use arraylist to add multiple bullets 
	}
	//added this but I'm not sure what's wrong - Divine
	public void removeBullet() {
		bulletArray.remove(bullet);
		remove(bullet);
	}
	
	public void moveBullet(){
		Timer t = new Timer(30,this);
		t.setInitialDelay(20);
		t.start();
	}

	public void pauseBullet() {
		t.stop();
	}

	public void resumeBullet() {
		t.start();
	}
	
	public void bulletSound() {
		
	}
	
	public void boundsChecking() {
		if (bullet.getY() <= 300.0){
			removeBullet();
		}
	}

	public void run() {
		ArrayList<GRect> bulletArray = new ArrayList<GRect>();
		makeBullet();
		//moveBullet();
		bulletArray.add(bullet);
		moveBullet();
		boundsChecking();
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
