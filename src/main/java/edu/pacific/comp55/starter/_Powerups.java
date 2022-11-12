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
	private int num; 
	private GLabel counter;
	private GImage power; 
	protected _PowerUpType type; 
	public AudioPlayer a;
	public static final String AUDIO_FOLDER = "sounds";
	
	
	
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
	
	public void addPower() {
		power = new GImage("Untitled-removebg-preview (1).png", 100, 100);
		add(power);
	}
	
	public void removePower() {
		remove(power);
	}
		
	@Override
	public void run() {
		spawnTime();
		counter = new GLabel("# of times called?", 0, 100);
		add(counter);	
		playSound("sounds", "X2Download.app - Sofia Reyes - 1, 2, 3 (feat. Jason Derulo & De La Ghetto) [Official Video] (320 kbps).mp3");
	}
	
	public void playSound(String fileName, String songName) {
		a = AudioPlayer.getInstance();
		a.playSound(fileName, songName);
	}
	
	public void actionPerformed(ActionEvent e) {
		num += 1; 
		numTimes += 1; 
		counter.setLabel("Timer:" + numTimes);
		if(num % 10 == 0) {
			addPower(); 
		}
		if(numTimes % 11 ==  0) {
			removePower();
		}
		
	}	

	public static void main(String[] args) {
		new _Powerups().start();
	}
	
}
