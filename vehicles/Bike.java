package vehicles;

import vehicleMovingService.VehicleMover;

/**
 * The Class Bike.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Bike extends Vehicle {
	
	/** The number of gears. */
	private final int gears;
	
	/** The speed of the bike. */
	private static final int SPEED = 20;  //NEED TO SET 2
	
	/** The bike's number of wheels. */
	private static final int NUM_OF_WHEELS = 2;
	
	/** The Constant numberOfSeats. */
	private static final int NUM_OF_SEATS = 1;
	
	/**
	 * Instantiates a new bike.
	 * 
	 * @param gears the bike's number of gears
	 * @param mover the vehicle mover
	 */
	public Bike(int gears,VehicleMover mover) {
		super(NUM_OF_WHEELS,NUM_OF_SEATS,mover);
		this.gears = gears;
	}
	
	public Bike(int gears,Location location,VehicleMover mover) {
		super(NUM_OF_WHEELS,NUM_OF_SEATS,location,mover);
		this.gears = gears;
	}
	
	private Bike(Bike other) {
		super(other);
		this.gears = other.getGears();
	}

	/**
	 * Gets the speed of the bike.
	 *
	 * @return the speed of the bike
	 */
	public int getSpeed() {
		return SPEED;
	}

	/**
	 * Gets the bike's number of gears.
	 *
	 * @return the bike's number of gears
	 */
	public int getGears() {
		return gears;
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#toString()
	 */
	public String toString() {
		return super.toString();
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#getVehicleName()
	 */
	public String getVehicleName() {
		return "Bike";
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#clone()
	 */
	public Object clone() {
		return new Bike(this);
	}
}
