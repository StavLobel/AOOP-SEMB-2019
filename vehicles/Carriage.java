package vehicles;

import refuelers.FuelTypeException;
import refuelers.IRefueler;
import refuelers.Refueler;
import vehicleMovingService.VehicleMover;

/**
 * The Class Carriage.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Carriage extends Vehicle implements IUsingFuel {
	
	/** The animal who carries the Carriage. */
	private PackAnimal animal;
	
	/** The speed of the carriage. */
	private static final int SPEED = 1;
	
	/** The carriage's number of wheels. */
	private static final int WHEELS = 4;
	
	/** The Constant numberOfSeats. */
	private static final int NUM_OF_SEATS = 2;
	
	/**
	 * Instantiates a new carriage.
	 */
	public Carriage(VehicleMover mover) {
		super(WHEELS,NUM_OF_SEATS,mover);
		this.animal = new PackAnimal("Pack Animal");
	}
	
	public Carriage(Location location,VehicleMover mover) {
		super(WHEELS,NUM_OF_SEATS,location,mover);
		this.animal = new PackAnimal("Pack Animal");
	}
	
	/**
	 * Instantiates a new carriage.
	 *
	 * @param other the other
	 */
	private Carriage(Carriage other) {
		super(other);
		this.animal = (PackAnimal) other.animal.clone();
	}
	
	/**
	 * Gets the animal who carries the carriage.
	 *
	 * @return a clone of the animal
	 */
	public PackAnimal getAnimal() {
		return (PackAnimal) animal.clone();
	}
	
	/**
	 * Gets the speed of the carriage.
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return Carriage.SPEED;
	}
	
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#toString()
	 */
	public String toString() {
		return super.toString();
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#clone()
	 */
	public Object clone() {
		synchronized (this) {
			return new Carriage(this);
		}
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#getVehicleName()
	 */
	public String getVehicleName() {
		return "Carriage";
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#getCurrentFuel()
	 */
	public synchronized int getCurrentFuel() {
		return this.animal.getCurrentEnergy();
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#useFuel(int)
	 */
	public synchronized boolean useFuel(int amount) {
		return this.animal.useFuel(amount);
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getFuelConsumption()
	 */
	public int getFuelConsumption() {
		return this.animal.getEnergyConsumption();
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getEngineType()
	 */
	public String getEngineType() {
		return "Pack Animal";
	}
	
	/* (non-Javadoc)
	 * @see graphics.IUsingFuel#canMove(vehicles.Point)
	 */
	public boolean canMove(Point toGo) {
		return getLocation().getLocationPoint().manhattanDistance(toGo)*getFuelConsumption() <= this.getCurrentFuel();
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IBeenRefueled#setCurrentFuel(int)
	 */
	public synchronized boolean setCurrentFuel(int amount) {
		return animal.setCurrentFuel(amount);
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IBeenRefueled#letRefuel(DesignPatterns.IRefueler)
	 */
	public synchronized void letRefuel(Refueler refueler) throws FuelTypeException{
		refueler.refuel(this);
	}
	
	public int getMaxCapacity() {
		return this.animal.getMaxCapacity();
	}
	
	public boolean drive(Point toGo) {
		this.useFuel(this.getLocation().getLocationPoint().manhattanDistance(toGo)*this.getFuelConsumption());
		return super.drive(toGo);
	}
	
	public int getDurability() {
		return 2;
	}
}
