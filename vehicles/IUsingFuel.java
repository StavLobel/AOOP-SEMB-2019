package vehicles;

import cityFrame.IMoveable;
import refuelers.FuelTypeException;
import refuelers.IRefueler;

/**
 * The Interface IUsingFuel.
 * 
 * @author Stav Lobel
 */
public interface IUsingFuel extends IMoveable {
	
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
	
	public int getMaxCapacity();
	
	public void letRefuel(IRefueler refueler) throws FuelTypeException;
	
	public boolean setCurrentFuel(int amount);
}
