package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * A factory for creating VehicleImagesDecorator objects.
 * 
 * @author Stav Lobel
 */
public class VehicleImagesFactory {

	/**
	 * Gets the images decorator.
	 *
	 * @param vehicleType the vehicle type
	 * @param color the color
	 * @param vehicle the vehicle
	 * @return the images decorator
	 */
	public VehicleImagesDecorator getImagesDecorator(String vehicleType,String color, IVehicle vehicle) {
		vehicleType = vehicleType.toLowerCase();
		if (vehicleType.equals("car"))
			return new CarImagesDecoratorFacory().getImagesDecorator(color, vehicle);
		if (vehicleType.equals("carriage"))
			return new CarriageImagesDecoratorFacory().getImagesDecorator(color, vehicle);
		if (vehicleType.equals("bike"))
			return new BikeImagesDecoratorFacory().getImagesDecorator(color, vehicle);
		else
			return null;
	}

}
