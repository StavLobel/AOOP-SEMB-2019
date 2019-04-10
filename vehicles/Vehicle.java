package vehicles;
import java.util.ArrayList;


/**
 * The Class Vehicle.
 * 
 * @author Stav Lobel ID 308549898
 */
public abstract class Vehicle {
	
	/** The license plate of the vehicle. */
	private final int licensePlate;
	
	/** The Constant LICENSE_RANGE. */
	private static final int[] LICENSE_RANGE = {1000,1000000};
	
	/** The licenses list. */
	private static ArrayList<Integer> LICENSES_LIST = new ArrayList<Integer>();
	
	/** The color of the vehicle. */
	private final String color;
	
	/** The Constant COLORS array. */
	private static final String[] COLORS = {"Red","Green","White","Silver"};
	
	/** The number of wheels of the vehicle. */
	private final int numberOfWheels;
	
	/** The location of the vehicle. */
	private Location location;
	
	/** The mileage of the vehicle. */
	private int mileage;
	
	/** The lights status of the vehicle. */
	private boolean lights;
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param licensePlate the license plate of the vehicle
	 * @param color the color of the vehicle
	 * @param numberOfWheels the number of wheels of the vehicle
	 */
	public Vehicle(int licensePlate,String color,int numberOfWheels) {
		this.licensePlate = licensePlate;
		if (!(LICENSES_LIST.contains(licensePlate)))
			LICENSES_LIST.add(licensePlate);
		this.color = color;
		this.numberOfWheels = numberOfWheels;
		this.location = new Location();
		this.lights = false;
		this.mileage = 0;
	}
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param licensePlate the license plate of the vehicle
	 * @param color the color of the vehicle
	 * @param numberOfWheels the number of wheels of the vehicle
	 * @param p the current point of the vehicle
	 */
	public Vehicle(int licensePlate,String color,int numberOfWheels,Point p) {
		this(licensePlate,color,numberOfWheels);
		this.location = new Location(p);
	}
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param licensePlate the license plate of the vehicle
	 * @param color the color of the vehicle
	 * @param numberOfWheels the number of wheels of the vehicle
	 * @param location the location of the vehicle
	 */
	public Vehicle(int licensePlate,String color,int numberOfWheels,Location location) {
		this(licensePlate,color,numberOfWheels);
		this.location = new Location(location);
	}
	
	/**
	 * Gets the location.
	 *
	 * @return a clone of the location of the vehicle
	 */
	public Location getLocation() {
		return this.location.replicate();
	}

	/**
	 * Sets the location.
	 *
	 * @param p the new point location to set
	 * @return true, if successful ,false if it's the same location
	 */
	public boolean setLocation(Point p) {
		return this.location.setLocation(p);
	}
	
	/**
	 * Sets the location.
	 *
	 * @param other the new Location to set
	 * @return true, if successful ,false if it's the same location
	 */
	public boolean setLocation(Location other) {
		return this.location.setLocation(other);
	}

	/**
	 * Checks if is lights on.
	 *
	 * @return true, if the lights on ,false if they are off
	 */
	public boolean isLights() {
		return lights;
	}

	/**
	 * Sets the lights.
	 *
	 * @param lights true,if set them on,false if turn them off
	 * @return true, if successful ,false if there was no change
	 */
	public boolean setLights(boolean lights) {
		if (this.lights == lights)
			return false;
		this.lights = lights;
		return true;
		
	}

	/**
	 * Gets the license plate.
	 *
	 * @return the license plate of the vehicle
	 */
	public int getLicensePlate() {
		return licensePlate;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color of the vehicle
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Gets the number of wheels.
	 *
	 * @return the number of wheels of the vehicle
	 */
	public int getNumberOfWheels() {
		return numberOfWheels;
	}



	/**
	 * Gets the mileage.
	 *
	 * @return the mileage of the vehicle
	 */
	public int getMileage() {
		return mileage;
	}
	
	/**
	 * Gets the colors.
	 *
	 * @return the color options
	 */
	public static String[] getColors() {
		return COLORS;
	}
	
	/**
	 * Gets the license range.
	 *
	 * @return the license range
	 */
	public static int[] getlicenseRange() {
		return LICENSE_RANGE;
	}
	
	/**
	 * Gets the license list.
	 *
	 * @return the licenses list
	 */
	public static int[] getLicensesList() {
		int[] licenseList = new int[LICENSES_LIST.size()];
		for (int i=0 ;i < LICENSES_LIST.size();++i)
			licenseList[i] = LICENSES_LIST.get(i);
		return licenseList;
	}

	/**
	 * Drive.
	 *
	 * @param toGo the point to drive to
	 * @return true, if successful ,false if the vehicle stay in it's location
	 */
	public boolean drive(Point toGo) {
		if (toGo.equals(this.location.getLocationPoint()))
			return false;
		this.mileage += this.location.getLocationPoint().distanceManhattan(toGo);
		this.location.setLocation(toGo);
		return true;
	}
	
	/**
	 * Equals.
	 * 
	 * @param other the other vehicle
	 * @return true, if there's license plate match
	 */
	public boolean equals(Vehicle other) {
		return getLicensePlate() == other.getLicensePlate();
	}
	
	/**
	 * Return the vehicle as String
	 * 
	 * @return "License Plate : Color : Number Of Wheels : Location : Mileage : Lights : "
	 */
	public String toString() {
		return "License Plate :"+ getLicensePlate() + " Color :"+ getColor() + " Number Of Wheels :" + getNumberOfWheels() + " Location :"+ getLocation() + " Mileage :"+ getMileage() + " Lights :" + isLights();
	}
}
