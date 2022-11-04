package edu.pacific.comp55.starter;

import java.util.ArrayList;

// PLAYER ship class inherited from Ship class
public class _BattleShip extends _Ships {
	
	private ArrayList<_BattleShip> playerList = new ArrayList<_BattleShip>();

	
	
	public _BattleShip(_ShipType type, int health, int damage, int isSpeed) {
		super(type, health, damage, isSpeed);
		// TODO Auto-generated constructor stub
	}
	
	
	// Testing things out - Miguel

	
	
	private void addPlayers(_BattleShip balanced, _BattleShip tank, _BattleShip speedster) {
	
	 balanced = new _BattleShip(_ShipType.SHIP_BALANCED, 3, 3, 3); 
	 tank = new _BattleShip(_ShipType.SHIP_TANK, 5, 2, 1);
	 speedster = new _BattleShip(_ShipType.SHIP_SPEED, 1, 4, 5);
	
	 playerList.add(balanced);
	 playerList.add(tank);
	 playerList.add(speedster);
	 
	
	}
	
	
	private void removePlayers() {}
	private void moveShip() {}
	private void setSpeed() {} 
	//In the future, add an input value in order to change the speed value when necessary
	
	public String toString() {
		return ("Vehicle info" + "\n -----------" + "\nType of ship: " + this.type + "\nhealth of vehicle: "
				+ this.health + "\ndamage of vehicle: " + this.damage + "\nspeed level: " + this.isSpeed);
	}
	public static void main(String[] args) {
		
		}
		
	}


