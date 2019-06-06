package colorsDecorators;

import java.awt.Color;

import designPatterns.IVehicle;

/**
 * The Class SilverColorDecorator.
 * 
 * @author Stav Lobel
 */
public class SilverColorDecorator extends ColorDecorator {

	/**
	 * Instantiates a new silver color decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public SilverColorDecorator(IVehicle vehicle) {
		super(vehicle);
		this.color = new Color(192,192,192);
	}
	
	public Object clone() {
		return new SilverColorDecorator((IVehicle) vehicleLayer.clone());
	}
	
}
