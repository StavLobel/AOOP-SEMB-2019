package DesignPatterns;

import java.awt.Graphics;

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
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IVehicle#drawObject(java.awt.Graphics)
	 */
	public void drawObject(Graphics g) {
		vehicle.drawObject(g);
	}
}
