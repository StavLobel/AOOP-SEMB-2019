package designPatterns;

import vehicleGraphicsDecorator.VehicleGraphicDecorator;
import vehicleGraphicsDecorator.VehicleGraphicFactory;
import vehicleMovingService.VehicleMover;
import vehicles.Carriage;
import vehicles.Location;

public class CarriageFactory {
	public static IVehicle getCarriage(String color,VehicleMover mover) {
		Carriage carriage = new Carriage(mover);
		LightsDecorator lightsDecorator = new LightsDecorator(carriage);
		VehicleGraphicDecorator graphic = VehicleGraphicFactory.getImagesDecorator("carriage", color, lightsDecorator);
		return graphic;
	}
	
	public static IVehicle getCarriage(String color,Location location,VehicleMover mover) {
		Carriage carriage = new Carriage(location,mover);
		LightsDecorator lightsDecorator = new LightsDecorator(carriage);
		VehicleGraphicDecorator graphic = VehicleGraphicFactory.getImagesDecorator("carriage", color, lightsDecorator);
		return graphic;
	}
}
