package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;
import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class _HealthBar  {
	private GRect healthBarOutline;
	private GRect healthBar;
	private GLabel healthLabel;
	private ArrayList<GRect> greenBars;
	// window dimensions
	private final int WINDOW_WIDTH = 1000;
	private final int WINDOW_HEIGHT = 1000;
	// Dimensions for Health bar rectangle
	private final double HEALTHBAR_HEIGHT = 50;
	private final double HEALTHBAR_WIDTH = 4 * HEALTHBAR_HEIGHT;
	private final double HEALTHBAR_X = (WINDOW_WIDTH - HEALTHBAR_WIDTH) - (WINDOW_WIDTH * .05);
	private final double HEALTHBAR_Y = 50;
	private final int HITPOINTS = 7;
	
	//Main screen reference
	MainApplication mainScreen;
	
	// Constructor
	public _HealthBar(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
		// Adds health bar outline
		healthBarOutline = new GRect(HEALTHBAR_X, HEALTHBAR_Y, HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT);
		mainScreen.add(healthBarOutline);
		
		greenBars = new ArrayList<GRect>();
		// this loop adds lines to split between N health points and also adds N GRect Objects as health points
		for (int i = 0; i < HITPOINTS; ++i) {
			// creates and adds health bars in order for them to display on the screen
			mainScreen.add(new GLine(HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HITPOINTS)) , HEALTHBAR_Y, HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HITPOINTS)), HEALTHBAR_Y + HEALTHBAR_HEIGHT));
			healthBar = new GRect(HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HITPOINTS)), HEALTHBAR_Y, HEALTHBAR_WIDTH / HITPOINTS, HEALTHBAR_HEIGHT - 1);
			healthBar.setFillColor(Color.green);
			healthBar.setFilled(true);
			mainScreen.add(healthBar);
			// adds health bars to ArrayList
			greenBars.add(healthBar);
			
		}
		
		healthLabel = new GLabel("Health: " + greenBars.size(), HEALTHBAR_X, HEALTHBAR_Y + HEALTHBAR_HEIGHT + 20);
		mainScreen.add(healthLabel);
		
	}

	
	// this function should be called by a shipDamaged() function on another class - maybe a "level" type class
	public boolean updateHealthData(boolean damage) {
		if (greenBars.size() > 0 ) {
			mainScreen.remove(greenBars.get(greenBars.size() - 1));
			greenBars.remove(greenBars.size() - 1);
			healthLabel.setLabel("Health: " + greenBars.size());
			return true;
		}
		else {
			greenBars.add(healthBar);
			
			healthLabel.setLabel("Health: " + greenBars.size());
			return false;
		}
	}
	
	
	public void healthSound() {
		
	}
	
	public void healthEmpty() {
		
	}
	
}
