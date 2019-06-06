package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

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
	
	public Object clone() {
		return new WhiteCarDecorator((IVehicle) vehicleLayer.clone());
	}
}
