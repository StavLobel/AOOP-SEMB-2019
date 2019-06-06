package vehicleGraphicsDecorator;

import designPatterns.IVehicle;

/**
 * The Class CarImagesDecoratorFacory.
 * 
 * @author Stav Lobel
 */
public class CarGraphicDecoratorFacory implements VehicleGraphicDecoratorFactory {
	
	/* (non-Javadoc)
	 * @see vehicleGraphicsDecorator.VehicleImagesDecoratorFactory#getImagesDecorator(java.lang.String, DesignPatterns.IVehicle)
	 */
	public VehicleGraphicDecorator getImagesDecorator(String color,IVehicle vehicle) {
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
