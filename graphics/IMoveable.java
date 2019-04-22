package graphics;
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
	 * Gets the fuel consumption.
	 *
	 * @return the fuel consumption
	 */
	public int getFuelConsumption();
	
	/**
	 * Gets the engine type.
	 *
	 * @return the engine type
	 */
	public String getEngineType();
	
	/**
	 * Gets the current fuel.
	 *
	 * @return the current fuel
	 */
	public int getCurrentFuel();
	
	/**
	 * Use fuel.
	 *
	 * @param amount the amount of fuel to use
	 * @return true, if successful
	 */
	public boolean useFuel(int amount);
	
	/**
	 * Refuel.
	 *
	 * @return true, if successful
	 */
	public boolean refuel();
	
	/**
	 * Move.
	 *
	 * @param p the new point to move to
	 * @return true, if successful. false if same point.
	 */
	public boolean move(Point p);

}
