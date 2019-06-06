package designPatterns;

/**
 * The Class LightsDecorator.
 * 
 * @author Stav Lobel
 */
public class LightsDecorator extends VehicleDecorator {
	protected boolean lights = false;
	
	/**
	 * Instantiates a new lights decorator.
	 *
	 * @param vehicleLayer the vehicle layer
	 */
	public LightsDecorator(IVehicle vehicleLayer) {
		super(vehicleLayer);
	}
	
	/**
	 * Switch lights.
	 *
	 * @return true, if successful
	 */
	public boolean switchLights() {
		lights = !lights;
		return true;
	}
	
	/**
	 * Checks if the lights turned on.
	 *
	 * @return true, if the lights on
	 */
	public boolean isLights() {
		return lights;
	}
	
	public Object clone() {
		LightsDecorator temp = new LightsDecorator((IVehicle) vehicleLayer.clone());
		while (temp.isLights() != this.isLights()) {
			temp.switchLights();
		}
		return temp;
	}
}
