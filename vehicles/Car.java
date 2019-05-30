package vehicles;

import refuelers.FuelTypeException;
import refuelers.IRefueler;
import vehicleMovingBridge.VehicleMover;

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
	private static final int NUM_OF_SEATS = 5;
	
	/**
	 * Instantiates a new car.
	 *
	 * @param engine the engine
	 */
	public Car(Engine engine,VehicleMover mover) {
		super(WHEELS,NUM_OF_SEATS,engine,mover);
	}
	
	public Car(Engine engine,Location location,VehicleMover mover) {
		super(WHEELS,NUM_OF_SEATS,engine,location,mover);
	}
	
	/**
	 * Instantiates a new car.
	 *
	 * @param other the other
	 */
	private Car(Car other) {
		super(other);
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
		return new Car(this);
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#getVehicleName()
	 */
	public String getVehicleName() {
		return this.getEngineType()+" Car";
	}
	
	/* (non-Javadoc)
	 * @see vehicles.HasEngine#setCurrentFuel(int)
	 */
	public boolean setCurrentFuel(int amount) {
		if (this.getCurrentFuel() + amount > FUEL_CAPACITY)
			return false;
		return super.setCurrentFuel(amount);
	}
	
	public static int getFuelCapacity() {
		return FUEL_CAPACITY;
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IBeenRefueled#letRefuel(DesignPatterns.IRefueler)
	 */
	public void letRefuel(IRefueler refueler) throws FuelTypeException {
		refueler.refuel(this);
	}
}
