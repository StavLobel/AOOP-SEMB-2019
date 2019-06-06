package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

/**
 * The Class WhiteCarriageDecorator.
 * 
 * @author Stav Lobel
 */
public class WhiteCarriageDecorator extends CarriageDecorator {
	
	/**
	 * Instantiates a new white carriage decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public WhiteCarriageDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("whiteCarriage");
	}
	
	public Object clone() {
		return new WhiteCarriageDecorator((IVehicle) vehicleLayer.clone());
	}
}
