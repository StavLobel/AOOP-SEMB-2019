package vehicleGraphicsDecorator;

import DesignPatterns.IVehicle;

/**
 * The Class CarriageImagesDecoratorFacory.
 * 
 * @author Stav Lobel
 */
public class CarriageGraphicDecoratorFacory implements VehicleGraphicDecoratorFactory {
	
	/* (non-Javadoc)
	 * @see vehicleGraphicsDecorator.VehicleImagesDecoratorFactory#getImagesDecorator(java.lang.String, DesignPatterns.IVehicle)
	 */
	public VehicleGraphicDecorator getImagesDecorator(String color,IVehicle vehicle) {
		color = color.toLowerCase();
		if (color.equals("red"))
			return new RedCarriageDecorator(vehicle);
		else if (color.equals("green"))
			return new GreenCarriageDecorator(vehicle);
		else if (color.equals("silver"))
			return new SilverCarriageDecorator(vehicle);
		else if (color.equals("white"))
			return new WhiteCarriageDecorator(vehicle);
		else
			return null;
	}
}
