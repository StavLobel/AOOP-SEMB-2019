package refuelers;

import vehicles.IUsingFuel;

public abstract class Refueler {
	public boolean refuel(IUsingFuel vehicleToRefuel) throws FuelTypeException{
		
		if (vehicleToRefuel.getCurrentFuel() == vehicleToRefuel.getMaxCapacity())
			return false;
		
		vehicleToRefuel.setCurrentFuel(vehicleToRefuel.getMaxCapacity()-vehicleToRefuel.getCurrentFuel());
		return true;
	}
}
