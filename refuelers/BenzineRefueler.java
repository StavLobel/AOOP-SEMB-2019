package refuelers;

import vehicles.BenzineEngine;
import vehicles.IUsingFuel;

public class BenzineRefueler extends Refueler {
	public boolean refuel(IUsingFuel vehicleToRefuel) throws FuelTypeException {
		if (!(vehicleToRefuel.getEngineType().equals(new BenzineEngine(1).toString())))
				throw new FuelTypeException(new BenzineEngine(1).toString(),vehicleToRefuel.getEngineType());
		else
			return super.refuel(vehicleToRefuel);
	}
}
