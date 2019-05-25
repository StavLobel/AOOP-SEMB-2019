package DesignPatterns;

/**
 * The Interface IRefueler.
 * 
 * Visitor Design Pattern.
 * 
 * @author Stav Lobel
 */
public interface IRefueler {
	
	/**
	 * Refuel.
	 *
	 * @param vehicleToRefuel the vehicle to refuel
	 * @return true, if successful
	 */
	public boolean refuel(IBeenRefueled vehicleToRefuel);
}
