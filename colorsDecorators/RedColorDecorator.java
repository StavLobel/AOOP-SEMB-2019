package colorsDecorators;

import java.awt.Color;

import DesignPatterns.IVehicle;

/**
 * The Class RedColorDecorator.
 * 
 * @author Stav Lobel
 */
public class RedColorDecorator extends ColorDecorator {
	
	/**
	 * Instantiates a new red color decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public RedColorDecorator(IVehicle vehicle) {
		super(vehicle);
		this.color = new Color(255,0,0);
	}
}
