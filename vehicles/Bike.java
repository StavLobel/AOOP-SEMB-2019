package vehicles;

/**
 * The Class Bike.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Bike extends Vehicle {
	
	/** The number of gears. */
	private final int gears;
	
	/** The speed of the bike. */
	private static final int SPEED = 2;
	
	/** The bike's number of wheels. */
	private static final int NUM_OF_WHEELS = 2;
	
	/** The Constant numberOfSeats. */
	private static final int NUM_OF_SEATS = 1;
	
	/**
	 * Instantiates a new bike.
	 * 
	 * @param gears the bike's number of gears
	 */
	public Bike(int gears) {
		super(NUM_OF_WHEELS,NUM_OF_SEATS);
		this.gears = gears;
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
		return new Bike(this.getGears());
	}
}
