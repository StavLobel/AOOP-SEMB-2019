package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * A factory for creating VehicleImagesDecorator objects.
 * 
 * @author Stav Lobel
 */
public class VehicleGraphicFactory {

	/**
	 * Gets the images decorator.
	 *
	 * @param vehicleType the vehicle type
	 * @param color the color
	 * @param vehicle the vehicle
	 * @return the images decorator
	 */
	public static VehicleGraphicDecorator getImagesDecorator(String vehicleType,String color, IVehicle vehicle) {
		vehicleType = vehicleType.toLowerCase();
		if (vehicleType.equals("car"))
			return new CarGraphicDecoratorFacory().getImagesDecorator(color, vehicle);
		if (vehicleType.equals("carriage"))
			return new CarriageGraphicDecoratorFacory().getImagesDecorator(color, vehicle);
		if (vehicleType.equals("bike"))
			return new BikeGraphicDecoratorFacory().getImagesDecorator(color, vehicle);
		else
			return null;
	}

}
