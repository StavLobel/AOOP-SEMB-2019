package vehicles;

/**
 * The Class BenzineEngine.
 * 
 * @author Stav Lobel ID 308549898
 */
public class BenzineEngine extends Engine {
	
	/** The Constant FUEL_CONSUMPTION. */
	private static final int FUEL_CONSUMPTION = 2;
	
	/**
	 * Instantiates a new benzine engine.
	 *
	 * @param fuelCapacity the fuel capacity of the engine
	 */
	public BenzineEngine(int fuelCapacity) {
		super(FUEL_CONSUMPTION,fuelCapacity);
	}
	
	/**
	 * Instantiates a new benzine engine.
	 *
	 * @param other the other
	 */
	private BenzineEngine(BenzineEngine other) {
		super(other);
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Engine#toString()
	 */
	public String toString() {
		return "Benzine " + super.toString();
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Engine#clone()
	 */
	public Object clone() {
		return new BenzineEngine(this);
	}
}
