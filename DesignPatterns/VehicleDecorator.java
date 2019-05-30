package DesignPatterns;

import vehicles.Vehicle;

/**
 * The Class VehicleDecorator.
 */
public abstract class VehicleDecorator implements IVehicle {
	
	/** The vehicle. */
	protected IVehicle vehicleLayer;
	
	/**
	 * Instantiates a new vehicle decorator.
	 *
	 * @param vehicleLayer the vehicle layer
	 */
	public VehicleDecorator (IVehicle vehicleLayer) {
		this.vehicleLayer = vehicleLayer;
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IVehicle#getLowerLayer()
	 */
	public IVehicle getLowerLayer() {
		return this.vehicleLayer;
	}
	
	/* (non-Javadoc)
	 * @see DesignPatterns.IVehicle#getCore()
	 */
	public Vehicle getCore() {
		IVehicle temp = this;
		while (temp instanceof Vehicle == false) {
			temp = temp.getLowerLayer();
		}
		return (Vehicle) temp;
	}
	
	public void run() {
		vehicleLayer.run();
	}
	
}
