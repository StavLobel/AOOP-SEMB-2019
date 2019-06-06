package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

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
	
	public Object clone() {
		return new RedCarDecorator((IVehicle) vehicleLayer.clone());
	}
}
