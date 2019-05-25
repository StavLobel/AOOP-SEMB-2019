package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class SilverCarDecorator.
 * 
 * @author Stav Lobel
 */
public class SilverCarDecorator extends CarDecorator {
	
	/**
	 * Instantiates a new silver car decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public SilverCarDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("silverCar");
	}
}
