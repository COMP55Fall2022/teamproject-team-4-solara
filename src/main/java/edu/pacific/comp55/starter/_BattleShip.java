package edu.pacific.comp55.starter;
import java.util.*;

import java.util.ArrayList;

public class _BattleShip extends _Ships {
	
	private int health; 
	private int damage; 
	private int speed; 
	private _ShipType type; 
	
	public _BattleShip(_ShipType type, int health, int damage, int speed) {
		super(type, health, damage, speed);
		this.health = health; 
		this.damage = damage; 
		this.type = type; 
		this.speed = speed; 
	}

	private Timer t;
	private int playerNum = 0;
	private ArrayList<_BattleShip> playerList = new ArrayList<_BattleShip>();
	
	
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

	private void addPlayers(_BattleShip balanced, _BattleShip tank, _BattleShip speedster) {
		toString();
		balanced = new _BattleShip(_ShipType.SHIP_BALANCED, 3, 3, 3); 
		tank = new _BattleShip(_ShipType.SHIP_TANK, 5, 2, 1);
		speedster = new _BattleShip(_ShipType.SHIP_SPEED, 1, 4, 5);
		playerList.add(balanced);
		playerList.add(tank);
		playerList.add(speedster);
	}

	public static void main (String[] args) {
//		_BattleShip player1 = new _BattleShip(_ShipType.SHIP_BALANCED, 3, 3, 3);
//		player1.addPlayers(player1);
//		System.out.println("There is 1 grunt with:");
//		System.out.println(player1);
//		System.out.println("Number of enemy ships in the array: " + player1.getPlayerNum());

	}
}

