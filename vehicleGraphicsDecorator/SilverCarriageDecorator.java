package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

/**
 * The Class SilverCarriageDecorator.
 * 
 * @author Stav Lobel
 */
public class SilverCarriageDecorator extends CarriageDecorator {
	
	/**
	 * Instantiates a new silver carriage decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public SilverCarriageDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("silverCarriage");
	}
	
	public Object clone() {
		return new SilverCarriageDecorator((IVehicle) vehicleLayer.clone());
	}
}
