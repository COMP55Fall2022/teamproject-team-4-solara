package edu.pacific.comp55.starter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import java.util.ArrayList;

import acm.graphics.GImage;

public class _BattleShip extends _Ships implements KeyListener {
	
	private int health; 
	private int damage; 
	private int speed; 
	private _ShipType type; 
	private GImage player;
	private MainApplication screen;
	
	
	public _BattleShip(_ShipType type, MainApplication app) {
		super(type, 0, 0, 0);
		int xBorder = 300;
		int yBorder = 300;
		this.type = type; 
		this.screen = app;
		double x = 0;
		double y = 0;
		String name = "";
		switch(this.type) {
			case SHIP_BALANCED: 
				this.health = 3;
				this.damage = 3;
				this.speed = 3;
				y = screen.getHeight() - yBorder;
				x = screen.getWidth() / 3;
				name = "media/Balanced plane.png";
				break;
			case SHIP_TANK: 
				this.health = 5;
				this.damage = 2;
				this.speed = 1;
				y = screen.getHeight() - yBorder;
				x = screen.getWidth() / 3 * 2;
				name = "media/Tank plane.png";
				break;
			case SHIP_SPEED:
				this.health = 1;
				this.damage = 4;
				this.speed = 5;
				y = screen.getHeight() - yBorder;
				x = screen.getWidth() - xBorder;
				name = "media/Speed plane.png";
				break;
			default:
		}
		this.player = new GImage(name,x,y);
		
	}	
	
	public void showPlayer() {
		System.out.println("player was added");
		screen.add(player);
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			System.out.println("right");
			player.move(0,10);
		}
	}
	
	//private _BattleShip b = new _BattleShip(type, health, damage, isSpeed);
	
	
	
	
//	private void addPlayers(_BattleShip player) {
//		//just adds players to the ArrayList for now - Divine
//		playerList.add(player);
//		playerNum++;
//	}
	/*
	private _Powerups p = new _Powerups();
	
	public void updateSpeed(int update) {
		this.isSpeed += update;
	}
	
	public void pickPowerUp() {
		if (b.getX() == p.getX(p)) {}
	}
*/
	@Override
	public String toString() {
		return ("Vehicle info" + "\n -----------" + "\nType of ship: " + this.type + "\nhealth of vehicle: " + this.health + "\ndamage of vehicle: " + this.damage
				+ "\nspeed level: " + this.isSpeed);
	}

	@Override
	public void keyTyped(KeyEvent e) {
			
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
