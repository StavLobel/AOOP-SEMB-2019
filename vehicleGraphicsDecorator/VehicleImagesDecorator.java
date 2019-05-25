package vehicleGraphicsDecorator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import DesignPatterns.IVehicle;
import DesignPatterns.VehicleDecorator;

/**
 * The Class VehicleImagesDecorator.
 * 
 * @author Stav Lobel
 */
public abstract class VehicleImagesDecorator extends VehicleDecorator {
	
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
	
	
	/**
	 * Instantiates a new vehicle graphics.
	 *
	 * @param vehicle the vehicle
	 */
	public VehicleImagesDecorator(IVehicle vehicle) {
		super(vehicle);
	}
	
	/**
	 * Load images.
	 *
	 * @param name the name of the vehicle and color
	 * @return true, if successful
	 */
	protected boolean loadImages(String name) {
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
}
