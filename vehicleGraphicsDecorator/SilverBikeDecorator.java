package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

/**
 * The Class SilverBikeDecorator.
 * 
 * @author Stav Lobel
 */
public class SilverBikeDecorator extends BikeDecorator {
	
	/**
	 * Instantiates a new silver bike decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public SilverBikeDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("silverBike");
	}
	
	public Object clone() {
		return new SilverBikeDecorator((IVehicle) vehicleLayer.clone());
	}
}
