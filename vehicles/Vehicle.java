package vehicles;

import java.awt.Dimension;
import java.util.LinkedList;

import DesignPatterns.IVehicle;
import cityTraffic.Observable;
import cityTraffic.Observer;
import graphics.IClonable;
import graphics.IMoveable;
import vehicleMovingService.VehicleMover;

/**
 * The Class Vehicle.
 * 
 * @author Stav Lobel ID 308549898
 */
public abstract class Vehicle implements IVehicle,IMoveable,IClonable,Runnable,Observable {
	
	/** The license plate of the vehicle. */
	private final int licensePlate;
	
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
	
	private boolean flag = false;
	
	private VehicleMover mover;
	
	private String takenDownBy;
	
	private LinkedList<Observer> observers = new LinkedList<Observer>();
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param wheels the number of wheels of the vehicle
	 * @param numberOfSeats the number of seats
	 */
	public Vehicle(int wheels,int numberOfSeats,VehicleMover mover) {
		synchronized (Vehicle.class) {
			this.licensePlate = Vehicle.NEXT_ID;
			Vehicle.NEXT_ID++;
		}
		this.numberOfWheels = wheels;
		this.location = new Location();
		this.numberOfSeats = numberOfSeats;
		this.mover = mover;
	}

	/**
	 * Instantiates a new vehicle.
	 *
	 * @param wheels the number of wheels of the vehicle
	 * @param numberOfSeats the number of seats
	 * @param p the current point of the vehicle
	 */
	public Vehicle(int wheels,int numberOfSeats,Point p,VehicleMover mover) {
		this(wheels,numberOfSeats,mover);
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
	public Vehicle(int wheels,int numberOfSeats,Location location,VehicleMover mover) {
		this(wheels,numberOfSeats,mover);
		this.location = new Location(location);
	}
	
	/**
	 * Instantiates a new vehicle only for cloning
	 *
	 * @param other the other vehicle to clone from
	 */
	protected Vehicle(Vehicle other) {
		this.licensePlate = other.getLicensePlate();
		this.location = (Location) other.getLocation().clone();
		this.mileage = other.getMileage();
		this.consumedFuelAmount = other.getConsumedFuelAmount();
		this.numberOfSeats = other.getNumberOfSeats();
		this.numberOfWheels = other.getNumberOfWheels();
		this.mover = other.getMover();
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
		return licensePlate;
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
	
	public VehicleMover getMover() {
		return this.mover;
	}

	/**
	 * Drive.
	 *
	 *Moves the vehicle to the toGo point and updates the fuel and mileage.
	 *
	 * @param toGo the point to drive to
	 * @return true, if successful ,false if the vehicle stay in it's location
	 */
	public boolean drive(Point toGo) {
		this.mileage += this.location.getLocationPoint().manhattanDistance(toGo);
		this.setLocation(toGo);
		return true;
	}
	
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
	
	public boolean canMove(Point toGo) {
		return true;
	}
	
	public boolean move(Point toGo) {
		return mover.move(this, toGo);
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IVehicle#getLowerLayer()
	 */
	public IVehicle getLowerLayer() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IVehicle#getCore()
	 */
	public Vehicle getCore() {
		return this;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		flag = true;
		while(flag) {
			Point toGo = mover.makeNextPoint(this.location,getSpeed());
			while (canMove(toGo) == false && flag) {
				synchronized (this) {
					try {
						notifyObservers("RunOutOfFuel");
						wait();	
					}
					catch (InterruptedException e) {}
					notifyObservers("Fueled");
				}
			}
			move(toGo);
			notifyObservers("moved");
			}
	}
	
	/**
	 * Kill.
	 * 
	 * kill the thread.
	 */
	public synchronized void kill(String byWho) {
		takenDownBy = byWho;
		notifyObservers("killed");
		this.flag = false;
		this.notify();
	}
	
	
	/**
	 * Gets the flag.
	 *
	 * @return the flag
	 */
	public boolean getFlag() {
		return this.flag;
	}
	
	public synchronized boolean addObserver(Observer observer) {
		return observers.add(observer);
	}
	
	public synchronized boolean removeObserver(Observer observer) {
		return observers.remove(observer);
	}
	
	public boolean notifyObservers(String msg) {
		observers.forEach(n -> n.getNotified(this,msg));
		return true;
	}
	
	public Dimension getDimensions() {
		int size = 65;
		if (this.getLocation().getOrientation().equals(Location.NORTH) || this.getCore().getLocation().getOrientation().equals(Location.SOUTH))
			return new Dimension(size, size*2);
		else
			return new Dimension(size*2, size);
	}
	
}
