package vehicles;

/**
 * The Class Car.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Car extends HasEngine {
	
	/** The Constant number of wheels. */
	private static final int WHEELS = 4;
	
	/** The Constant FUEL_CAPACITY. */
	private static final int FUEL_CAPACITY = 40;
	
	/** The Constant SPEED. */
	private static final int SPEED = 4;
	
	/** The Constant numberOfSeats. */
	private static final int numberOfSeats = 5;
	
	/**
	 * Instantiates a new car.
	 *
	 * @param color the color
	 * @param engineType the engine type
	 */
	public Car(String color,String engineType) {
		super(color,WHEELS,Car.numberOfSeats,engineType,FUEL_CAPACITY);
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
		return new Car(this.getColor(),this.getEngineType());
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#getVehicleName()
	 */
	public String getVehicleName() {
		return this.getEngineType()+" Car";
	}
}
