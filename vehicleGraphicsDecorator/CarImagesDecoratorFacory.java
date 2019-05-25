package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class CarImagesDecoratorFacory.
 * 
 * @author Stav Lobel
 */
public class CarImagesDecoratorFacory implements VehicleImagesDecoratorFactory {
	
	/* (non-Javadoc)
	 * @see vehicleGraphicsDecorator.VehicleImagesDecoratorFactory#getImagesDecorator(java.lang.String, DesignPatterns.IVehicle)
	 */
	public VehicleImagesDecorator getImagesDecorator(String color,IVehicle vehicle) {
		color = color.toLowerCase();
		if (color.equals("red"))
			return new RedCarDecorator(vehicle);
		else if (color.equals("green"))
			return new GreenCarDecorator(vehicle);
		else if (color.equals("silver"))
			return new SilverCarDecorator(vehicle);
		else if (color.equals("white"))
			return new WhiteCarDecorator(vehicle);
		else
			return null;
	}
}
