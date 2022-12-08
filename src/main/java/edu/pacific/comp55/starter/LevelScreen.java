package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class LevelScreen extends GraphicsPane implements ActionListener {
	// "program" to get access to all of the GraphicsProgram calls
	private MainApplication program;
	private GImage level; 
	private _ToolDesign engine;
	private _HealthBar healthBar; 
	private _Movement movement; 
	private _Powerups powerups; 
	private _Score score;
	private _Bullet bulletObj;
	private MenuPane menu; 
	
	public LevelScreen(MainApplication app) {
		this.program = app;
		level = new GImage("media/Space Background.jpg", 0, 0);
		engine = new _ToolDesign(app, _ShipType.SHIP_BALANCED, _ShipType.SHIP_TANK);
		
		healthBar = new _HealthBar(app);
		powerups = new _Powerups(app);
		score = new _Score(app);
		bulletObj = new _Bullet(app);
		menu = new MenuPane(app);
		
		
		
		//movement = new _Movement(app);
		
		}

	/*
	@Override
	public void keyPressed(KeyEvent e) {

	}
	*/
	
	@Override
	public void showContents() {
		program.add(level);
		engine.run();
		healthBar.makeHealthBar();
		powerups.run();
		score.addScoreLabel();
		
	//	movement.run();
	}

	@Override
	public void hideContents() {
		program.remove(level);
	}
	
	public void mousePressed(MouseEvent e) {
		bulletObj.newBullet(e.getX());
		
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menu.yes) {
			System.exit(0);
		}
		else if (obj == menu.no) {
			menu.removeQuitBox();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		bulletObj.shoot();
		bulletObj.removeBullet();
		}
}
	

