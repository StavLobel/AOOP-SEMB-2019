package refuelers;

import vehicles.IUsingFuel;
import vehicles.SolarEngine;

/**
 * The Class SolarRefueler.
 */
public class SolarRefueler extends Refueler {
	
	/* (non-Javadoc)
	 * @see refuelers.Refueler#refuel(vehicles.IUsingFuel)
	 */
	public boolean refuel(IUsingFuel vehicleToRefuel) throws FuelTypeException {
		if (!(vehicleToRefuel.getEngineType().equals(new SolarEngine(1).toString())))
				throw new FuelTypeException(new SolarEngine(1).toString(),vehicleToRefuel.getEngineType());
		else
			return super.refuel(vehicleToRefuel);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Solar Refueler";
	}
}
