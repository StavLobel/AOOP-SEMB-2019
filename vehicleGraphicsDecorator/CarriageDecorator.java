package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class CarriageDecorator.
 * 
 * @author Stav Lobel
 */
public abstract class CarriageDecorator extends VehicleGraphicDecorator {

	/**
	 * Instantiates a new carriage decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public CarriageDecorator(IVehicle vehicle) {
		super(vehicle);
	}
	
}