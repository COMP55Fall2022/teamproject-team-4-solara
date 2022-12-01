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
	private double HEALTHBAR_Y;
	private double HEALTHBAR_WIDTH;
	private double HEALTHBAR_HEIGHT;
	private int originalHealth;
	private final int HIT_POINTS = 4;
	
	
	private final int WINDOW_WIDTH = 1000;
	private final int WINDOW_HEIGHT = 1000;
	
	// MainApplication (main screen) reference
	MainApplication mainScreen;
	
	// Constructor: Will ONLY be called by MainApplication
	public _HealthBar(MainApplication app) {
			mainScreen = app; 
	}
	
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
		mainScreen.add(healthLabel);
	}
	
	// adds health bar
	private void addHealthBarOutline(double height, double y) {
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
			healthBar = new GRect(HEALTHBAR_X + ((greenBars.size()) * (HEALTHBAR_WIDTH / HIT_POINTS)), HEALTHBAR_Y, HEALTHBAR_WIDTH / HIT_POINTS, HEALTHBAR_HEIGHT - 1);
			healthBar.setFillColor(Color.green);
			healthBar.setFilled(true);
			
			mainScreen.add(healthBar);
			greenBars.add(healthBar);
			mainScreen.remove(healthLabel);
			addLabel();
		}
	}
	
	// calls these functions to make health bar
	// For this reason, these functions are private
	public void makeHealthBar() {
		addHealthBarOutline(50.0,50.0);
		addGreenBars();
		addLabel();
	}
	
}
