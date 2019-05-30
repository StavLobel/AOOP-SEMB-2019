package refuelers;

import vehicles.IUsingFuel;
import vehicles.SolarEngine;

public class SolarRefueler extends Refueler {
	public boolean refuel(IUsingFuel vehicleToRefuel) throws FuelTypeException {
		if (!(vehicleToRefuel.getEngineType().equals(new SolarEngine(1).toString())))
				throw new FuelTypeException(new SolarEngine(1).toString(),vehicleToRefuel.getEngineType());
		else
			return super.refuel(vehicleToRefuel);
	}
}
