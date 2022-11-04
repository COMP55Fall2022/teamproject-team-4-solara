package edu.pacific.comp55.starter;

import acm.graphics.*;

public class _Ships {

	// Protected because we need to use them for the child classes - Miguel
	
	/*
	 * We can implement a SPAWN CLASS and declare it here!
	 */
	
	
	protected SimplePoint spawnLocation;
	protected int healthScore;
	protected int damage;
	protected int health;
	protected int isSpeed;
	protected _ShipType type;

	public _Ships(_ShipType type, int health, int damage, int isSpeed) {
		this.health = health;
		this.type = type;
		this.damage = damage;
		this.isSpeed = isSpeed;
		
		//spawnLocation = new SimplePoint(x, y);
	}

	public _ShipType getShipType() {
		return type;
	}

	public void setShipType(_ShipType type) {
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return isSpeed;
	}

	public void setSpeed(int isSpeed) {
		this.isSpeed = isSpeed;
	}

	public String toString() {
		return ("Vehicle info" + "\n -----------" + "\nType of ship: " + this.type + "\nhealth of vehicle: "
				+ this.health + "\ndamage of vehicle: " + this.damage + "\nspeed level: " + this.isSpeed);
	}

	public static void healthScore() {

	}

	public static void main(String[] args) { 
//		 _Ships balancedShip = new _Ships(_ShipType.SHIP_BALANCED, 3, 3, 3); _Ships
//		 tankShip = new _Ships(_ShipType.SHIP_TANK, 5, 2, 1); _Ships speedShip = new
//		 _Ships(_ShipType.SHIP_SPEED, 2, 4,5 );
//		 System.out.println("this is a test to print out balanced ship stats\n");
//		 System.out.println(balancedShip);
//		 System.out.println("This is a test to print out tankShip stats");
//		 System.out.println(tankShip);
//		 System.out.println("This is a test to print out speedShip stats");
//		 System.out.println(speedShip);
	}
}
