package vehicleMovingService;

import vehicles.Location;
import vehicles.Point;
import vehicles.Vehicle;

/**
 * The Interface IVehicleMover.
 */
public interface IVehicleMover {
	
	/**
	 * Move.
	 * 
	 * Deside how to move the vehicle based on specific logic.
	 *
	 * @param toGo the toGo point
	 * @return true, if successful
	 */
	public boolean move(Vehicle vehicle,Point toGo);
	
	public Point makeNextPoint(Location location,int distance);
}
