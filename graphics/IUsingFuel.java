package graphics;

import DesignPatterns.IBeenRefueled;
import DesignPatterns.IRefueler;
import vehicles.Point;

/**
 * The Interface IUsingFuel.
 * 
 * @author Stav Lobel
 */
public interface IUsingFuel extends IMoveable,IBeenRefueled {
	
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
	 * Can move.
	 *
	 * @param toGo the point toGo
	 * @return true, if successful
	 */
	public boolean canMove(Point toGo);
	
	public boolean drive(Point toGo);
}
