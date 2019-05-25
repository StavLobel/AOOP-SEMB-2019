package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class SilverBikeDecorator.
 * 
 * @author Stav Lobel
 */
public class SilverBikeDecorator extends BikeDecorator {
	
	/**
	 * Instantiates a new silver bike decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public SilverBikeDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("silverBike");
	}
}
