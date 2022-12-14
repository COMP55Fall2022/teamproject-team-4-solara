package edu.pacific.comp55.starter;

public class _Ships {
	protected double xLoc;
	protected double yLoc;
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
	
	public double getX() {
		return xLoc;
	}

	public void setX(int spawnX) {
		this.xLoc = spawnX;
	}

	public double getSpawnY() {
		return yLoc;
	}

	public void setY(int spawnY) {
		this.yLoc = spawnY;
	}

	public String toString() {
		return ("Vehicle info" + "\n -----------" + "\nType of ship: " + this.type + "\nhealth of vehicle: "
				+ this.health + "\ndamage of vehicle: " + this.damage + "\nspeed level: " + this.isSpeed);
	}

	public static void healthScore() {

	}

	public static void main(String[] args) { 
		 _Ships balancedShip = new _Ships(_ShipType.SHIP_BALANCED, 3, 3, 3); _Ships
		 tankShip = new _Ships(_ShipType.SHIP_TANK, 5, 2, 1); _Ships speedShip = new
		 _Ships(_ShipType.SHIP_SPEED, 2, 4,5 );
		 System.out.println("this is a test to print out balanced ship stats\n");
		 System.out.println(balancedShip);
		 System.out.println("This is a test to print out tankShip stats");
		 System.out.println(tankShip);
		 System.out.println("This is a test to print out speedShip stats");
		 System.out.println(speedShip);
	}
}
