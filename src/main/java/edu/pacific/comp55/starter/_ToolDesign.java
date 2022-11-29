package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;


public class _ToolDesign extends GraphicsProgram{
	
	private _Ships balanced; 
	private _Ships tank; 
	private _Ships Speed;
	private ArrayList<GRect> enemies;
	private RandomGenerator rgen; 
	private Timer movement; 
	private int numTimes; 
	
	public void init() {
		setSize(800, 600);
		requestFocus();
	} 

	
	public _ToolDesign (MainApplication app) {
		// constructor to add on to level screen 
	}
	
	public  GRect makeEnemey(double y) { 
		GRect temp = new GRect(800, 100, 200, 200);
		temp.setColor(Color.GREEN);
		temp.setFilled(true);
		return temp;
	}
	
	private void moveAllEnemiesOnce() {
		for(GRect rect: enemies) {
			rect.move(0,rgen.nextInt(-2,2));
		}
	}


	
	public void run() {
		rgen = RandomGenerator.getInstance(); 
		enemies = new ArrayList<GRect>(); 
		movement = new Timer(50, this); 
		movement.start(); 
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
	
	
	
	
	
	
	
}
