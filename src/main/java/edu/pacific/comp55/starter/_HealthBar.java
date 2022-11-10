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
	private int healthScore = 2;
	private GRect healthBarOutline;
	private Timer timerObj;
	private GLine line;
	
	private final int WINDOW_WIDTH = 1000;
	private final int WINDOW_HEIGHT = 1000;
	// Dimensions for Health bar rectangle
	private final double HEALTHBAR_HEIGHT = 50;
	private final double HEALTHBAR_WIDTH = 4 * HEALTHBAR_HEIGHT;
	private final double HEALTHBAR_X = (WINDOW_WIDTH - HEALTHBAR_WIDTH) - (WINDOW_WIDTH * .05);
	private final double HEALTHBAR_Y = 50;
	
	private final int HITPOINTS = 8;
	
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		healthBarOutline = new GRect(HEALTHBAR_X, HEALTHBAR_Y, HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT);
		add(healthBarOutline);
		
		
		for (int i = 0; i < HITPOINTS; ++i) {
			GRect healthBar;
			
			add(new GLine(HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HITPOINTS)) , HEALTHBAR_Y, HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HITPOINTS)), HEALTHBAR_Y + HEALTHBAR_HEIGHT));
			healthBar = new GRect(HEALTHBAR_X + (i * (HEALTHBAR_WIDTH / HITPOINTS)), HEALTHBAR_Y, HEALTHBAR_WIDTH / HITPOINTS, HEALTHBAR_HEIGHT - 1);
			healthBar.setFillColor(Color.green);
			healthBar.setFilled(true);
			add(healthBar);
		}
		
		
		
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
		
	}
	
	public void healthBar() {
		
	}
	
	public void healthSound() {
		
	}
	
	public void healthEmpty() {
		
	}
	
	public static void main(String[] args) {
		new _HealthBar().start();
	}
	
}
