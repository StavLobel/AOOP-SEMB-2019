package vehicleMovingBridge;

import vehicles.*;

public class VehicleMover implements IVehicleMover {
	
	@Override
	public boolean move(Vehicle vehicle,Point toGo) {
		if (vehicle.canMove() && vehicle.getLocation().getLocationPoint().equals(toGo) == false) {    
	    	try {Thread.sleep(100);}
	        catch (InterruptedException e) { e.printStackTrace(); }
	        vehicle.drive(toGo);
		    return true;
	    }
	    return false;
	}
	
	public Point makeNextPoint(Location location,int speed) {
		if (location.getOrientation().equals("North")) 
			return Point.getPointInstance(location.getLocationPoint().getX(),location.getLocationPoint().getY() - speed);
		else if (location.getOrientation().equals("South")) 
			return Point.getPointInstance(location.getLocationPoint().getX(),location.getLocationPoint().getY() + speed);
		else if (location.getOrientation().equals("East")) 
			return Point.getPointInstance(location.getLocationPoint().getX() + speed,location.getLocationPoint().getY());
		else if (location.getOrientation().equals("West")) 
			return Point.getPointInstance(location.getLocationPoint().getX() - speed,location.getLocationPoint().getY());
		else
			return null;
	}
}
