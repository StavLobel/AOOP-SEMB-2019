package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

/**
 * The Class RedCarriageDecorator.
 * 
 * @author Stav Lobel
 */
public class RedCarriageDecorator extends CarriageDecorator {
	
	/**
	 * Instantiates a new red carriage decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public RedCarriageDecorator(IVehicle vehicle) {
		super(vehicle);
		loadImages("redCarriage");
	}
	
	public Object clone() {
		return new RedCarriageDecorator((IVehicle) vehicleLayer.clone());
	}
}
