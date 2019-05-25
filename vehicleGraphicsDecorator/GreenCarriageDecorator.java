package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class GreenCarriageDecorator.
 * 
 * @author Stav Lobel
 */
public class GreenCarriageDecorator extends CarriageDecorator {
	
	/**
	 * Instantiates a new green carriage decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public GreenCarriageDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("greenCarriage");
	}
}
