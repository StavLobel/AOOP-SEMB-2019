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
	private static final int WHEELS = 2;
	
	/**
	 * Instantiates a new bike.
	 *
	 * @param licensePlate the license plate of the bike
	 * @param color the color of the bike
	 * @param gears the bike's number of gears
	 */
	public Bike(int licensePlate,String color,int gears) {
		super(licensePlate,color,WHEELS);
		this.gears = gears;
	}

	/**
	 * Gets the speed of the bike.
	 *
	 * @return the speed of the bike
	 */
	public static int getSpeed() {
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
	
	/**
	 * Return the Bike as String
	 * 
	 * @return "Speed : Gears : "
	 */
	public String toString() {
		return "Bike " + super.toString()+ " Speed :" + SPEED +" Gears :" + getGears();
	}
}
