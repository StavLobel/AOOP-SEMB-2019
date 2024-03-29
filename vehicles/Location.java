package vehicles;

import java.util.Arrays;

/**
 * The Class Location.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Location{
	
	/** The location. */
	private Point location;
	
	/** The Constant NORTH. */
	private static final String NORTH = "North";
	
	/** The Constant SOUTH. */
	private static final String SOUTH = "South";
	
	/** The Constant EAST. */
	private static final String EAST = "East";
	
	/** The Constant WEST. */
	private static final String WEST = "West";
	
	private static final String[] ORIENTATIONS = {NORTH,SOUTH,EAST,WEST};
	
	/** The orientation. */
	private String orientation = EAST;
	
	/**
	 * Instantiates a new location with point (0,0) and center orientation
	 */
	public Location() {
		this.location = new Point();
	}
	
	/**
	 * Instantiates a new location.
	 *
	 * @param p the point to set the new location
	 */
	public Location(Point p) {
		this.location = p;
	}
	
	/**
	 * Instantiates a new location.
	 *
	 * @param other other location to copy from
	 */
	public Location(Location other) {
		this.location = other.getLocationPoint();
		this.orientation = other.getOrientation();
	}
	
	/**
	 * Gets the location's point.
	 *
	 * @return the location point
	 */
	public Point getLocationPoint() {
		return this.location;
	}
	
	/**
	 * Gets the orientation.
	 *
	 * @return the orientation
	 */
	public String getOrientation() {
		return this.orientation;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param p new point to set
	 * @return true, if successful ,false if it's the new point equals the current point
	 */
	public boolean setLocation(Point p) {
		if (this.location.equals(p))
			return false;
		else {
			if (this.location.getX() < p.getX() && this.location.getY() == p.getY())
				this.orientation = EAST;
			else if (this.location.getX() > p.getX() && this.location.getY() == p.getY())
				this.orientation = WEST;
			else if (this.location.getX() == p.getX() && this.location.getY() > p.getY())
				this.orientation = NORTH;
			else if (this.location.getX() == p.getX() && this.location.getY() < p.getY())
				this.orientation = SOUTH;
			else if ((this.getOrientation().equals(EAST) || this.getOrientation().equals(WEST)) && this.location.getY() < p.getY())
				this.orientation = SOUTH;
			else if ((this.getOrientation().equals(EAST) || this.getOrientation().equals(WEST)) && this.location.getY() > p.getY())
				this.orientation = NORTH;
			else if ((this.getOrientation().equals(NORTH) || this.getOrientation().equals(SOUTH)) && this.location.getX() > p.getX())
				this.orientation = WEST;
			else if ((this.getOrientation().equals(NORTH) || this.getOrientation().equals(SOUTH)) && this.location.getX() < p.getX())
				this.orientation = EAST;
			this.location = p;
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
		return setLocation(other.getLocationPoint());
	}
	
	/**
	 * Equals.
	 *
	 * @param other other Location
	 * @return true, if has same location point
	 */
	public boolean equals(Location other) {
		return this.location.equals(other.getLocationPoint());
	}
	
	/**
	 * Return the Location as String
	 * 
	 * @return "(X,Y),orientation"
	 */
	public String toString() {
		return locationPointToString() + ","+ getOrientation();
	}
	
	/**
	 * Returns only the location's point as String
	 *
	 * @return "(X,Y)"
	 */
	public String locationPointToString() {
		return ""+getLocationPoint();
	}
	
	/**
	 * Replicate the Location
	 *
	 * @return a clone of the location
	 */
	public Location replicate() {
		Location toCopy = new Location(this);
		toCopy.setOrientation(this.getOrientation());
		return toCopy;
	}
	
	public static String[] getOrientations() {
		return Location.ORIENTATIONS;
	}
	
	public boolean setOrientation(String orientation) {
		boolean orientationExist = false;
		for (int i = 0 ; i < ORIENTATIONS.length ; ++i)
			if (ORIENTATIONS[i].equals(orientation))
				orientationExist = true;
		if (orientation.equals(this.getOrientation()) || orientationExist == false)
			return false;
		this.orientation = orientation;
		return true;
	}
	
	public String getOppositeOrientation() {
		if (orientation.equals(NORTH))
			return SOUTH;
		if (orientation.equals(SOUTH))
			return NORTH;
		if (orientation.equals(EAST))
			return WEST;
		if (orientation.equals(WEST))
			return EAST;
		return null;
	}
}
