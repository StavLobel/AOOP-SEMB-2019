package refuelers;

import vehicles.BenzineEngine;
import vehicles.IUsingFuel;

/**
 * The Class BenzineRefueler.
 * 
 * @author Stav Lobel
 */
public class BenzineRefueler extends Refueler {
	
	/* (non-Javadoc)
	 * @see refuelers.Refueler#refuel(vehicles.IUsingFuel)
	 */
	public boolean refuel(IUsingFuel vehicleToRefuel) throws FuelTypeException {
		if (!(vehicleToRefuel.getEngineType().equals(new BenzineEngine(1).toString())))
			throw new FuelTypeException(vehicleToRefuel.getEngineType(),new BenzineEngine(1).toString());
			
		else
			return super.refuel(vehicleToRefuel);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Benzine Refueler";
	}
}
