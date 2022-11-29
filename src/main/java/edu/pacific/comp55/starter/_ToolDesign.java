package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;


public class _ToolDesign extends GraphicsProgram{
	
	private _Ships balanced; 
	private _Ships tank; 
	private _Ships Speed;
	private ArrayList<GRect> enemies;
	private ArrayList<GRect> bullets; 
	private RandomGenerator rgen; 
	private Timer movement; 
	private int numTimes; 
	
	public void init() {
		setSize(800, 600);
		requestFocus();
	} 

	
	/*public _ToolDesign (MainApplication app) {
		// constructor to add on to level screen 
	}*/
	
	public  GRect makeEnemy(double y) { 
		GRect temp = new GRect(500, 0, 50, 50);
		temp.setColor(Color.GREEN);
		temp.setFilled(true);
		return temp;
	}
	
	private void moveAllEnemiesOnce() {
		for(GRect rect: enemies) {
			rect.move(rgen.nextInt(-50,50),0);
			
		}
	}

	private void addAnEnemy() {
		GRect e = makeEnemy(rgen.nextInt(0, 575));
		enemies.add(e); 
		add(e); 
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
		add(b); 
	}
	public void moveAllBulletsOnce() {
		for (GRect bullet: bullets) {
			bullet.move(0, 10);
		}
	}
	
	public static void main(String args[]) {
		new _ToolDesign().start();
	}
	
	
	
	
	
	
	
	
	
	
}
