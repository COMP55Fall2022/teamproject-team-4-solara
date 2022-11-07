package edu.pacific.comp55.starter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;


public class _Bullet extends GraphicsProgram {
	
	private ArrayList<GRect> bullets;
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int RECT_SIZE = 100;
	public static final int BREAK_MS = 30;
	public static final int INIT_X_VELOCITY = 5;
	public static final int NUM_BULLETS = 2; 
	private GRect bullet;
	private int xVelocity;
	private int numTimes; 
	private _ShipType playerT; 
	private Timer t; 
	
	public void init() {
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	
	public void makeBullet() {
		
		bullet = new GRect (100,100,20, 20);
		bullet.setColor(Color.BLACK);
		bullet.setFillColor(Color.BLACK);
		add(bullet);
	}
	
	public void moveBullet(){}
	
	public void pauseBullet() {}
	
	public void resumeBullet() {}
	
	public void bulletSound() {}

	@Override
	public void run() {
		
		makeBullet();
		
	}
	
}
