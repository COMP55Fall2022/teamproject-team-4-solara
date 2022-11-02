package edu.pacific.comp55.starter;

public class _Ships {
	
	
	int damage; 
	int health; 
	boolean isSpeed; 
	// ask professor how to go about implementing speed. Should it be a boolean or an  int?
	// constructor to use for ships 
	public _Ships(_ShipType type, int health, int damage, boolean isSpeed) {
		
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

}
