package vehicles;

/**
 * The Class Car.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Car extends HasEngine {
	
	/** The number of passengers. */
	private final int numberOfPassengers;
	
	/** The Constant number of wheels. */
	private static final int WHEELS = 4;
	
	/** The Constant FUEL_CAPACITY. */
	private static final int FUEL_CAPACITY = 40;
	
	/** The Constant SPEED. */
	private static final int SPEED = 4;
	
	/**
	 * Instantiates a new car.
	 *
	 * @param licensePlate the license plate
	 * @param color the color
	 * @param minAge the minimum age to drive the vehicle
	 * @param engineType the engine type
	 * @param numberOfPassengers the number of passengers
	 */
	public Car(int licensePlate,String color,int minAge,String engineType,int numberOfPassengers) {
		super(licensePlate,color,WHEELS,minAge,engineType,FUEL_CAPACITY);
		this.numberOfPassengers = numberOfPassengers;
	}

	/**
	 * Gets the number of passengers.
	 *
	 * @return the number of passengers
	 */
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#getSpeed()
	 */
	public int getSpeed() {
		return SPEED;
	}
	
	/* (non-Javadoc)
	 * @see vehicles.HasEngine#toString()
	 */
	public String toString() {
		return super.toString();
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#clone()
	 */
	public Object clone() {
		return new Car(this.getLicensePlate(),this.getColor(),this.getMinAge(),this.getEngineType(),this.numberOfPassengers);
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#getVehicleName()
	 */
	public String getVehicleName() {
		return "Car";
	}
}
