package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class RedCarDecorator.
 * 
 * @author Stav Lobel
 */
public class RedCarDecorator extends CarDecorator {
	
	/**
	 * Instantiates a new red car decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public RedCarDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("redCar");
	}
}
