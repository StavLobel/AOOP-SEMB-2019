package DesignPatterns;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import graphics.CityPanel;
import vehicles.Location;
import vehicles.Point;
import vehicles.Vehicle;

public class VehicleDecorator {
	
	/** The color of the vehicle. */
	private final String color;
	
	/** The Color object of the vehicle.*/
	private final Color colorObject;
	
	/** The Constant COLORS array. */
	private static final String[] COLORS = {"red","green","White","Silver"};
	
	/** The lights status of the vehicle. */
	private boolean lights = false;
	
	/** The size of the vehicle.*/
	private static final int size= 65;
	
	/** The panel.*/
	protected static CityPanel pan;
	
	/** The vehicle images.*/
	protected BufferedImage img1, img2, img3, img4;
	
	/** The Constant vehicleWidthHorizon. */
	protected static final int vehicleWidthHorizon = size*2;
	
	/** The Constant vehicleHeightHorizon. */
	protected static final int vehicleHeightHorizon = size;
	
	/** The Constant vehicleWidthVertical. */
	protected static final int vehicleWidthVertical = size;
	
	/** The Constant vehicleHeightVertical. */
	protected static final int vehicleHeightVertical = size*2;
	
	/** The panel width. */
	protected static int panelWidth;
	
	/** The panel height. */
	protected static int panelHeight;
	
	/** The panel middle. */
	protected static int panelMiddle;
	
	/** The table of information about the vehicle. */
	private Object[] table = new Object[9];
	
	loadImages();
	
	
	/**
	 * Builds the table.
	 *
	 * @return true, if successful
	 */
	protected boolean buildTable() {
		table[0] = this.getVehicleName();
		table[1] = this.getLicensePlate();
		table[2] = this.getColor();
		table[3] = this.getNumberOfWheels();
		table[4] = this.getSpeed();
		table[5] = this.getCurrentFuel();
		table[6] = this.getMileage();
		table[7] = this.getVehicleFuelConsumption();
		table[8] = this.isLights();
		return true;
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
	 * Gets the color.
	 *
	 * @return the color of the vehicle
	 */
	public String getColor() {
		return color;
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
	 * Gets the panel.
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
		Vehicle.pan = pan;
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
	
	//IN MOVE FUNC IN VEHICLE AFTER DRIVE
	pan.repaint();
	
	
	/* (non-Javadoc)
	 * @see graphics.IDrawable#drawObject(java.awt.Graphics)
	 */
	public void drawObject(Graphics g) {
	    if(loc.getOrientation().equals("North")) //drives to north side
	        g.drawImage(img1, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), vehicleWidthVertical, vehicleHeightVertical, pan);
	    else if (loc.getOrientation().equals("South"))//drives to the south side
	        g.drawImage(img2, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), vehicleWidthVertical, vehicleHeightVertical, pan);
	    else if(loc.getOrientation().equals("East")) //drives to the east side
	        g.drawImage(img3, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), vehicleWidthHorizon, vehicleHeightHorizon, pan);
	    else if(loc.getOrientation().equals("West")) //drives to the west side
	        g.drawImage(img4, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), vehicleWidthHorizon, vehicleHeightHorizon, pan);
	}

	/* (non-Javadoc)
	 * @see graphics.IDrawable#loadImages()
	 */
	public void loadImages() {
		String name = this.getColor().toLowerCase()+this.getVehicleName();
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
	
	
	/**
	 * Next location maker.
	 *
	 * @param current the current point
	 * @param next the next point
	 * @param gap the gap
	 * @return the point to go to
	 */
	private static Point nextLocationMaker(Location current,Point next,int gap) {
		Point intersection = getIntersection(current.getLocationPoint(),next);
		while (intersection != null) {
			gap = current.getLocationPoint().manhattanDistance(intersection);
			current.setLocation(intersection);
			String nextDirection = directionInIntersection(current,gap);
			current.setOrientation(nextDirection);
			next = makeNextPoint(current, gap);
			intersection = getIntersection(current.getLocationPoint(),next);
		}
		return next;
	}
	
	/**
	 * Gets the intersection.
	 *
	 * @param current the current point
	 * @param next the next point
	 * @return the intersection between them,if exist
	 */
	private static Point getIntersection(Point current,Point next) {
		if (current.equals(next))
			return null;
		if (current.getY() == next.getY()) {
			if (next.getX() <= 0)
				return new Point(0,current.getY());
			else if (next.getX() >= panelWidth)
				return new Point(panelWidth,current.getY());
		}
		else if (current.getX() == next.getX()) {
			if (next.getY() >= panelHeight || next.getY() <= 0) {
				if (next.getY() <= 0)
					return new Point(current.getX(),0);
				else if (next.getY() >= panelHeight)
					return new Point(current.getX(),panelHeight);
			}
			if (current.getY() == panelHeight/2)
				return null;
			else if ((current.getY() < panelMiddle && next.getY() > panelMiddle) || (current.getY() > panelMiddle && next.getY() < panelMiddle))
				return new Point(current.getX(),panelMiddle);
		}
		return null;
	}
	
	/**
	 * Direction in intersection.
	 *
	 * @param current the current point
	 * @param gap the gap
	 * @return the new direction
	 */
	private static String directionInIntersection(Location current,int gap) {
		String nextOrientation = current.getOppositeOrientation();
		Random randomInt = new Random();
		Location next = current.replicate();
		int index = 0;
		while (nextOrientation.equals(current.getOppositeOrientation()) || !inBounds(next.getLocationPoint())) {
			next = current.replicate();
			index = randomInt.nextInt(4);
			nextOrientation = Location.getOrientations()[index];
			next.setOrientation(nextOrientation);
			next = new Location(makeNextPoint(next,1));
		}
		return nextOrientation;
	}
	
	/**
	 * In bounds.
	 *
	 * @param p the point
	 * @return true, if the point inside the panel
	 */
	private static boolean inBounds(Point p) {
		return !(p.getX() < 0 || p.getX() > panelWidth || p.getY() < 0 || p.getY() > panelHeight);
	}
	
	/**
	 * Sets the panel.
	 *
	 * @param panel the panel
	 * @return true, if successful
	 */
	public static boolean setPanel(CityPanel panel) {
		Vehicle.pan = panel;
		panelWidth = pan.getWidth()-vehicleWidthVertical*5/4;
		panelHeight = pan.getHeight()-vehicleHeightHorizon*5/3;
		panelMiddle = panelHeight/2;
		return true;
	}
	
	/**
	 * Gets the table.
	 *
	 * @return the info table
	 */
	public Object[] getTable() {
		this.buildTable();
		return this.table;
	}

	/**
	 * Next location.
	 *
	 * @return the next point to drive to
	 */
	public Point nextLocation() {
		Location current = this.getLocation().replicate();
		Point next = makeNextPoint(current,this.getSpeed());
		return nextLocationMaker(current,next,this.getSpeed());
	}
	
	// FROM DRIVE IN VEHICLE
	this.useFuel(this.location.getLocationPoint().manhattanDistance(toGo)*this.getFuelConsumption());
	//FROM VEHICLE
	private boolean canMove(Point toGo) {
		return this.location.getLocationPoint().manhattanDistance(toGo)*this.getFuelConsumption() <= this.getCurrentFuel();
	}
	
	//FROM MOVE IN VEHICLE
	if (/*this.canMove(p)*/ && this.location.getLocationPoint().equals(p) == false)
}
