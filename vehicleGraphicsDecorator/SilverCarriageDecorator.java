package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class SilverCarriageDecorator.
 * 
 * @author Stav Lobel
 */
public class SilverCarriageDecorator extends CarriageDecorator {
	
	/**
	 * Instantiates a new silver carriage decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public SilverCarriageDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("silverCarriage");
	}
}
