package vehicles;

import DesignPatterns.IRefueler;
import graphics.IAnimal;
import graphics.IClonable;
import graphics.IUsingFuel;


// TODO: Auto-generated Javadoc
/**
 * The Class PackAnimal.
 * 
 * @author Stav Lobel
 */
public class PackAnimal implements IUsingFuel, IClonable,IAnimal {
	
	/** The name of the animal. */
	private final String name;
	
	/** The Constant MAX_ENERGY of all animals. */
	private static final int MAX_ENERGY = 1000;
	
	/** The current energy of the animal. */
	private int currentEnergy = MAX_ENERGY;
	
	/** The Constant ENERGY_CONSUMPTION of all animals. */
	private static final int ENERGY_CONSUMPTION = 20;
	
	/**
	 * Instantiates a new pack animal.
	 *
	 * @param name the name of the animal
	 */
	public PackAnimal(String name) {
		this.name = name;
	}
	
	/**
	 * Instantiates a new pack animal.
	 *
	 * @param other the other
	 */
	private PackAnimal(PackAnimal other) {
		this.name = other.getAnimalName();
		this.currentEnergy = other.getCurrentEnergy();
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
	 * @see graphics.IAnimal#eat()
	 */
	public boolean eat(int amount) {
		synchronized (this) {
			if (currentEnergy == MAX_ENERGY || currentEnergy + amount > MAX_ENERGY)
				return false;
			currentEnergy = currentEnergy + amount;
			return true;
		}
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
	public boolean useFuel(int amount) {
		this.currentEnergy -= amount;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IBeenRefueled#letRefuel(DesignPatterns.IRefueler)
	 */
	public void letRefuel(IRefueler refueler) {
		refueler.refuel(this);
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getCurrentFuel()
	 */
	public int getCurrentFuel() {
		return getCurrentEnergy();
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getEngineType()
	 */
	public String getEngineType() {
		return getAnimalName();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		return new PackAnimal(this);
	}
	
	/* (non-Javadoc)
	 * @see graphics.IUsingFuel#canMove(vehicles.Point)
	 */
	public boolean canMove(Point toGo) {
		return currentEnergy == 0;
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IBeenRefueled#setCurrentFuel(DesignPatterns.IRefueler, int)
	 */
	public boolean setCurrentFuel(int amount) {
		return eat(amount);
	}
}
