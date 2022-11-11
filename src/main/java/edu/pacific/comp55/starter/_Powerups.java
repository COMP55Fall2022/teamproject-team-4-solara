package edu.pacific.comp55.starter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.util.RandomGenerator;


public class _Powerups extends GraphicsProgram {
	private static final int TIME_LIMIT = 1000;
	private static final int MAX_HEALTH = 10;
	private RandomGenerator rgen;
	private double spawnX, spawnY;
	private Timer t;
	private boolean isActive;
	private GImage powerUp;
	private int numTimes; 
	private GLabel counter;
	private GRect power; 
	
	
	public void init() {
		setSize(800, 600);
		requestFocus();
	}
	
	
	private void powerUpSound(_PowerUpType p) {}
	
	private void setPoint(double x, double y) {
		spawnX = x;
		spawnY = y;
	}
	
	public double getX(_Powerups p) {
		return p.spawnX;
	}
	
	private double getY(_Powerups p) {
		return p.spawnY;
	}
	
	private void updateShipSpeed(_BattleShip b) {
		b.updateSpeed(b.getSpeed() + 5);
	}
	
	private void updateShipBullets(_Bullet b) {}
	
	private void updateShipHealth(_BattleShip b) {
		if(b.getHealth() < MAX_HEALTH) {
			b.setHealth(b.getHealth() + 5);
		}
		else {
			b.setHealth(MAX_HEALTH);
		}
	}
	
	
	public void spawnTime () {
		t = new Timer(TIME_LIMIT, this);
		t.setInitialDelay(10);
		t.start();

	}
		
	
	@Override
	public void run() {
		spawnTime();
		counter = new GLabel("# of times called?", 0, 100);
		add(counter);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		numTimes++; 
		counter.setLabel("Timer:" + numTimes);


		if (numTimes != 10 ) {
		// add despawn method here once implemented
			power = new GRect (200,300,100,100);
			power.setFillColor(Color.BLACK);
			power.setFilled(true);
			add(power);
		}	
		else {
			remove(power);
		}

	}

	public static void main(String[] args) {

		new _Powerups().start();
	}
	
}
