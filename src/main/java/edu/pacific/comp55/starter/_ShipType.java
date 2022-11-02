package edu.pacific.comp55.starter;
public enum _ShipType {
	SHIP_BALANCED, SHIP_TANK, SHIP_SPEED;
//yo	
	public String toString() {
		switch(this) {
			case SHIP_BALANCED: return "balanced";
			case SHIP_TANK: return "tank";
			case SHIP_SPEED: return "speed";
		}
		return "n/a";
	}
}