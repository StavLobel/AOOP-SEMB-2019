package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class CarDecorator.
 * 
 * @author Stav Lobel
 */
public abstract class CarDecorator extends VehicleGraphicDecorator {
	
	/**
	 * Instantiates a new car decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public CarDecorator(IVehicle vehicle) {
		super(vehicle);
	}
}
