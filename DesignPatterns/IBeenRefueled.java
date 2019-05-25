package DesignPatterns;

/**
 * The Interface IBeenRefueled.
 * 
 * Visitor Design Pattern.
 * 
 * @author Stav Lobel
 */
public interface IBeenRefueled {
	
	/**
	 * Sets the current fuel.
	 *
	 * @param amount the amount of fuel
	 * @return true, if successful
	 */
	public boolean setCurrentFuel(int amount);
	
	/**
	 * Let Refuel.
	 *
	 * @param refueler the refueler
	 */
	public void letRefuel(IRefueler refueler);
}
