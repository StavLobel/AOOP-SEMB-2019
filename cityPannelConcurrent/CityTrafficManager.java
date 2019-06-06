package cityPannelConcurrent;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.concurrent.ConcurrentHashMap;
import designPatterns.Observable;
import designPatterns.Observer;
import vehicles.Vehicle;

public class CityTrafficManager implements Observer {
	
	private ConcurrentHashMap<Vehicle, Rectangle> traffic = new ConcurrentHashMap<Vehicle, Rectangle>();
	
	@Override
	public boolean getNotified(Observable observable,String msg) {
		if (msg.equals(Vehicle.KILLED)) {
			synchronized (traffic) {
				traffic.remove(observable);
				return true;	
			}
		}
		else if (msg.equals(Vehicle.MOVED) || msg.equals(Vehicle.CREATED)) {
			synchronized (observable) {
				Vehicle v = (Vehicle) observable;
				Point p = new Point(v.getLocation().getLocationPoint().getX(), v.getLocation().getLocationPoint().getY());
				Rectangle vRec = new Rectangle(p, v.getDimensions());
				if (((Vehicle) observable).getFlag()) {
					traffic.put(v,vRec);
					for (Vehicle other : traffic.keySet()) {
						if (v.equals(other) == false && traffic.get(v).intersects(traffic.get(other))) {
							if (v.getDurability() > other.getDurability())
								other.kill(v.toString());
							else if (v.getDurability() < other.getDurability())
								v.kill(other.toString());
							else {
								String vString = v.toString();
								String oString = other.toString();
								v.kill(oString);
								other.kill(vString);
							}
						}
					}
				}	
			}
		}
		return true;
	}
		
}
