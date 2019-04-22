package graphics;

public class FuelTypeException extends Exception {
	private static String msg = "Type of fuel does not match the type of the vehicle !";
	
	public FuelTypeException() {
		super(msg);
	}
	
	public FuelTypeException(String from,String to) {
		super(msg+" Tried to refuel " + from + " with " + to + " fuel.");
	}
	
	public FuelTypeException(int numberOfVehicles) {
		super(msg+" Tried to refuel : " + numberOfVehicles + " cars .");
	}
}
