package graphics;

/**
 * The Class FuelTypeException.
 * 
 * @author Stav Lobel
 */
public class FuelTypeException extends Exception {
	
	/** The message. */
	private static String msg = "Type of fuel does not match the type of the vehicle !";
	
	/**
	 * Instantiates a new fuel type exception.
	 */
	public FuelTypeException() {
		super(msg);
	}
	
	/**
	 * Instantiates a new fuel type exception.
	 *
	 * @param from the "from" type
	 * @param to the "to" type
	 */
	public FuelTypeException(String from,String to) {
		super(msg+" Tried to refuel " + from + " with " + to + " fuel.");
	}
	
	/**
	 * Instantiates a new fuel type exception.
	 *
	 * @param numberOfVehicles the number of vehicles with errors
	 */
	public FuelTypeException(int numberOfVehicles) {
		super(msg+" Tried to refuel : " + numberOfVehicles + " cars .");
	}
}
