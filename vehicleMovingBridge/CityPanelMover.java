package vehicleMovingBridge;

import java.util.Random;

import graphics.CityPanel;
import vehicles.Location;
import vehicles.Point;
import vehicles.Vehicle;

public class CityPanelMover extends VehicleMover {
	/** The panel.*/
	private CityPanel panel;
	
	private static int size = 65;
	
	/** The Constant vehicleWidthHorizon. */
	private static final int vehicleWidthHorizon = size*2;
	
	/** The Constant vehicleHeightHorizon. */
	private static final int vehicleHeightHorizon = size;
	
	/** The Constant vehicleWidthVertical. */
	private static final int vehicleWidthVertical = size;
	
	/** The Constant vehicleHeightVertical. */
	private static final int vehicleHeightVertical = size*2;
	
	/** The panel width. */
	private int panelWidth;
	
	/** The panel height. */
	private int panelHeight;
	
	/** The panel middle. */
	private int panelMiddle;
	
	private Point upLeftCorner;
	
	private Point upRightCorner;
	
	private Point downLeftCorner;
	
	private Point downRightCorner;
	
	private Point middleLeftCorner;
	
	private Point middleRightCorner;
	
	public CityPanelMover(CityPanel panel) {
		setPanel(panel);
	}
	
	private boolean setPanel(CityPanel panel) {
		this.panel = panel;
		this.panelWidth = panel.getWidth()-vehicleWidthVertical*5/4;
		this.panelHeight = panel.getHeight()-vehicleHeightHorizon*5/3;
		this.panelMiddle = panelHeight/2;
		setIntersections();
		return true;
	}
	
	public boolean setIntersections() {
		upLeftCorner = Point.getPointInstance(0, 0);
		upRightCorner = Point.getPointInstance(panelWidth, 0);
		downLeftCorner = Point.getPointInstance(0, panelHeight);
		downRightCorner = Point.getPointInstance(panelWidth, panelHeight);
		middleLeftCorner = Point.getPointInstance(0, panelMiddle);
		middleRightCorner = Point.getPointInstance(panelWidth, panelMiddle);
		return true;
		
	}
	
	public boolean move(Vehicle vehicle,Point toGo) {
		toGo = nextLocation(vehicle);
		if (vehicle.canMove() && vehicle.getLocation().getLocationPoint().equals(toGo) == false) {    
	    	try {Thread.sleep(100);}
	        catch (InterruptedException e) { e.printStackTrace(); }
	        vehicle.drive(toGo);
	        panel.repaint();
		    return true;
	    }
	    return false;
	}
	
	private Point nextLocation(Vehicle vehicle) {
		Location current = (Location) vehicle.getLocation().clone();
		Point nextPoint = makeNextPoint(current,vehicle.getSpeed());
		Point intersection = intersects(vehicle.getLocation().getLocationPoint(), nextPoint); 
		while (intersection != null && intersection.equals(current.getLocationPoint()) == false) {
			int gap = intersection.manhattanDistance(nextPoint);
			current = getCurrent(current, intersection);
			nextPoint = makeNextPoint(current, gap);
			intersection = intersects(current.getLocationPoint(), nextPoint);
		}
		return nextPoint;
		
	}
	
	private Point intersects(Point current ,Point end) {
		if (current.inBetween(upLeftCorner, end))
			return upLeftCorner;
		else if (current.inBetween(upRightCorner, end))
			return upRightCorner;
		else if (current.inBetween(downLeftCorner, end))
			return downLeftCorner;
		else if (current.inBetween(downRightCorner, end))
			return downRightCorner;
		else if (current.inBetween(middleLeftCorner, end))
			return middleLeftCorner;
		else if (current.inBetween(middleRightCorner, end))
			return middleRightCorner;
		else
			return null;
		
	}
	
	private Location getCurrent(Location current,Point intersection) {
		//Up Left
		if (intersection.equals(upLeftCorner) && current.getOrientation().equals("North"))
			return new Location(intersection,"East");
		else if (intersection.equals(upLeftCorner) && current.getOrientation().equals("West"))
			return new Location(intersection,"South");
		//Up Right
		else if (intersection.equals(upRightCorner) && current.getOrientation().equals("East"))
			return new Location(intersection,"South");
		else if (intersection.equals(upRightCorner) && current.getOrientation().equals("North"))
			return new Location(intersection,"West");
		//Down Left
		else if (intersection.equals(downLeftCorner) && current.getOrientation().equals("South"))
			return new Location(intersection,"East");
		else if (intersection.equals(downLeftCorner) && current.getOrientation().equals("West"))
			return new Location(intersection,"North");
		//Down Right
		else if (intersection.equals(downRightCorner) && current.getOrientation().equals("South"))
			return new Location(intersection,"West");
		else if (intersection.equals(downRightCorner) && current.getOrientation().equals("East"))
			return new Location(intersection,"North");
		//Middles
		else if (intersection.equals(middleLeftCorner) || intersection.equals(middleRightCorner)) {
			Random rand = new Random();
			String[] orientations = {"North","South","East","West"};
			String nextOrientation = orientations[rand.nextInt(4)];
			while (nextOrientation.equals(current.getOrientation()) || nextOrientation.equals(current.getOppositeOrientation())) {
				nextOrientation = orientations[rand.nextInt(4)];
				if ((intersection.equals(middleLeftCorner) && nextOrientation.equals("West") || (intersection.equals(middleRightCorner) && nextOrientation.equals("East"))))
						nextOrientation = current.getOrientation();
			}
			return new Location(intersection,nextOrientation);
		}
		else
			return null;
	}
			
	
}
