package edu.pacific.comp55.starter;
import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class _Score /* extends GraphicsProgram */{
	private GLabel label;
	private int score;
	private MainApplication mainScreen;
	private final double LABEL_X = 50.0;
	private final double LABEL_Y = 50.0;
	private int extraPoints = 10;
	
	// TODO: figure out how to associate this class with the game
	// TODO: figure out how to add it to the "level" screen
	
	public _Score(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	/*
	public void init() {
		setSize(1000,1000);
	}
	public void run() {
		score = 40;
		label = new GLabel("Score: " + score, 50, 50);
		add(label);
		
		enemyKilled(true, 50);
	}
	*/
	
	// adds simple label to the screen with the current score
	public void addScoreLabel() {
		score = 0;
		label = new GLabel("Score: " + score);
		label.setColor(Color.WHITE);
		label.setVisible(true);
		label.setLocation(LABEL_X, LABEL_Y);
		mainScreen.add(label);
	}
	
	/**
	 * If enemy is destroyed, add 1 point to total score
	 * @param isDestroyed IF true, player gets score
	 *
	 */
	public void enemyDestroyed(boolean isDestroyed) {
		mainScreen.remove(label);
		if(isDestroyed) {
			label = new GLabel("Score: " + (score + 1), LABEL_X, LABEL_Y);
			mainScreen.add(label);
		}
	}
	
	/**
	 * Adds more points if boss is destroyed
	 * @param isDestroyed
	 */
	public void bossDestroyed(boolean isDestroyed) {
		mainScreen.remove(label);
		if (isDestroyed) {
			label = new GLabel("Score: " + (score + extraPoints), LABEL_X, LABEL_Y); /* (x, y) = (50, 50) */
			mainScreen.add(label);
		}
	}
	
	// resets score to zero
	public void resetScore() {
		int newScore = 0;
		mainScreen.remove(label);
		label = new GLabel("Score: " + newScore, LABEL_X, LABEL_Y); /* (x, y) = (50, 50) */
		mainScreen.add(label);
	}
	
	/*
	public static void main(String[] args) {
		new _Score().start();
	}
	*/
	
}
