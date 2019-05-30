package DesignPatterns;

import vehicleGraphicsDecorator.VehicleImagesDecorator;
import vehicleGraphicsDecorator.VehicleImagesFactory;
import vehicleMovingBridge.VehicleMover;
import vehicles.BenzineEngine;
import vehicles.Car;
import vehicles.Engine;
import vehicles.SolarEngine;
import vehicles.Vehicle;

public class CarFactory {
	
	public static IVehicle getCar(String engineType,String color,VehicleMover mover) throws Exception{
		Engine engine;
		if (engineType.equals("Solar"))
			engine = new SolarEngine(Car.getFuelCapacity());
		else if (engineType.equals("Benzine"))
			engine = new BenzineEngine(Car.getFuelCapacity());
		else
			throw new Exception("Cannot create an engine for this vehicle !");
		
		Vehicle car = new Car(engine, mover);
		LightsDecorator lightsDecorator = new LightsDecorator(car);
		VehicleImagesDecorator iVehicle = VehicleImagesFactory.getImagesDecorator("car", color, lightsDecorator);
		return iVehicle;
	}
}
