package vehicleMovingBridge;

import java.util.Random;

import graphics.CityPanel;
import vehicles.Location;
import vehicles.Point;
import vehicles.Vehicle;

public class CityPanelMover extends VehicleMover {
	/** The panel.*/
	private CityPanel panel;
	
	private int size = 65;
	
	/** The Constant vehicleWidthHorizon. */
	private final int vehicleWidthHorizon = size*2;
	
	/** The Constant vehicleHeightHorizon. */
	private final int vehicleHeightHorizon = size;
	
	/** The Constant vehicleWidthVertical. */
	private final int vehicleWidthVertical = size;
	
	/** The Constant vehicleHeightVertical. */
	private final int vehicleHeightVertical = size*2;
	
	/** The panel width. */
	private int panelWidth;
	
	/** The panel height. */
	private int panelHeight;
	
	/** The panel middle. */
	private int panelMiddle;
	
	public CityPanelMover(CityPanel panel) {
		this.panel = panel;
		setPanel();
	}
	
	public boolean setPanel() {
		panelWidth = panel.getWidth()-vehicleWidthVertical*5/4;
		panelHeight = panel.getHeight()-vehicleHeightHorizon*5/3;
		panelMiddle = panelHeight/2;
		return true;
	}
	
	public boolean move(Vehicle vehicle,Point toGo) {
		if (vehicle.canMove() && vehicle.getLocation().getLocationPoint().equals(toGo) == false) {    
	    	try {Thread.sleep(100);}
	        catch (InterruptedException e) { e.printStackTrace(); }
	    	toGo = nextLocation(vehicle, toGo);
	        vehicle.drive(toGo);
		    return true;
	    }
	    return false;
	}
	
	public Point nextLocation(Vehicle vehicle,Point toGo) {
		Location current = (Location) vehicle.getLocation().clone();
		Point next = makeNextPoint(vehicle.getLocation(),vehicle.getSpeed());
		return nextLocationMaker(current,next,vehicle.getSpeed());
	}
	
	private Point nextLocationMaker(Location current,Point next,int gap) {
		Point intersection = getIntersection(current.getLocationPoint(),next);
		while (intersection != null) {
			gap = current.getLocationPoint().manhattanDistance(intersection);
			current.setLocation(intersection);
			String nextDirection = directionInIntersection(current,gap);
			current.setOrientation(nextDirection);
			next = makeNextPoint(current, gap);
			intersection = getIntersection(current.getLocationPoint(),next);
		}
		return next;
	}
	
	private Point getIntersection(Point current,Point next) {
		if (current.equals(next))
			return null;
		if (current.getY() == next.getY()) {
			if (next.getX() <= 0)
				return Point.getPointInstance(0,current.getY());
			else if (next.getX() >= panelWidth)
				return Point.getPointInstance(panelWidth,current.getY());
		}
		else if (current.getX() == next.getX()) {
			if (next.getY() >= panelHeight || next.getY() <= 0) {
				if (next.getY() <= 0)
					return Point.getPointInstance(current.getX(),0);
				else if (next.getY() >= panelHeight)
					return Point.getPointInstance(current.getX(),panelHeight);
			}
			if (current.getY() == panelHeight/2)
				return null;
			else if ((current.getY() < panelMiddle && next.getY() > panelMiddle) || (current.getY() > panelMiddle && next.getY() < panelMiddle))
				return Point.getPointInstance(current.getX(),panelMiddle);
		}
		return null;
	}
	
	private String directionInIntersection(Location current,int gap) {
		String nextOrientation = current.getOppositeOrientation();
		Random randomInt = new Random();
		Location next = (Location) current.clone();
		int index = 0;
		while (nextOrientation.equals(current.getOppositeOrientation()) || !inBounds(next.getLocationPoint())) {
			next = (Location) current.clone();
			index = randomInt.nextInt(4);
			nextOrientation = Location.getAllOrientations()[index];
			next.setOrientation(nextOrientation);
			next = new Location(makeNextPoint(next,1));
		}
		return nextOrientation;
	}
	
	private boolean inBounds(Point p) {
		return !(p.getX() < 0 || p.getX() > panelWidth || p.getY() < 0 || p.getY() > panelHeight);
	}
}
