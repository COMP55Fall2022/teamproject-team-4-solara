package edu.pacific.comp55.starter;

import java.util.*;

public class _EnemyShip extends _Ships {
	

	public _EnemyShip(_ShipType type, int health, int damage, int isSpeed) {
		super(type, health, damage, isSpeed);
		// TODO Auto-generated constructor stub
	}

	private Timer movementTimer;
	private ArrayList<_EnemyShip> shipList = new ArrayList<_EnemyShip>();
	
	/*
	 * public void addEnemyShip(_EnemyShip s) { s = new _EnemyShip(s.type,
	 * s.health,s.damage, s.isSpeed); shipList.add(s); } private void
	 * removeEnemyShip(_Ships s) { s = new _Ships(s.type, s.health, s.damage,
	 * s.isSpeed); }
	 */
	private void bulletsShooting() {}

	@Override
	public String toString() { 
		return ("Vehicle info" + "\n -----------" + "\nType of ship: " + this.type + "\nhealth of vehicle: " + this.health + "\ndamage of vehicle: " + this.damage
				+ "\nspeed level: " + this.isSpeed  );
	}
	
	public static void main(String[] args) {
		_EnemyShip grunt1 = new _EnemyShip(_ShipType.GRUNT, 3, 3, 3);
		System.out.println("There is 1 grunt with:");
		System.out.println(grunt1);
		System.out.println("Number of enemy ships in the array: ");
		
	}
}
