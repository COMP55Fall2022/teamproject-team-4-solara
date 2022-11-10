package edu.pacific.comp55.starter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.util.RandomGenerator;


public class _Powerups extends GraphicsProgram {
	
	private static final int TIME_LIMIT = 10;
	private static final int MAX_HEALTH = 10;
	private RandomGenerator rgen;
	private double spawnX, spawnY;
	private Timer t;
	private boolean isActive;
	private int numTimes; 
	private GLabel counter;
	
	public void init() {
		setSize(800, 600);
		requestFocus();
	}
	
	private void powerUpSound(_PowerUpType p) {}
	
	private void setSpawn(double x, double y) {
		spawnX = x;
		spawnY = y;
	}
	private void updateShipSpeed(_BattleShip b) {
		b.updateSpeed(b.getSpeed() + 5);
	}
	private void updateShipBullets(_Bullet bull) {
		bull.makeBullet(); 
		
	}
	
	private void updateShipHealth(_BattleShip b) {
		if(b.getHealth() < MAX_HEALTH) {
			b.setHealth(b.getHealth() + 5);
		}
		else {
			b.setHealth(MAX_HEALTH);
		}
	}
	
	
	

	
	public void despawnPower() {
		if ( numTimes == 10 ) {
			// TO-DO
		}
	}
	
	public void powerUpSound() {
		
	}
	
	public void spawnTime () {
		t = new Timer(1000, this);
		t.setInitialDelay(TIME_LIMIT);
		t.start();
		
	}
	
	
	public void run() {
		spawnTime();
		counter = new GLabel("# of times called?", 0, 100);
		add(counter);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		numTimes++; 
		counter.setLabel("Timer:" + numTimes);
		
		
		if (numTimes == 10 ) {
		// add despawn method here once implemented
		}	
		
	}
	
	public static void main(String[] args) {
		 
		new _Powerups().start();
		
	}
	
}
