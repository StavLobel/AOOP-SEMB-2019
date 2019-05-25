package vehicles;

import graphics.IUsingFuel;

/**
 * The Class HasEngine.
 * 
 * @author Stav Lobel ID 308549898
 */
public abstract class HasEngine extends Vehicle implements IUsingFuel {
	
	/** The engine. */
	private final Engine engine;
	
	/** The current fuel. */
	private int currentFuel;
	
	/**
	 * Instantiates a new HasEngine.
	 *
	 * @param wheels the number of wheels
	 * @param numberOfSeats the number of seats
	 * @param engine the engine
	 */
	public HasEngine(int wheels,int numberOfSeats,Engine engine) {
		super(wheels,numberOfSeats);
		this.engine = engine;
		this.currentFuel = this.engine.getFuelCapacity();
	}
	
	/**
	 * Instantiates a new checks for engine.
	 *
	 * @param other the other
	 */
	protected HasEngine(HasEngine other) {
		super(other);
		this.engine = (Engine) other.getEngine().clone();
		this.currentFuel = other.getCurrentFuel();
	}

	/**
	 * Gets the engine.
	 *
	 * @return the engine
	 */
	public Engine getEngine() {
		return (Engine) engine.clone();
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
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#toString()
	 */
	public String toString() {
		return super.toString();
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#useFuel(int)
	 */
	public boolean useFuel(int amount) {
		this.currentFuel -= amount;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getFuelConsumption()
	 */
	public int getFuelConsumption() {
		return this.engine.getFuelConsumption();
	}
	
	/* (non-Javadoc)
	 * @see graphics.IUsingFuel#canMove(vehicles.Point)
	 */
	public boolean canMove(Point toGo) {
		return this.getLocation().getLocationPoint().manhattanDistance(toGo)*getFuelConsumption() > this.getCurrentFuel();
	}
}
