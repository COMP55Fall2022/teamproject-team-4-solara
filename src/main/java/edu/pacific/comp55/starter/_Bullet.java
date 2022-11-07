package edu.pacific.comp55.starter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import acm.graphics.*;
public class _Bullet {
	
	private ArrayList<GRect> bullets;
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int BALL_SIZE = 100;
	public static final int BREAK_MS = 30;
	public static final int INIT_X_VELOCITY = 5;
	public static final int NUM_BULLETS = 2; 
	private GRect bullet;
	private int xVelocity;
	private int numTimes; 
	private _ShipType playerT; 
	
	
	public void actionPerformed(ActionEvent e){
		
	}
	
	public void moveBullet(){}
	
	public void pauseBullet() {}
	
	public void resumeBullet() {}
	
	public void bulletSound() {}
	
}
