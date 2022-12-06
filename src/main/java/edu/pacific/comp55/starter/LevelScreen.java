package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class LevelScreen extends GraphicsPane implements ActionListener {
	private MainApplication program; // you will use program to get access to
				// all of the GraphicsProgram calls
	private GImage level; 
	private _ToolDesign engine;
	private _HealthBar healthBar; 
	private _Movement movement; 
	private _Powerups powerups; 
	private _Score score;
	private _Bullet bullet;
	int BULLET_SPAWN_Y = 1080 - 50; // PROGRAM_HEIGHT - 50
	
	public LevelScreen(MainApplication app) {
		this.program = app;
		level = new GImage("media/Space Background.jpg", 0, 0);
		engine = new _ToolDesign(app, _ShipType.SHIP_BALANCED, _ShipType.SHIP_TANK);
		
		healthBar = new _HealthBar(app);
		powerups = new _Powerups(app);
		score = new _Score(app);
		bullet = new _Bullet(app);
		
		//movement = new _Movement(app);
		
		}

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

	@Override
	public void mousePressed(MouseEvent e) {
		bullet.newbullet(e.getX(), BULLET_SPAWN_Y);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		bullet.shoot();
		bullet.removeBullet();
	}
}
