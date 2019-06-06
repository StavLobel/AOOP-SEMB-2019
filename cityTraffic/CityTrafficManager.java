package cityTraffic;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import graphics.CityPanel;
import vehicles.Vehicle;

public class CityTrafficManager implements Observer {
	
	private ConcurrentHashMap<Vehicle, Rectangle> traffic = new ConcurrentHashMap<Vehicle, Rectangle>();
	
	@Override
	public synchronized boolean getNotified(Observable observable,String msg) {
		if (msg.equals("killed")) {
			traffic.remove((Vehicle) observable);
			return true;
			}
		else if (msg.equals("moved")) {
			Vehicle v = (Vehicle) observable;
			Point p = new Point(v.getLocation().getLocationPoint().getX(), v.getLocation().getLocationPoint().getY());
			traffic.put(v, new Rectangle(p, v.getDimensions()));
			
			for (Map.Entry<Vehicle, Rectangle> entry : traffic.entrySet()) {
				if (entry.getKey() != v) {
					if (traffic.get(entry.getKey()).intersects(traffic.get(v))) {
						Vehicle other = entry.getKey();
						if (other.getDurability() > v.getDurability())
							CityPanel.pool.killVehicle(v, other.toString());
						else if (other.getDurability() < v.getDurability())
							CityPanel.pool.killVehicle(other, v.toString());
						else {
							CityPanel.pool.killVehicle(v, other.toString());
							CityPanel.pool.killVehicle(other, v.toString());
						}
							
					}
				}
			}
		}
		return true;
	}
		
}
