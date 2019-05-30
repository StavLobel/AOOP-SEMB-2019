package vehicleMovingBridge;

import vehicles.*;

public abstract class VehicleMover implements IVehicleMover {
	
	@Override
	public boolean move(Vehicle vehicle,Point toGo) {
		vehicle.drive(toGo);
	    return false;
	}
	
	public Point makeNextPoint(Location location,int distance) {
		if (location.getOrientation().equals("North")) 
			return Point.getPointInstance(location.getLocationPoint().getX(),location.getLocationPoint().getY() - distance);
		else if (location.getOrientation().equals("South")) 
			return Point.getPointInstance(location.getLocationPoint().getX(),location.getLocationPoint().getY() + distance);
		else if (location.getOrientation().equals("East")) 
			return Point.getPointInstance(location.getLocationPoint().getX() + distance,location.getLocationPoint().getY());
		else if (location.getOrientation().equals("West")) 
			return Point.getPointInstance(location.getLocationPoint().getX() - distance,location.getLocationPoint().getY());
		else
			return null;
	}
}
