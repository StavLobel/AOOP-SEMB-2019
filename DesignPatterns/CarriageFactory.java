package DesignPatterns;

import vehicleGraphicsDecorator.VehicleImagesDecorator;
import vehicleGraphicsDecorator.VehicleImagesFactory;
import vehicleMovingBridge.VehicleMover;
import vehicles.Carriage;

public class CarriageFactory {
	public static IVehicle getCarriage(String color,VehicleMover mover) {
		Carriage carriage = new Carriage(mover);
		LightsDecorator lightsDecorator = new LightsDecorator(carriage);
		VehicleImagesDecorator iVehicle = VehicleImagesFactory.getImagesDecorator("carriage", color, lightsDecorator);
		return iVehicle;
	}
}
