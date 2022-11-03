package edu.pacific.comp55.starter;
import java.util.*;

public class _EnemyShip extends _Ships{

	public _EnemyShip(_ShipType type, int health, int damage, int isSpeed) {
		super(type, health, damage, isSpeed);
		// TODO Auto-generated constructor stub
	}
	
	private int enemyShipNum;
	private Timer movementTimer;
	private ArrayList<_Ships> shipList= new ArrayList<_Ships>();;
	
	private void incrementShips() {
		enemyShipNum++;
	}
	private void decrementShips() {
		enemyShipNum--;
	}

	/*
	 * private int getShipNum() { return enemyShipNum; }
	 */
	private void addEnemyShip(_Ships s) {
		s = new _Ships(s.type, s.health, s.damage, s.isSpeed);
		shipList.add(s);
		incrementShips();
	}
	private void removeEnemyShip() {
		
		decrementShips();
	}
	private void bulletsShooting() {
		
	}
	
	
	@Override
	public String toString() {
		return ("Vehicle info" + "\n -----------" + "\nType of ship: " + this.type + "\nhealth of vehicle: " + this.health + "\ndamage of vehicle: " + this.damage
				+ "\nspeed level: " + this.isSpeed  );
	}
	public static void main() {
		_Ships grunt1 = new _Ships(_ShipType.GRUNT, 3, 3, 3 );
		//addEnemyShip(s);
	}
}
