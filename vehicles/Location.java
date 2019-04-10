package vehicles;

/**
 * The Class Location.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Location{
	
	/** The location. */
	private Point location;
	
	/** The orientation. */
	private String orientation;
	
	/**
	 * Instantiates a new location with point (0,0) and center orientation
	 */
	public Location() {
		this.location = new Point();
		this.orientation = getOrientation(this.location);
	}
	
	/**
	 * Instantiates a new location.
	 *
	 * @param p the point to set the new location
	 */
	public Location(Point p) {
		this.location = p;
		this.orientation = getOrientation(this.location);
	}
	
	/**
	 * Instantiates a new location.
	 *
	 * @param other other location to copy from
	 */
	public Location(Location other) {
		this.location = other.getLocationPoint();
		this.orientation = getOrientation(this.location);
	}
	
	/**
	 * Factory method to get the orientation of a point
	 * assumes (0,0) is the center
	 *
	 * @param p the point to get it's orientation
	 * @return the orientation as String
	 */
	private static String getOrientation(Point p) {
		String x,y;
		
		if (p.getX() == 0 && p.getY() == 0)
			return "Center";
		if (p.getX() > 0)
			x = "East";
		else if (p.getX() < 0)
			x = "West";
		else
			x = "";
		
		if (p.getY() > 0)
			y = "North";
		else if (p.getY() < 0)
			y = "South";
		else
			y = "";
		
		return y+x;
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
			this.location = p;
			this.orientation = getOrientation(p);
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
		return new Location(this);
	}
}
