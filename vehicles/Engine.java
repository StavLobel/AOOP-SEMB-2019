package vehicles;

import graphics.IClonable;

/**
 * The Class Engine.
 * 
 * @author Stav Lobel ID 308549898
 */
public abstract class Engine implements IClonable{
	
	/** The fuel consumption of the engine. */
	private final int fuelConsumption;
	
	/** The fuel capacity of the engine. */
	private final int fuelCapacity;
	
	
	/**
	 * Instantiates a new engine.
	 *
	 * @param fuelConsumption the fuel consumption of the engine
	 * @param fuelCapacity the fuel capacity of the engine
	 */
	public Engine(int fuelConsumption,int fuelCapacity) {
		this.fuelConsumption = fuelConsumption;
		this.fuelCapacity = fuelCapacity;
	}
	
	/**
	 * Instantiates a new engine.
	 *
	 * @param other the other
	 */
	protected Engine(Engine other) {
		this.fuelConsumption = other.getFuelConsumption();
		this.fuelCapacity = other.getFuelCapacity();
	}

	/**
	 * Gets the fuel consumption of the engine.
	 *
	 * @return the fuel consumption of the engine
	 */
	public int getFuelConsumption() {
		return fuelConsumption;
	}

	/**
	 * Gets the fuel capacity of the engine.
	 *
	 * @return the fuel capacity of the engine
	 */
	public int getFuelCapacity() {
		return fuelCapacity;
	}
	
	/**
	 * Return the Engine as String.
	 *
	 * @return "Fuel Consumption : Fuel Capacity :"
	 */
	public String toString() {
		return "Engine";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public abstract Object clone();
}
