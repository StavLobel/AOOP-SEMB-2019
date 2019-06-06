package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

/**
 * The Class GreenCarDecorator.
 * 
 * @author Stav Lobel
 */
public class GreenCarDecorator extends CarDecorator {
	
	/**
	 * Instantiates a new green car decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public GreenCarDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("greenCar");
	}
	
	public Object clone() {
		return new GreenCarDecorator((IVehicle) vehicleLayer.clone());
	}
}
