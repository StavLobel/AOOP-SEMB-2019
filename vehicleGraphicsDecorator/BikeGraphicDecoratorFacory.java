package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class BikeImagesDecoratorFacory.
 * 
 * @author Stav Lobel
 */
public class BikeGraphicDecoratorFacory implements VehicleGraphicDecoratorFactory {
	
	/* (non-Javadoc)
	 * @see vehicleGraphicsDecorator.VehicleImagesDecoratorFactory#getImagesDecorator(java.lang.String, DesignPatterns.IVehicle)
	 */
	public VehicleGraphicDecorator getImagesDecorator(String color,IVehicle vehicle) {
		color = color.toLowerCase();
		if (color.equals("red"))
			return new RedBikeDecorator(vehicle);
		else if (color.equals("green"))
			return new GreenBikeDecorator(vehicle);
		else if (color.equals("silver"))
			return new SilverBikeDecorator(vehicle);
		else if (color.equals("white"))
			return new WhiteBikeDecorator(vehicle);
		else
			return null;
	}
}
