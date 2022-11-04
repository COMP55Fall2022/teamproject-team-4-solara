package edu.pacific.comp55.starter;
import java.util.*;

// PLAYER ship class inherited from Ship class
public class _BattleShip extends _Ships {
	
	private Timer t;
	private int playerNum = 0;
	private ArrayList<_BattleShip> PlayerList = new ArrayList(1);
		
	public _BattleShip(_ShipType type, int health, int damage, int isSpeed) {
		super(type, health, damage, isSpeed);
		// TODO Auto-generated constructor stub
	}
	private void addPlayers(_BattleShip player) {
		//just adds players to the ArrayList for now - Divine
		player = new _BattleShip(player.type, player.health, player.damage, player.isSpeed);
		PlayerList.add(player);
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
	
	//In the future, add an input value in order to change the speed value when necessary
	
	
	
	// Testing things out - Miguel
	@Override
	public String toString() { 
		return ("Vehicle info" + "\n -----------" + "\nType of ship: " + this.type + "\nhealth of vehicle: " + this.health + "\ndamage of vehicle: " + this.damage
				+ "\nspeed level: " + this.isSpeed  );
	}
	
	public static void main (String[] args) {
		_BattleShip player1 = new _BattleShip(_ShipType.SHIP_BALANCED, 3, 3, 3);
		player1.addPlayers(player1);
		System.out.println("There is 1 grunt with:");
		System.out.println(player1);
		System.out.println("Number of enemy ships in the array: " + player1.getPlayerNum());
	}
}

