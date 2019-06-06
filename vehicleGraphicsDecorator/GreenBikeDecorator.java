package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

/**
 * The Class GreenBikeDecorator.
 * 
 * @author Stav Lobel
 */
public class GreenBikeDecorator extends BikeDecorator {
	
	/**
	 * Instantiates a new green bike decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public GreenBikeDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("greenBike");
	}
	
	public Object clone() {
		return new GreenBikeDecorator((IVehicle) vehicleLayer.clone());
	}
}
