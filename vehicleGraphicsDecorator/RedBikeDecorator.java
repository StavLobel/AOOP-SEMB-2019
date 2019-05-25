package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class RedBikeDecorator.
 * 
 * @author Stav Lobel
 */
public class RedBikeDecorator extends BikeDecorator {
	
	/**
	 * Instantiates a new red bike decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public RedBikeDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("redBike");
	}
}
