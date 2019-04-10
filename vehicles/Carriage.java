package vehicles;

/**
 * The Class Carriage.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Carriage extends Vehicle {
	
	/** The animal who carries the Carriage. */
	private PackAnimal animal;
	
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
		this.animal = new PackAnimal(animal);
	}
	
	/**
	 * Gets the animal who carries the carriage.
	 *
	 * @return a clone of the animal
	 */
	public PackAnimal getAnimal() {
		return new PackAnimal(this.animal.getAnimalName());
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
		return "" + this.getLicensePlate();
	}
}
