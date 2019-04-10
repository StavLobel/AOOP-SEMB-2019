package vehicles;

/**
 * The Class Carriage.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Carriage extends Vehicle {
	
	/** The animal who carries the Carriage. */
	private final String animal;
	
	/** The speed of the carriage. */
	private static final int SPEED = 1;
	
	/** The carriage's number of wheels. */
	private static final int WHEELS = 4;
	
	/**
	 * Instantiates a new carriage.
	 *
	 * @param licensePlate the license plate of the carriage
	 * @param color the color of the carriage
	 * @param animal the animal who will carry the carriage
	 */
	public Carriage(int licensePlate,String color,String animal) {
		super(licensePlate,color,WHEELS);
		this.animal = animal;
	}
	
	/**
	 * Gets the animal who carries the carriage.
	 *
	 * @return the animal
	 */
	public String getAnimal() {
		return this.animal;
	}
	
	/**
	 * Gets the speed of the carriage
	 *
	 * @return the speed
	 */
	public static int getSpeed() {
		return Carriage.SPEED;
	}
	
	/** Return the Carriage as String
	 * 
	 * @return "Speed : Animal : "
	 */
	public String toString() {
		return "Carriage " + super.toString() + " Speed :" + SPEED + " Animal :" + getAnimal();
	}
}
