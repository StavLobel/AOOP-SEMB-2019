package vehicles;

import graphics.IAnimal;
import graphics.IClonable;

// TODO: Auto-generated Javadoc
/**
 * The Class PackAnimal.
 * 
 * @author Stav Lobel
 */
public class PackAnimal implements IAnimal, IClonable {
	
	/** The name of the animal. */
	private final String name;
	
	/** The Constant MAX_ENERGY of all animals. */
	private static final int MAX_ENERGY = 1000;
	
	/** The current energy of the animal. */
	private int currentEnergy = 0;
	
	/** The Constant ENERGY_CONSUMPTION of all animals. */
	private static final int ENERGY_CONSUMPTION = 20;
	
	/**
	 * Instantiates a new pack animal.
	 *
	 * @param name the name of the animal
	 */
	public PackAnimal(String name) {
		this.name = name;
		this.eat();
	}

	/**
	 * Gets the name.
	 *
	 * @return the name of the animal
	 */
	public String getAnimalName() {
		return this.name;
	}

	/**
	 * Gets the max energy.
	 *
	 * @return the max energy of the animal
	 */
	public int getMaxEnergy() {
		return MAX_ENERGY;
	}

	/**
	 * Gets the current energy.
	 *
	 * @return the current energy of the animal
	 */
	public int getCurrentEnergy() {
		return currentEnergy;
	}

	/**
	 * Gets the energy consumption.
	 *
	 * @return the energy consumption of the animal
	 */
	public int getEnergyConsumption() {
		return ENERGY_CONSUMPTION;
	}
	
	/* (non-Javadoc)
	 * @see graphics.IClonable#clone()
	 */
	public Object clone() {
		return new PackAnimal(this.name);
	}
	
	/* (non-Javadoc)
	 * @see graphics.IAnimal#eat()
	 */
	public boolean eat() {
		if (this.getCurrentEnergy() == this.getMaxEnergy())
			return false;
		this.currentEnergy = this.getMaxEnergy();
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.getAnimalName();
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#move(vehicles.Point)
	 */
	public boolean move(Point p) {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getFuelConsumption()
	 */
	public int getFuelConsumption() {
		return this.getEnergyConsumption();
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getVehicleName()
	 */
	public String getVehicleName() {
		return "Pack Animal";
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getSpeed()
	 */
	public int getSpeed() {
		return 0;
	}
	
	/**
	 * Reduce energy.
	 *
	 * @param amount the amount of energy to reduce
	 * @return true, if successful
	 */
	public boolean reduceEnergy(int amount) {
		if (this.getCurrentEnergy() < amount || amount < 0)
			return false;
		this.currentEnergy -= amount;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#refuel()
	 */
	public boolean refuel() {
		return this.eat();
	}
}
