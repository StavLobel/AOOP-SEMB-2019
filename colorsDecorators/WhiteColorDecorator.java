package colorsDecorators;

import java.awt.Color;

import DesignPatterns.IVehicle;

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
	
}
