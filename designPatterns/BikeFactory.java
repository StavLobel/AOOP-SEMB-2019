package designPatterns;

import vehicleGraphicsDecorator.VehicleGraphicDecorator;
import vehicleGraphicsDecorator.VehicleGraphicFactory;
import vehicleMovingService.VehicleMover;
import vehicles.Bike;
import vehicles.Location;

public class BikeFactory {
	public static IVehicle getBike(int gears,String color,VehicleMover mover) {
		Bike bike = new Bike(gears, mover);
		LightsDecorator lightsDecorator = new LightsDecorator(bike);
		VehicleGraphicDecorator graphic = VehicleGraphicFactory.getImagesDecorator("bike", color, lightsDecorator);
		return graphic;
	}
	
	public static IVehicle getBike(int gears,String color,Location location,VehicleMover mover) {
		Bike bike = new Bike(gears,location, mover);
		LightsDecorator lightsDecorator = new LightsDecorator(bike);
		VehicleGraphicDecorator graphic = VehicleGraphicFactory.getImagesDecorator("bike", color, lightsDecorator);
		return graphic;
	}
}
