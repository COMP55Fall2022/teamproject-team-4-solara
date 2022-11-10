package edu.pacific.comp55.starter;

public enum _PowerUpType {
	SPEED_UP, DOUBLE_BULLET, HEALTH_BOOST;
	
	public String toString() {
		switch(this) {
		case SPEED_UP: return "speed increases by x";
		case DOUBLE_BULLET: return "shoots double bullet";
		case HEALTH_BOOST: return "increase hp by x";
		}
		return "n/a";
	}
}
