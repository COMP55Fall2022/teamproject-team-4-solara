package edu.pacific.comp55.starter;

// PLAYER ship class inherited from Ship class
public class _BattleShip extends _Ships {
	
	public _BattleShip(_ShipType type, int health, int damage, int isSpeed) {
		super(type, health, damage, isSpeed);
		// TODO Auto-generated constructor stub
	}
	
	// Testing things out - Miguel
	@Override
	public String toString() {
		return super.toString() + "Hello";
	}
	
	
	private void addPlayers() {}
	private void removePlayers() {}
	private void moveShip() {}
	private void setSpeed() {} 
	//In the future, add an input value in order to change the speed value when necessary
	
}

