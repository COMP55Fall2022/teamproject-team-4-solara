package edu.pacific.comp55.starter;
public enum _ShipType {
	MYCAR, TRUCK, AUTO;
	
	public String toString() {
		switch(this) {
			case MYCAR: return "car";
			case TRUCK: return "truck";
			case AUTO: return "auto";
		}
		return "n/a";
	}
}