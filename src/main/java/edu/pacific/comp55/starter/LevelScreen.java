package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;
import javax.swing.*;


public class LevelScreen extends GraphicsPane implements ActionListener {
	// "program" to get access to all of the GraphicsProgram calls
	private MainApplication program;
	private GImage level; 
	private _ToolDesign engine;
	private _HealthBar healthBar; 
	private _Movement movement; 
	private _Powerups powerups; 
	private _Score score;
	
	private GObject bulletCheck;

	private ChoosePlaneScreen p;
	private _ShipType p1;
	private _ShipType p2;
	int BULLET_SPAWN_Y = 1080 - 50; // PROGRAM_HEIGHT - 50

	private _Bullet bulletObj;
	private Timer t;

	
	public LevelScreen(MainApplication app) {
		//p = new ChoosePlaneScreen(app);
		this.program = app;
		level = new GImage("media/Space Background.jpg", 0, 0);
		engine = new _ToolDesign(app, _ShipType.SHIP_BALANCED, _ShipType.SHIP_BALANCED);
		healthBar = new _HealthBar(app);
		powerups = new _Powerups(app);
		score = new _Score(app);
		bulletObj = new _Bullet(app);
		
		//movement = new _Movement(app);
		}


	
	void setPLayersType(_ShipType t1, _ShipType t2) {
		engine.setBattleShip1(t1);
		engine.setBattleShip2(t2);
	}

	
	public void showContents() {
		program.add(level);
		engine.run();
		healthBar.makeHealthBar();
		powerups.run();
		score.addScoreLabel();
		
		t = new Timer(1, this);
		t.start();
	//	movement.run();
	}

	public void actionPerformed(ActionEvent e) {
		bulletObj.shoot();
		bulletObj.removeBullet();
	}
	public void mousePressed(MouseEvent e) {
		bulletObj.newBullet(e.getX());
	}
	
	public void hideContents() {
		program.remove(level);
	}
	

	
}
