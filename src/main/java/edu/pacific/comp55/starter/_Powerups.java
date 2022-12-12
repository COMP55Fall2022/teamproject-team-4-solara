package edu.pacific.comp55.starter;
/**
 * This class is used to create and spawn the power ups speed, health, and double bullets
 * @author All of Team Solara
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import acm.graphics.*;
import acm.program.*;

public class _Powerups extends GraphicsProgram implements ActionListener {
	private static final int TIME_LIMIT = 10000;
	private double spawnX;
	private Timer t;
	private boolean isActive;
	private int imageNum; 
	private GImage power; 
	 
	protected _PowerUpType type; 
	public AudioPlayer a;
	public static final String AUDIO_FOLDER = "sounds";
	private  MainApplication levelScreen;
	private static final String [] IMAGE_FILES = {"LightningBolt.png", "HealthPower.png", "DoubleBullet.png" };
		
	/**
	 * Assigns and calls timers, as well as implements music for when player "gets" powerup
	 * @param app --> assigned to levelscreen in order to display it on the screen
	 */
	public _Powerups(MainApplication app) {
		this.levelScreen = app;
		addPower();
		spawnTime();
		playSound(AUDIO_FOLDER,"X2Download.app - Sofia Reyes - 1, 2, 3 (feat. Jason Derulo & De La Ghetto) [Official Video] (320 kbps).mp3" );
	}
	
	/**
	 * Gets x-coordinate of power up
	 * @param p object containing x-coordinate
	 * @return returns x-coordinate
	 */
	public double getX(_Powerups p) {
		return p.spawnX;
	}
	// Implements timer 
	public void spawnTime() {
		t = new Timer(TIME_LIMIT, this);
		t.start();
	}
	
	// adds power up to screen
	public void addPower() {
		imageNum = (int)(Math.random() * 3);
		power = new GImage ("media/" + IMAGE_FILES[ imageNum % IMAGE_FILES.length], 100, 100); 
		levelScreen.add(power);
	}
	// removes powerup from screeen
	public void removePower() {
		levelScreen.remove(power);
	}
	// makes sure the powerup(s) is/are active for a set period of time
	public void setActive() {
		isActive = true;
		removePower();
		t.stop();
		t.start();
	}
		
	// Runs music whenever power ups are retrieved
	@Override
	public void run() {
		//levelScreen.add(counter);	
		playSound("sounds", "X2Download.app - Sofia Reyes - 1, 2, 3 (feat. Jason Derulo & De La Ghetto) [Official Video] (320 kbps).mp3");
		addPower();
		spawnTime();
	}
	
	/**
	 * Plays sound 
	 * @param fileName name of file with music
	 * @param songName music pertaining to the fileName
	 */
	public void playSound(String fileName, String songName) {
		a = AudioPlayer.getInstance();
		a.playSound(fileName, songName);
	}
	
	// Key detections
	@Override
	public void mousePressed(MouseEvent e) {
		setActive();
	}
	
	// Sets time for player to be able to retrieve power up
	public void actionPerformed(ActionEvent e) {
		
		if(isActive) {
			isActive = false;
		//	counter.setLabel("not active any more");
		} else {
			removePower();
		//	counter.setLabel("not available to grab");
		
	
		}
		t.stop();
		
	}	
}