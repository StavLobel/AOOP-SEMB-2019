package DesignPatterns;

import vehicleGraphicsDecorator.VehicleGraphicDecorator;
import vehicleGraphicsDecorator.VehicleGraphicFactory;
import vehicleMovingService.VehicleMover;
import vehicles.BenzineEngine;
import vehicles.Car;
import vehicles.Engine;
import vehicles.Location;
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
		VehicleGraphicDecorator graphic = VehicleGraphicFactory.getImagesDecorator("car", color, lightsDecorator);
		return graphic;
	}
	
	public static IVehicle getCar(String engineType,String color,Location location,VehicleMover mover) throws Exception{
		Engine engine;
		if (engineType.equals("Solar"))
			engine = new SolarEngine(Car.getFuelCapacity());
		else if (engineType.equals("Benzine"))
			engine = new BenzineEngine(Car.getFuelCapacity());
		else
			throw new Exception("Cannot create an engine for this vehicle !");
		
		Vehicle car = new Car(engine, location, mover);
		LightsDecorator lightsDecorator = new LightsDecorator(car);
		VehicleGraphicDecorator graphic = VehicleGraphicFactory.getImagesDecorator("car", color, lightsDecorator);
		return graphic;
	}
}
