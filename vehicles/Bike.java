package vehicles;


// TODO: Auto-generated Javadoc
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
	private static final int WHEELS = 2;
	
	/** The Constant numberOfSeats. */
	private static final int numberOfSeats = 1;
	
	/**
	 * Instantiates a new bike.
	 *
	 * @param color the color of the bike
	 * @param gears the bike's number of gears
	 */
	public Bike(String color,int gears) {
		super(color,WHEELS,Bike.numberOfSeats);
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
	
	//*************HW2***********
	
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
		return new Bike(this.getColor(),this.getGears());
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#refuel()
	 */
	public boolean refuel() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#getCurrentFuel()
	 */
	public int getCurrentFuel() {
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getFuelConsumption()
	 */
	public int getFuelConsumption() {
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#useFuel(int)
	 */
	public boolean useFuel(int amount) {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getEngineType()
	 */
	public String getEngineType() {
		return null;
	}
}
