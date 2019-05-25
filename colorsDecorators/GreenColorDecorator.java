package colorsDecorators;

import java.awt.Color;

import DesignPatterns.IVehicle;

/**
 * The Class GreenColorDecorator.
 * 
 * @author Stav Lobel
 */
public class GreenColorDecorator extends ColorDecorator {

	/**
	 * Instantiates a new green color decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public GreenColorDecorator(IVehicle vehicle) {
		super(vehicle);
		this.color = new Color(0,128,0);
	}
	
}
