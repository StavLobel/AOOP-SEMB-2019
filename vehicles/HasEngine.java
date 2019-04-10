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
	
	/** The minimum age to drive the vehicle. */
	private final int minAge;
	
	/**
	 * Instantiates a new checks for engine.
	 *
	 * @param licensePlate the license plate
	 * @param color the color
	 * @param wheels the number of wheels
	 * @param minAge the minimum age do drive the vehicle
	 * @param engineType the engine type
	 * @param fuelCapacity the fuel capacity
	 */
	public HasEngine(int licensePlate,String color,int wheels,int minAge,String engineType,int fuelCapacity) {
		super(licensePlate,color,wheels);
		if (engineType == "SolarEngine")
			this.engine = new SolarEngine(fuelCapacity);
		else if(engineType == "BenzineEngine")
			this.engine = new BenzineEngine(fuelCapacity);
		else
			this.engine = null;
		this.currentFuel = this.engine.getFuelCapacity();
		this.minAge = minAge;
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
	 * Gets the min age.
	 *
	 * @return the min age
	 */
	public int getMinAge() {
		return minAge;
	}
	
	/**
	 * Update fuel.
	 *
	 * @param distance the distance been driven
	 * @return true
	 */
	public boolean UpdateFuel(int distance) {
		this.currentFuel -= distance*this.engine.getFuelConsumption();
		return true;
	}
	
	/** 
	 * Drive.
	 * use the drive from class Vehicle and also update the fuel
	 * @return true,if the drive went successfully ,false if not
	 * @see vehicles.Vehicle#drive(vehicles.Point)
	 */
	public boolean drive(Point toGo) {
		if (this.getLocation().getLocationPoint().distanceManhattan(toGo)*this.engine.getFuelConsumption() > this.currentFuel)
			return false;
		this.UpdateFuel(this.getLocation().getLocationPoint().distanceManhattan(toGo));
		return super.drive(toGo);
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
		this.currentFuel = this.engine.getFuelCapacity();
		return true;
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#toString()
	 */
	public String toString() {
		return super.toString()+" Engine Type :" + this.getEngine() + " Current Fuel :" + this.getCurrentFuel() + " Minimum Age to Drive :"+ this.getMinAge();
	}
}
