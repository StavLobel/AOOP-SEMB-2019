package vehicles;

import DesignPatterns.IBeenRefueled;
import DesignPatterns.IRefueler;
import graphics.IClonable;
import graphics.IMoveable;

/**
 * The Class Vehicle.
 * 
 * @author Stav Lobel ID 308549898
 */
public abstract class Vehicle implements IMoveable,IClonable,IBeenRefueled{
	
	/** The license plate of the vehicle. */
	private final int LicensePlate;
	
	/** The first id. */
	private static int NEXT_ID = 1000;
	
	/** The number of wheels of the vehicle. */
	private final int numberOfWheels;
	
	/** The location of the vehicle. */
	private Location location;
	
	/** The mileage of the vehicle. */
	private int mileage = 0;
	
	/** The total fuel that have been consumed.*/
	private int consumedFuelAmount = 0;
	
	/** The number of seats. */
	private final int numberOfSeats;
	
	/** The minimum age. */
	private static int minAge = 18;
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param wheels the number of wheels of the vehicle
	 * @param numberOfSeats the number of seats
	 */
	public Vehicle(int wheels,int numberOfSeats) {
		synchronized (Vehicle.class) {
			this.LicensePlate = Vehicle.NEXT_ID;
			Vehicle.NEXT_ID++;
		}
		this.numberOfWheels = wheels;
		this.location = new Location();
		this.numberOfSeats = numberOfSeats;
	}

	/**
	 * Instantiates a new vehicle.
	 *
	 * @param wheels the number of wheels of the vehicle
	 * @param numberOfSeats the number of seats
	 * @param p the current point of the vehicle
	 */
	public Vehicle(int wheels,int numberOfSeats,Point p) {
		this(wheels,numberOfSeats);
		this.location = new Location(p);
	}
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param id the id
	 * @param wheels the number of wheels of the vehicle
	 * @param numberOfSeats the number of seats
	 * @param location the location of the vehicle
	 */
	public Vehicle(int id,int wheels,int numberOfSeats,Location location) {
		this(wheels,numberOfSeats);
		this.location = new Location(location);
	}
	
	/**
	 * Gets the location.
	 *
	 * @return a clone of the location of the vehicle
	 */
	public Location getLocation() {
		return (Location) location.clone();
	}

	/**
	 * Sets the location.
	 *
	 * @param p the new point location to set
	 * @return true, if successful ,false if it's the same location
	 */
	private boolean setLocation(Point p) {
		return this.location.setLocation(p);
	}
	
	/**
	 * Gets the license plate.
	 *
	 * @return the license plate of the vehicle
	 */
	public int getLicensePlate() {
		return LicensePlate;
	}

	/**
	 * Gets the number of wheels.
	 *
	 * @return the number of wheels of the vehicle
	 */
	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	/**
	 * Gets the mileage.
	 *
	 * @return the mileage of the vehicle
	 */
	public int getMileage() {
		return mileage;
	}
	
	/**
	 * Gets the license range.
	 *
	 * @return the license range
	 */
	public static int getNextId() {
		return Vehicle.NEXT_ID;
	}

	/**
	 * Drive.
	 *
	 *Moves the vehicle to the toGo point and updates the fuel and mileage.
	 *
	 * @param toGo the point to drive to
	 * @return true, if successful ,false if the vehicle stay in it's location
	 */
	private boolean drive(Point toGo) {
		this.useFuel(this.location.getLocationPoint().manhattanDistance(toGo)*this.getFuelConsumption());
		this.mileage += this.location.getLocationPoint().manhattanDistance(toGo);
		this.setLocation(toGo);
		return true;
	}
	
	/**
	 * Can move.
	 *
	 * @param toGo the toGo point
	 * @return true, if the vehicle can move to the toGo point
	 */
	private boolean canMove(Point toGo) {
		return this.location.getLocationPoint().manhattanDistance(toGo)*this.getFuelConsumption() <= this.getCurrentFuel();
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#useFuel(int)
	 */
	public abstract boolean useFuel(int amount);
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getCurrentFuel()
	 */
	public abstract int getCurrentFuel();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (other instanceof Vehicle == false)
			return false;
		else
			return equals((Vehicle) other);
	}
	
	/**
	 * Equals.
	 * 
	 * @param other the other vehicle
	 * @return true, if there's license plate match
	 */
	public boolean equals(Vehicle other) {
		return getLicensePlate() == other.getLicensePlate();
	}
	
	/**
	 * Return the vehicle as String.
	 *
	 * @return the license plate of the vehicle 
	 */
	public String toString() {
		return this.getLicensePlate() + "";
	}
	
	/**
	 * Gets the number of seats.
	 *
	 * @return the number of seats
	 */
	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}
	
	/**
	 * Gets the minimum age to drive this vehicle.
	 *
	 * @return the minimum age
	 */
	public int getMinAge() {
		return Vehicle.minAge;
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getFuelConsumption()
	 */
	public int getConsumedFuelAmount() {
		return consumedFuelAmount;
	}
	
	/**
	 * Sets the fuel been consumed.
	 *
	 * @param amount the amount of fuel that consumed.
	 * @return true, if successful. false ,is amount is negative number.
	 */
	public boolean setFuelBeenConsumed(int amount) {
		if (amount < 0)
			return false;
		consumedFuelAmount += amount;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see graphics.IClonable#clone()
	 */
	public abstract Object clone();
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getVehicleName()
	 */
	public abstract String getVehicleName();
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getSpeed()
	 */
	public abstract int getSpeed();
	
	/* (non-Javadoc)
	 */
	public boolean move(Point p){
	    if (this.canMove(p) && this.location.getLocationPoint().equals(p) == false) {    
	    	try {Thread.sleep(100);}
	        catch (InterruptedException e) { e.printStackTrace(); }
	        this.drive(p);
		    return true;
	    }
	    return false;
	}
	
	public void letRefuel(IRefueler refueler) {
		refueler.refuel(this);
	}
	
	/**
	 * Make next point.
	 *
	 * @param current the current point
	 * @param distance the distance that need to drive
	 * @return the point to go
	 */
	public Point makeNextPoint() {
		if (location.getOrientation().equals("North")) 
			return Point.getPointInstance(location.getLocationPoint().getX(),location.getLocationPoint().getY() - getSpeed());
		else if (location.getOrientation().equals("South")) 
			return Point.getPointInstance(location.getLocationPoint().getX(),location.getLocationPoint().getY() + getSpeed());
		else if (location.getOrientation().equals("East")) 
			return Point.getPointInstance(location.getLocationPoint().getX() + getSpeed(),location.getLocationPoint().getY());
		else if (location.getOrientation().equals("West")) 
			return Point.getPointInstance(location.getLocationPoint().getX() - getSpeed(),location.getLocationPoint().getY());
		else
			return null;
	}
}
