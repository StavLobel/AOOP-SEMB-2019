package designPatterns;

import vehicles.Vehicle;

/**
 * The Interface IVehicle.
 * 
 * @author Stav Lobel
 */
public interface IVehicle extends Runnable,Cloneable{
	
	/**
	 * Gets the lower layer.
	 *
	 * @return the lower layer
	 */
	public IVehicle getLowerLayer();
	
	/**
	 * Gets the vehicle that inside the decorators layers.
	 *
	 * @return the core vehicle
	 */
	public Vehicle getCore();
	
	public Object clone();
	
}
