package vehicles;

/**
 * The Class Carriage.
 * 
 * @author Stav Lobel ID 308549898
 */
public class Carriage extends Vehicle {
	
	/** The animal who carries the Carriage. */
	private PackAnimal animal;
	
	/** The speed of the carriage. */
	private static final int SPEED = 1;
	
	/** The carriage's number of wheels. */
	private static final int WHEELS = 4;
	
	/** The Constant numberOfSeats. */
	private static final int numberOfSeats = 2;
	
	/**
	 * Instantiates a new carriage.
	 *
	 * @param color the color of the carriage
	 */
	public Carriage(String color) {
		super(color,WHEELS,Carriage.numberOfSeats);
		this.animal = new PackAnimal("Pack Animal");
	}
	
	/**
	 * Gets the animal who carries the carriage.
	 *
	 * @return a clone of the animal
	 */
	public PackAnimal getAnimal() {
		return new PackAnimal(this.animal.getAnimalName());
	}
	
	/**
	 * Gets the speed of the carriage
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
		return new Carriage(this.getColor());
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#getVehicleName()
	 */
	public String getVehicleName() {
		return "Carriage";
	}
	
	/* (non-Javadoc)
	 * @see vehicles.Vehicle#refuel()
	 */
	public boolean refuel() {
		this.setFuelConsumption(this.animal.getMaxEnergy()-this.animal.getCurrentEnergy());
		return this.animal.eat();
	}
	
	public int getCurrentFuel() {
		return this.getAnimal().getCurrentEnergy();
	}
	
	public boolean useFuel(int amount) {
		return this.animal.useFuel(amount);
	}
	
	public int getFuelConsumption() {
		return this.animal.getEnergyConsumption();
	}
	
}
