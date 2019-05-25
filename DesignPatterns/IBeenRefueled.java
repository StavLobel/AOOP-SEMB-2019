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
	 * Let Refuel.
	 *
	 * @param refueler the refueler
	 */
	public void letRefuel(IRefueler refueler);
}
