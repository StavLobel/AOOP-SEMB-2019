package colorsDecorators;

import java.awt.Color;

import designPatterns.IVehicle;

/**
 * The Class WhiteColorDecorator.
 * 
 * @author Stav Lobel
 */
public class WhiteColorDecorator extends ColorDecorator {

	/**
	 * Instantiates a new white color decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public WhiteColorDecorator(IVehicle vehicle) {
		super(vehicle);
		this.color = new Color(255,255,255);
	}
	
	public Object clone() {
		return new WhiteColorDecorator((IVehicle) vehicleLayer.clone());
	}
	
}
