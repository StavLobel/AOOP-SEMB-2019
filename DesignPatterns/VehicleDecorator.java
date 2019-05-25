package DesignPatterns;

import vehicles.Location;

/**
 * The Class VehicleDecorator.
 */
public abstract class VehicleDecorator implements IVehicle {
	
	/** The vehicle. */
	protected IVehicle vehicle;
	
	/**
	 * Instantiates a new vehicle decorator.
	 *
	 * @param vehicle the vehicle
	 */
	public VehicleDecorator (IVehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Location getLocation() {
		return vehicle.getLocation();
	}
	
	public void run() {
		vehicle.run();
	}
}
