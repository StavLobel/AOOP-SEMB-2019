package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class WhiteCarDecorator.
 * 
 * @author Stav Lobel
 */
public class WhiteCarDecorator extends CarDecorator {
	
	/**
	 * Instantiates a new white car decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public WhiteCarDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("whiteCar");
	}
}
