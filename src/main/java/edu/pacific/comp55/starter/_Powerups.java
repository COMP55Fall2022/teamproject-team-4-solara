package edu.pacific.comp55.starter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.util.RandomGenerator;


public class _Powerups extends GraphicsProgram {
	private static final int TIME_LIMIT = 10000;
	private static final int MAX_HEALTH = 10;
	private RandomGenerator rgen;
	private double spawnX, spawnY;
	private Timer t;
	private Timer activeTimer;
	private boolean isActive;
	private GImage powerUp;
	private int numTimes; 
	private int num; 
	private GLabel counter;
	private GImage power; 
	protected _PowerUpType type; 
	public AudioPlayer a;
	public static final String AUDIO_FOLDER = "sounds";
	private  MainApplication mainScreen;
		
	public _Powerups(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
		addPower();
		spawnTime();
		playSound(AUDIO_FOLDER,"X2Download.app - Sofia Reyes - 1, 2, 3 (feat. Jason Derulo & De La Ghetto) [Official Video] (320 kbps).mp3" );
		
	}
	
	public void init() {
		setSize(800, 600);
		requestFocus();
	}
		
	
	
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
		//b.updateSpeed(b.getSpeed() + 5);
	}
	
	private void updateShipBullets(_Bullet b) {}
	
	private void updateShipHealth(_BattleShip b) {
		/*if(b.getHealth() < MAX_HEALTH) {
			b.setHealth(b.getHealth() + 5);
		}
		else {
			b.setHealth(MAX_HEALTH);
		}
		*/
	}
	
	public void spawnTime() {
		t = new Timer(TIME_LIMIT, this);
		
		t.start();
	}
	
	public void addPower() {
		power = new GImage("Untitled-removebg-preview (1).png", 100, 100);
		mainScreen.add(power);
	}
	
	public void removePower() {
		mainScreen.remove(power);
	}
	
	public void setActive() {
		isActive = true;
		removePower();
		t.stop();
		t.start();
		
	}
		
	@Override
	public void run() {
		addMouseListeners();
		//spawnTime();
		counter = new GLabel("# of times called?", 0, 100);
		add(counter);	
		playSound("sounds", "X2Download.app - Sofia Reyes - 1, 2, 3 (feat. Jason Derulo & De La Ghetto) [Official Video] (320 kbps).mp3");
		addPower();
		spawnTime();
	}
	
	public void playSound(String fileName, String songName) {
		a = AudioPlayer.getInstance();
		a.playSound(fileName, songName);
	}
	
//
	@Override
	public void mousePressed(MouseEvent e) {
		setActive();
	}
	
	public void actionPerformed(ActionEvent e) {
		/*
		num += 1; 
		numTimes += 1; 
		counter.setLabel("Timer:" + numTimes);
		if(num % 10 == 0) {
			addPower(); 
		}
		if(numTimes % 11 ==  0) {
			removePower();
		}
		*/
		if(isActive) {
			isActive = false;
			counter.setLabel("not active any more");
		} else {
			removePower();
			counter.setLabel("not available to grab");
		}
		t.stop();
	}	

	public static void main(String[] args) {
		//new _Powerups().start();
	}
	
}
