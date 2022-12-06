package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class LevelScreen extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
				// all of the GraphicsProgram calls
	private GImage level; 
	private _ToolDesign engine;
	private _HealthBar healthBar; 
	private _Movement movement; 
	private _Powerups powerups; 
	//private _BattleShip ship; 
	
	
	public LevelScreen(MainApplication app) {
		this.program = app;
		level = new GImage("media/Space Background.jpg", 0, 0);
		engine = new _ToolDesign(app, _ShipType.SHIP_BALANCED, _ShipType.SHIP_TANK);
	//	ship = new _BattleShip(_ShipType.SHIP_BALANCED, app);
		
		// TODO: make sure health bar can display on the "game play" screen
		// it appears behind the main menu screen
		healthBar = new _HealthBar(app);
		powerups = new _Powerups(app);
	
		
		
		//movement = new _Movement(app);
		
		}

	@Override
	public void showContents() {
		program.add(level);
		engine.run();
		healthBar.makeHealthBar();
		powerups.run(); 

	//	movement.run();
		
		
	}

	@Override
	public void hideContents() {
		program.remove(level);	
	}
	
	

	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		//if (obj == returnButton) {
		//	program.switchToMenu();
		//}
		
		System.out.println("OK");
	}
}
	
	

