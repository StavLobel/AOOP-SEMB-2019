package cityFrame;
import vehicles.Point;

/**
 * The Interface IMoveable.
 * 
 * @author Stav Lobel
 */
public interface IMoveable {
	
	/**
	 * Gets the vehicle name.
	 *
	 * @return the vehicle type as String.
	 */
	public String getVehicleName();
	
	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed();
	
	/**
	 * Move.
	 *
	 * @param p the new point to move to
	 * @return true, if successful. false if same point.
	 */
	public boolean move(Point p);
	
	/**
	 * Can move.
	 *
	 * @param toGo the togo point
	 * @return true, if the vehicle can move
	 */
	public boolean canMove(Point toGo);
	
	/**
	 * Gets the durability.
	 *
	 * @return the durability of the vehicle
	 */
	public int getDurability();

}
