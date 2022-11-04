package edu.pacific.comp55.starter;

public enum _ShipType {
	
	SHIP_BALANCED, SHIP_TANK, SHIP_SPEED, GRUNT, BOSS;
	
	
	public String toString() {
		switch(this) {
			case SHIP_BALANCED: return "balanced";
			case SHIP_TANK: return "tank";
			case SHIP_SPEED: return "speed";
			case GRUNT: return "grunt"; 
			case BOSS: return "boss"; 
		}
		return "n/a";
	}
}