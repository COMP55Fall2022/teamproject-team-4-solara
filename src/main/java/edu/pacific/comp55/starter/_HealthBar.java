package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Timer;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class _HealthBar {
	private ArrayList<GRect> greenBars;
	private GRect healthBar;
	private GRect healthBarOutline;
	private GLabel healthLabel;
	private double HEALTHBAR_X;
	private double HEALTHBAR_Y = 50.0;
	private double HEALTHBAR_WIDTH;
	private double HEALTHBAR_HEIGHT = 50.0;
	private int originalHealth;
	private final int HIT_POINTS = 10;
	
	
	private final int WINDOW_WIDTH = 1600;
	//private final int WINDOW_HEIGHT = 1000;
	
	// MainApplication (main screen) reference
	private MainApplication mainScreen;
	
	// constructor initialized with MainApplication object
	public _HealthBar(MainApplication app) {
			mainScreen = app; 
	}
	
	// adds green rectangles "bars" to the screen
	private void addGreenBars() {
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
	private void addLabel() {
		healthLabel = new GLabel("Health: " + greenBars.size(), HEALTHBAR_X, HEALTHBAR_Y + HEALTHBAR_HEIGHT + 20);
		healthLabel.setColor(Color.PINK);
		mainScreen.add(healthLabel);
	}
	
	// Makes and adds health bar to "level" screen
	private void addHealthBarOutline() {
		HEALTHBAR_WIDTH = 4 * HEALTHBAR_HEIGHT; // width is 4x the height of the health bar
		HEALTHBAR_X = (WINDOW_WIDTH - HEALTHBAR_WIDTH) - (WINDOW_WIDTH * .05); // 0.05 means 5% away from the screen's edge
		
		// Adds health bar outline
		healthBarOutline = new GRect(HEALTHBAR_X, HEALTHBAR_Y, HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT);
		mainScreen.add(healthBarOutline);
	}
	
	/**
	 * Updates health: either decreases or increases it
	 * @param isNotDamaged "true" increases health. "False" decreases it.
	 */
	public void updateHealthBar(boolean isNotDamaged) {
		if (!isNotDamaged && greenBars.size() > 0) {
			mainScreen.remove(greenBars.get(greenBars.size() - 1));
			greenBars.remove(greenBars.size() - 1);
			mainScreen.remove(healthLabel);
			addLabel();
		}
		else if (isNotDamaged && greenBars.size() < originalHealth) {
			healthBar = new GRect(HEALTHBAR_X + ((greenBars.size()) * (HEALTHBAR_WIDTH / HIT_POINTS)), HEALTHBAR_Y, HEALTHBAR_WIDTH / HIT_POINTS, HEALTHBAR_HEIGHT - 1);
			healthBar.setFillColor(Color.green);
			healthBar.setFilled(true);
			
			mainScreen.add(healthBar);
			greenBars.add(healthBar);
			mainScreen.remove(healthLabel);
			addLabel();
		}
	}
	
	// Makes the "overall" health bar
	public void makeHealthBar() {
		addHealthBarOutline();
		addGreenBars();
		addLabel();
	}
	
}
