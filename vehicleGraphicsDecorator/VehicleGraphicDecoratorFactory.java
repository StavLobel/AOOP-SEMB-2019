package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

/**
 * A factory for creating VehicleImagesDecorator objects.
 * 
 * @author Stav Lobel
 */
public interface VehicleGraphicDecoratorFactory {
	
	/**
	 * Gets the images decorator.
	 *
	 * @param color the color of the vehicle
	 * @param vehicle the vehicle
	 * @return the images decorator
	 */
	public VehicleGraphicDecorator getImagesDecorator(String color,IVehicle vehicle); 
}
