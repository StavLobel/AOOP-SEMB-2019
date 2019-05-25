package DesignPatterns;

/**
 * The Class LightsDecorator.
 * 
 * @author Stav Lobel
 */
public class LightsDecorator extends VehicleDecorator {
	protected boolean lights;
	
	/**
	 * Instantiates a new lights decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public LightsDecorator(IVehicle vehicle) {
		super(vehicle);
	}
	
	public boolean switchLights() {
		lights = !lights;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IVehicle#isLights()
	 */
	public boolean isLights() {
		return lights;
	}
}
