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
	private int originalHealth;
	
	private boolean isDamaged;
	
	// window dimensions
	private int WINDOW_WIDTH;
	private int WINDOW_HEIGHT;
	
	private int HIT_POINTS;
	private double HEALTHBAR_X, HEALTHBAR_Y;
	private double HEALTHBAR_HEIGHT, HEALTHBAR_WIDTH;
	
	// MainApplication (main screen) reference
	MainApplication mainScreen;
	
	// Constructor: Will ONLY be called by MainApplication
	public _HealthBar(HowToPlayScreen howToPlay, int windowWidth, int windowHeight, int hitPoints) {
		this.mainScreen = mainScreen;
		// assign window width/height
		WINDOW_WIDTH = windowWidth;
		WINDOW_HEIGHT = windowHeight;
		HIT_POINTS = hitPoints;
	}
	
	/*
	 * This function can be called to do everything else that needs to be 
	 * done in order to create a health bar.
	 */
	
	public _HealthBar(HowToPlayScreen howToPlayScreen) {
		// TODO Auto-generated constructor stub
	}

	public void addGreenBars() {
		// initializes an ArrayList called "greenBars"
		greenBars = new ArrayList<GRect>();
		
		// this loop adds lines to help the player know how much health remains
		for (int i = 0; i < HIT_POINTS; ++i) {
			// creates and adds health bars (and to "greenBars") in order for them to display on the screen
			mainScreen.add(new GLine(HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HIT_POINTS)) , HEALTHBAR_Y, HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HIT_POINTS)), HEALTHBAR_Y + HEALTHBAR_HEIGHT));
			healthBar = new GRect(HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HIT_POINTS)), HEALTHBAR_Y, HEALTHBAR_WIDTH / HIT_POINTS, HEALTHBAR_HEIGHT - 1);
			healthBar.setFillColor(Color.green);
			healthBar.setFilled(true);
			mainScreen.add(healthBar);
			// adds health bars to ArrayList
			greenBars.add(healthBar);
		}
		originalHealth = greenBars.size();
		
	}
	// creates and adds a health LABEL under the health bar (e.g.:  "Health: 8")
	public void addLabel() {
		healthLabel = new GLabel("Health: " + greenBars.size(), HEALTHBAR_X, HEALTHBAR_Y + HEALTHBAR_HEIGHT + 20);
		mainScreen.add(healthLabel);
	}
	
	// adds health bar
	public void addHealthBarOutline(double height, double y) {
		HEALTHBAR_HEIGHT = height;
		HEALTHBAR_WIDTH = 4 * HEALTHBAR_HEIGHT; // width is 4x the height of the health bar
		HEALTHBAR_X = (WINDOW_WIDTH - HEALTHBAR_WIDTH) - (WINDOW_WIDTH * .05); // 0.05 means 5% away from the screen's edge
		HEALTHBAR_Y = y;
		
		// Adds health bar outline
		healthBarOutline = new GRect(HEALTHBAR_X, HEALTHBAR_Y, HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT);
		mainScreen.add(healthBarOutline);
	}
	
	public void updateHealthBar(boolean isNotDamaged) {
		if (!isNotDamaged && greenBars.size() > 0) {
			mainScreen.remove(greenBars.get(greenBars.size() - 1));
			greenBars.remove(greenBars.size() - 1);
			mainScreen.remove(healthLabel);
			addLabel();
		}
		else if (isNotDamaged && greenBars.size() < originalHealth) {
			GRect tempBar = new GRect(HEALTHBAR_X + ((greenBars.size() - 1) * (HEALTHBAR_WIDTH / HIT_POINTS)), HEALTHBAR_Y, HEALTHBAR_WIDTH / HIT_POINTS, HEALTHBAR_HEIGHT - 1);
			tempBar.setFillColor(Color.green);
			tempBar.setFilled(true);
			// adds health bars to ArrayList
			greenBars.add(tempBar);
			mainScreen.add(tempBar);
		}
	}
	
	@Override
	public String toString() {
		return "" + greenBars.size();
	}
	
}
