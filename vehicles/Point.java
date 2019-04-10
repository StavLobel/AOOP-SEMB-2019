package vehicles;
import java.lang.Math;

/**
 * The Class Point 
 * 
 * @author Stav Lobel ID 308549898
 * 
 * The class is immutable 
 */
public class Point {
	/** the X value*/
	private int x;
	/** the X value*/
	private int y;
	
	/**
	 * Instantiates a new point with default values x=y=0
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the value of X
	 * @param y the value of Y
	 */
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Instantiates a new point.
	 *
	 * @param other Other Point to copy from it's values
	 */
	public Point(Point other) {
		this.x = other.getX();
		this.y = other.getY();
	}
	
	/**
	 * Equals.
	 *
	 * @param other Other Point to compare
	 * @return true, if the x and y values of both points are equals
	 */
	public boolean equals(Point other) {
		return (this.x == other.getX() && this.y == other.getY());
	}
	
	/**
	 * Gets the X value of the point
	 *
	 * @return the X value
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the Y value of the point.
	 *
	 * @return the Y value
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Return the point as String
	 * 
	 * @return "(X,Y)"
	 */
	public String toString() {
		return "("+getX()+","+getY()+")";
	}
	
	/**
	 * Distance.
	 *
	 * @param other other point
	 * @return the distance between this point and the other point
	 */
	public float distance(Point other) {
		return (float)Math.sqrt(Math.pow(this.x-other.getX(),2)+Math.pow(this.y-other.getY(),2));
	}
	
	/**
	 * Manhattan Distance.
	 *
	 * @param other other point
	 * @return the the "Manhattan Distance" between this point and the other point
	 */
	public int distanceManhattan(Point other) {
		return Math.abs(this.x - other.getX())+Math.abs(this.y - other.getY());
	}
}
