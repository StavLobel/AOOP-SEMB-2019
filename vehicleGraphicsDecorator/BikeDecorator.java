package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class BikeImagesDecorator.
 * 
 * @author Stav Lobel
 */
public abstract class BikeDecorator extends VehicleImagesDecorator {
	
	/**
	 * Instantiates a new bike graphics.
	 *
	 * @param vehicle the vehicle
	 */
	public BikeDecorator(IVehicle vehicle) {
		super(vehicle);
	}
}
