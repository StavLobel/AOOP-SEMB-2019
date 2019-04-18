package vehicles;

/**
 * The Class BenzineEngine.
 * 
 * @author Stav Lobel ID 308549898
 */
public class BenzineEngine extends Engine {
	
	/** The Constant FUEL_CONSUMPTION. */
	private static final int FUEL_CONSUMPTION = 0;
	
	/**
	 * Instantiates a new benzine engine.
	 *
	 * @param fuelCapacity the fuel capacity of the engine
	 */
	public BenzineEngine(int fuelCapacity) {
		super(FUEL_CONSUMPTION,fuelCapacity);
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Engine#toString()
	 */
	public String toString() {
		return "Benzine " + super.toString();
	}
}
