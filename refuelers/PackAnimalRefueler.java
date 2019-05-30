package refuelers;

import vehicles.IUsingFuel;

public class PackAnimalRefueler extends Refueler {
	
	public boolean refuel(IUsingFuel vehicleToRefuel) throws FuelTypeException {
		if (!(vehicleToRefuel.getEngineType().equals("Pack Animal")))
				throw new FuelTypeException("Pack Animal",vehicleToRefuel.getEngineType());
		else
			return super.refuel(vehicleToRefuel);
	}
}
