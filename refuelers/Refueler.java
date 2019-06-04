package refuelers;

import vehicles.IUsingFuel;
import vehicles.Vehicle;

/**
 * The Class Refueler.
 * 
 * @author Stav Lobel
 */
public abstract class Refueler {
	
	/**
	 * Refuel.
	 *
	 * @param vehicleToRefuel the vehicle to refuel
	 * @return true, if successful
	 * @throws FuelTypeException the fuel type exception
	 */
	public boolean refuel(IUsingFuel vehicleToRefuel) throws FuelTypeException{
		if (vehicleToRefuel.getCurrentFuel() == vehicleToRefuel.getMaxCapacity())
			return false;
		
		vehicleToRefuel.setCurrentFuel(vehicleToRefuel.getMaxCapacity()-vehicleToRefuel.getCurrentFuel());
		synchronized (vehicleToRefuel) {
			vehicleToRefuel.notify();
		}
		return true;
	}
}
