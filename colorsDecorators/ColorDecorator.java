package colorsDecorators;

import java.awt.Color;

import designPatterns.IVehicle;
import designPatterns.VehicleDecorator;

/**
 * The Class ColorDecorator.
 * 
 * @author Stav Lobel
 */
public abstract class ColorDecorator extends VehicleDecorator {

	/** The color. */
	protected Color color;
	
	/**
	 * Instantiates a new color decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public ColorDecorator(IVehicle vehicle) {
		super(vehicle);
	}
	
	/**
	 * Gets the color name.
	 *
	 * @return the color name
	 */
	public String getColorName() {
		return color.toString();
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	
}
