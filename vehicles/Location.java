package vehicles;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Class Location.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Location{
	
	/** The point. */
	private Point point;
	
	/** The Constant NORTH. */
	private static final String NORTH = "north";
	
	/** The Constant SOUTH. */
	private static final String SOUTH = "south";
	
	/** The Constant EAST. */
	private static final String EAST = "east";
	
	/** The Constant WEST. */
	private static final String WEST = "west";
	
	/** The Constant ORIENTATIONS. */
	private static ArrayList<String> ORIENTATIONS = new ArrayList<String>() {
		{
			add(NORTH);
			add(SOUTH);
			add(EAST);
			add(WEST);
		}
	};
	
	/** The opposites orientations. */
	private static HashMap<String, String> OPPOSITES = new HashMap<String, String>() {
		{
			put(NORTH, SOUTH);
			put(SOUTH, NORTH);
			put(EAST, WEST);
			put(WEST, EAST);
		}
	};
	
	/** The orientation. */
	private String orientation = EAST;
	
	/**
	 * Instantiates a new location in a specific point.
	 *
	 * @param p the point to set the new location
	 */
	private Location(Point p) {
		this.point = p;
	}
	
	/**
	 * Instantiates a new location with point (0,0) and east orientation
	 */
	private Location() {
		this(Point.getPointInstance(0,0));
	}
	
	/**
	 * Instantiates a new location.
	 *
	 * @param other other location to copy from
	 */
	private Location(Location other) {
		this.point = other.getLocationPoint();
		this.orientation = other.getOrientation();
	}
	
	/**
	 * Gets the location's point.
	 *
	 * @return the location's point
	 */
	public Point getLocationPoint() {
		return this.point;
	}
	
	/**
	 * Sets the location's point.
	 *
	 * @param p new point to set
	 * @return true, if successful ,false if it's the new point equals the current location's point
	 */
	public boolean setLocation(Point p) {
		if (this.point.equals(p))
			return false;
		else {
			if (this.point.getX() < p.getX() && this.point.getY() == p.getY())
				this.orientation = EAST;
			else if (this.point.getX() > p.getX() && this.point.getY() == p.getY())
				this.orientation = WEST;
			else if (this.point.getX() == p.getX() && this.point.getY() > p.getY())
				this.orientation = NORTH;
			else if (this.point.getX() == p.getX() && this.point.getY() < p.getY())
				this.orientation = SOUTH;
			else if ((this.getOrientation().equals(EAST) || this.getOrientation().equals(WEST)) && this.point.getY() < p.getY())
				this.orientation = SOUTH;
			else if ((this.getOrientation().equals(EAST) || this.getOrientation().equals(WEST)) && this.point.getY() > p.getY())
				this.orientation = NORTH;
			else if ((this.getOrientation().equals(NORTH) || this.getOrientation().equals(SOUTH)) && this.point.getX() > p.getX())
				this.orientation = WEST;
			else if ((this.getOrientation().equals(NORTH) || this.getOrientation().equals(SOUTH)) && this.point.getX() < p.getX())
				this.orientation = EAST;
			this.point = p;
			return true;
		}
	}
	
	/**
	 * Sets the location.
	 *
	 * @param other other location to copy from
	 * @see #setLocation(Point p)
	 * @return true, if successful ,false if it's the new location equals the current location
	 */
	public boolean setLocation(Location other) {
		if (this.equals(other))
			return false;
		return setLocation(other.getLocationPoint());
	}
	
	/**
	 * Equals.
	 *
	 * @param other the other location
	 * @return true, if has same point location
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Location))
			return false;
		return this.equals((Location) other);
	}
	
	/**
	 * Equals.
	 *
	 * @param other the other location
	 * @return true, if has same point location
	 */
	public boolean equals(Location other) {
		return this.point.equals(other.getLocationPoint());
	}
	
	/**
	 * Gets the orientation.
	 *
	 * @return the orientation
	 */
	public String getOrientation() {
		return this.orientation.substring(0, 1).toUpperCase() + this.orientation.substring(1);
	}
	
	/**
	 * Return the Location as String
	 * 
	 * @return "(X,Y),Orientation"
	 */
	public String toString() {
		return pointPointToString() + ","+ getOrientation();
	}
	
	/**
	 * Returns only the location's point as String
	 *
	 * @return "(X,Y)"
	 */
	public String pointPointToString() {
		return getLocationPoint().toString();
	}
	
	/**
	 * Gets the all orientations.
	 *
	 * @return all of the orientations in an array
	 */
	public static String[] getAllOrientations() {
		return (String[]) ORIENTATIONS.toArray();
	}
	
	/**
	 * Sets the orientation of the location.
	 *
	 * @param orientation the new orientation
	 * @return true, if successful
	 */
	public boolean setOrientation(String orientation) {
		orientation = orientation.toLowerCase();
		if (ORIENTATIONS.contains(orientation) == false || orientation.equals(this.orientation))
			return false;
		this.orientation = orientation;
		return true;
	}
	
	/**
	 * Gets the opposite orientation.
	 *
	 * @return the opposite orientation
	 */
	public String getOppositeOrientation() {
		return OPPOSITES.get(this.orientation);
	}
}
