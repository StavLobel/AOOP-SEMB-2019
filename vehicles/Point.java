package vehicles;
import java.lang.Math;
import java.util.HashMap;


/**
 * The Class Point
 * 
 * A lazy initialization class that not creating a new point if other point's with the same
 * values has been already created. 
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
	
	/**the collection that saves all of the instances*/
	private static HashMap<String, Point> pointsInstances = new HashMap<String, Point>();
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the value of X
	 * @param y the value of Y
	 */
	private Point(int x,int y) {
		this.x = x;
		this.y = y;
		pointsInstances.put(this.toString(), this);
	}
	
	/**
	 * Instantiates a new point with default values x=0 , y=0.
	 */
	private Point() {
		this(0,0);
	}
	
	/**
	 * Gets a point instance.
	 *
	 * @param x the x
	 * @param y the y
	 * @return an instance of the point.
	 */
	public Point getPointInstance(int x,int y) {
		synchronized (pointsInstances) {
			if (!(pointsInstances.containsKey("("+x+","+y+")")))
				pointsInstances.put("("+x+","+y+")", new Point(x,y));	
		}
		return pointsInstances.get("("+x+","+y+")");
	}
	
	/**
	 * Equals.
	 *
	 * @param other Other Point to compare
	 * @return true, if the x and y values of both points are equals
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Point))
			return false;
		else
			return other == this;
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
	public int manhattanDistance(Point other) {
		return Math.abs(this.x - other.getX())+Math.abs(this.y - other.getY());
	}
}
