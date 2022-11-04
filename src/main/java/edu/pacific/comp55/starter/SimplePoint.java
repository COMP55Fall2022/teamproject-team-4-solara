package edu.pacific.comp55.starter;

public class SimplePoint {
	  private double x, y;

	  public SimplePoint(double x, double y) {
	    this.x = x;
	    this.y = y;
	  }

	  public double getX() { return x; };

	  public double getY() { return y; };

	  public double distance(SimplePoint p) {
	    return Math.sqrt( Math.pow(p.getX()-x,2) + Math.pow(p.getY()-y,2) );
	  }

	  public static void main(String[] args) {
	    SimplePoint p1 = new SimplePoint(2,1);
	    SimplePoint p2 = new SimplePoint(8,2);

	    System.out.println( p1.distance(p2) ); // 6.082762530298219
	  }
}
