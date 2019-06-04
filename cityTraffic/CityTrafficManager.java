package cityTraffic;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;

import DesignPatterns.VehicleDecorator;
import vehicleGraphicsDecorator.VehicleGraphicDecorator;
import vehicles.Vehicle;

public class CityTrafficManager implements Observer {
	
	private HashMap<Vehicle, Rectangle> traffic = new HashMap<Vehicle, Rectangle>();
	
	@Override
	public boolean getNotified(Observable observable) {
		synchronized (((VehicleDecorator) observable).getCore()) {
			Dimension dim = ((VehicleGraphicDecorator) ((ObserversDecorator) observable).getLowerLayer()).getDimensions();
			traffic.put(((VehicleDecorator) observable).getCore(), new Rectangle(new Point(), d))
		}
	}
		
}
