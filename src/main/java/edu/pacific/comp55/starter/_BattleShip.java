package edu.pacific.comp55.starter;
import java.util.*;

import java.util.ArrayList;

// PLAYER ship class inherited from Ship class
public class _BattleShip extends _Ships {
	private Timer t;
	private int playerNum = 0;
	private ArrayList<_BattleShip> playerList = new ArrayList<_BattleShip>();
	
	public _BattleShip(_ShipType type, int health, int damage, int isSpeed) {
		super(type, health, damage, isSpeed);
		// TODO Auto-generated constructor stub
	}
	private void addPlayers(_BattleShip player) {
		//just adds players to the ArrayList for now - Divine
		playerList.add(player);
		playerNum++;
	}
	//-------------------------------------------------------------------
	//test helper function(s)
	private int getPlayerNum() {
		return playerNum;
	}
	// end of test helper functions
	//--------------------------------------------------------------------
	private void removePlayers() {
		//if a player dies

	}
	private void moveShip() {
		//should this be in the graphics instead?? - Divine
	}
	private void updateSpeed(int update) {
		//if powerup type = speed update or maybe on contact with a speed update object - Divine
		this.isSpeed += update;
	}

	@Override
	public String toString() { 
		return ("Vehicle info" + "\n -----------" + "\nType of ship: " + this.type + "\nhealth of vehicle: " + this.health + "\ndamage of vehicle: " + this.damage
				+ "\nspeed level: " + this.isSpeed  );
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
		_BattleShip player1 = new _BattleShip(_ShipType.SHIP_BALANCED, 3, 3, 3);
		player1.addPlayers(player1);
		System.out.println("There is 1 grunt with:");
		System.out.println(player1);
		System.out.println("Number of enemy ships in the array: " + player1.getPlayerNum());

	}
}

