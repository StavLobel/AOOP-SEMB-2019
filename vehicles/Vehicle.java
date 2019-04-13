package vehicles;
import java.util.ArrayList;

import graphics.IClonable;
import graphics.IMoveable;
import java.awt.Color;
import graphics.CityPanel;
import java.awt.image.BufferedImage;

/**
 * The Class Vehicle.
 * 
 * @author Stav Lobel ID 308549898
 */
public abstract class Vehicle implements IMoveable,IClonable{
	
	/** The license plate of the vehicle. */
	private final int id;
	
	/** The first id. */
	private static int NEXT_ID = 1000;
	
	/** The color of the vehicle. */
	private final String color;
	
	/** The Color object of the vehicle.*/
	private final Color col;
	
	/** The Constant COLORS array. */
	private static final String[] COLORS = {"Red","Green","White","Silver"};
	
	/** The number of wheels of the vehicle. */
	private final int wheels;
	
	/** The loc of the vehicle. */
	private Location loc;
	
	/** The mileage of the vehicle. */
	private int mileage = 0;
	
	/** The lights status of the vehicle. */
	private boolean lights = false;
	
	/** The size of the vehicle.*/
	private int size= 0;
	
	/** The total fuel that have been consumed.*/
	private int fuelConsumption = 0;
	
	/** The number of seats. */
	private final int numberOfSeats;
	
	/** The panel.*/
	private CityPanel pan;
	
	/** The min age. */
	private static int minAge = 18;
	
	/** The vehicle images.*/
	private BufferedImage img1, img2, img3, img4;
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param color the color of the vehicle
	 * @param wheels the number of wheels of the vehicle
	 */
	public Vehicle(String color,int wheels,int numberOfSeats) {
		this.id = Vehicle.NEXT_ID;
		Vehicle.NEXT_ID++;
		this.color = color;
		this.col = getColorObject(color);
		this.wheels = wheels;
		this.loc = new Location();
		this.numberOfSeats = numberOfSeats;
	}
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param color the color of the vehicle
	 * @param wheels the number of wheels of the vehicle
	 * @param p the current point of the vehicle
	 */
	public Vehicle(String color,int wheels,int numberOfSeats,Point p) {
		this(color,wheels,numberOfSeats);
		this.loc = new Location(p);
	}
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param color the color of the vehicle
	 * @param wheels the number of wheels of the vehicle
	 * @param loc the loc of the vehicle
	 */
	public Vehicle(int id,String color,int wheels,int numberOfSeats,Location loc) {
		this(color,wheels,numberOfSeats);
		this.loc = new Location(loc);
	}
	
	/**
	 * Gets the loc.
	 *
	 * @return a clone of the loc of the vehicle
	 */
	public Location getLocation() {
		return this.loc.replicate();
	}

	/**
	 * Sets the loc.
	 *
	 * @param p the new point loc to set
	 * @return true, if successful ,false if it's the same loc
	 */
	public boolean setLocation(Point p) {
		return this.loc.setLocation(p);
	}
	
	/**
	 * Sets the loc.
	 *
	 * @param other the new Location to set
	 * @return true, if successful ,false if it's the same loc
	 */
	public boolean setLocation(Location other) {
		return this.loc.setLocation(other);
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
		return id;
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
		return wheels;
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
	public static int getNextId() {
		return Vehicle.NEXT_ID;
	}

	/**
	 * Drive.
	 *
	 * @param toGo the point to drive to
	 * @return true, if successful ,false if the vehicle stay in it's loc
	 */
	public boolean drive(Point toGo) {
		if (toGo.equals(this.loc.getLocationPoint()))
			return false;
		this.mileage += this.loc.getLocationPoint().distanceManhattan(toGo);
		this.loc.setLocation(toGo);
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
	 * Return the vehicle as String.
	 *
	 * @return "License Plate : Color : Number Of Wheels : Location : Mileage : Lights : "
	 */
	public String toString() {
		return ""+ this.getLicensePlate();
	}
	
	/**
	 * Gets the number of seats.
	 *
	 * @return the number of seats
	 */
	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}
	
	/**
	 * Gets the min age.
	 *
	 * @return the min age
	 */
	public int getMinAge() {
		return Vehicle.minAge;
	}
	
	//*****************HW2*******************
	
	
	/**
	 * Gets the color object.
	 *
	 * @param color the color
	 * @return the a Color object
	 */
	private static Color getColorObject(String color) {
		if (color.equals("Red"))
			return new Color(255,0,0);
		else if (color.equals("Green"))
			return new Color(0,128,0);
		else if (color.equals("Silver"))
			return new Color(192,192,192);
		else
			return new Color(255,255,255);
	}
	
	/**
	 * Gets the pan.
	 *
	 * @return the citypanel
	 */
	public CityPanel getPan() {
		return pan;
	}

	/**
	 * Sets the pan.
	 *
	 * @param pan the new CityPanel
	 * @return true, if successful
	 */
	public boolean setPan(CityPanel pan) {
		this.pan = pan;
		return true;
	}

	/**
	 * Gets the img 1.
	 *
	 * @return the img 1
	 */
	public BufferedImage getImg1() {
		return img1;
	}

	/**
	 * Sets the img 1.
	 *
	 * @param img1 the new img 1
	 * @return true, if successful
	 */
	public boolean setImg1(BufferedImage img1) {
		this.img1 = img1;
		return true;
	}

	/**
	 * Gets the img 2.
	 *
	 * @return the img 2
	 */
	public BufferedImage getImg2() {
		return img2;
	}

	/**
	 * Sets the img 2.
	 *
	 * @param img2 the new img 2
	 * @return true, if successful
	 */
	public boolean setImg2(BufferedImage img2) {
		this.img2 = img2;
		return true;
	}

	/**
	 * Gets the img 3.
	 *
	 * @return the img 3
	 */
	public BufferedImage getImg3() {
		return img3;
	}

	/**
	 * Sets the img 3.
	 *
	 * @param img3 the new img 3
	 * @return true, if successful
	 */
	public boolean setImg3(BufferedImage img3) {
		this.img3 = img3;
		return true;
	}

	/**
	 * Gets the img 4.
	 *
	 * @return the img 4
	 */
	public BufferedImage getImg4() {
		return img4;
	}

	/**
	 * Sets the img 4.
	 *
	 * @param img4 the new img 4
	 * @return true, if successful
	 */
	public boolean setImg4(BufferedImage img4) {
		this.img4 = img4;
		return true;
	}

	/**
	 * Gets the color object.
	 *
	 * @return the Color object
	 */
	public Color getColorObject() {
		return col;
	}

	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getFuelConsumption()
	 */
	public int getFuelConsumption() {
		return fuelConsumption;
	}
	
	/**
	 * Sets the fuel consumption.
	 *
	 * @param amount the amount of fuel that used.
	 * @return true, if successful. false ,is amount is negative number.
	 */
	public boolean setFuelConsumption(int amount) {
		if (amount < 0)
			return false;
		this.fuelConsumption += amount;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see graphics.IClonable#clone()
	 */
	public abstract Object clone();
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getVehicleName()
	 */
	public abstract String getVehicleName();
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#getSpeed()
	 */
	public abstract int getSpeed();
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#move(vehicles.Point)
	 */
	public boolean move(Point p) {
		return this.drive(p);
	}
	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#refuel()
	 */
	public abstract boolean refuel();
}
