package vehicles;

/**
 * The Class HasEngine.
 * 
 * @author Stav Lobel ID 308549898
 */
public abstract class HasEngine extends Vehicle {
	
	/** The engine. */
	private final Engine engine;
	
	/** The current fuel. */
	private int currentFuel;
	
	/**
	 * Instantiates a new checks for engine.
	 *
	 * @param color the color
	 * @param wheels the number of wheels
	 * @param numberOfSeats the number of seats
	 * @param engineType the engine type
	 * @param fuelCapacity the fuel capacity
	 */
	public HasEngine(String color,int wheels,int numberOfSeats,String engineType,int fuelCapacity) {
		super(color,wheels,numberOfSeats);
		if (engineType == "SolarEngine")
			this.engine = new SolarEngine(fuelCapacity);
		else if(engineType == "BenzineEngine")
			this.engine = new BenzineEngine(fuelCapacity);
		else
			this.engine = null;
		this.currentFuel = this.engine.getFuelCapacity();
	}

	/**
	 * Gets the engine.
	 *
	 * @return the engine
	 */
	public Engine getEngine() {
		return engine;
	}

	/**
	 * Gets the current fuel.
	 *
	 * @return the current fuel
	 */
	public int getCurrentFuel() {
		return currentFuel;
	}
	
	/**
	 * Gets the engine type.
	 *
	 * @return the engine type as String
	 */
	public String getEngineType() {
		return ""+ this.getEngine();
	}
	
	/**
	 * Refuel.
	 *
	 * @return true, if successful
	 */
	public boolean refuel() {
		if (this.currentFuel == this.engine.getFuelCapacity())
			return false;
		this.setFuelConsumption(this.engine.getFuelCapacity()-this.getCurrentFuel());
		this.currentFuel = this.engine.getFuelCapacity();
		return true;
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#toString()
	 */
	public String toString() {
		return super.toString();
	}
	
	public boolean useFuel(int amount) {
		this.currentFuel -= amount;
		return true;
	}
}
