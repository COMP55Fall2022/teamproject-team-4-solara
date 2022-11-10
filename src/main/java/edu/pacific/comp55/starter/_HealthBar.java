package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Timer;
import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class _HealthBar extends GraphicsProgram implements ActionListener {
	private GRect healthBarOutline;
	private GRect healthBar;
	private GLabel healthLabel;
	private ArrayList<GRect> greenBars;
	// windown dimensions
	private final int WINDOW_WIDTH = 1000;
	private final int WINDOW_HEIGHT = 1000;
	// Dimensions for Health bar rectangle
	private final double HEALTHBAR_HEIGHT = 50;
	private final double HEALTHBAR_WIDTH = 4 * HEALTHBAR_HEIGHT;
	private final double HEALTHBAR_X = (WINDOW_WIDTH - HEALTHBAR_WIDTH) - (WINDOW_WIDTH * .05);
	private final double HEALTHBAR_Y = 50;
	private final int HITPOINTS = 7;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		createHealthBar();
		updateHealthOnScreen();
		
		/*
		timerObj = new Timer(1000, this);
		
		healthBar_1 = new GRect(HEALTHBAR_X + 0.5, HEALTHBAR_Y + 0.5, (HEALTHBAR_WIDTH - 0.5) / 2, HEALTHBAR_HEIGHT - 1);
		healthBar_1.setColor(Color.green);
		healthBar_1.setFillColor(Color.green);
		healthBar_1.setFilled(true);
		add(healthBar_1);
		
		healthBar_2 = new GRect(HEALTHBAR_X + (HEALTHBAR_WIDTH / 2), HEALTHBAR_Y + 0.5, (HEALTHBAR_WIDTH - 0.5) / 2, HEALTHBAR_HEIGHT - 1);
		healthBar_2.setColor(Color.green);
		healthBar_2.setFillColor(Color.green);
		healthBar_2.setFilled(true);
		add(healthBar_2);
		
		timerObj.start();
		*/
	}
	
	public boolean damageToShip() {
		return true;
	}
	
	public void updateHealthOnScreen() {
		if (damageToShip()) {
			remove(healthBar);
			greenBars.remove(greenBars.size() - 1);
			healthLabel.setLabel("Health: " + greenBars.size());
		}
		
	}
	
	public void createHealthBar() {
		// Adds health bar outline
		healthBarOutline = new GRect(HEALTHBAR_X, HEALTHBAR_Y, HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT);
		add(healthBarOutline);
		
		greenBars = new ArrayList<GRect>();
		// this loop adds lines to split between N health points and also adds N GRect Objects as health points
		for (int i = 0; i < HITPOINTS; ++i) {
			//creates and adds health bars in order for them to display on the screen
			add(new GLine(HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HITPOINTS)) , HEALTHBAR_Y, HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HITPOINTS)), HEALTHBAR_Y + HEALTHBAR_HEIGHT));
			healthBar = new GRect(HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HITPOINTS)), HEALTHBAR_Y, HEALTHBAR_WIDTH / HITPOINTS, HEALTHBAR_HEIGHT - 1);
			healthBar.setFillColor(Color.green);
			healthBar.setFilled(true);
			add(healthBar);
			// adds health bars to ArrayList
			greenBars.add(healthBar);
			
		}
		
		healthLabel = new GLabel("Health: " + greenBars.size(), HEALTHBAR_X, HEALTHBAR_Y + HEALTHBAR_HEIGHT + 20);
		add(healthLabel);
		
	}
	
	public void healthSound() {
		
	}
	
	public void healthEmpty() {
		
	}
	
	public static void main(String[] args) {
		new _HealthBar().start();
	}
	
}
