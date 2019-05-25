package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * A factory for creating VehicleImagesDecorator objects.
 * 
 * @author Stav Lobel
 */
public interface VehicleImagesDecoratorFactory {
	
	/**
	 * Gets the images decorator.
	 *
	 * @param color the color of the vehicle
	 * @param vehicle the vehicle
	 * @return the images decorator
	 */
	public VehicleImagesDecorator getImagesDecorator(String color,IVehicle vehicle); 
}
