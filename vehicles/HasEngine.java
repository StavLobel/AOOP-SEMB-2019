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
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#move(vehicles.Point)
	 */
	public boolean move(Point p) {
		return this.drive(p);
	}
}
