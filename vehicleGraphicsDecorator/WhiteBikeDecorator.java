package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class WhiteBikeDecorator.
 * 
 * @author Stav Lobel
 */
public class WhiteBikeDecorator extends BikeDecorator {
	
	/**
	 * Instantiates a new white bike decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public WhiteBikeDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("whiteBike");
	}
}
