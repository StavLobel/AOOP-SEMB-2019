package DesignPatterns;

import vehicleGraphicsDecorator.VehicleImagesDecorator;
import vehicleGraphicsDecorator.VehicleImagesFactory;
import vehicleMovingBridge.VehicleMover;
import vehicles.Bike;

public class BikeFactory {
	public static IVehicle getBike(int gears,String color,VehicleMover mover) {
		Bike bike = new Bike(gears, mover);
		LightsDecorator lightsDecorator = new LightsDecorator(bike);
		VehicleImagesDecorator iVehicle = VehicleImagesFactory.getImagesDecorator("bike", color, lightsDecorator);
		return iVehicle;
	}
}
