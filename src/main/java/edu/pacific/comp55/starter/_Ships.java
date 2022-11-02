package edu.pacific.comp55.starter;

public class _Ships {
	
	
	private int damage; 
	private int health; 
	private boolean isSpeed; 
	// ask professor how to go about implementing speed. Should it be a boolean or an  int?
	// constructor to use for ships 
	public _Ships(_ShipType type, int health, int damage, boolean isSpeed) {
		this.health = health; 
		this.type = type; 
		this.damage = damage; 
		this.isSpeed = isSpeed; 
	}
	
	_ShipType type; 
	public _ShipType getType() {
		return type;
	}
	public void setType(_ShipType type) {
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
	public boolean isSpeed() {
		return isSpeed;
	}
	public void setSpeed(boolean isSpeed) {
		this.isSpeed = isSpeed;
	}

	public String toString() { 
		return ("Vehicle info" + "\n -----------" + "\nType of ship: " + this.type + "\nhealth of vehicle: " + this.health + "\ndamage of vehicle: " + this.damage
				+ "\nis it speedy? " + this.isSpeed  );
	}
		
	public static void main(String[] args) {
		
		_Ships balancedShip = new _Ships(_ShipType.SHIP_BALANCED, 3, 3, false );
		_Ships tankShip = new _Ships(_ShipType.SHIP_TANK, 5, 2, false);
		_Ships speedShip = new _Ships(_ShipType.SHIP_SPEED, 2, 5, true);
		
		System.out.println("this is a test to print out balanced ship stats");
		System.out.println(balancedShip);
		System.out.println("This is a test to print out tankShip stats");
		System.out.print(tankShip);
		System.out.println("This is a test to print out speedShip stats");
		System.out.println(speedShip);
		
	}
}
