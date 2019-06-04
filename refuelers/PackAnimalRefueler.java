package refuelers;

import vehicles.IUsingFuel;

/**
 * The Class PackAnimalRefueler.
 */
public class PackAnimalRefueler extends Refueler {
	
	/* (non-Javadoc)
	 * @see refuelers.Refueler#refuel(vehicles.IUsingFuel)
	 */
	public boolean refuel(IUsingFuel vehicleToRefuel) throws FuelTypeException {
		if (!(vehicleToRefuel.getEngineType().equals("Pack Animal")))
				throw new FuelTypeException("Pack Animal",vehicleToRefuel.getEngineType());
		else
			return super.refuel(vehicleToRefuel);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Pack Animal Refueler";
	}
}
