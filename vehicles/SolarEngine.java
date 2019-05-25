package vehicles;

// TODO: Auto-generated Javadoc
/**
 * The Class SolarEngine.
 * 
 * @author Stav Lobel ID 308549898
 */
public class SolarEngine extends Engine {
	
	/** The Constant FUEL_CONSUMPTION. */
	private static final int FUEL_CONSUMPTION = 1;
	
	/**
	 * Instantiates a new solar engine.
	 *
	 * @param fuelCapacity the fuel capacity of the engine
	 */
	public SolarEngine(int fuelCapacity) {
		super(FUEL_CONSUMPTION,fuelCapacity);
	}
	
	/**
	 * Instantiates a new solar engine.
	 *
	 * @param other the other
	 */
	private SolarEngine(SolarEngine other) {
		super(other);
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Engine#toString()
	 */
	public String toString() {
		return "Solar "+super.toString();
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Engine#clone()
	 */
	public Object clone() {
		return new SolarEngine(this);
	}
}
