package vehicleGraphicsDecorator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import DesignPatterns.IVehicle;
import DesignPatterns.VehicleDecorator;
import cityFrame.CityPanel;
import vehicles.Location;
import vehicles.Vehicle;

/**
 * The Class VehicleImagesDecorator.
 * 
 * @author Stav Lobel
 */
public abstract class VehicleGraphicDecorator extends VehicleDecorator {
	
	/** The size of the vehicle.*/
	protected static final int size= 65;
	
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
	
	protected static CityPanel panel;
	
	
	/**
	 * Instantiates a new vehicle graphics decorator.
	 *
	 * @param vehicleLayer the vehicle layer
	 */
	public VehicleGraphicDecorator(IVehicle vehicleLayer) {
		super(vehicleLayer);
	}
	
	public boolean setPanel(CityPanel panel) {
		VehicleGraphicDecorator.panel = panel;
		return true;
	}
	
	/**
	 * Load images.
	 *
	 * @param name the name of the vehicle and color
	 * @return true, if successful
	 */
	public boolean loadImages(String name) {
		String nameNorth = name+"North.png";
		String nameSouth = name+"South.png";
		String nameEast = name+"East.png";
		String nameWest = name+"West.png";
		
		try {
			this.img1 = ImageIO.read(new File("PNGs//"+nameNorth));
		}
		catch (IOException e) {
			return false;
		}
		
		try {
			this.img2 = ImageIO.read(new File("PNGs//"+nameSouth));
		}
		catch (IOException e) {
			return false;
		}
		
		try {
			this.img3 = ImageIO.read(new File("PNGs//"+nameEast));
		}
		catch (IOException e) {
			return false;
		}
		
		try {
			this.img4 = ImageIO.read(new File("PNGs//"+nameWest));
		}
		catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public void drawObject(Graphics g) {
		Vehicle core = this.getCore();
		Location loc = core.getLocation();
	    if(loc.getOrientation().equals("North")) //drives to north side
	        g.drawImage(img1, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), vehicleWidthVertical, vehicleHeightVertical, panel);
	    else if (loc.getOrientation().equals("South"))//drives to the south side
	        g.drawImage(img2, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), vehicleWidthVertical, vehicleHeightVertical, panel);
	    else if(loc.getOrientation().equals("East")) //drives to the east side
	        g.drawImage(img3, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), vehicleWidthHorizon, vehicleHeightHorizon, panel);
	    else if(loc.getOrientation().equals("West")) //drives to the west side
	        g.drawImage(img4, loc.getLocationPoint().getX(), loc.getLocationPoint().getY(), vehicleWidthHorizon, vehicleHeightHorizon, panel);
	}
	
	public Dimension getDimensions() {
		if (this.getCore().getLocation().getOrientation().equals(Location.NORTH) || this.getCore().getLocation().getOrientation().equals(Location.SOUTH))
			return new Dimension(vehicleWidthVertical, vehicleHeightVertical);
		else
			return new Dimension(vehicleWidthHorizon, vehicleHeightHorizon);
	}
	
}
