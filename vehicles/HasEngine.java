package vehicles;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class HasEngine.
 * 
 * @author Stav Lobel ID 308549898
 */
public abstract class HasEngine extends Vehicle {
	
	/** The engine. */
	private Engine engine = null;
	
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
		if (engineType.equals("SolarEngine"))
			this.engine = new SolarEngine(fuelCapacity);
		else if(engineType.equals("BenzineEngine"))
			this.engine = new BenzineEngine(fuelCapacity);
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
	 * @see vehicles.Vehicle#loadImages()
	 */
	public void loadImages() {
		String name = this.getColor().toLowerCase()+"Car";
		String nameNorth = name+"North.png";
		String nameSouth = name+"South.png";
		String nameEast = name+"East.png";
		String nameWest = name+"West.png";
		
		try {
			this.img1 = ImageIO.read(new File("PNGs//"+nameNorth));
		}
		catch (IOException e) {
			System.out.println("Cannot load image");
		}
		
		try {
			this.img2 = ImageIO.read(new File("PNGs//"+nameSouth));
		}
		catch (IOException e) {
			System.out.println("Cannot load image");
		}
		
		try {
			this.img3 = ImageIO.read(new File("PNGs//"+nameEast));
		}
		catch (IOException e) {
			System.out.println("Cannot load image");
		}
		
		try {
			this.img4 = ImageIO.read(new File("PNGs//"+nameWest));
		}
		catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}
}
