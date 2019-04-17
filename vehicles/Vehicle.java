package vehicles;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import graphics.IClonable;
import graphics.IDrawable;
import graphics.IMoveable;
import java.awt.Color;
import java.awt.Graphics;

import graphics.CityPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The Class Vehicle.
 * 
 * @author Stav Lobel ID 308549898
 */
public abstract class Vehicle implements IMoveable,IClonable,IDrawable{
	
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
	private int size= 65;
	
	/** The total fuel that have been consumed.*/
	private int fuelConsumption = 0;
	
	/** The number of seats. */
	private final int numberOfSeats;
	
	/** The panel.*/
	private static CityPanel pan;
	
	/** The min age. */
	private static int minAge = 18;
	
	/** The vehicle images.*/
	protected BufferedImage img1, img2, img3, img4;
	
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
		loadImages();
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
	public boolean move(Point p){
	        try { Thread.sleep(100); }
	        catch (InterruptedException e) { e.printStackTrace(); }
	        this.drive(p);
	    pan.repaint();
	    return true;
	}



	
	/* (non-Javadoc)
	 * @see graphics.IMoveable#refuel()
	 */
	public abstract boolean refuel();
	
	public void drawObject(Graphics g) {
		g.setColor(col);
	    if(loc.getOrientation().equals("North")) //drives to north side
	        g.drawImage(img1, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), size, size*2, pan);
	    else if (loc.getOrientation().equals("South"))//drives to the south side
	        g.drawImage(img2, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), size, size*2, pan);
	    else if(loc.getOrientation().equals("East")) //drives to the east side
	        g.drawImage(img3, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), size, size*2, pan);
	    else if(loc.getOrientation().equals("West")) //drives to the west side
	        g.drawImage(img4, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), size, size*2, pan);
	}

	public void loadImages() {
		String name = this.getColor().toLowerCase()+this.getVehicleName().replaceAll(" ","");;
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
	
	public Point nextLocation() {
		int x = this.loc.getLocationPoint().getX();
		int y = this.loc.getLocationPoint().getY();
		if (this.loc.getOrientation().equals("North")) {
			y += this.getSpeed();
			if (y > 600) {
				x -= y-600;
				y = 600;
			}
		}
		else if(this.loc.getOrientation().equals("South")) {
			y -= this.getSpeed();
			if (y < 0) {
				x -= y;
				y = 0;
			}
		}
		else if(this.loc.getOrientation().equals("East")) {
			x += this.getSpeed();
			if(x > 800) {
				y += 800-x;
				x = 800;
			}
		}
		else if(this.loc.getOrientation().equals("West")) {
			x -= this.getSpeed();
			if (x < 0) {
				y -= x;
				x = 0;
			}
		}
		return new Point(x,y);
	}
	
	public static boolean setPanel(CityPanel panel) {
		Vehicle.pan = panel;
		return true;
	}
}
